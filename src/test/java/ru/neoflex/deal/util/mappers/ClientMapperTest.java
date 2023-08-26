package ru.neoflex.deal.util.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.neoflex.deal.models.Client;
import ru.neoflex.openapi.dtos.*;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ClientMapperTest {
    @Autowired
    private ClientMapper clientMapper;

    @TestConfiguration
    public static class TestConfig {
        @Bean
        public ClientMapper clientMapper() {
            return new ClientMapperImpl();
        }
    }

    @Test
    void loanApplicationRequestDTOToClient() {
        LoanApplicationRequestDTO request = new LoanApplicationRequestDTO()
                .firstName("Ivan")
                .lastName("Ivanov")
                .middleName("Ivanovich")
                .email("ivan@mail.ru")
                .birthdate(LocalDate.of(2000, 1, 1))
                .passportSeries("1234")
                .passportNumber("123456");

        //expected
        Passport passport = new Passport()
                .series("1234")
                .number("123456");
        Client expected = Client.builder()
                .lastName("Ivanov")
                .firstName("Ivan")
                .middleName("Ivanovich")
                .birthdate(LocalDate.of(2000, 1, 1))
                .email("ivan@mail.ru")
                .passport(passport)
                .build();

        //actual
        Client actual = clientMapper.loanApplicationRequestDTOToClient(request);

        //tests
        assertNotNull(actual);
        assertEquals(actual.getFirstName(), expected.getFirstName());
        assertEquals(actual.getLastName(), expected.getLastName());
        assertEquals(actual.getMiddleName(), expected.getMiddleName());
        assertEquals(actual.getEmail(), expected.getEmail());
        assertEquals(actual.getBirthdate(), expected.getBirthdate());
        assertEquals(actual.getPassport().getNumber(), expected.getPassport().getNumber());
        assertEquals(actual.getPassport().getSeries(), expected.getPassport().getSeries());
    }

    @Test
    void passportSeriesAndNumberToPassport() {
        LoanApplicationRequestDTO request = new LoanApplicationRequestDTO()
                .passportSeries("1234")
                .passportNumber("123456");

        //expected
        Passport expected = new Passport()
                .series("1234")
                .number("123456");

        //actual
        Passport actual = ClientMapper.passportSeriesAndNumberToPassport(request);

        //tests
        assertNotNull(actual);
        assertEquals(actual, expected);
    }
}