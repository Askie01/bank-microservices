package com.askie01.loans.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LoanTypeAlreadyExistsException extends RuntimeException {
    public LoanTypeAlreadyExistsException(String message) {
        super(message);
    }
}
