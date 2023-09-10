/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.6.0).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package ru.neoflex.openapi.controllers;

import ru.neoflex.openapi.dtos.Application;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2023-09-10T00:47:20.725375700+03:00[Europe/Moscow]")
@Validated
@Tag(name = "admin", description = "the admin API")
public interface AdminApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * GET /admin/application : Get all applications
     *
     * @return Received applications (status code 200)
     */
    @Operation(
        operationId = "getAllApplications",
        summary = "Get all applications",
        responses = {
            @ApiResponse(responseCode = "200", description = "Received applications", content = {
                @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Application.class)))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/admin/application",
        produces = { "application/json" }
    )
    default ResponseEntity<List<Application>> _getAllApplications(
        
    ) {
        return getAllApplications();
    }

    // Override this method
    default  ResponseEntity<List<Application>> getAllApplications() {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "[ { \"creditId\" : { \"amount\" : 10000.0, \"isSalaryClient\" : false, \"monthlyPayment\" : 1740.34, \"rate\" : 15, \"paymentSchedule\" : [ { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 }, { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 } ], \"psk\" : 8.841, \"term\" : 6, \"isInsuranceEnabled\" : false }, \"clientId\" : { \"dependentAmount\" : 1, \"lastName\" : \"Ivanov\", \"firstName\" : \"Ivan\", \"birthdate\" : \"2000-01-01\", \"passport\" : { \"issueBranch\" : \"UFMS Moscow\", \"number\" : \"123456\", \"series\" : \"1234\", \"issueDate\" : \"2014-01-01\" }, \"middleName\" : \"Ivanovich\", \"employment\" : { \"workExperienceCurrent\" : 3, \"workExperienceTotal\" : 12, \"salary\" : 10000, \"employerINN\" : \"0123456789\" }, \"email\" : \"ivan@mail.ru\", \"account\" : \"01234567890123456789\" }, \"appliedOffer\" : { \"totalAmount\" : 10150.0, \"isSalaryClient\" : true, \"monthlyPayment\" : 1756.38, \"rate\" : 13, \"requestedAmount\" : 10000.0, \"term\" : 6, \"applicationId\" : 1, \"isInsuranceEnabled\" : true }, \"sesCode\" : \"1234\", \"creationDate\" : \"2017-07-21T17:32:28Z\", \"signDate\" : \"2017-07-21T17:32:28Z\" }, { \"creditId\" : { \"amount\" : 10000.0, \"isSalaryClient\" : false, \"monthlyPayment\" : 1740.34, \"rate\" : 15, \"paymentSchedule\" : [ { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 }, { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 } ], \"psk\" : 8.841, \"term\" : 6, \"isInsuranceEnabled\" : false }, \"clientId\" : { \"dependentAmount\" : 1, \"lastName\" : \"Ivanov\", \"firstName\" : \"Ivan\", \"birthdate\" : \"2000-01-01\", \"passport\" : { \"issueBranch\" : \"UFMS Moscow\", \"number\" : \"123456\", \"series\" : \"1234\", \"issueDate\" : \"2014-01-01\" }, \"middleName\" : \"Ivanovich\", \"employment\" : { \"workExperienceCurrent\" : 3, \"workExperienceTotal\" : 12, \"salary\" : 10000, \"employerINN\" : \"0123456789\" }, \"email\" : \"ivan@mail.ru\", \"account\" : \"01234567890123456789\" }, \"appliedOffer\" : { \"totalAmount\" : 10150.0, \"isSalaryClient\" : true, \"monthlyPayment\" : 1756.38, \"rate\" : 13, \"requestedAmount\" : 10000.0, \"term\" : 6, \"applicationId\" : 1, \"isInsuranceEnabled\" : true }, \"sesCode\" : \"1234\", \"creationDate\" : \"2017-07-21T17:32:28Z\", \"signDate\" : \"2017-07-21T17:32:28Z\" } ]";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /admin/application/{applicationId} : Get application by id
     *
     * @param applicationId Id of application (required)
     * @return Received application (status code 200)
     */
    @Operation(
        operationId = "getApplicationById",
        summary = "Get application by id",
        responses = {
            @ApiResponse(responseCode = "200", description = "Received application", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = Application.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/admin/application/{applicationId}",
        produces = { "application/json" }
    )
    default ResponseEntity<Application> _getApplicationById(
        @Parameter(name = "applicationId", description = "Id of application", required = true, in = ParameterIn.PATH) @PathVariable("applicationId") Long applicationId
    ) {
        return getApplicationById(applicationId);
    }

    // Override this method
    default  ResponseEntity<Application> getApplicationById(Long applicationId) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"creditId\" : { \"amount\" : 10000.0, \"isSalaryClient\" : false, \"monthlyPayment\" : 1740.34, \"rate\" : 15, \"paymentSchedule\" : [ { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 }, { \"date\" : \"2023-07-31\", \"interestPayment\" : 0, \"number\" : 0, \"totalPayment\" : -10000.0, \"debtPayment\" : 0, \"remainingDebt\" : 10000 } ], \"psk\" : 8.841, \"term\" : 6, \"isInsuranceEnabled\" : false }, \"clientId\" : { \"dependentAmount\" : 1, \"lastName\" : \"Ivanov\", \"firstName\" : \"Ivan\", \"birthdate\" : \"2000-01-01\", \"passport\" : { \"issueBranch\" : \"UFMS Moscow\", \"number\" : \"123456\", \"series\" : \"1234\", \"issueDate\" : \"2014-01-01\" }, \"middleName\" : \"Ivanovich\", \"employment\" : { \"workExperienceCurrent\" : 3, \"workExperienceTotal\" : 12, \"salary\" : 10000, \"employerINN\" : \"0123456789\" }, \"email\" : \"ivan@mail.ru\", \"account\" : \"01234567890123456789\" }, \"appliedOffer\" : { \"totalAmount\" : 10150.0, \"isSalaryClient\" : true, \"monthlyPayment\" : 1756.38, \"rate\" : 13, \"requestedAmount\" : 10000.0, \"term\" : 6, \"applicationId\" : 1, \"isInsuranceEnabled\" : true }, \"sesCode\" : \"1234\", \"creationDate\" : \"2017-07-21T17:32:28Z\", \"signDate\" : \"2017-07-21T17:32:28Z\" }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /admin/application/{applicationId}/status : Update application status
     *
     * @param applicationId Id of application (required)
     * @param body  (required)
     * @return Successfully updated (status code 200)
     */
    @Operation(
        operationId = "updateApplicationStatus",
        summary = "Update application status",
        responses = {
            @ApiResponse(responseCode = "200", description = "Successfully updated")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/admin/application/{applicationId}/status",
        consumes = { "text/plain;charset=UTF-8" }
    )
    default ResponseEntity<Void> _updateApplicationStatus(
        @Parameter(name = "applicationId", description = "Id of application", required = true, in = ParameterIn.PATH) @PathVariable("applicationId") Long applicationId,
        @Parameter(name = "body", description = "", required = true) @Valid @RequestBody String body
    ) {
        return updateApplicationStatus(applicationId, body);
    }

    // Override this method
    default  ResponseEntity<Void> updateApplicationStatus(Long applicationId, String body) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
