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
import ru.neoflex.openapi.dtos.Passport;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Client
 */

@Schema(name = "Client", description = "Client")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-10T00:47:20.725375700+03:00[Europe/Moscow]")
public class Client implements Serializable {

  private static final long serialVersionUID = 1L;

  private String lastName;

  private String firstName;

  private String middleName;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate birthdate = null;

  private String email;

  private Gender gender;

  private MaritalStatus maritalStatus;

  private Integer dependentAmount;

  private Passport passport;

  private Employment employment;

  private String account;

  public Client lastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  /**
   * Last name
   * @return lastName
  */
  
  @Schema(name = "lastName", example = "Ivanov", description = "Last name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("lastName")
  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Client firstName(String firstName) {
    this.firstName = firstName;
    return this;
  }

  /**
   * First name
   * @return firstName
  */
  
  @Schema(name = "firstName", example = "Ivan", description = "First name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("firstName")
  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public Client middleName(String middleName) {
    this.middleName = middleName;
    return this;
  }

  /**
   * Middle name
   * @return middleName
  */
  
  @Schema(name = "middleName", example = "Ivanovich", description = "Middle name", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("middleName")
  public String getMiddleName() {
    return middleName;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public Client birthdate(LocalDate birthdate) {
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

  public Client email(String email) {
    this.email = email;
    return this;
  }

  /**
   * Email
   * @return email
  */
  
  @Schema(name = "email", example = "ivan@mail.ru", description = "Email", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Client gender(Gender gender) {
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

  public Client maritalStatus(MaritalStatus maritalStatus) {
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

  public Client dependentAmount(Integer dependentAmount) {
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

  public Client passport(Passport passport) {
    this.passport = passport;
    return this;
  }

  /**
   * Get passport
   * @return passport
  */
  @Valid 
  @Schema(name = "passport", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("passport")
  public Passport getPassport() {
    return passport;
  }

  public void setPassport(Passport passport) {
    this.passport = passport;
  }

  public Client employment(Employment employment) {
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
  public Employment getEmployment() {
    return employment;
  }

  public void setEmployment(Employment employment) {
    this.employment = employment;
  }

  public Client account(String account) {
    this.account = account;
    return this;
  }

  /**
   * Account
   * @return account
  */
  
  @Schema(name = "account", example = "01234567890123456789", description = "Account", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Client client = (Client) o;
    return Objects.equals(this.lastName, client.lastName) &&
        Objects.equals(this.firstName, client.firstName) &&
        Objects.equals(this.middleName, client.middleName) &&
        Objects.equals(this.birthdate, client.birthdate) &&
        Objects.equals(this.email, client.email) &&
        Objects.equals(this.gender, client.gender) &&
        Objects.equals(this.maritalStatus, client.maritalStatus) &&
        Objects.equals(this.dependentAmount, client.dependentAmount) &&
        Objects.equals(this.passport, client.passport) &&
        Objects.equals(this.employment, client.employment) &&
        Objects.equals(this.account, client.account);
  }

  @Override
  public int hashCode() {
    return Objects.hash(lastName, firstName, middleName, birthdate, email, gender, maritalStatus, dependentAmount, passport, employment, account);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Client {\n");
    sb.append("    lastName: ").append(toIndentedString(lastName)).append("\n");
    sb.append("    firstName: ").append(toIndentedString(firstName)).append("\n");
    sb.append("    middleName: ").append(toIndentedString(middleName)).append("\n");
    sb.append("    birthdate: ").append(toIndentedString(birthdate)).append("\n");
    sb.append("    email: ").append(toIndentedString(email)).append("\n");
    sb.append("    gender: ").append(toIndentedString(gender)).append("\n");
    sb.append("    maritalStatus: ").append(toIndentedString(maritalStatus)).append("\n");
    sb.append("    dependentAmount: ").append(toIndentedString(dependentAmount)).append("\n");
    sb.append("    passport: ").append(toIndentedString(passport)).append("\n");
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

