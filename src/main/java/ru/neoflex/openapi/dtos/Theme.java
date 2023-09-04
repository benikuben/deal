package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Theme
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-04T21:19:31.333702200+03:00[Europe/Moscow]")
public enum Theme {
  
  FINISH_REGISTRATION("FINISH_REGISTRATION"),
  
  CREATE_DOCUMENTS("CREATE_DOCUMENTS"),
  
  SEND_DOCUMENTS("SEND_DOCUMENTS"),
  
  SEND_SES("SEND_SES"),
  
  CREDIT_ISSUED("CREDIT_ISSUED"),
  
  APPLICATION_DENIED("APPLICATION_DENIED");

  private String value;

  Theme(String value) {
    this.value = value;
  }

  @JsonValue
  public String getValue() {
    return value;
  }

  @Override
  public String toString() {
    return String.valueOf(value);
  }

  @JsonCreator
  public static Theme fromValue(String value) {
    for (Theme b : Theme.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

