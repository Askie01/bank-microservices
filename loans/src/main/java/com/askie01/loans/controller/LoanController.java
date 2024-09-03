
package com.askie01.loans.controller;

import com.askie01.loans.constants.LoanConstants;
import com.askie01.loans.dto.ErrorResponseDTO;
import com.askie01.loans.dto.LoanContactInfoDTO;
import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.dto.ResponseDTO;
import com.askie01.loans.service.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(path = "loan", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(
        name = "CRUD REST APIs for Loans in bank-microservices",
        description = "CRUD REST APIs in bank-microservices to CREATE, UPDATE, GET and DELETE loan details"
)
public class LoanController {
    private final LoanService loanService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private LoanContactInfoDTO loanContactInfoDTO;

    @Operation(
            summary = "Create Loan REST API",
            description = "REST API to create new loan inside bank-microservices"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PostMapping(path = "create")
    public ResponseEntity<ResponseDTO> createLoan(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits.")
                                                  @RequestParam String mobileNumber) {
        loanService.createLoan(mobileNumber);
        return new ResponseEntity<>(
                new ResponseDTO(LoanConstants.STATUS_201, LoanConstants.MESSAGE_201), HttpStatus.CREATED
        );
    }

    @Operation(
            summary = "Get loan details REST API",
            description = "REST API to get loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Http Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @GetMapping(path = "get")
    public ResponseEntity<LoanDTO> getLoanDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                  @RequestParam String mobileNumber) {
        final LoanDTO loanDTO = loanService.getLoan(mobileNumber);
        return new ResponseEntity<>(loanDTO, HttpStatus.OK);

    }

    @Operation(
            summary = "Update loan details REST API",
            description = "REST API to update loan details based on a loan number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @PutMapping(path = "update")
    public ResponseEntity<ResponseDTO> updateLoanDetails(@Valid @RequestBody LoanDTO loanDTO) {
        final boolean isUpdated = loanService.updateLoan(loanDTO);
        if (isUpdated) {
            return new ResponseEntity<>(
                    new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_UPDATE),
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }

    @Operation(
            summary = "Delete loan details REST API",
            description = "REST API to delete loan details based on a mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )
    })
    @DeleteMapping(path = "delete")
    public ResponseEntity<ResponseDTO> deleteLoanDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                         @RequestParam String mobileNumber) {
        final boolean isDeleted = loanService.deleteLoan(mobileNumber);
        if (isDeleted) {
            return new ResponseEntity<>(
                    new ResponseDTO(LoanConstants.STATUS_200, LoanConstants.MESSAGE_200),
                    HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(LoanConstants.STATUS_417, LoanConstants.MESSAGE_417_DELETE),
                    HttpStatus.EXPECTATION_FAILED
            );
        }
    }

    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into loans microservice."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )}
    )
    @GetMapping(path = "build-info")
    public ResponseEntity<String> getBuildVersion() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Java version",
            description = "Get Java version details that is installed into loans microservice."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )}
    )
    @GetMapping(path = "java-version")
    public ResponseEntity<String> getJavaVersion() {
        final String javaVersion = environment.getProperty("JAVA_HOME");
        return new ResponseEntity<>(javaVersion, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Maven version",
            description = "Get Maven version details that is installed into loans microservice."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )}
    )
    @GetMapping(path = "maven-version")
    public ResponseEntity<String> getMavenVersion() {
        final String mavenVersion = environment.getProperty("MAVEN_HOME");
        return new ResponseEntity<>(mavenVersion, HttpStatus.OK);
    }

    @Operation(
            summary = "Get contact info",
            description = "Get contact info details that can be reached out in case of any issues."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDTO.class)
                    )
            )}
    )
    @GetMapping(path = "contact-info")
    public ResponseEntity<LoanContactInfoDTO> getContactInfo() {
        return new ResponseEntity<>(loanContactInfoDTO, HttpStatus.OK);
    }
}
