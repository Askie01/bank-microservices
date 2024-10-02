package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to validate {@code firstName} field.
 * <p>
 * Ensures that {@code firstName} contains only letters, starts with an uppercase letter, and is 3-20 characters long.
 * This annotation can be applied to fields or method parameters of type {@link String}.
 * </p>
 * <p>
 * The validation is based on the regular expression: {@code "^[A-Z][a-z]{2,19}"}, meaning:
 * <ul>
 *     <li>The first letter must be an uppercase English letter (A-Z).</li>
 *     <li>The remaining letters must be lowercase English letters (a-z), with a 2-19 additional characters.</li>
 *     <li>Total length of {@code firstName} must not exceed 20 characters.</li>
 * </ul>
 * </p>
 *
 * @see Pattern
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[A-Z][a-z]{2,19}",
        message = "First name can contain only letters, must start with uppercase letter and not exceed 20 characters.")
public @interface ValidFirstName {

    /**
     * Specifies the default error {@code message} if the {@code firstName} format is invalid.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid first name format";

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
