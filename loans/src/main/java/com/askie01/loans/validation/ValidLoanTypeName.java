package com.askie01.loans.validation;

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
@Pattern(regexp = "^[A-Z_]{1,20}$", message = "Name must only contain uppercase letters and underscores, with a maximum length of 20 characters.")
public @interface ValidLoanTypeName {
    String message() default "Invalid loan type name";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}