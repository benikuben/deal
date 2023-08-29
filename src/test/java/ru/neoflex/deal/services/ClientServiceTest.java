package ru.neoflex.deal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.repositories.ClientRepository;
import ru.neoflex.openapi.dtos.Passport;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ClientServiceTest {
    @Mock
    private ClientRepository clientRepository;

    @InjectMocks
    private ClientService clientService;

    @Test
    void save() {
        Passport passport = new Passport();
        passport.setSeries("1234");
        passport.setNumber("123456");
        Client client = new Client();
        client.setLastName("Ivanov");
        client.setFirstName("Ivan");
        client.setMiddleName("Ivanovich");
        client.setBirthdate(LocalDate.of(2000, 1, 1));
        client.setPassport(passport);
        client.setEmail("ivan@mail.ru");

        //expected
        Client expectedClient = new Client();
        BeanUtils.copyProperties(client, expectedClient);
        expectedClient.setId(1L);

        /*
         * Если клиент с таким номером и серией паспорта есть в БД,
         * получаем его, проверяя актуальность email из БД при необходимости обновляя,
         * иначе сохранеяем новгого клиента.
         */
        when(clientRepository.findClientByPassportNumberAndSeries(any(), any())).
                thenReturn(Optional.empty(), Optional.of(client));
        when(clientRepository.save(any())).
                thenReturn(expectedClient);

        //actual
        Client actualClient = clientService.save(client);

        //tests
        assertEquals(actualClient.getId(), expectedClient.getId());
        assertEquals(actualClient.getLastName(), expectedClient.getLastName());
        assertEquals(actualClient.getFirstName(), expectedClient.getFirstName());
        assertEquals(actualClient.getMiddleName(), expectedClient.getMiddleName());
        assertEquals(actualClient.getBirthdate(), expectedClient.getBirthdate());
        assertEquals(actualClient.getEmail(), expectedClient.getEmail());
        assertEquals(actualClient.getPassport(), expectedClient.getPassport());

        //клиент с email, отличным от того, что в бд
        Client clientWithChangedEmail = new Client();
        BeanUtils.copyProperties(client, clientWithChangedEmail);
        clientWithChangedEmail.setEmail("ivanChanged@mail.ru");

        //expected
        expectedClient.setEmail("ivanChanged@mail.ru");

        //actual
        Client actualClient2 = clientService.save(clientWithChangedEmail);

        //tests
        assertEquals(actualClient2.getId(), expectedClient.getId());
        assertEquals(actualClient2.getLastName(), expectedClient.getLastName());
        assertEquals(actualClient2.getFirstName(), expectedClient.getFirstName());
        assertEquals(actualClient2.getMiddleName(), expectedClient.getMiddleName());
        assertEquals(actualClient2.getBirthdate(), expectedClient.getBirthdate());
        assertEquals(actualClient2.getEmail(), expectedClient.getEmail());
        assertEquals(actualClient2.getPassport(), expectedClient.getPassport());
    }
}