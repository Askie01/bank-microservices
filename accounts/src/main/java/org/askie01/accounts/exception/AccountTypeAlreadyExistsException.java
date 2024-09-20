package org.askie01.accounts.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountTypeAlreadyExistsException extends RuntimeException {
    public AccountTypeAlreadyExistsException(String message) {
        super(message);
    }
}
