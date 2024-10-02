package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import org.askie01.customers.entity.Country;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to ensure that a {@link Country#name} is valid.
 * <p>
 * The country name must meet the following conditions:
 *     <ul>
 *         <li>It cannot be empty or {@code null}.</li>
 *         <li>It must only contain letters (including accented characters), digits, spaces, and hyphens.</li>
 *         <li>The length of {@link Country#name} must not exceed 100 characters.</li>
 *     </ul>
 * </p>
 *
 * @see NotEmpty
 * @see Pattern
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotEmpty(message = "Country is required")
@Pattern(regexp = "^[A-Za-zÀ-ÿ0-9\\s-]{1,100}$",
        message = "Country name must only contain letters, digits, spaces, and hyphens, with a maximum length of 100 characters.")
public @interface ValidCountryName {

    /**
     * Specifies default error {@code message} if the {@link Country#name} does not meet the criteria.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid country name.";

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
