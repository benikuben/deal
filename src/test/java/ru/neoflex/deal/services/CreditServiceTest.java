package ru.neoflex.deal.services;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.BeanUtils;
import ru.neoflex.deal.models.Application;
import ru.neoflex.deal.models.Credit;
import ru.neoflex.deal.repositories.CreditRepository;
import ru.neoflex.openapi.dtos.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreditServiceTest {
    @Mock
    private CreditRepository creditRepository;

    @InjectMocks
    private CreditService creditService;

    @Test
    void save() {
        Application application = Application.builder()
                .id(1L).build();
        BigDecimal amount = BigDecimal.valueOf(10000);
        BigDecimal monthlyPayment = BigDecimal.valueOf(1740.34);
        List<PaymentScheduleElement> payments = List.of(
                new PaymentScheduleElement().number(1).date(LocalDate.of(2000, 7, 1)).totalPayment(amount.negate()).interestPayment(BigDecimal.ZERO).debtPayment(BigDecimal.ZERO).remainingDebt(amount)
        );
        Credit credit = Credit.builder()
                .amount(amount)
                .term(6)
                .monthlyPayment(monthlyPayment)
                .rate(BigDecimal.valueOf(15))
                .psk(BigDecimal.valueOf(8.841))
                .paymentSchedule(payments)
                .isInsuranceEnabled(false)
                .isSalaryClient(false)
                .creditStatus(CreditStatus.CALCULATED).
                application(application).build();

        //expected
        Credit expectedCredit = new Credit();
        BeanUtils.copyProperties(credit, expectedCredit);
        expectedCredit.setId(1L);

        when(creditRepository.save(any())).thenReturn(expectedCredit);

        //actual
        Credit actualCredit = creditService.save(credit);

        //tests
        assertEquals(actualCredit.getId(), expectedCredit.getId());
        assertEquals(actualCredit.getAmount(), expectedCredit.getAmount());
        assertEquals(actualCredit.getTerm(), expectedCredit.getTerm());
        assertEquals(actualCredit.getMonthlyPayment(), expectedCredit.getMonthlyPayment());
        assertEquals(actualCredit.getRate(), expectedCredit.getRate());
        assertEquals(actualCredit.getPsk(), expectedCredit.getPsk());
        assertEquals(actualCredit.getPaymentSchedule(), expectedCredit.getPaymentSchedule());
        assertEquals(actualCredit.getIsInsuranceEnabled(), expectedCredit.getIsInsuranceEnabled());
        assertEquals(actualCredit.getIsSalaryClient(), expectedCredit.getIsSalaryClient());
        assertEquals(actualCredit.getCreditStatus(), expectedCredit.getCreditStatus());
        assertEquals(actualCredit.getApplication().getId(), expectedCredit.getApplication().getId());
    }
}