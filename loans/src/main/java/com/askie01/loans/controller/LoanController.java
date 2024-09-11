
package com.askie01.loans.controller;

import com.askie01.loans.constant.ResponseCode;
import com.askie01.loans.constant.ResponseMessage;
import com.askie01.loans.dto.LoanContactInformationDTO;
import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.response.Response;
import com.askie01.loans.service.LoanService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
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
    private final LoanContactInformationDTO loanContactInformationDTO;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createLoan(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits.")
                                               @RequestParam String mobileNumber) {
        loanService.createLoan(mobileNumber);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }


    @GetMapping(path = "get")
    public ResponseEntity<LoanDTO> getLoanDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                  @RequestParam String mobileNumber) {
        final LoanDTO loanDTO = loanService.getLoan(mobileNumber);
        return new ResponseEntity<>(loanDTO, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateLoanDetails(@Valid @RequestBody LoanDTO loanDTO) {
        loanService.updateLoan(loanDTO);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteLoanDetails(@Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                      @RequestParam String mobileNumber) {
        loanService.deleteLoan(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(path = "build-info")
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

    @GetMapping(path = "contact-info")
    public ResponseEntity<LoanContactInformationDTO> getContactInfo() {
        return new ResponseEntity<>(loanContactInformationDTO, HttpStatus.OK);
    }
}
