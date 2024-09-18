
package com.askie01.loans.controller;

import com.askie01.loans.constant.ResponseCode;
import com.askie01.loans.constant.ResponseMessage;
import com.askie01.loans.dto.ContactInformationDTO;
import com.askie01.loans.entity.Loan;
import com.askie01.loans.request.create.LoanCreateRequest;
import com.askie01.loans.request.delete.LoanDeleteRequest;
import com.askie01.loans.request.get.LoanGetRequest;
import com.askie01.loans.request.update.LoanUpdateRequest;
import com.askie01.loans.response.Response;
import com.askie01.loans.service.DefaultLoanService;
import jakarta.validation.Valid;
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

    private final DefaultLoanService defaultLoanService;
    private final Environment environment;
    private final ContactInformationDTO contactInformationDTO;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createLoan(@Valid @RequestBody LoanCreateRequest request) {
        defaultLoanService.createLoan(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.LOAN_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "get")
    public ResponseEntity<Loan> getLoan(@Valid @RequestBody LoanGetRequest request) {
        final Loan loan = defaultLoanService.getLoan(request);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateLoan(@Valid @RequestBody LoanUpdateRequest request) {
        defaultLoanService.updateLoan(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteLoan(@Valid @RequestBody LoanDeleteRequest request) {
        defaultLoanService.deleteLoan(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "build-version")
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
