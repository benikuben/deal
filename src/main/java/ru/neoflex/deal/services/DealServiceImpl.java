package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import ru.neoflex.deal.feignclient.ConveyorClient;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.deal.util.mappers.ClientMapper;
import ru.neoflex.deal.util.mappers.CreditMapper;
import ru.neoflex.openapi.dtos.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService{
    private final ClientMapper clientMapper;
    private final CreditMapper creditMapper;
    private final ClientService clientService;
    private final ApplicationService applicationService;
    private final CreditService creditService;
    private final ConveyorClient conveyorClient;

    /**
     * На основе LoanApplicationRequestDTO создаётся сущность Client и сохраняется в БД.
     * Создаётся Application со связью на только что созданный Client и сохраняется в БД.
     * Отправляется POST запрос на /conveyor/offers МС conveyor через FeignClient.
     * Каждому элементу из списка List<LoanOfferDTO> присваивается id созданной заявки (Application)
     */
    public List<LoanOfferDTO> createApplication(LoanApplicationRequestDTO request) {
        Client client = clientMapper.loanApplicationRequestDTOToClient(request);

        client = clientService.save(client);
        log.info("Client {} {}, passport {} {} saved in database. Id - {}", request.getFirstName(), request.getLastName(), request.getPassportSeries(), request.getPassportNumber(), client.getId());

        Application application = Application.builder().
                clientId(client).
                creationDate(LocalDateTime.now()).build();
        updateStatus(application, ApplicationStatus.PREAPPROVAL, ChangeType.AUTOMATIC);
        application = applicationService.save(application);
        log.info("Application was saved in database with id {}. Client id - {}. Status - PREAPPROVAL, Change type - AUTOMATIC", application.getId(), client.getId());

        log.info("Sending request to /conveyor/offers. Generating offers for application with id - {}", application.getId());
        List<LoanOfferDTO> offers = conveyorClient.generateOffers(request);
        long id = application.getId();
        offers.forEach(offer -> offer.setApplicationId(id));

        return offers;
    }

    /**
     * Достаётся из БД заявка(Application) по applicationId из LoanOfferDTO.
     * В заявке обновляется статус, история статусов(List<ApplicationStatusHistoryDTO>),
     * принятое предложение LoanOfferDTO устанавливается в поле appliedOffer.
     * Заявка сохраняется.
     */
    public void applyOffer(LoanOfferDTO loanOfferDTO) {
        log.info("Search application with id - {} in database", loanOfferDTO.getApplicationId());
        Application application = applicationService.findById(loanOfferDTO.getApplicationId());
        log.info("Status of application with id - {} was updated to APPROVED. Change type - AUTOMATIC", loanOfferDTO.getApplicationId());
        updateStatus(application, ApplicationStatus.APPROVED, ChangeType.AUTOMATIC);
        log.info("Loan offer for application with id - {} saved in database", loanOfferDTO.getApplicationId());
        application.setAppliedOffer(loanOfferDTO);
        applicationService.save(application);
    }

    private void updateStatus(Application application, ApplicationStatus status, ChangeType type) {
        application.setStatus(status);
        List<ApplicationStatusHistoryDTO> history = application.getStatusHistory();
        if (history == null)
            history = new ArrayList<>();
        history.add(new ApplicationStatusHistoryDTO(status, LocalDateTime.now(), type));
        application.setStatusHistory(history);
    }

    /**
     * Достаётся из БД заявка(Application) по applicationId.
     * ScoringDataDTO насыщается информацией из FinishRegistrationRequestDTO и Client, который хранится в Application
     * Отправляется POST запрос к МС КК с телом ScoringDataDTO
     */
    public void finishRegistration(Long applicationId, FinishRegistrationRequestDTO finishRegistrationRequestDTO) {
        log.info("Search application with id - {} in database", applicationId);
        Application application = applicationService.findById(applicationId);

        Client client = application.getClientId();
        BeanUtils.copyProperties(finishRegistrationRequestDTO, client);
        Passport passport = client.getPassport();
        passport.setIssueBranch(finishRegistrationRequestDTO.getPassportIssueBranch());
        passport.setIssueDate(finishRegistrationRequestDTO.getPassportIssueDate());
        log.info("Additional information for the client with id - {} was saved in database", client.getId());

        ScoringDataDTO data = new ScoringDataDTO();
        BeanUtils.copyProperties(client, data);
        data.setPassportIssueBranch(passport.getIssueBranch());
        data.setPassportIssueDate(passport.getIssueDate());
        data.setPassportNumber(passport.getNumber());
        data.setPassportSeries(passport.getSeries());
        BeanUtils.copyProperties(application.getAppliedOffer(), data);
        data.setAmount(application.getAppliedOffer().getTotalAmount());

        log.info("Sending request to /conveyor/calculation. Generating credit for application with id - {}", application.getId());
        CreditDTO creditDTO = conveyorClient.generateCredit(data);
        Credit credit = creditMapper.creditDTOToCredit(creditDTO);
        credit.setCreditStatus(CreditStatus.CALCULATED);

        creditService.save(credit);
        log.info("Credit with id - {} was saved. Status - CALCULATED", credit.getId());
        application.setCreditId(credit);
        applicationService.save(application);
        log.info("Application with id - {} updated", application.getId());
    }
}
