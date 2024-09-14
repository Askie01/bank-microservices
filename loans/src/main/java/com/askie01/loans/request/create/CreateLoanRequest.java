package com.askie01.loans.request.create;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class CreateLoanRequest {

    @Min(value = 100_000_000, message = "Loan's mobile number must be at least 9 digits")
    @Max(value = 999_999_999, message = "Loan's mobile number must be at most 9 digits")
    private Integer mobileNumber;

    @NotEmpty(message = "Loan type cannot be null or empty")
    private String type;

    @NotNull(message = "Money limit cannot be null")
    @Positive(message = "Money limit should be greater than zero")
    private Integer moneyLimit;
}
