package org.askie01.accounts.controller.account.type;

import lombok.Data;
import org.askie01.accounts.constant.ResponseCode;
import org.askie01.accounts.constant.ResponseMessage;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.response.Response;
import org.askie01.accounts.service.account.type.AccountTypeService;
import org.askie01.accounts.validation.ValidAccountTypeName;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(path = "account/type", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountTypeController {

    private final AccountTypeService accountTypeService;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createAccountType(@ValidAccountTypeName @RequestParam String name) {
        accountTypeService.createAccountType(name);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.ACCOUNT_TYPE_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "get")
    public ResponseEntity<AccountType> getAccountType(@ValidAccountTypeName @RequestParam String name) {
        final AccountType accountType = accountTypeService.getAccountType(name);
        return new ResponseEntity<>(accountType, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateAccountType(@ValidAccountTypeName @RequestParam String oldName,
                                                      @ValidAccountTypeName @RequestParam String newName) {
        accountTypeService.updateAccountType(oldName, newName);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteAccountType(@ValidAccountTypeName @RequestParam String name) {
        accountTypeService.deleteAccountType(name);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
