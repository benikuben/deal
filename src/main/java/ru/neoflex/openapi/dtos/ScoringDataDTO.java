package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import ru.neoflex.openapi.dtos.EmploymentDTO;
import ru.neoflex.openapi.dtos.Gender;
import ru.neoflex.openapi.dtos.MaritalStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Scoring data
 */

@Schema(name = "ScoringDataDTO", description = "Scoring data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-13T21:43:13.391899+03:00[Europe/Moscow]")
@lombok.AllArgsConstructor @lombok.NoArgsConstructor
public class ScoringDataDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private java.math.BigDecimal amount;

  private Integer term;

  private String firstName;

  private String lastName;

  private String middleName;

  private Gender gender;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate birthdate = null;

  private String passportSeries;

  private String passportNumber;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate passportIssueDate = null;

  private String passportIssueBranch;

  private MaritalStatus maritalStatus;

  private Integer dependentAmount;

  private EmploymentDTO employment;

  private String account;

  private Boolean isInsuranceEnabled;

  private Boolean isSalaryClient;

  public ScoringDataDTO amount(java.math.BigDecimal amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Loan amount
   * minimum: 10000.0
   * @return amount
  */
  @Valid @DecimalMin("10000.0") 
  @Schema(name = "amount", example = "10000.0", description = "Loan amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("amount")
  public java.math.BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(java.math.BigDecimal amount) {
    this.amount = amount;
  }

  public ScoringDataDTO term(Integer term) {
    this.term = term;
    return this;
  }

  /**
   * Loan term
   * minimum: 6
   * @return term
  */
  @Min(6) 
  @Schema(name = "term", example = "6", description = "Loan term", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("term")
  public Integer getTerm() {
    return term;
  }

  public void setTerm(Integer term) {
    this.term = term;
  }

  public ScoringDataDTO firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name
   * @return firstName
  */
  @Pattern(regexp = "^[A-Za-z]{2,30}$") 
  @Schema(name = "firstName", example = "Ivan", description = "First name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public ScoringDataDTO lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name
   * @return lastName
  */
  @Pattern(regexp = "^[A-Za-z]{2,30}$") 
  @Schema(name = "lastName", example = "Ivanov", description = "Last name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public ScoringDataDTO middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle name
   * @return middleName
  */
  @Pattern(regexp = "^[A-Za-z]{2,30}$") 
  @Schema(name = "middleName", example = "Ivanovich", description = "Middle name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("middleName")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public ScoringDataDTO gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @Valid 
  @Schema(name = "gender", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("gender")
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public ScoringDataDTO birthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
    return this;
  }

  /**
   * Birthdate in YYYY-MM-DD format
   * @return birthdate
  */
  @Valid 
  @Schema(name = "birthdate", example = "2000-01-01", description = "Birthdate in YYYY-MM-DD format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("birthdate")
  public LocalDate getBirthdate() {
    return birthdate;
  }

  public void setBirthdate(LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public ScoringDataDTO passportSeries(String passportSeries) {
    this.passportSeries = passportSeries;
    return this;
  }

  /**
   * Passport series
   * @return passportSeries
  */
  @Pattern(regexp = "^[0-9]{4}$") 
  @Schema(name = "passportSeries", example = "1234", description = "Passport series", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passportSeries")
  public String getPassportSeries() {
    return passportSeries;
  }

  public void setPassportSeries(String passportSeries) {
    this.passportSeries = passportSeries;
  }

  public ScoringDataDTO passportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
    return this;
  }

  /**
   * Passport number
   * @return passportNumber
  */
  @Pattern(regexp = "^[0-9]{6}$") 
  @Schema(name = "passportNumber", example = "123456", description = "Passport number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passportNumber")
  public String getPassportNumber() {
    return passportNumber;
  }

  public void setPassportNumber(String passportNumber) {
    this.passportNumber = passportNumber;
  }

  public ScoringDataDTO passportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
    return this;
  }

  /**
   * Passport issue date in YYYY-MM-DD format
   * @return passportIssueDate
  */
  @Valid 
  @Schema(name = "passportIssueDate", example = "2014-01-01", description = "Passport issue date in YYYY-MM-DD format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passportIssueDate")
  public LocalDate getPassportIssueDate() {
    return passportIssueDate;
  }

  public void setPassportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
  }

  public ScoringDataDTO passportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
    return this;
  }

  /**
   * Passport issue branch
   * @return passportIssueBranch
  */
  @Pattern(regexp = "^[A-Za-z ]{2,50}$") 
  @Schema(name = "passportIssueBranch", example = "UFMS Moscow", description = "Passport issue branch", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passportIssueBranch")
  public String getPassportIssueBranch() {
    return passportIssueBranch;
  }

  public void setPassportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
  }

  public ScoringDataDTO maritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Get maritalStatus
   * @return maritalStatus
  */
  @Valid 
  @Schema(name = "maritalStatus", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("maritalStatus")
  public MaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public ScoringDataDTO dependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
    return this;
  }

  /**
   * Dependent amount
   * minimum: 0
   * maximum: 20
   * @return dependentAmount
  */
  @Min(0) @Max(20) 
  @Schema(name = "dependentAmount", example = "1", description = "Dependent amount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("dependentAmount")
  public Integer getDependentAmount() {
    return dependentAmount;
  }

  public void setDependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
  }

  public ScoringDataDTO employment(EmploymentDTO employment) {
    this.employment = employment;
    return this;
  }

  /**
   * Get employment
   * @return employment
  */
  @Valid 
  @Schema(name = "employment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("employment")
  public EmploymentDTO getEmployment() {
    return employment;
  }

  public void setEmployment(EmploymentDTO employment) {
    this.employment = employment;
  }

  public ScoringDataDTO account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Account
   * @return account
  */
  @Pattern(regexp = "^\\d{20}$") 
  @Schema(name = "account", example = "01234567890123456789", description = "Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("account")
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  public ScoringDataDTO isInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
    return this;
  }

  /**
   * Is insurance enabled
   * @return isInsuranceEnabled
  */
  
  @Schema(name = "isInsuranceEnabled", example = "true", description = "Is insurance enabled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isInsuranceEnabled")
  public Boolean getIsInsuranceEnabled() {
    return isInsuranceEnabled;
  }

  public void setIsInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
  }

  public ScoringDataDTO isSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
    return this;
  }

  /**
   * Is salary client
   * @return isSalaryClient
  */
  
  @Schema(name = "isSalaryClient", example = "true", description = "Is salary client", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isSalaryClient")
  public Boolean getIsSalaryClient() {
    return isSalaryClient;
  }

  public void setIsSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ScoringDataDTO scoringDataDTO = (ScoringDataDTO) o;
    return Objects.equals(this.amount, scoringDataDTO.amount) &&
        Objects.equals(this.term, scoringDataDTO.term) &&
        Objects.equals(this.firstName, scoringDataDTO.firstName) &&
        Objects.equals(this.lastName, scoringDataDTO.lastName) &&
        Objects.equals(this.middleName, scoringDataDTO.middleName) &&
        Objects.equals(this.gender, scoringDataDTO.gender) &&
        Objects.equals(this.birthdate, scoringDataDTO.birthdate) &&
        Objects.equals(this.passportSeries, scoringDataDTO.passportSeries) &&
        Objects.equals(this.passportNumber, scoringDataDTO.passportNumber) &&
        Objects.equals(this.passportIssueDate, scoringDataDTO.passportIssueDate) &&
        Objects.equals(this.passportIssueBranch, scoringDataDTO.passportIssueBranch) &&
        Objects.equals(this.maritalStatus, scoringDataDTO.maritalStatus) &&
        Objects.equals(this.dependentAmount, scoringDataDTO.dependentAmount) &&
        Objects.equals(this.employment, scoringDataDTO.employment) &&
        Objects.equals(this.account, scoringDataDTO.account) &&
        Objects.equals(this.isInsuranceEnabled, scoringDataDTO.isInsuranceEnabled) &&
        Objects.equals(this.isSalaryClient, scoringDataDTO.isSalaryClient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, term, firstName, lastName, middleName, gender, birthdate, passportSeries, passportNumber, passportIssueDate, passportIssueBranch, maritalStatus, dependentAmount, employment, account, isInsuranceEnabled, isSalaryClient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ScoringDataDTO {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    passportSeries: ").append(toIndentedString(passportSeries)).append("\n");
    sb.append("    passportNumber: ").append(toIndentedString(passportNumber)).append("\n");
    sb.append("    passportIssueDate: ").append(toIndentedString(passportIssueDate)).append("\n");
    sb.append("    passportIssueBranch: ").append(toIndentedString(passportIssueBranch)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    dependentAmount: ").append(toIndentedString(dependentAmount)).append("\n");
    sb.append("    employment: ").append(toIndentedString(employment)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
    sb.append("    isInsuranceEnabled: ").append(toIndentedString(isInsuranceEnabled)).append("\n");
    sb.append("    isSalaryClient: ").append(toIndentedString(isSalaryClient)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

