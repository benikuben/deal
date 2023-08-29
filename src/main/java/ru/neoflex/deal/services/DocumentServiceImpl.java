package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.exceptions.ApplicationStatusException;
import ru.neoflex.deal.exceptions.InvalidSesCodeException;
import ru.neoflex.openapi.dtos.ApplicationStatus;
import ru.neoflex.openapi.dtos.ChangeType;
import ru.neoflex.openapi.dtos.EmailMessage;
import ru.neoflex.openapi.dtos.Theme;

import java.util.Random;

import static ru.neoflex.deal.services.DealServiceImpl.updateStatus;

@Slf4j
@Service
@RequiredArgsConstructor
public class DocumentServiceImpl implements DocumentService {
    private final KafkaProducer emailSender;
    private final ApplicationService applicationService;

    @Override
    public void sendDocuments(Long applicationId) {
        Application application = applicationService.findById(applicationId);
        log.info("Application with id {} was found in database", applicationId);

        if (!application.getStatus().equals(ApplicationStatus.CC_APPROVED)) {
            log.warn("ApplicationStatusException when updating status to PREPARE_DOCUMENTS. Expected status before the update - CC_APPROVED, actual - {}", application.getStatus());
            throw new ApplicationStatusException();
        }

        updateStatus(application, ApplicationStatus.PREPARE_DOCUMENTS, ChangeType.AUTOMATIC);
        log.info("Application status updated to PREPARE_DOCUMENTS");

        applicationService.save(application);
        log.info("Application was updated in database - {}", application);

        EmailMessage emailMessage = new EmailMessage()
                .address(application.getClientId().getEmail())
                .theme(Theme.SEND_DOCUMENTS)
                .applicationId(application.getId());
        log.info("Send documents email message - {}", emailMessage);
        emailSender.produceMessage(emailMessage);
    }

    @Override
    public void signDocuments(Long applicationId) {
        Application application = applicationService.findById(applicationId);
        log.info("Application with id {} was found in database", applicationId);

        if (!application.getStatus().equals(ApplicationStatus.DOCUMENT_CREATED)) {
            log.warn("ApplicationStatusException when sending ses code. Expected status  - DOCUMENT_CREATED, actual - {}", application.getStatus());
            throw new ApplicationStatusException();
        }

        int sesCode = generateSes();
        application.setSesCode(String.valueOf(sesCode));
        log.info("Application with id {} was updated with SES code {}", applicationId, sesCode);

        applicationService.save(application);
        log.info("Application was updated in database - {}", application);

        EmailMessage emailMessage = new EmailMessage()
                .address(application.getClientId().getEmail())
                .theme(Theme.SEND_SES)
                .applicationId(application.getId());
        log.info("Send documents email message - {}", emailMessage);
        emailSender.produceMessage(emailMessage);
    }

    @Override
    public void verifyCode(Long applicationId, Integer sesCode) {
        Application application = applicationService.findById(applicationId);
        log.info("Application with id {} was found in database", applicationId);

        if (!application.getStatus().equals(ApplicationStatus.DOCUMENT_CREATED)) {
            log.warn("ApplicationStatusException when updating status to DOCUMENT_SIGNED. Expected status before the update - DOCUMENT_CREATED, actual - {}", application.getStatus());
            throw new ApplicationStatusException();
        }

        if (application.getSesCode().equals(sesCode.toString())) {
            updateStatus(application, ApplicationStatus.DOCUMENT_SIGNED, ChangeType.AUTOMATIC);
            log.info("Application status updated to DOCUMENT_SIGNED");
            applicationService.save(application);
            log.info("Application was updated in database - {}", application);

            updateStatus(application, ApplicationStatus.CREDIT_ISSUED, ChangeType.AUTOMATIC);
            log.info("Application status updated to CREDIT_ISSUED");
            applicationService.save(application);
            log.info("Application was updated in database - {}", application);

            EmailMessage emailMessage = new EmailMessage()
                    .address(application.getClientId().getEmail())
                    .theme(Theme.CREDIT_ISSUED)
                    .applicationId(application.getId());
            log.info("Send documents email message - {}", emailMessage);
            emailSender.produceMessage(emailMessage);
        } else {
            log.warn("Ses code verification failed");
            throw new InvalidSesCodeException();
        }
    }

    private Integer generateSes() {
        int max = 9999;
        int min = 1000;
        Random random = new Random();
        return random.nextInt((max - min) + 1) + min;
    }
}
