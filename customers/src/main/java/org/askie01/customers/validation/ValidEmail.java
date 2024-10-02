package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to ensure that an {@code email} is in a valid format.
 * <p>
 * The annotation applies the following constraints:
 * <ul>
 *     <li>The {@code email} cannot be {@code null} or empty, enforced by {@link NotEmpty}.</li>
 *     <li>The {@code email} must follow a valid format defined by a regular expression, enforced by {@link Pattern}.</li>
 *     <li>The length of {@code email} must not exceed 100 characters, enforced by {@link Size}.</li>
 * </ul>
 * </p>
 * <p>
 *     The regular expression used for validation is:
 *     {@code "^[\\w-.]{3,}+@[\\w-]{3,10}+\\.[a-zA-Z]{2,}$"}. This ensures:
 *     <ul>
 *         <li>The local part (before {@code @}) must be at least 3 characters long and can contain letters, numbers, dots, or hyphens.</li>
 *         <li>The domain name (after {@code @}) must be 3-10 characters long and can contain letters, dots, and hyphens.</li>
 *         <li>The domain must end with a valid top-level domain (TLD) consisting of at least 2 letters.</li>
 *     </ul>
 * </p>
 *
 * @see NotEmpty
 * @see Pattern
 * @see Size
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotEmpty(message = "Email cannot be null nor empty.")
@Pattern(regexp = "^[\\w.-]{3,}+@[\\w-]{3,10}+\\.[a-zA-Z]{2,}$",
        message = "Email must be in a valid format."
)
@Size(max = 100, message = "Email must not exceed 100 characters.")
public @interface ValidEmail {

    /**
     * Specifies the default error {@code message} if {@code email} format is invalid.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid email format.";

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
