package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to validate that an {@code id} field is a positive number greater than 0.
 * <p>
 * This annotation can be applied to fields or method parameters of type {@link Long} or {@link Integer}.
 * </p>
 * <p>
 * The validation is based on the {@link Min} constraint, where the minimum allowable value is {@code 1}.
 * </p>
 *
 * @see Min
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Min(value = 1, message = "Id must be a positive number greater than 0.")
public @interface ValidId {

    /**
     * Specifies the default error {@code message} if the {@code id} value is invalid.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid id value";

    /**
     * Specifies groups the constraint belongs to.
     * This can be used to apply the constraint only to specific validation groups.
     *
     * @return the validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients to assign custom payload objects to the constraint.
     * Typically used to carry metadata information for the validation.
     *
     * @return the payload.
     */
    Class<? extends Payload>[] payload() default {};
}