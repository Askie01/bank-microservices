package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to validate {@code lastName} field.
 * <p>
 * Ensures that {@code lastName} contains only letters, starts with an uppercase letter, and is 3-40 characters long.
 * This annotation can be applied to fields or method parameters of type {@link String}.
 * </p>
 * <p>
 * The validation is based on the regular expression {@code "^[A-Z][a-z]{2,39}"}, meaning:
 * <ul>
 *     <li>The first letter must be an uppercase English letter (A-Z).</li>
 *     <li>The remaining letters must be lowercase English letters (a-z), with 2-39 additional characters.</li>
 *     <li>The total length of {@code lastName} must not exceed 40 characters.</li>
 * </ul>
 * </p>
 *
 * @see Pattern
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[A-Z][a-z]{2,39}",
        message = "Last name can contain only letters, must start with uppercase letter and not exceed 40 characters.")
public @interface ValidLastName {

    /**
     * Specifies the default error {@code message} if the {@code lastName} format is invalid.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid last name format";

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