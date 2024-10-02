package org.askie01.customers.exception;

import org.askie01.customers.entity.Country;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when attempting to create a {@link Country} with a {@code name} that already exists.
 * <p>
 * This exception is annotated with {@link ResponseStatus} to automatically return a
 * {@link HttpStatus#BAD_REQUEST} (400) response when it is thrown.
 * </p>
 * <p>
 * The exception message will include the name of the country that caused the conflict.
 * </p>
 *
 * @see ResponseStatus
 * @see RuntimeException
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class CountryNameAlreadyExistsException extends RuntimeException {

    /**
     * Constructs a new {@link CountryNameAlreadyExistsException} with a detailed message
     * that includes the provided name.
     *
     * @param name the name of the {@link Country} that already exists.
     */
    public CountryNameAlreadyExistsException(String name) {
        super(String.format("Country with name '%s' already exists.", name));
    }
}
