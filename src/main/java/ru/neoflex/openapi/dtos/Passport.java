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
 * Passport
 */

@Schema(name = "Passport", description = "Passport")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-13T21:43:13.391899+03:00[Europe/Moscow]")
public class Passport implements Serializable {

  private static final long serialVersionUID = 1L;

  private String series;

  private String number;

  private String issueBranch;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer.class)
  private LocalDate issueDate = null;

  public Passport series(String series) {
    this.series = series;
    return this;
  }

  /**
   * Passport series
   * @return series
  */
  
  @Schema(name = "series", example = "1234", description = "Passport series", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("series")
  public String getSeries() {
    return series;
  }

  public void setSeries(String series) {
    this.series = series;
  }

  public Passport number(String number) {
    this.number = number;
    return this;
  }

  /**
   * Passport number
   * @return number
  */
  
  @Schema(name = "number", example = "123456", description = "Passport number", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("number")
  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public Passport issueBranch(String issueBranch) {
    this.issueBranch = issueBranch;
    return this;
  }

  /**
   * Passport issue branch
   * @return issueBranch
  */
  
  @Schema(name = "issueBranch", example = "UFMS Moscow", description = "Passport issue branch", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issueBranch")
  public String getIssueBranch() {
    return issueBranch;
  }

  public void setIssueBranch(String issueBranch) {
    this.issueBranch = issueBranch;
  }

  public Passport issueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
    return this;
  }

  /**
   * Passport issue date in YYYY-MM-DD format
   * @return issueDate
  */
  @Valid 
  @Schema(name = "issueDate", example = "2014-01-01", description = "Passport issue date in YYYY-MM-DD format", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("issueDate")
  public LocalDate getIssueDate() {
    return issueDate;
  }

  public void setIssueDate(LocalDate issueDate) {
    this.issueDate = issueDate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Passport passport = (Passport) o;
    return Objects.equals(this.series, passport.series) &&
        Objects.equals(this.number, passport.number) &&
        Objects.equals(this.issueBranch, passport.issueBranch) &&
        Objects.equals(this.issueDate, passport.issueDate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(series, number, issueBranch, issueDate);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Passport {\n");
    sb.append("    series: ").append(toIndentedString(series)).append("\n");
    sb.append("    number: ").append(toIndentedString(number)).append("\n");
    sb.append("    issueBranch: ").append(toIndentedString(issueBranch)).append("\n");
    sb.append("    issueDate: ").append(toIndentedString(issueDate)).append("\n");
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

