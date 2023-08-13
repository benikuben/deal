package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import ru.neoflex.openapi.dtos.EmploymentDTO;
import ru.neoflex.openapi.dtos.Gender;
import ru.neoflex.openapi.dtos.MaritalStatus;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

/**
 * User data required for full calculation of loan parameters
 */

@Schema(name = "FinishRegistrationRequestDTO", description = "User data required for full calculation of loan parameters")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-07T16:38:08.239013800+03:00[Europe/Moscow]")
public class FinishRegistrationRequestDTO  implements Serializable {

  private static final long serialVersionUID = 1L;

  @JsonProperty("gender")
  private Gender gender;

  @JsonProperty("maritalStatus")
  private MaritalStatus maritalStatus;

  @JsonProperty("dependentAmount")
  private Integer dependentAmount;

  @JsonProperty("passportIssueDate")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate passportIssueDate;

  @JsonProperty("passportIssueBrach")
  private String passportIssueBrach;

  @JsonProperty("employment")
  private EmploymentDTO employment;

  @JsonProperty("account")
  private String account;

  public FinishRegistrationRequestDTO gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @Valid 
  @Schema(name = "gender", required = false)
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public FinishRegistrationRequestDTO maritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Get maritalStatus
   * @return maritalStatus
  */
  @Valid 
  @Schema(name = "maritalStatus", required = false)
  public MaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public FinishRegistrationRequestDTO dependentAmount(Integer dependentAmount) {
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
  @Schema(name = "dependentAmount", example = "1", description = "Dependent amount", required = false)
  public Integer getDependentAmount() {
    return dependentAmount;
  }

  public void setDependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
  }

  public FinishRegistrationRequestDTO passportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
    return this;
  }

  /**
   * Passport issue date in YYYY-MM-DD format
   * @return passportIssueDate
  */
  @Valid @Pattern(regexp = "^\\d{4}(0[1-9]|1[012])(0[1-9]|[12][0-9]|3[01])$") @Size(min = 10, max = 10) 
  @Schema(name = "passportIssueDate", example = "Wed Jan 01 04:00:00 MSK 2014", description = "Passport issue date in YYYY-MM-DD format", required = false)
  public LocalDate getPassportIssueDate() {
    return passportIssueDate;
  }

  public void setPassportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
  }

  public FinishRegistrationRequestDTO passportIssueBrach(String passportIssueBrach) {
    this.passportIssueBrach = passportIssueBrach;
    return this;
  }

  /**
   * Passport issue branch
   * @return passportIssueBrach
  */
  @Pattern(regexp = "^[A-Za-z ]{2,50}$") 
  @Schema(name = "passportIssueBrach", example = "UFMS Moscow", description = "Passport issue branch", required = false)
  public String getPassportIssueBrach() {
    return passportIssueBrach;
  }

  public void setPassportIssueBrach(String passportIssueBrach) {
    this.passportIssueBrach = passportIssueBrach;
  }

  public FinishRegistrationRequestDTO employment(EmploymentDTO employment) {
    this.employment = employment;
    return this;
  }

  /**
   * Get employment
   * @return employment
  */
  @Valid 
  @Schema(name = "employment", required = false)
  public EmploymentDTO getEmployment() {
    return employment;
  }

  public void setEmployment(EmploymentDTO employment) {
    this.employment = employment;
  }

  public FinishRegistrationRequestDTO account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Account
   * @return account
  */
  @Pattern(regexp = "^\\d{20}$") 
  @Schema(name = "account", example = "1.2345678901234568E+18", description = "Account", required = false)
  public String getAccount() {
    return account;
  }

  public void setAccount(String account) {
    this.account = account;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FinishRegistrationRequestDTO finishRegistrationRequestDTO = (FinishRegistrationRequestDTO) o;
    return Objects.equals(this.gender, finishRegistrationRequestDTO.gender) &&
        Objects.equals(this.maritalStatus, finishRegistrationRequestDTO.maritalStatus) &&
        Objects.equals(this.dependentAmount, finishRegistrationRequestDTO.dependentAmount) &&
        Objects.equals(this.passportIssueDate, finishRegistrationRequestDTO.passportIssueDate) &&
        Objects.equals(this.passportIssueBrach, finishRegistrationRequestDTO.passportIssueBrach) &&
        Objects.equals(this.employment, finishRegistrationRequestDTO.employment) &&
        Objects.equals(this.account, finishRegistrationRequestDTO.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gender, maritalStatus, dependentAmount, passportIssueDate, passportIssueBrach, employment, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinishRegistrationRequestDTO {\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    dependentAmount: ").append(toIndentedString(dependentAmount)).append("\n");
    sb.append("    passportIssueDate: ").append(toIndentedString(passportIssueDate)).append("\n");
    sb.append("    passportIssueBrach: ").append(toIndentedString(passportIssueBrach)).append("\n");
    sb.append("    employment: ").append(toIndentedString(employment)).append("\n");
    sb.append("    account: ").append(toIndentedString(account)).append("\n");
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

