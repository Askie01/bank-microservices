package com.askie01.cards.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resource, String field, Long value) {
        super(String.format("'%s' not found with the given input data '%s' : '%d'", resource, field, value));
    }

    public ResourceNotFoundException(String resource, String field, Integer value) {
        super(String.format("'%s' not found with the given input data '%s' : '%d'", resource, field, value));
    }

    public ResourceNotFoundException(String resource, String field, String value) {
        super(String.format("'%s' not found with the given input data '%s' : '%s'", resource, field, value));
    }
}
