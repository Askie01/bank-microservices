package org.askie01.accounts.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.askie01.accounts.constant.AccountConstants;
import org.askie01.accounts.dto.AccountContactInfoDto;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.dto.ErrorResponseDTO;
import org.askie01.accounts.dto.ResponseDTO;
import org.askie01.accounts.service.AccountService;
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
@RequestMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(
        name = "CRUD REST APIs for Accounts in bank-microservices",
        description = "CRUD REST APIs in bank-microservices to CREATE, UPDATE, FETCH and DELETE account details"
)
public class AccountController {

    private final AccountService accountService;

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    private Environment environment;

    @Autowired
    private AccountContactInfoDto accountContactInfoDto;

    @Operation(
            summary = "Create Account REST API",
            description = "REST API to create a new Account inside bank-microservices"
    )
    @ApiResponse(
            responseCode = "201",
            description = "HTTP Status CREATED"
    )
    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createAccount(@Valid @RequestBody final CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return new ResponseEntity<>
                (new ResponseDTO
                        (AccountConstants.STATUS_201, AccountConstants.MESSAGE_201)
                        , HttpStatus.CREATED);
    }

    @Operation(
            summary = "Get account REST API",
            description = "REST API to get Account details based on a given mobileNumber"
    )
    @ApiResponse(
            responseCode = "302",
            description = "HTTP Status FOUND"
    )
    @GetMapping("get")
    public ResponseEntity<CustomerDTO> getAccountDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                         @RequestParam String mobileNumber) {
        final CustomerDTO customerDTO = accountService.getAccount(mobileNumber);
        return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
    }

    @Operation(
            summary = "Update account REST API",
            description = "REST API to update Account details, based on a given customer details (which are going to be updated in the account)."
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
            ),
            @ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            )}
    )
    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO) {
        final boolean isUpdated = accountService.updateAccount(customerDTO);
        if (isUpdated) {
            return new ResponseEntity<>(
                    new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200), HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500), HttpStatus.INTERNAL_SERVER_ERROR
            );
        }
    }

    @Operation(
            summary = "Delete account REST API",
            description = "REST API to delete Account & Customer details."
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status INTERNAL_SERVER_ERROR"
            )
    })
    @DeleteMapping("delete")
    public ResponseEntity<ResponseDTO> deleteAccountDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                            @RequestParam String mobileNumber) {
        final boolean isDeleted = accountService.deleteAccount(mobileNumber);
        if (isDeleted) {
            return new ResponseEntity<>(
                    new ResponseDTO(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200), HttpStatus.OK
            );
        } else {
            return new ResponseEntity<>(
                    new ResponseDTO(AccountConstants.STATUS_417, AccountConstants.MESSAGE_417_DELETE), HttpStatus.EXPECTATION_FAILED
            );
        }
    }

    @Operation(
            summary = "Get Build information",
            description = "Get Build information that is deployed into accounts microservice."
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
    @GetMapping("build-info")
    public ResponseEntity<String> getBuildVersion() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Java version",
            description = "Get Java version details that is installed into accounts microservice."
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
    @GetMapping("java-version")
    public ResponseEntity<String> getJavaVersion() {
        final String javaVersion = environment.getProperty("JAVA_HOME");
        return new ResponseEntity<>(javaVersion, HttpStatus.OK);
    }

    @Operation(
            summary = "Get Maven version",
            description = "Get Maven version details that is installed into accounts microservice."
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
    @GetMapping("maven-version")
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
    @GetMapping("contact-info")
    public ResponseEntity<AccountContactInfoDto> getContactInfo() {
        return new ResponseEntity<>(accountContactInfoDto, HttpStatus.OK);
    }
}
