package ru.neoflex.deal.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.neoflex.openapi.dtos.CreditStatus;
import ru.neoflex.openapi.dtos.PaymentScheduleElement;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "credit")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Credit {
    @Id
    @Column(name = "credit_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount", nullable = false)
    private BigDecimal amount;

    @Column(name = "term", nullable = false)
    private Integer term;

    @Column(name = "monthly_payment", nullable = false)
    private BigDecimal monthlyPayment;

    @Column(name = "rate", nullable = false)
    private BigDecimal rate;

    @Column(name = "psk", nullable = false)
    private BigDecimal psk;

    @Column(name = "payment_schedule", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private List<PaymentScheduleElement> paymentSchedule;

    @Column(name = "insurance_enable", nullable = false)
    private Boolean isInsuranceEnabled;

    @Column(name = "salary_client", nullable = false)
    private Boolean isSalaryClient;

    @Column(name = "credit_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private CreditStatus creditStatus;

    @OneToOne(mappedBy = "creditId")
    private Application application;

}
