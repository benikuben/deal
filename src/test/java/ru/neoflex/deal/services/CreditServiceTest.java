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
//                new PaymentScheduleElement(0, LocalDate.of(2000, 1, 1), amount.negate(), BigDecimal.ZERO, BigDecimal.ZERO, amount),
//                new PaymentScheduleElement(1, LocalDate.of(2000, 2, 1), monthlyPayment, BigDecimal.valueOf(141.67), BigDecimal.valueOf(1608.60), BigDecimal.valueOf(8391.40)),
//                new PaymentScheduleElement(2, LocalDate.of(2000, 3, 1), monthlyPayment, BigDecimal.valueOf(118.88), BigDecimal.valueOf(1608.60), BigDecimal.valueOf(8391.40)),
//                new PaymentScheduleElement(3, LocalDate.of(2000, 4, 1), monthlyPayment, BigDecimal.valueOf(95.77), BigDecimal.valueOf(1654.50), BigDecimal.valueOf(5105.51)),
//                new PaymentScheduleElement(4, LocalDate.of(2000, 5, 1), monthlyPayment, BigDecimal.valueOf(72.33), BigDecimal.valueOf(1677.94), BigDecimal.valueOf(3427.57)),
//                new PaymentScheduleElement(5, LocalDate.of(2000, 6, 1), monthlyPayment, BigDecimal.valueOf(48.56), BigDecimal.valueOf(1701.71), BigDecimal.valueOf(1725.86)),
                new PaymentScheduleElement(6, LocalDate.of(2000, 7, 1), monthlyPayment, BigDecimal.valueOf(24.45), BigDecimal.valueOf(1725.82), BigDecimal.valueOf(0.04))
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
        assertEquals(actualCredit.getId(), actualCredit.getId());
        assertEquals(actualCredit.getAmount(), actualCredit.getAmount());
        assertEquals(actualCredit.getTerm(), actualCredit.getTerm());
        assertEquals(actualCredit.getMonthlyPayment(), actualCredit.getMonthlyPayment());
        assertEquals(actualCredit.getRate(), actualCredit.getRate());
        assertEquals(actualCredit.getPsk(), actualCredit.getPsk());
        assertEquals(actualCredit.getPaymentSchedule(), actualCredit.getPaymentSchedule());
        assertEquals(actualCredit.getIsInsuranceEnabled(), actualCredit.getIsInsuranceEnabled());
        assertEquals(actualCredit.getIsSalaryClient(), actualCredit.getIsSalaryClient());
        assertEquals(actualCredit.getCreditStatus(), actualCredit.getCreditStatus());
        assertEquals(actualCredit.getApplication().getId(), actualCredit.getApplication().getId());
    }
}