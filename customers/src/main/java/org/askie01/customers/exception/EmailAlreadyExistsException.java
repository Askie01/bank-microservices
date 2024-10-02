package org.askie01.customers.exception;

import org.askie01.customers.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when an attempt is made to register a {@link Customer} with an {@code email}
 * that already exists in the system.
 * <p>
 * This exception is annotated with {@link ResponseStatus} to return a
 * {@link HttpStatus#BAD_REQUEST} (400) response code when thrown.
 * </p>
 *
 * @see RuntimeException
 * @see ResponseStatus
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmailAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new {@link EmailAlreadyExistsException} with a detailed message
     * that includes the provided email.
     *
     * @param email the email address that is already associated with an existing customer.
     */
    public EmailAlreadyExistsException(String email) {
        super(String.format("Customer with email '%s' already exists.", email));
    }
}
