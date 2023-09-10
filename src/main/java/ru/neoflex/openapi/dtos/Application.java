package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import ru.neoflex.openapi.dtos.Client;
import ru.neoflex.openapi.dtos.Credit;
import ru.neoflex.openapi.dtos.LoanOffer;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Application
 */

@Schema(name = "Application", description = "Application")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-10T00:47:20.725375700+03:00[Europe/Moscow]")
public class Application implements Serializable {

  private static final long serialVersionUID = 1L;

  private Client clientId;

  private Credit creditId;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime creationDate;

  private LoanOffer appliedOffer;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime signDate;

  private String sesCode;

  public Application clientId(Client clientId) {
    this.clientId = clientId;
    return this;
  }

  /**
   * Get clientId
   * @return clientId
  */
  @Valid 
  @Schema(name = "clientId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("clientId")
  public Client getClientId() {
    return clientId;
  }

  public void setClientId(Client clientId) {
    this.clientId = clientId;
  }

  public Application creditId(Credit creditId) {
    this.creditId = creditId;
    return this;
  }

  /**
   * Get creditId
   * @return creditId
  */
  @Valid 
  @Schema(name = "creditId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creditId")
  public Credit getCreditId() {
    return creditId;
  }

  public void setCreditId(Credit creditId) {
    this.creditId = creditId;
  }

  public Application creationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
    return this;
  }

  /**
   * Time and date of the status change
   * @return creationDate
  */
  @Valid 
  @Schema(name = "creationDate", example = "2017-07-21T17:32:28Z", description = "Time and date of the status change", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("creationDate")
  public LocalDateTime getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(LocalDateTime creationDate) {
    this.creationDate = creationDate;
  }

  public Application appliedOffer(LoanOffer appliedOffer) {
    this.appliedOffer = appliedOffer;
    return this;
  }

  /**
   * Get appliedOffer
   * @return appliedOffer
  */
  @Valid 
  @Schema(name = "appliedOffer", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("appliedOffer")
  public LoanOffer getAppliedOffer() {
    return appliedOffer;
  }

  public void setAppliedOffer(LoanOffer appliedOffer) {
    this.appliedOffer = appliedOffer;
  }

  public Application signDate(LocalDateTime signDate) {
    this.signDate = signDate;
    return this;
  }

  /**
   * Time and date of the status change
   * @return signDate
  */
  @Valid 
  @Schema(name = "signDate", example = "2017-07-21T17:32:28Z", description = "Time and date of the status change", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("signDate")
  public LocalDateTime getSignDate() {
    return signDate;
  }

  public void setSignDate(LocalDateTime signDate) {
    this.signDate = signDate;
  }

  public Application sesCode(String sesCode) {
    this.sesCode = sesCode;
    return this;
  }

  /**
   * Ses code
   * @return sesCode
  */
  
  @Schema(name = "sesCode", example = "1234", description = "Ses code", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("sesCode")
  public String getSesCode() {
    return sesCode;
  }

  public void setSesCode(String sesCode) {
    this.sesCode = sesCode;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Application application = (Application) o;
    return Objects.equals(this.clientId, application.clientId) &&
        Objects.equals(this.creditId, application.creditId) &&
        Objects.equals(this.creationDate, application.creationDate) &&
        Objects.equals(this.appliedOffer, application.appliedOffer) &&
        Objects.equals(this.signDate, application.signDate) &&
        Objects.equals(this.sesCode, application.sesCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, creditId, creationDate, appliedOffer, signDate, sesCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Application {\n");
    sb.append("    clientId: ").append(toIndentedString(clientId)).append("\n");
    sb.append("    creditId: ").append(toIndentedString(creditId)).append("\n");
    sb.append("    creationDate: ").append(toIndentedString(creationDate)).append("\n");
    sb.append("    appliedOffer: ").append(toIndentedString(appliedOffer)).append("\n");
    sb.append("    signDate: ").append(toIndentedString(signDate)).append("\n");
    sb.append("    sesCode: ").append(toIndentedString(sesCode)).append("\n");
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

