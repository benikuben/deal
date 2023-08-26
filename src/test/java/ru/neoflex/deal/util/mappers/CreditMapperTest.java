package ru.neoflex.deal.util.mappers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.openapi.dtos.CreditDTO;
import ru.neoflex.openapi.dtos.PaymentScheduleElement;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CreditMapperTest {
    @Autowired
    private CreditMapper creditMapper;

    @TestConfiguration
    public static class TestConfig {
        @Bean
        public CreditMapper creditMapper() {
            return new CreditMapperImpl();
        }
    }

    @Test
    void creditDTOToCredit() {
        BigDecimal amount = BigDecimal.valueOf(10000);
        BigDecimal monthlyPayment = BigDecimal.valueOf(1740.34);
        BigDecimal rate = BigDecimal.valueOf(15);
        BigDecimal psk = BigDecimal.valueOf(8.841);
        List<PaymentScheduleElement> payments = List.of(
                new PaymentScheduleElement().number(1).date(LocalDate.of(2000, 7, 1)).totalPayment(amount.negate()).interestPayment(BigDecimal.ZERO).debtPayment(BigDecimal.ZERO).remainingDebt(amount)
        );
        CreditDTO creditDTO = new CreditDTO()
                .amount(amount)
                .term(6)
                .monthlyPayment(monthlyPayment)
                .rate(rate)
                .psk(psk)
                .paymentSchedule(payments)
                .isInsuranceEnabled(false)
                .isSalaryClient(false);

        //expected
        Credit expected = Credit.builder()
                .amount(amount)
                .term(6)
                .monthlyPayment(monthlyPayment)
                .rate(rate)
                .psk(psk)
                .paymentSchedule(payments)
                .isInsuranceEnabled(false)
                .isSalaryClient(false)
                .build();

        //actual
        Credit actual = creditMapper.creditDTOToCredit(creditDTO);

        //tests
        assertNotNull(actual);
        assertEquals(actual.getAmount(), expected.getAmount());
        assertEquals(actual.getTerm(), expected.getTerm());
        assertEquals(actual.getMonthlyPayment(), expected.getMonthlyPayment());
        assertEquals(actual.getRate(), expected.getRate());
        assertEquals(actual.getPsk(), expected.getPsk());
        assertEquals(actual.getPaymentSchedule(), expected.getPaymentSchedule());
        assertEquals(actual.getIsInsuranceEnabled(), expected.getIsInsuranceEnabled());
        assertEquals(actual.getIsSalaryClient(), expected.getIsSalaryClient());
    }
}