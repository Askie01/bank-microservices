package org.askie01.accounts.controller;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.askie01.accounts.constant.AccountConstants;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.dto.ResponseDTO;
import org.askie01.accounts.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Data
@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping(path = "account", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping("create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody final CustomerDTO customerDTO) {
        accountService.createAccount(customerDTO);
        return new ResponseEntity<>
                (new ResponseDTO
                        (AccountConstants.STATUS_201, AccountConstants.MESSAGE_201)
                        , HttpStatus.CREATED);
    }

    @GetMapping("get")
    public ResponseEntity<CustomerDTO> getAccountDetails(@RequestParam String mobileNumber) {
        final CustomerDTO customerDTO = accountService.getAccount(mobileNumber);
        return new ResponseEntity<>(customerDTO, HttpStatus.FOUND);
    }

    @PutMapping("update")
    public ResponseEntity<ResponseDTO> updateAccountDetails(@RequestBody CustomerDTO customerDTO) {
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
}
