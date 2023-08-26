package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;
import ru.neoflex.openapi.dtos.ApplicationStatus;
import ru.neoflex.openapi.dtos.ChangeType;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Application status history
 */

@Schema(name = "ApplicationStatusHistoryDTO", description = "Application status history")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-26T13:42:25.056214800+03:00[Europe/Moscow]")
public class ApplicationStatusHistoryDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private ApplicationStatus status;

  @com.fasterxml.jackson.databind.annotation.JsonSerialize(using = com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer.class) @com.fasterxml.jackson.databind.annotation.JsonDeserialize(using = com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer.class)
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
  private LocalDateTime time;

  private ChangeType changeType;

  /**
   * Default constructor
   * @deprecated Use {@link ApplicationStatusHistoryDTO#ApplicationStatusHistoryDTO(ApplicationStatus, LocalDateTime, ChangeType)}
   */
  @Deprecated
  public ApplicationStatusHistoryDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public ApplicationStatusHistoryDTO(ApplicationStatus status, LocalDateTime time, ChangeType changeType) {
    this.status = status;
    this.time = time;
    this.changeType = changeType;
  }

  public ApplicationStatusHistoryDTO status(ApplicationStatus status) {
    this.status = status;
    return this;
  }

  /**
   * Get status
   * @return status
  */
  @NotNull @Valid 
  @Schema(name = "status", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("status")
  public ApplicationStatus getStatus() {
    return status;
  }

  public void setStatus(ApplicationStatus status) {
    this.status = status;
  }

  public ApplicationStatusHistoryDTO time(LocalDateTime time) {
    this.time = time;
    return this;
  }

  /**
   * Time and date of the status change
   * @return time
  */
  @NotNull @Valid 
  @Schema(name = "time", example = "2017-07-21T17:32:28Z", description = "Time and date of the status change", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("time")
  public LocalDateTime getTime() {
    return time;
  }

  public void setTime(LocalDateTime time) {
    this.time = time;
  }

  public ApplicationStatusHistoryDTO changeType(ChangeType changeType) {
    this.changeType = changeType;
    return this;
  }

  /**
   * Get changeType
   * @return changeType
  */
  @NotNull @Valid 
  @Schema(name = "changeType", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("changeType")
  public ChangeType getChangeType() {
    return changeType;
  }

  public void setChangeType(ChangeType changeType) {
    this.changeType = changeType;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ApplicationStatusHistoryDTO applicationStatusHistoryDTO = (ApplicationStatusHistoryDTO) o;
    return Objects.equals(this.status, applicationStatusHistoryDTO.status) &&
        Objects.equals(this.time, applicationStatusHistoryDTO.time) &&
        Objects.equals(this.changeType, applicationStatusHistoryDTO.changeType);
  }

  @Override
  public int hashCode() {
    return Objects.hash(status, time, changeType);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ApplicationStatusHistoryDTO {\n");
    sb.append("    status: ").append(toIndentedString(status)).append("\n");
    sb.append("    time: ").append(toIndentedString(time)).append("\n");
    sb.append("    changeType: ").append(toIndentedString(changeType)).append("\n");
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

