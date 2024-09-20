package org.askie01.accounts.controller.account;

import jakarta.validation.Valid;
import lombok.Data;
import org.askie01.accounts.constant.ResponseCode;
import org.askie01.accounts.constant.ResponseMessage;
import org.askie01.accounts.dto.AccountContactInformationDTO;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.request.account.create.AccountCreateRequest;
import org.askie01.accounts.request.account.delete.AccountDeleteRequest;
import org.askie01.accounts.request.account.get.AccountGetRequest;
import org.askie01.accounts.request.account.update.AccountUpdateRequest;
import org.askie01.accounts.response.Response;
import org.askie01.accounts.service.account.AccountService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @PostMapping(path = "create")
    public ResponseEntity<Response> createAccount(@Valid @RequestBody AccountCreateRequest request) {
        accountService.createAccount(request);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.ACCOUNT_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

//    @GetMapping(path = "get")
//    public ResponseEntity<Account> getAccount(@Valid @RequestBody AccountGetRequest request) {
//        final Account account = accountService.getAccount(request);
//        return new ResponseEntity<>(account, HttpStatus.FOUND);
//    }

    @GetMapping(path = "get")
    public ResponseEntity<List<Account>> getAccounts(@Valid @RequestBody AccountGetRequest request) {
        final List<Account> accounts = accountService.getAccounts(request);
        return new ResponseEntity<>(accounts, HttpStatus.FOUND);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateAccountDetails(@Valid @RequestBody AccountUpdateRequest request) {
        accountService.updateAccount(request);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteAccountDetails(@Valid @RequestBody AccountDeleteRequest mobileNumber) {
        accountService.deleteAccount(mobileNumber);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("build-version")
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
