package com.askie01.loans.controller;

import com.askie01.loans.constant.ResponseCode;
import com.askie01.loans.constant.ResponseMessage;
import com.askie01.loans.entity.LoanType;
import com.askie01.loans.response.Response;
import com.askie01.loans.service.LoanTypeService;
import com.askie01.loans.validation.ValidLoanTypeName;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Data
@Validated
@RestController
@RequestMapping(path = "loan/type", produces = MediaType.APPLICATION_JSON_VALUE)
public class LoanTypeController {

    private final LoanTypeService loanTypeService;

    @PostMapping(path = "create")
    public ResponseEntity<Response> createLoanType(@ValidLoanTypeName @RequestParam String name) {
        loanTypeService.createLoanType(name);
        final Response response = new Response(ResponseCode.CREATED, ResponseMessage.LOAN_TYPE_CREATED);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping(path = "get")
    public ResponseEntity<LoanType> getLoanType(@ValidLoanTypeName @RequestParam String name) {
        final LoanType loanType = loanTypeService.getLoanType(name);
        return new ResponseEntity<>(loanType, HttpStatus.OK);
    }

    @PutMapping(path = "update")
    public ResponseEntity<Response> updateLoanType(@ValidLoanTypeName @RequestParam String oldName,
                                                   @ValidLoanTypeName @RequestParam String newName) {
        loanTypeService.updateLoanType(oldName, newName);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping(path = "delete")
    public ResponseEntity<Response> deleteLoanType(@ValidLoanTypeName @RequestParam String name) {
        loanTypeService.deleteLoanType(name);
        final Response response = new Response(ResponseCode.OK, ResponseMessage.OK);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
