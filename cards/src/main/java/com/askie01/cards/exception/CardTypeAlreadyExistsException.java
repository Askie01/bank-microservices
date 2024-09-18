package com.askie01.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CardTypeAlreadyExistsException extends RuntimeException {
    public CardTypeAlreadyExistsException(String message) {
        super(message);
    }
}
