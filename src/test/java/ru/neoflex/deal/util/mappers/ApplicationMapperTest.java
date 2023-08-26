package ru.neoflex.deal.util.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Client;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.openapi.dtos.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ApplicationMapperTest {
    @Autowired
    private ApplicationMapper applicationMapper;

    @TestConfiguration
    public static class TestConfig {
        @Bean
        public ApplicationMapper applicationMapper() {
            return new ApplicationMapperImpl();
        }
    }

    @Test
    void applicationToApplicationDTO() {
        Passport passport = new Passport()
                .series("1234")
                .number("123456")
                .issueDate(LocalDate.of(2014, 1, 1))
                .issueBranch("UFMS Moscow");
        EmploymentDTO employment = new EmploymentDTO()
                .employmentStatus(EmploymentStatus.BUSINESS_OWNER)
                .employerINN("0123456789")
                .salary(BigDecimal.valueOf(20000))
                .position(Position.TOP_MANAGER)
                .workExperienceTotal(12)
                .workExperienceCurrent(12);
        Client client = Client.builder()
                .id(1L)
                .lastName("Ivanov")
                .firstName("Ivan")
                .middleName("Ivanovich")
                .birthdate(LocalDate.of(2000, 1, 1))
                .email("ivan@mail.ru")
                .gender(Gender.MALE)
                .maritalStatus(MaritalStatus.MARRIED)
                .dependentAmount(1)
                .passport(passport)
                .employment(employment)
                .account("01234567890123456789")
                .build();
        BigDecimal amount = BigDecimal.valueOf(10000);
        BigDecimal monthlyPayment = BigDecimal.valueOf(1740.34);
        BigDecimal rate = BigDecimal.valueOf(15);
        List<PaymentScheduleElement> payments = List.of(
                new PaymentScheduleElement().number(1).date(LocalDate.of(2000, 7, 1)).totalPayment(amount.negate()).interestPayment(BigDecimal.ZERO).debtPayment(BigDecimal.ZERO).remainingDebt(amount)
        );
        Credit credit = Credit.builder()
                .id(1L)
                .amount(amount)
                .term(6)
                .monthlyPayment(monthlyPayment)
                .rate(rate)
                .psk(BigDecimal.valueOf(8.841))
                .paymentSchedule(payments)
                .isInsuranceEnabled(false)
                .isSalaryClient(false)
                .creditStatus(CreditStatus.CALCULATED)
                .build();
        LoanOfferDTO offer = new LoanOfferDTO()
                .applicationId(1L)
                .requestedAmount(amount)
                .totalAmount(amount)
                .term(6)
                .monthlyPayment(monthlyPayment)
                .rate(rate)
                .isInsuranceEnabled(false)
                .isSalaryClient(false);
        List<ApplicationStatusHistoryDTO> history = List.of(
                new ApplicationStatusHistoryDTO()
                        .status(ApplicationStatus.PREAPPROVAL)
                        .changeType(ChangeType.AUTOMATIC)
                        .time(LocalDateTime.now())
        );
        Application application = Application.builder()
                .id(1L)
                .clientId(client)
                .creditId(credit)
                .status(ApplicationStatus.CC_APPROVED)
                .creationDate(LocalDateTime.now())
                .appliedOffer(offer)
                .signDate(LocalDateTime.now())
                .sesCode("1234")
                .statusHistory(history)
                .build();

        //expected
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        CreditDTO creditDTO = new CreditDTO();
        BeanUtils.copyProperties(credit, creditDTO);
        ApplicationDTO expected = new ApplicationDTO();
        BeanUtils.copyProperties(application, expected);
        expected
                .clientId(clientDTO)
                .creditId(creditDTO);

        //actual
        ApplicationDTO actual = applicationMapper.applicationToApplicationDTO(application);

        //tests
        assertNotNull(actual);
        assertEquals(actual, expected);
    }
}