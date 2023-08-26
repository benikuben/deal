package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import ru.neoflex.openapi.dtos.ClientDTO;
import ru.neoflex.openapi.dtos.CreditDTO;
import ru.neoflex.openapi.dtos.LoanOfferDTO;
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

@Schema(name = "ApplicationDTO", description = "Application")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-26T13:42:25.056214800+03:00[Europe/Moscow]")
public class ApplicationDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private ClientDTO clientId;

  private CreditDTO creditId;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime creationDate;

  private LoanOfferDTO appliedOffer;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime signDate;

  private String sesCode;

  public ApplicationDTO clientId(ClientDTO clientId) {
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
  public ClientDTO getClientId() {
    return clientId;
  }

  public void setClientId(ClientDTO clientId) {
    this.clientId = clientId;
  }

  public ApplicationDTO creditId(CreditDTO creditId) {
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
  public CreditDTO getCreditId() {
    return creditId;
  }

  public void setCreditId(CreditDTO creditId) {
    this.creditId = creditId;
  }

  public ApplicationDTO creationDate(LocalDateTime creationDate) {
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

  public ApplicationDTO appliedOffer(LoanOfferDTO appliedOffer) {
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
  public LoanOfferDTO getAppliedOffer() {
    return appliedOffer;
  }

  public void setAppliedOffer(LoanOfferDTO appliedOffer) {
    this.appliedOffer = appliedOffer;
  }

  public ApplicationDTO signDate(LocalDateTime signDate) {
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

  public ApplicationDTO sesCode(String sesCode) {
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
    ApplicationDTO applicationDTO = (ApplicationDTO) o;
    return Objects.equals(this.clientId, applicationDTO.clientId) &&
        Objects.equals(this.creditId, applicationDTO.creditId) &&
        Objects.equals(this.creationDate, applicationDTO.creationDate) &&
        Objects.equals(this.appliedOffer, applicationDTO.appliedOffer) &&
        Objects.equals(this.signDate, applicationDTO.signDate) &&
        Objects.equals(this.sesCode, applicationDTO.sesCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(clientId, creditId, creationDate, appliedOffer, signDate, sesCode);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationDTO {\n");
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

