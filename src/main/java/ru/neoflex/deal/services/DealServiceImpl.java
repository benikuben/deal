package ru.neoflex.deal.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.neoflex.deal.exceptions.DealException;
import ru.neoflex.deal.feignclient.ConveyorClient;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.exceptions.ApplicationStatusException;
import ru.neoflex.deal.util.mappers.ClientMapper;
import ru.neoflex.deal.util.mappers.CreditMapper;
import ru.neoflex.openapi.dtos.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {
    private static final ErrorResponse LOAN_REJECTION = new ErrorResponse("Отказ в одобрении кредита");
    private final ClientMapper clientMapper;
    private final CreditMapper creditMapper;
    private final ClientService clientService;
    private final ApplicationService applicationService;
    private final CreditService creditService;
    private final ConveyorClient conveyorClient;
    private final KafkaProducer emailSender;

    /**
     * На основе LoanApplicationRequestDTO создаётся сущность Client и сохраняется в БД.
     * Создаётся Application со связью на только что созданный Client и сохраняется в БД.
     * Отправляется POST запрос на /conveyor/offers МС conveyor через FeignClient.
     * Каждому элементу из списка List<LoanOfferDTO> присваивается id созданной заявки (Application)
     */
    public List<LoanOffer> createApplication(LoanApplicationRequest request) {
        log.info("LoanApplicationRequestDTO - {}", request);
        Client client = clientMapper.loanApplicationRequestDTOToClient(request);

        client = clientService.save(client);
        log.info("Client was saved in database - {}", client);

        Application application = Application.builder().
                clientId(client).
                creationDate(LocalDateTime.now()).build();
        updateStatus(application, ApplicationStatus.PREAPPROVAL, ChangeType.AUTOMATIC);
        application = applicationService.save(application);
        log.info("Application was saved in database with id {}. Client id - {}. Status - PREAPPROVAL, Change type - AUTOMATIC", application.getId(), client.getId());
        log.info("Application - {}", application);

        log.info("Sending request to /conveyor/offers. Generating offers for application with id - {}", application.getId());
        List<LoanOffer> offers = conveyorClient.generateOffers(request).getBody();
        long id = application.getId();
        offers.forEach(offer -> offer.setApplicationId(id));
        log.info("Generated offers - {}", offers);

        return offers;
    }

    /**
     * Достаётся из БД заявка(Application) по applicationId из LoanOfferDTO.
     * В заявке обновляется статус, история статусов(List<ApplicationStatusHistoryDTO>),
     * принятое предложение LoanOfferDTO устанавливается в поле appliedOffer.
     * Заявка сохраняется.
     */
    public void applyOffer(LoanOffer loanOfferDTO) {
        log.info("Search application with id - {} in database", loanOfferDTO.getApplicationId());
        Application application = applicationService.findById(loanOfferDTO.getApplicationId());

        if (!application.getStatus().equals(ApplicationStatus.PREAPPROVAL)) {
            log.warn("ApplicationStatusException when updating status to APPROVED. Expected status before the update - PREAPPROVAL, actual - {}", application.getStatus());
            throw new ApplicationStatusException();
        }

        updateStatus(application, ApplicationStatus.APPROVED, ChangeType.AUTOMATIC);
        log.info("Status of application with id - {} was updated to APPROVED. Change type - AUTOMATIC", loanOfferDTO.getApplicationId());

        application.setAppliedOffer(loanOfferDTO);
        applicationService.save(application);
        log.info("Loan offer for application with id - {} saved in database", loanOfferDTO.getApplicationId());
        log.info("Application - {}", application);

        EmailMessage emailMessage = new EmailMessage()
                .address(application.getClientId().getEmail())
                .theme(Theme.FINISH_REGISTRATION)
                .applicationId(application.getId());
        log.info("Finish registration email message - {}", emailMessage);
        emailSender.produceMessage(emailMessage);
    }


    /**
     * Достаётся из БД заявка(Application) по applicationId.
     * ScoringDataDTO насыщается информацией из FinishRegistrationRequestDTO и Client, который хранится в Application
     * Отправляется POST запрос к МС КК с телом ScoringDataDTO
     */
    public void finishRegistration(Long applicationId, FinishRegistrationRequest finishRegistrationRequestDTO) {
        Application application = applicationService.findById(applicationId);
        log.info("Application with id {} was found in database", applicationId);

        if (!application.getStatus().equals(ApplicationStatus.APPROVED)) {
            log.warn("ApplicationStatusException when updating status to CC_APPROVED or CC_DENIED. Expected status before the update - APPROVED, actual - {}", application.getStatus());
            throw new ApplicationStatusException();
        }

        Client client = application.getClientId();
        BeanUtils.copyProperties(finishRegistrationRequestDTO, client);
        Passport passport = client.getPassport()
                .issueBranch(finishRegistrationRequestDTO.getPassportIssueBranch())
                .issueDate(finishRegistrationRequestDTO.getPassportIssueDate());
        clientService.update(client);
        log.info("Client was updated in database - {}", client);

        ScoringData data = new ScoringData();
        BeanUtils.copyProperties(client, data);
        BeanUtils.copyProperties(application.getAppliedOffer(), data);
        data.passportIssueBranch(passport.getIssueBranch())
                .passportIssueDate(passport.getIssueDate())
                .passportNumber(passport.getNumber())
                .passportSeries(passport.getSeries())
                .amount(application.getAppliedOffer().getTotalAmount());
        log.info("Scoring data - {}", data);

        try {
            log.info("Sending request to /conveyor/calculation. Generating credit for application with id - {}", application.getId());
            ResponseEntity<Credit> creditDTO = conveyorClient.generateCredit(data);

            updateStatus(application, ApplicationStatus.CC_APPROVED, ChangeType.AUTOMATIC);
            log.info("Application status was updated to CC_APPROVED");

            ru.neoflex.deal.models.Credit credit = creditMapper.creditDTOToCredit(creditDTO.getBody());
            log.info("Calculated credit - {}", credit);

            credit.setCreditStatus(CreditStatus.CALCULATED);
            log.info("Credit status was updated to CALCULATED");

            creditService.save(credit);
            log.info("Credit was saved in database - {}", credit);

            application.setCreditId(credit);
            applicationService.save(application);
            log.info("Application was updated in database - {}", application);

            EmailMessage emailMessage = new EmailMessage()
                    .address(client.getEmail())
                    .theme(Theme.CREATE_DOCUMENTS)
                    .applicationId(application.getId());
            log.info("Create documents email message - {}", emailMessage);
            emailSender.produceMessage(emailMessage);
        } catch (FeignException e) {
            if (e.status() == 400) {
                ErrorResponse response;
                try {
                    response = new ObjectMapper().readValue(e.contentUTF8(), ErrorResponse.class);
                } catch (JsonProcessingException ex) {
                    log.warn("JsonProcessingException {}", ex.getMessage());
                    throw new DealException();
                }
                if (response.equals(LOAN_REJECTION)) {
                    updateStatus(application, ApplicationStatus.CC_DENIED, ChangeType.AUTOMATIC);
                    log.info("Application status was updated to CC_DENIED");
                    applicationService.save(application);
                    log.info("Application was updated in database - {}", application);

                    EmailMessage emailMessage = new EmailMessage()
                            .address(client.getEmail())
                            .theme(Theme.APPLICATION_DENIED)
                            .applicationId(application.getId());
                    log.info("Application denied email message - {}", emailMessage);
                    emailSender.produceMessage(emailMessage);
                }
            }
        }
    }

    public static void updateStatus(Application application, ApplicationStatus status, ChangeType type) {
        application.setStatus(status);
        List<ApplicationStatusHistory> history = application.getStatusHistory();
        if (history == null)
            history = new ArrayList<>();
        history.add(new ApplicationStatusHistory(status, LocalDateTime.now(), type));
        application.setStatusHistory(history);
    }
}

