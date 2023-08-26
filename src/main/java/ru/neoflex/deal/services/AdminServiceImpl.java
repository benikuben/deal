package ru.neoflex.deal.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.util.mappers.ApplicationMapper;
import ru.neoflex.openapi.dtos.*;

import static ru.neoflex.deal.services.DealServiceImpl.updateStatus;

@Slf4j
@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final ApplicationService applicationService;
    private final ApplicationMapper applicationMapper;

    @Override
    public ApplicationDTO getApplicationById(Long applicationId) {
        Application application = applicationService.findById(applicationId);
        log.info("Application with id {} was found in database", applicationId);

        return applicationMapper.applicationToApplicationDTO(application);
    }

    @Override
    public void updateApplicationStatus(Long applicationId, String newStatus) {
        try {
            ApplicationStatus status = ApplicationStatus.valueOf(newStatus);

            Application application = applicationService.findById(applicationId);
            log.info("Application with id {} was found in database", applicationId);

            updateStatus(application, status, ChangeType.AUTOMATIC);
            log.info("Application status updated to {}", status);

            applicationService.save(application);
            log.info("Application was updated in database - {}", application);
        } catch (IllegalArgumentException e) {
            log.warn("Invalid application status name {}", newStatus);
        }
    }
}
