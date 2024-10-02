package org.askie01.customers.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Custom validation annotation to ensure that a {@code birthdate} is valid.
 * <p>
 * The {@code birthdate} must meet the following conditions:
 *     <ul>
 *         <li>It cannot be {@code null}.</li>
 *         <li>It must be in the past or the present.</li>
 *     </ul>
 * </p>
 * <p>
 *     This annotation combines the constraint {@link NotNull} and {@link PastOrPresent} to enforce the rule that a valid
 *     {@code birthdate} is required and must be either in the past or today.
 * </p>
 *
 * @see NotNull
 * @see PastOrPresent
 * @see Constraint
 */
@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@NotNull(message = "Birthdate is required.")
@PastOrPresent(message = "Birthdate must be in the past, or present.")
public @interface ValidBirthdate {

    /**
     * Specifies the default error {@code message} if the {@code birthdate} does not meet the criteria.
     *
     * @return the error {@code message}.
     */
    String message() default "Invalid birthdate.";

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
