package ru.neoflex.deal.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import ru.neoflex.openapi.dtos.Employment;
import ru.neoflex.openapi.dtos.Gender;
import ru.neoflex.openapi.dtos.MaritalStatus;
import ru.neoflex.openapi.dtos.Passport;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(of = {"id"})
@ToString(exclude = "applications")
public class Client {
    @Id
    @Column(name = "client_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "last_name",nullable=false)
    private String lastName;

    @Column(name = "first_name",nullable=false)
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "birth_date",nullable=false)
    @Temporal(TemporalType.DATE)
    private LocalDate birthdate;

    @Column(name = "email",nullable=false)
    private String email;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column(name = "martial_status")
    @Enumerated(EnumType.STRING)
    private MaritalStatus maritalStatus;

    @Column(name = "dependent_amount")
    private Integer dependentAmount;

    @Column(name = "passport_id", nullable = false)
    @JdbcTypeCode(SqlTypes.JSON)
    private Passport passport;

    @Column(name = "employment_id")
    @JdbcTypeCode(SqlTypes.JSON)
    private Employment employment;

    @Column(name = "account")
    private String account;

    @OneToMany(mappedBy = "clientId")
    private List<Application> applications;
}
