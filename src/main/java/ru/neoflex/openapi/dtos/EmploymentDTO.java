package ru.neoflex.openapi.dtos;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import ru.neoflex.openapi.dtos.EmploymentStatus;
import ru.neoflex.openapi.dtos.Position;
import org.openapitools.jackson.nullable.JsonNullable;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * User&#39;s employment data
 */

@Schema(name = "EmploymentDTO", description = "User's employment data")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-08-13T21:43:13.391899+03:00[Europe/Moscow]")
public class EmploymentDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private EmploymentStatus employmentStatus;

  private String employerINN;

  private java.math.BigDecimal salary;

  private Position position;

  private Integer workExperienceTotal;

  private Integer workExperienceCurrent;

  /**
   * Default constructor
   * @deprecated Use {@link EmploymentDTO#EmploymentDTO(EmploymentStatus, String, java.math.BigDecimal, Position, Integer, Integer)}
   */
  @Deprecated
  public EmploymentDTO() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public EmploymentDTO(EmploymentStatus employmentStatus, String employerINN, java.math.BigDecimal salary, Position position, Integer workExperienceTotal, Integer workExperienceCurrent) {
    this.employmentStatus = employmentStatus;
    this.employerINN = employerINN;
    this.salary = salary;
    this.position = position;
    this.workExperienceTotal = workExperienceTotal;
    this.workExperienceCurrent = workExperienceCurrent;
  }

  public EmploymentDTO employmentStatus(EmploymentStatus employmentStatus) {
    this.employmentStatus = employmentStatus;
    return this;
  }

  /**
   * Get employmentStatus
   * @return employmentStatus
  */
  @NotNull @Valid 
  @Schema(name = "employmentStatus", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("employmentStatus")
  public EmploymentStatus getEmploymentStatus() {
    return employmentStatus;
  }

  public void setEmploymentStatus(EmploymentStatus employmentStatus) {
    this.employmentStatus = employmentStatus;
  }

  public EmploymentDTO employerINN(String employerINN) {
    this.employerINN = employerINN;
    return this;
  }

  /**
   * Employment INN
   * @return employerINN
  */
  @NotNull @Pattern(regexp = "^\\d{10}$", message="должно содержать 10 цифр") 
  @Schema(name = "employerINN", example = "0123456789", description = "Employment INN", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("employerINN")
  public String getEmployerINN() {
    return employerINN;
  }

  public void setEmployerINN(String employerINN) {
    this.employerINN = employerINN;
  }

  public EmploymentDTO salary(java.math.BigDecimal salary) {
    this.salary = salary;
    return this;
  }

  /**
   * Salary
   * @return salary
  */
  @NotNull @Valid 
  @Schema(name = "salary", example = "10000", description = "Salary", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("salary")
  public java.math.BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(java.math.BigDecimal salary) {
    this.salary = salary;
  }

  public EmploymentDTO position(Position position) {
    this.position = position;
    return this;
  }

  /**
   * Get position
   * @return position
  */
  @NotNull @Valid 
  @Schema(name = "position", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("position")
  public Position getPosition() {
    return position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public EmploymentDTO workExperienceTotal(Integer workExperienceTotal) {
    this.workExperienceTotal = workExperienceTotal;
    return this;
  }

  /**
   * Total work experience
   * @return workExperienceTotal
  */
  @NotNull 
  @Schema(name = "workExperienceTotal", example = "12", description = "Total work experience", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workExperienceTotal")
  public Integer getWorkExperienceTotal() {
    return workExperienceTotal;
  }

  public void setWorkExperienceTotal(Integer workExperienceTotal) {
    this.workExperienceTotal = workExperienceTotal;
  }

  public EmploymentDTO workExperienceCurrent(Integer workExperienceCurrent) {
    this.workExperienceCurrent = workExperienceCurrent;
    return this;
  }

  /**
   * Current work experience
   * @return workExperienceCurrent
  */
  @NotNull 
  @Schema(name = "workExperienceCurrent", example = "3", description = "Current work experience", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("workExperienceCurrent")
  public Integer getWorkExperienceCurrent() {
    return workExperienceCurrent;
  }

  public void setWorkExperienceCurrent(Integer workExperienceCurrent) {
    this.workExperienceCurrent = workExperienceCurrent;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EmploymentDTO employmentDTO = (EmploymentDTO) o;
    return Objects.equals(this.employmentStatus, employmentDTO.employmentStatus) &&
        Objects.equals(this.employerINN, employmentDTO.employerINN) &&
        Objects.equals(this.salary, employmentDTO.salary) &&
        Objects.equals(this.position, employmentDTO.position) &&
        Objects.equals(this.workExperienceTotal, employmentDTO.workExperienceTotal) &&
        Objects.equals(this.workExperienceCurrent, employmentDTO.workExperienceCurrent);
  }

  @Override
  public int hashCode() {
    return Objects.hash(employmentStatus, employerINN, salary, position, workExperienceTotal, workExperienceCurrent);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EmploymentDTO {\n");
    sb.append("    employmentStatus: ").append(toIndentedString(employmentStatus)).append("\n");
    sb.append("    employerINN: ").append(toIndentedString(employerINN)).append("\n");
    sb.append("    salary: ").append(toIndentedString(salary)).append("\n");
    sb.append("    position: ").append(toIndentedString(position)).append("\n");
    sb.append("    workExperienceTotal: ").append(toIndentedString(workExperienceTotal)).append("\n");
    sb.append("    workExperienceCurrent: ").append(toIndentedString(workExperienceCurrent)).append("\n");
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

