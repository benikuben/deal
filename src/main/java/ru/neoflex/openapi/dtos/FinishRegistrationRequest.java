package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDate;
import ru.neoflex.openapi.dtos.Employment;
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
 * Finish registration request
 */

@Schema(name = "FinishRegistrationRequest", description = "Finish registration request")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-29T12:41:16.541503800+03:00[Europe/Moscow]")
public class FinishRegistrationRequest implements Serializable {

  private static final long serialVersionUID = 1L;

  private Gender gender;

  private MaritalStatus maritalStatus;

  private Integer dependentAmount;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate passportIssueDate = null;

  private String passportIssueBranch;

  private Employment employment;

  private String account;

  /**
   * Default constructor
   * @deprecated Use {@link FinishRegistrationRequest#FinishRegistrationRequest(Gender, MaritalStatus, Integer, LocalDate, String, Employment, String)}
   */
  @Deprecated
  public FinishRegistrationRequest() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public FinishRegistrationRequest(Gender gender, MaritalStatus maritalStatus, Integer dependentAmount, LocalDate passportIssueDate, String passportIssueBranch, Employment employment, String account) {
    this.gender = gender;
    this.maritalStatus = maritalStatus;
    this.dependentAmount = dependentAmount;
    this.passportIssueDate = passportIssueDate;
    this.passportIssueBranch = passportIssueBranch;
    this.employment = employment;
    this.account = account;
  }

  public FinishRegistrationRequest gender(Gender gender) {
    this.gender = gender;
    return this;
  }

  /**
   * Get gender
   * @return gender
  */
  @NotNull @Valid 
  @Schema(name = "gender", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("gender")
  public Gender getGender() {
    return gender;
  }

  public void setGender(Gender gender) {
    this.gender = gender;
  }

  public FinishRegistrationRequest maritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
    return this;
  }

  /**
   * Get maritalStatus
   * @return maritalStatus
  */
  @NotNull @Valid 
  @Schema(name = "maritalStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("maritalStatus")
  public MaritalStatus getMaritalStatus() {
    return maritalStatus;
  }

  public void setMaritalStatus(MaritalStatus maritalStatus) {
    this.maritalStatus = maritalStatus;
  }

  public FinishRegistrationRequest dependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
    return this;
  }

  /**
   * Dependent amount
   * minimum: 0
   * maximum: 20
   * @return dependentAmount
  */
  @NotNull @Min(0) @Max(20) 
  @Schema(name = "dependentAmount", example = "1", description = "Dependent amount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dependentAmount")
  public Integer getDependentAmount() {
    return dependentAmount;
  }

  public void setDependentAmount(Integer dependentAmount) {
    this.dependentAmount = dependentAmount;
  }

  public FinishRegistrationRequest passportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
    return this;
  }

  /**
   * Passport issue date in YYYY-MM-DD format
   * @return passportIssueDate
  */
  @NotNull @Valid 
  @Schema(name = "passportIssueDate", example = "2014-01-01", description = "Passport issue date in YYYY-MM-DD format", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("passportIssueDate")
  public LocalDate getPassportIssueDate() {
    return passportIssueDate;
  }

  public void setPassportIssueDate(LocalDate passportIssueDate) {
    this.passportIssueDate = passportIssueDate;
  }

  public FinishRegistrationRequest passportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
    return this;
  }

  /**
   * Passport issue branch
   * @return passportIssueBranch
  */
  @NotNull @Pattern(regexp = "^[A-Za-z ]{2,50}$", message="должно быть длиной от 2 до 50 латинских букв") 
  @Schema(name = "passportIssueBranch", example = "UFMS Moscow", description = "Passport issue branch", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("passportIssueBranch")
  public String getPassportIssueBranch() {
    return passportIssueBranch;
  }

  public void setPassportIssueBranch(String passportIssueBranch) {
    this.passportIssueBranch = passportIssueBranch;
  }

  public FinishRegistrationRequest employment(Employment employment) {
    this.employment = employment;
    return this;
  }

  /**
   * Get employment
   * @return employment
  */
  @NotNull @Valid 
  @Schema(name = "employment", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("employment")
  public Employment getEmployment() {
    return employment;
  }

  public void setEmployment(Employment employment) {
    this.employment = employment;
  }

  public FinishRegistrationRequest account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Account
   * @return account
  */
  @NotNull @Pattern(regexp = "^\\d{20}$", message="должно содержать 20 цифр") 
  @Schema(name = "account", example = "01234567890123456789", description = "Account", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("account")
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
    FinishRegistrationRequest finishRegistrationRequest = (FinishRegistrationRequest) o;
    return Objects.equals(this.gender, finishRegistrationRequest.gender) &&
        Objects.equals(this.maritalStatus, finishRegistrationRequest.maritalStatus) &&
        Objects.equals(this.dependentAmount, finishRegistrationRequest.dependentAmount) &&
        Objects.equals(this.passportIssueDate, finishRegistrationRequest.passportIssueDate) &&
        Objects.equals(this.passportIssueBranch, finishRegistrationRequest.passportIssueBranch) &&
        Objects.equals(this.employment, finishRegistrationRequest.employment) &&
        Objects.equals(this.account, finishRegistrationRequest.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(gender, maritalStatus, dependentAmount, passportIssueDate, passportIssueBranch, employment, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FinishRegistrationRequest {\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    dependentAmount: ").append(toIndentedString(dependentAmount)).append("\n");
    sb.append("    passportIssueDate: ").append(toIndentedString(passportIssueDate)).append("\n");
    sb.append("    passportIssueBranch: ").append(toIndentedString(passportIssueBranch)).append("\n");
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

