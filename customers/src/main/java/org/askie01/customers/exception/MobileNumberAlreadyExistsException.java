package org.askie01.customers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a {@code mobileNumber} already exists in the system.
 * <p>
 * This exception is annotated with {@link ResponseStatus} to return a
 * {@link HttpStatus#BAD_REQUEST} (400) response code when thrown.
 * </p>
 *
 * @see RuntimeException
 * @see ResponseStatus
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class MobileNumberAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new {@link MobileNumberAlreadyExistsException} with a detailed message
     * that includes the provided {@code mobileNumber}.
     *
     * @param mobileNumber the mobile number that is already associated with an existing customer.
     */
    public MobileNumberAlreadyExistsException(String mobileNumber) {
        super(String.format("Customer with mobileNumber '%s' already exists.", mobileNumber));
    }
}
