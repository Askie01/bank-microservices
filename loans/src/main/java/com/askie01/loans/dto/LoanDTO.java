package com.askie01.loans.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class LoanDTO {

    @NotEmpty(message = "Mobile number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be a 9 digits")
    private String mobileNumber;

    @NotEmpty(message = "Loan number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]+)", message = "Loan number can only contain digits")
    private String loanNumber;

    @NotEmpty(message = "Loan type cannot be a null or empty")
    private String loanType;

    @Positive(message = "Total loan amount should be greater than zero")
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    private int outstandingAmount;
}
