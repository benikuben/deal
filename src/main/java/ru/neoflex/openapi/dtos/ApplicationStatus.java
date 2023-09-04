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
 * Application status
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-04T21:19:31.333702200+03:00[Europe/Moscow]")
public enum ApplicationStatus {
  
  PREAPPROVAL("PREAPPROVAL"),
  
  APPROVED("APPROVED"),
  
  CC_DENIED("CC_DENIED"),
  
  CC_APPROVED("CC_APPROVED"),
  
  PREPARE_DOCUMENTS("PREPARE_DOCUMENTS"),
  
  DOCUMENT_CREATED("DOCUMENT_CREATED"),
  
  CLIENT_DENIED("CLIENT_DENIED"),
  
  DOCUMENT_SIGNED("DOCUMENT_SIGNED"),
  
  CREDIT_ISSUED("CREDIT_ISSUED");

  private String value;

  ApplicationStatus(String value) {
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
  public static ApplicationStatus fromValue(String value) {
    for (ApplicationStatus b : ApplicationStatus.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

