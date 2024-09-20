package org.askie01.accounts.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Pattern;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Pattern(regexp = "^[A-Z][a-z]{2,39}",
        message = "Last name can contain only letters, must start with uppercase letter and not exceed 40 characters.")
public @interface ValidLastName {
    String message() default "Invalid last name format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}