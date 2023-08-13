package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonValue;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import javax.validation.Valid;
import javax.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import javax.annotation.Generated;

import com.fasterxml.jackson.annotation.JsonCreator;

/**
 * Gets or Sets ApplicationStatus
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-07T16:38:08.239013800+03:00[Europe/Moscow]")
public enum ApplicationStatus {
  
  PREAPPROVAL("PREAPPROVAL"),
  
  APPROVED("APPROVED"),
  
  CC_DENIED("CC_DENIED"),
  
  CC_APPROVED("CC_APPROVED"),
  
  PREPARE_DOCUMENTS("PREPARE_DOCUMENTS"),
  
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

