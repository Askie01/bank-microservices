package com.askie01.loans.request.update;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LoanUpdateRequest implements UpdateRequest {

    @Min(value = 100_000_000, message = "Loan number must be at least 100 000 000")
    @Max(value = 999_999_999, message = "Loan number must be at most 999 999 999")
    private Integer loanNumber;

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Loan type name cannot be null/empty")
    private String loanTypeName;

    @DecimalMin(value = "0.01", message = "Money loaned must be at least 0.01")
    @DecimalMax(value = "99999999.99", message = "Money loaned must be below 99 999 999.99")
    private BigDecimal moneyLoaned;

    @PositiveOrZero(message = "Money paid must be at least 0")
    @DecimalMax(value = "99999999.99", message = "Money paid must be below 99 999 999.99")
    private BigDecimal moneyPaid;
}
