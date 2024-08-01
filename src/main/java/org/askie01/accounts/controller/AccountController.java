package org.askie01.accounts.controller;

import org.askie01.accounts.constant.AccountConstants;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.dto.ResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
public class AccountController {

    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> createAccount(@RequestBody final CustomerDTO customerDTO) {
        return new ResponseEntity<>
                (new ResponseDTO
                        (AccountConstants.STATUS_201, AccountConstants.MESSAGE_201)
                        , HttpStatus.CREATED);
    }
}
