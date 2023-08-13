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
 * Gets or Sets Position
 */

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-07T16:38:08.239013800+03:00[Europe/Moscow]")
public enum Position {
  
  WORKER("WORKER"),
  
  MID_MANAGER("MID_MANAGER"),
  
  TOP_MANAGER("TOP_MANAGER"),
  
  OWNER("OWNER");

  private String value;

  Position(String value) {
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
  public static Position fromValue(String value) {
    for (Position b : Position.values()) {
      if (b.value.equals(value)) {
        return b;
      }
    }
    throw new IllegalArgumentException("Unexpected value '" + value + "'");
  }
}

