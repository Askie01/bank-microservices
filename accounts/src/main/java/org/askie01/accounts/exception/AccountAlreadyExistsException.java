package org.askie01.accounts.exception;

import org.askie01.accounts.entity.Account;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an attempt is made to create an {@link Account} that already exists.
 * <p>
 * This exception indicates that a {@link ResponseStatus} with {@link HttpStatus#BAD_REQUEST}
 * should be returned when this exception is thrown.
 * </p>
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class AccountAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new {@link AccountAlreadyExistsException} with the specified detail message.
     *
     * @param message the detail message, which is saved for later retrieval by the {@link Throwable#getMessage()} method.
     */
    public AccountAlreadyExistsException(String message) {
        super(message);
    }
}
