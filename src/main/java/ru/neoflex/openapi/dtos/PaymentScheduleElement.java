package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Payment schedule element
 */

@Schema(name = "PaymentScheduleElement", description = "Payment schedule element")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-04T21:19:31.333702200+03:00[Europe/Moscow]")
public class PaymentScheduleElement implements Serializable {

  private static final long serialVersionUID = 1L;

  private Integer number;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate date = null;

  private java.math.BigDecimal totalPayment;

  private java.math.BigDecimal interestPayment;

  private java.math.BigDecimal debtPayment;

  private java.math.BigDecimal remainingDebt;

  public PaymentScheduleElement number(Integer number) {
    this.number = number;
    return this;
  }

  /**
   * Number
   * @return number
  */
  
  @Schema(name = "number", example = "0", description = "Number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public Integer getNumber() {
    return number;
  }

  public void setNumber(Integer number) {
    this.number = number;
  }

  public PaymentScheduleElement date(LocalDate date) {
    this.date = date;
    return this;
  }

  /**
   * Date in YYYY-MM-DD format
   * @return date
  */
  @Valid 
  @Schema(name = "date", example = "2023-07-31", description = "Date in YYYY-MM-DD format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("date")
  public LocalDate getDate() {
    return date;
  }

  public void setDate(LocalDate date) {
    this.date = date;
  }

  public PaymentScheduleElement totalPayment(java.math.BigDecimal totalPayment) {
    this.totalPayment = totalPayment;
    return this;
  }

  /**
   * Total payment
   * @return totalPayment
  */
  @Valid 
  @Schema(name = "totalPayment", example = "-10000.0", description = "Total payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("totalPayment")
  public java.math.BigDecimal getTotalPayment() {
    return totalPayment;
  }

  public void setTotalPayment(java.math.BigDecimal totalPayment) {
    this.totalPayment = totalPayment;
  }

  public PaymentScheduleElement interestPayment(java.math.BigDecimal interestPayment) {
    this.interestPayment = interestPayment;
    return this;
  }

  /**
   * Interest payment
   * @return interestPayment
  */
  @Valid 
  @Schema(name = "interestPayment", example = "0", description = "Interest payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("interestPayment")
  public java.math.BigDecimal getInterestPayment() {
    return interestPayment;
  }

  public void setInterestPayment(java.math.BigDecimal interestPayment) {
    this.interestPayment = interestPayment;
  }

  public PaymentScheduleElement debtPayment(java.math.BigDecimal debtPayment) {
    this.debtPayment = debtPayment;
    return this;
  }

  /**
   * Debt payment
   * @return debtPayment
  */
  @Valid 
  @Schema(name = "debtPayment", example = "0", description = "Debt payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("debtPayment")
  public java.math.BigDecimal getDebtPayment() {
    return debtPayment;
  }

  public void setDebtPayment(java.math.BigDecimal debtPayment) {
    this.debtPayment = debtPayment;
  }

  public PaymentScheduleElement remainingDebt(java.math.BigDecimal remainingDebt) {
    this.remainingDebt = remainingDebt;
    return this;
  }

  /**
   * Remaining payment
   * @return remainingDebt
  */
  @Valid 
  @Schema(name = "remainingDebt", example = "10000", description = "Remaining payment", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("remainingDebt")
  public java.math.BigDecimal getRemainingDebt() {
    return remainingDebt;
  }

  public void setRemainingDebt(java.math.BigDecimal remainingDebt) {
    this.remainingDebt = remainingDebt;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PaymentScheduleElement paymentScheduleElement = (PaymentScheduleElement) o;
    return Objects.equals(this.number, paymentScheduleElement.number) &&
        Objects.equals(this.date, paymentScheduleElement.date) &&
        Objects.equals(this.totalPayment, paymentScheduleElement.totalPayment) &&
        Objects.equals(this.interestPayment, paymentScheduleElement.interestPayment) &&
        Objects.equals(this.debtPayment, paymentScheduleElement.debtPayment) &&
        Objects.equals(this.remainingDebt, paymentScheduleElement.remainingDebt);
  }

  @Override
  public int hashCode() {
    return Objects.hash(number, date, totalPayment, interestPayment, debtPayment, remainingDebt);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentScheduleElement {\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    date: ").append(toIndentedString(date)).append("\n");
    sb.append("    totalPayment: ").append(toIndentedString(totalPayment)).append("\n");
    sb.append("    interestPayment: ").append(toIndentedString(interestPayment)).append("\n");
    sb.append("    debtPayment: ").append(toIndentedString(debtPayment)).append("\n");
    sb.append("    remainingDebt: ").append(toIndentedString(remainingDebt)).append("\n");
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

