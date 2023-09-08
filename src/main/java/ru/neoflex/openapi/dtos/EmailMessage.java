package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import ru.neoflex.openapi.dtos.Theme;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Email message
 */

@Schema(name = "EmailMessage", description = "Email message")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-08T19:52:55.385320200+03:00[Europe/Moscow]")
public class EmailMessage implements Serializable {

  private static final long serialVersionUID = 1L;

  private String address;

  private Theme theme;

  private Long applicationId;

  public EmailMessage address(String address) {
    this.address = address;
    return this;
  }

  /**
   * Address
   * @return address
  */
  
  @Schema(name = "address", example = "ivan@mail.ru", description = "Address", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public EmailMessage theme(Theme theme) {
    this.theme = theme;
    return this;
  }

  /**
   * Get theme
   * @return theme
  */
  @Valid 
  @Schema(name = "theme", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("theme")
  public Theme getTheme() {
    return theme;
  }

  public void setTheme(Theme theme) {
    this.theme = theme;
  }

  public EmailMessage applicationId(Long applicationId) {
    this.applicationId = applicationId;
    return this;
  }

  /**
   * Id of application
   * @return applicationId
  */
  
  @Schema(name = "applicationId", example = "1", description = "Id of application", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  @JsonProperty("applicationId")
  public Long getApplicationId() {
    return applicationId;
  }

  public void setApplicationId(Long applicationId) {
    this.applicationId = applicationId;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmailMessage emailMessage = (EmailMessage) o;
    return Objects.equals(this.address, emailMessage.address) &&
        Objects.equals(this.theme, emailMessage.theme) &&
        Objects.equals(this.applicationId, emailMessage.applicationId);
  }

  @Override
  public int hashCode() {
    return Objects.hash(address, theme, applicationId);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmailMessage {\n");
    sb.append("    address: ").append(toIndentedString(address)).append("\n");
    sb.append("    theme: ").append(toIndentedString(theme)).append("\n");
    sb.append("    applicationId: ").append(toIndentedString(applicationId)).append("\n");
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

