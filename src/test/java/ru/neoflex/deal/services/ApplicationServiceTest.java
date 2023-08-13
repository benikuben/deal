package ru.neoflex.deal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.repositories.ApplicationRepository;
import ru.neoflex.deal.util.exceptions.NotFoundException;
import ru.neoflex.openapi.dtos.ApplicationStatus;
import ru.neoflex.openapi.dtos.ApplicationStatusHistoryDTO;
import ru.neoflex.openapi.dtos.ChangeType;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApplicationServiceTest {
    @Mock
    private ApplicationRepository applicationRepository;

    @InjectMocks
    private ApplicationService applicationService;

    @Test
    void save() {
        Client client = Client.builder()
                .id(1L).build();
        List<ApplicationStatusHistoryDTO> history =
                new ArrayList<>(Arrays.asList(
                        new ApplicationStatusHistoryDTO(ApplicationStatus.PREAPPROVAL, LocalDateTime.now(), ChangeType.AUTOMATIC))
                );
        Application application = Application.builder()
                .clientId(client)
                .status(ApplicationStatus.PREAPPROVAL)
                .creationDate(LocalDateTime.now())
                .statusHistory(history).build();

        //expected
        Application expectedApplication = new Application();
        BeanUtils.copyProperties(application, expectedApplication);
        expectedApplication.setId(1L);

        when(applicationRepository.save(any())).thenReturn(expectedApplication);

        //actual
        Application actualApplication = applicationService.save(application);

        //tests
        assertEquals(actualApplication.getId(), expectedApplication.getId());
        assertEquals(actualApplication.getStatus(), expectedApplication.getStatus());
        assertEquals(actualApplication.getCreationDate(), expectedApplication.getCreationDate());
        assertEquals(actualApplication.getStatusHistory(), expectedApplication.getStatusHistory());
        assertEquals(actualApplication.getClientId().getId(), expectedApplication.getClientId().getId());
    }

    @Test
    void findById() {
        Long id = 1L;

        //expected
        Application expectedApplication = Application.builder().id(id).build();

        when(applicationRepository.findApplicationById(any())).thenReturn(Optional.of(expectedApplication), Optional.empty());

        //actual
        Application actualApplication = applicationService.findById(id);

        //tests
        assertEquals(actualApplication, expectedApplication);
        assertThrows(NotFoundException.class, () -> applicationService.findById(2L));
    }
}