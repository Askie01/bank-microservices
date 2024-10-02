package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to ensure that a {@code mobileNumber} is in a valid format.
 * <p>
 * The {@code mobileNumber} must follow the pattern: {@code "^\\+\\d{2,3} \\d{8,15}$"}, which enforces:
 * <ul>
 *     <li>The {@code mobileNumber} must start with a {@code +}.</li>
 *     <li>It must be followed by 2-3 digits representing the country code.</li>
 *     <li>There must be a space separating the country code from the rest of the number.</li>
 *     <li>The remaining portion must contain 8-15 digits.</li>
 * </ul>
 * </p>
 *
 * @see Pattern
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
        message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
public @interface ValidMobileNumber {

    /**
     * Specifies default error {@code message} if the {@code mobileNumber} format is invalid.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid mobileNumber value";

    /**
     * Specifies groups the constraint belongs to.
     * This can be used to apply the constraint only to specific validation groups.
     *
     * @return the validation groups.
     */
    Class<?>[] groups() default {};

    /**
     * Can be used by clients to assign custom payload objects to constraint.
     * Typically used to carry metadata information for the validation.
     *
     * @return the payload.
     */
    Class<? extends Payload>[] payload() default {};
}
