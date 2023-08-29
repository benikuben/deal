package ru.neoflex.deal.services;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.neoflex.deal.exceptions.ApplicationStatusException;
import ru.neoflex.deal.exceptions.DealException;
import ru.neoflex.deal.feignclient.ConveyorClient;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Client;
import ru.neoflex.openapi.dtos.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class DealServiceTest {
    @Mock
    private ApplicationService applicationService;
    @Mock
    private ConveyorClient conveyorClient;
    @Mock
    private KafkaProducer emailSender;
    @Mock
    private ClientService clientService;
    @InjectMocks
    private DealServiceImpl dealService;

    @Test
    void applyOffer() {
        Application application = Application.builder()
                .status(ApplicationStatus.CREDIT_ISSUED).build();
        when(applicationService.findById(any())).thenReturn(application);

        assertThrows(ApplicationStatusException.class, () -> dealService.applyOffer(new LoanOffer()));
    }

    @Test
    void finishRegistration() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, JsonProcessingException {
        Application applicationWithInvalidStatus = Application.builder()
                .status(ApplicationStatus.CREDIT_ISSUED).build();
        Application applicationWithValidStatus = Application.builder()
                .status(ApplicationStatus.APPROVED)
                .clientId(Client.builder().passport(new Passport()).build())
                .appliedOffer(new LoanOffer())
                .build();
        when(applicationService.findById(any())).thenReturn(applicationWithInvalidStatus, applicationWithValidStatus);

        //test throws ApplicationStatusException
        assertThrows(ApplicationStatusException.class, () -> dealService.finishRegistration(1L, new FinishRegistrationRequest()));

        ErrorResponse loanRejection = new ErrorResponse("Отказ в одобрении кредита");

        Constructor<FeignException> constructor = FeignException.class.getDeclaredConstructor(int.class, String.class, byte[].class, Map.class);
        constructor.setAccessible(true);

        FeignException e1 = constructor.newInstance(400, "", new byte[]{}, new HashMap<>());
        FeignException e2 = constructor.newInstance(400, "", new ObjectMapper().writeValueAsBytes(loanRejection), new HashMap<>());

        when(clientService.update(any())).thenReturn(new Client());
        doNothing().when(emailSender).produceMessage(any());

        when(conveyorClient.generateCredit(any())).thenThrow(e1, e2);

        //test throws DealException
        assertThrows(DealException.class, () -> dealService.finishRegistration(1L, new FinishRegistrationRequest()));

        //test does not throw exceptions
        assertDoesNotThrow(() -> dealService.finishRegistration(1L, new FinishRegistrationRequest()));
    }
}