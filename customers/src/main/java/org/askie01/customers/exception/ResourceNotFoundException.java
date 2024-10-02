package org.askie01.customers.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown when a requested resource is not found.
 * <p>
 * This exception is annotated with {@link ResponseStatus} to return a
 * {@link HttpStatus#NOT_FOUND} (404) response code when thrown.
 * </p>
 * <p>
 * It can be used to indicate that a specific resource could not be located in the system.
 * </p>
 *
 * @see RuntimeException
 * @see ResponseStatus
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    /**
     * Constructs a new {@link ResourceNotFoundException} with a specified resource name, field name, and field value.
     *
     * @param resourceName the name of resource that was not found.
     * @param fieldName    the name of the field that was searched, but was not found.
     * @param fieldValue   the value of field that was searched for, which was not found.
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Long fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, fieldName, fieldValue));
    }

    /**
     * Constructs a new {@link ResourceNotFoundException} with a specified resource name, field name, and field value.
     *
     * @param resourceName the name of resource that was not found.
     * @param fieldName    the name of the field that was searched, but was not found.
     * @param fieldValue   the value of field that was searched for, which was not found.
     */
    public ResourceNotFoundException(String resourceName, String fieldName, Integer fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, fieldName, fieldValue));
    }

    /**
     * Constructs a new {@link ResourceNotFoundException} with a specified resource name, field name, and field value.
     *
     * @param resourceName the name of resource that was not found.
     * @param fieldName    the name of the field that was searched, but was not found.
     * @param fieldValue   the value of field that was searched for, which was not found.
     */
    public ResourceNotFoundException(String resourceName, String fieldName, String fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, fieldName, fieldValue));
    }
}
