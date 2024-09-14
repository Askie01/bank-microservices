
package com.askie01.loans.controller;

import com.askie01.loans.constant.ResponseCode;
import com.askie01.loans.constant.ResponseMessage;
import com.askie01.loans.dto.ContactInformationDTO;
import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.request.create.CreateLoanRequest;
import com.askie01.loans.response.Response;
import com.askie01.loans.service.LoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.Data;
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
public class LoanController {

    @Value("${build.version}")
    private String buildVersion;

    private final LoanService loanService;
    private final Environment environment;
    private final ContactInformationDTO contactInformationDTO;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createLoan(@Valid @RequestBody CreateLoanRequest request) {
        loanService.createLoan(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(path = "get")
    public ResponseEntity<LoanDTO> getLoanDTO(@Min(value = 100_000_000, message = "Mobile number must be at least 9 digits")
                                              @Max(value = 999_999_999, message = "Mobile number must be at most 9 digits")
                                              @RequestParam Integer mobileNumber) {
        final LoanDTO loanDTO = loanService.getLoanDTO(mobileNumber);
        return new ResponseEntity<>(loanDTO, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateLoan(@Valid @RequestBody LoanUpdateRequest request) {
        loanService.updateLoan(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteLoan(@Min(value = 100_000_000, message = "Mobile number must be at least 9 digits")
                                               @Max(value = 999_999_999, message = "Mobile number must be at most 9 digits")
                                               @RequestParam Integer mobileNumber) {
        loanService.deleteLoan(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "build-information")
    public ResponseEntity<String> getBuildVersion() {
        return new ResponseEntity<>(buildVersion, HttpStatus.OK);
    }

    @GetMapping(path = "java-version")
    public ResponseEntity<String> getJavaVersion() {
        final String javaVersion = environment.getProperty("JAVA_HOME");
        return new ResponseEntity<>(javaVersion, HttpStatus.OK);
    }

    @GetMapping(path = "maven-version")
    public ResponseEntity<String> getMavenVersion() {
        final String mavenVersion = environment.getProperty("MAVEN_HOME");
        return new ResponseEntity<>(mavenVersion, HttpStatus.OK);
    }

    @GetMapping(path = "contact-information")
    public ResponseEntity<ContactInformationDTO> getContactInformationDTO() {
        return new ResponseEntity<>(contactInformationDTO, HttpStatus.OK);
    }
}
