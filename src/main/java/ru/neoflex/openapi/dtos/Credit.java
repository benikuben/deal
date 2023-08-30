package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.ArrayList;
import java.util.List;
import ru.neoflex.openapi.dtos.PaymentScheduleElement;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Credit
 */

@Schema(name = "Credit", description = "Credit")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-30T17:25:18.342929200+03:00[Europe/Moscow]")
public class Credit implements Serializable {

  private static final long serialVersionUID = 1L;

  private java.math.BigDecimal amount;

  private Integer term;

  private java.math.BigDecimal monthlyPayment;

  private java.math.BigDecimal rate;

  private java.math.BigDecimal psk;

  @Valid
  private List<@Valid PaymentScheduleElement> paymentSchedule;

  private Boolean isInsuranceEnabled;

  private Boolean isSalaryClient;

  public Credit amount(java.math.BigDecimal amount) {
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

  public Credit term(Integer term) {
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

  public Credit monthlyPayment(java.math.BigDecimal monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
    return this;
  }

  /**
   * Monthly payment
   * @return monthlyPayment
  */
  @Valid 
  @Schema(name = "monthlyPayment", example = "1740.34", description = "Monthly payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("monthlyPayment")
  public java.math.BigDecimal getMonthlyPayment() {
    return monthlyPayment;
  }

  public void setMonthlyPayment(java.math.BigDecimal monthlyPayment) {
    this.monthlyPayment = monthlyPayment;
  }

  public Credit rate(java.math.BigDecimal rate) {
    this.rate = rate;
    return this;
  }

  /**
   * Rate
   * @return rate
  */
  @Valid 
  @Schema(name = "rate", example = "15", description = "Rate", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("rate")
  public java.math.BigDecimal getRate() {
    return rate;
  }

  public void setRate(java.math.BigDecimal rate) {
    this.rate = rate;
  }

  public Credit psk(java.math.BigDecimal psk) {
    this.psk = psk;
    return this;
  }

  /**
   * PSK
   * @return psk
  */
  @Valid 
  @Schema(name = "psk", example = "8.841", description = "PSK", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("psk")
  public java.math.BigDecimal getPsk() {
    return psk;
  }

  public void setPsk(java.math.BigDecimal psk) {
    this.psk = psk;
  }

  public Credit paymentSchedule(List<@Valid PaymentScheduleElement> paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
    return this;
  }

  public Credit addPaymentScheduleItem(PaymentScheduleElement paymentScheduleItem) {
    if (this.paymentSchedule == null) {
      this.paymentSchedule = new ArrayList<>();
    }
    this.paymentSchedule.add(paymentScheduleItem);
    return this;
  }

  /**
   * Payment schedule
   * @return paymentSchedule
  */
  @Valid 
  @Schema(name = "paymentSchedule", description = "Payment schedule", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("paymentSchedule")
  public List<@Valid PaymentScheduleElement> getPaymentSchedule() {
    return paymentSchedule;
  }

  public void setPaymentSchedule(List<@Valid PaymentScheduleElement> paymentSchedule) {
    this.paymentSchedule = paymentSchedule;
  }

  public Credit isInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
    return this;
  }

  /**
   * Is insurance enabled
   * @return isInsuranceEnabled
  */
  
  @Schema(name = "isInsuranceEnabled", example = "false", description = "Is insurance enabled", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("isInsuranceEnabled")
  public Boolean getIsInsuranceEnabled() {
    return isInsuranceEnabled;
  }

  public void setIsInsuranceEnabled(Boolean isInsuranceEnabled) {
    this.isInsuranceEnabled = isInsuranceEnabled;
  }

  public Credit isSalaryClient(Boolean isSalaryClient) {
    this.isSalaryClient = isSalaryClient;
    return this;
  }

  /**
   * Is salary client
   * @return isSalaryClient
  */
  
  @Schema(name = "isSalaryClient", example = "false", description = "Is salary client", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
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
    Credit credit = (Credit) o;
    return Objects.equals(this.amount, credit.amount) &&
        Objects.equals(this.term, credit.term) &&
        Objects.equals(this.monthlyPayment, credit.monthlyPayment) &&
        Objects.equals(this.rate, credit.rate) &&
        Objects.equals(this.psk, credit.psk) &&
        Objects.equals(this.paymentSchedule, credit.paymentSchedule) &&
        Objects.equals(this.isInsuranceEnabled, credit.isInsuranceEnabled) &&
        Objects.equals(this.isSalaryClient, credit.isSalaryClient);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, term, monthlyPayment, rate, psk, paymentSchedule, isInsuranceEnabled, isSalaryClient);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Credit {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    term: ").append(toIndentedString(term)).append("\n");
    sb.append("    monthlyPayment: ").append(toIndentedString(monthlyPayment)).append("\n");
    sb.append("    rate: ").append(toIndentedString(rate)).append("\n");
    sb.append("    psk: ").append(toIndentedString(psk)).append("\n");
    sb.append("    paymentSchedule: ").append(toIndentedString(paymentSchedule)).append("\n");
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

