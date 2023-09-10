package ru.neoflex.deal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.neoflex.deal.exceptions.ApplicationStatusException;
import ru.neoflex.deal.models.Application;
import ru.neoflex.openapi.dtos.ApplicationStatus;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DocumentServiceTest {
    @Mock
    private ApplicationService applicationService;
    @InjectMocks
    private DocumentServiceImpl documentService;

    @Test
    void sendDocuments() {
        Application application = Application.builder()
                .status(ApplicationStatus.CREDIT_ISSUED).build();
        when(applicationService.findById(any())).thenReturn(application);
        assertThrows(ApplicationStatusException.class, () -> documentService.sendDocuments(1L));
    }

    @Test
    void signDocuments() {
        Application application = Application.builder()
                .status(ApplicationStatus.CREDIT_ISSUED).build();
        when(applicationService.findById(any())).thenReturn(application);
        assertThrows(ApplicationStatusException.class, () -> documentService.signDocuments(1L));
    }

    @Test
    void verifyCode() {
        Application application = Application.builder()
                .status(ApplicationStatus.CREDIT_ISSUED).build();
        when(applicationService.findById(any())).thenReturn(application);
        assertThrows(ApplicationStatusException.class, () -> documentService.verifyCode(1L, 1111));
    }
}