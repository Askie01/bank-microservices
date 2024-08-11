package com.askie01.loans.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
@Schema(
        description = "Schema to hold Loan information"
)
public class LoanDTO {

    @NotEmpty(message = "Mobile number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be a 9 digits")
    @Schema(
            description = "Loan number of the customer", example = "123456789"
    )
    private String mobileNumber;

    @NotEmpty(message = "Loan number cannot be a null or empty")
    @Pattern(regexp = "(^$|[0-9]+)", message = "Loan number can only contain digits")
    @Schema(
            description = "Loan number of the customer", example = "1"
    )
    private String loanNumber;

    @NotEmpty(message = "Loan type cannot be a null or empty")
    @Schema(
            description = "Type of the loan", example = "Home loan"
    )
    private String loanType;


    @Positive(message = "Total loan amount should be greater than zero")
    @Schema(
            description = "Total loan amount", example = "100000"
    )
    private int totalLoan;

    @PositiveOrZero(message = "Total loan amount paid should be equal or greater than zero")
    @Schema(
            description = "Total loan amount paid", example = "1000"
    )
    private int amountPaid;

    @PositiveOrZero(message = "Total outstanding amount should be equal or greater than zero")
    @Schema(
            description = "Total outstanding amount against a loan", example = "99000"
    )
    private int outstandingAmount;

}
