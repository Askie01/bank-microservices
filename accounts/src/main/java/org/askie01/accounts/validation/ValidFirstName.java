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
@Pattern(regexp = "^[A-Z][a-z]{2,19}",
        message = "First name can contain only letters, must start with uppercase letter and not exceed 20 characters.")
public @interface ValidFirstName {
    String message() default "Invalid first name format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
