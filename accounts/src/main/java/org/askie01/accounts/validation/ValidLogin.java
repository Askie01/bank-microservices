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
@Pattern(regexp = "^[A-Za-z][A-Za-z0-9!@#$%^&*()_+={}\\[\\]:;'\"<>,.?\\/\\\\|-]{4,}$",
        message = "Login must start with a letter and be at least 5 characters long, containing letters, numbers, and specific special characters.")
public @interface ValidLogin {
    String message() default "Invalid login format";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
