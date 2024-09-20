package org.askie01.accounts.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.Min;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = {})
@Min(value = 1, message = "Id must be a positive number greater than 0.")
public @interface ValidId {
    String message() default "Invalid id value";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}