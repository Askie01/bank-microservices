package org.askie01.accounts.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.askie01.accounts.constant.ResponseCode;
import org.askie01.accounts.constant.ResponseMessage;
import org.askie01.accounts.dto.AccountContactInformationDTO;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.response.Response;
import org.askie01.accounts.service.AccountService;
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
public class AccountController {

    @Value("${build.version}")
    private String buildVersion;

    private final AccountService accountService;
    private final Environment environment;
    private final AccountContactInformationDTO accountContactInformationDto;

    @PostMapping
    public ResponseEntity<Response> createAccount(@Valid @RequestBody final CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<CustomerDTO> getAccountDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                         @RequestParam String mobileNumber) {
        final CustomerDTO customerDTO = accountService.getAccount(mobileNumber);
        return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
    }

    @PutMapping
    public ResponseEntity<Response> updateAccountDetails(@Valid @RequestBody CustomerDTO customerDTO) {
        accountService.updateAccount(customerDTO);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<Response> deleteAccountDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                         @RequestParam String mobileNumber) {
        accountService.deleteAccount(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("build-information")
    public ResponseEntity<String> getBuildVersion() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping("java-version")
    public ResponseEntity<String> getJavaVersion() {
        final String javaVersion = environment.getProperty("JAVA_HOME");
        return new ResponseEntity<>(javaVersion, HttpStatus.OK);
    }

    @GetMapping("maven-version")
    public ResponseEntity<String> getMavenVersion() {
        final String mavenVersion = environment.getProperty("MAVEN_HOME");
        return new ResponseEntity<>(mavenVersion, HttpStatus.OK);
    }

    @GetMapping("contact-information")
    public ResponseEntity<AccountContactInformationDTO> getContactInfo() {
        return new ResponseEntity<>(accountContactInformationDto, HttpStatus.OK);
    }
}
