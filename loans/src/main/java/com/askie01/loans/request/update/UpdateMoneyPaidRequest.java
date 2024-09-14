package com.askie01.loans.request.update;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.Data;

@Data
public class UpdateMoneyPaidRequest {

    @Min(value = 1000_0000_0000_0000L, message = "Loan's number must be at least 16 digits")
    @Max(value = 9999_9999_9999_9999L, message = "Loan's number must be at most 16 digits")
    private Long number;

    @Min(value = 100_000_000, message = "Loan's mobile number must be at least 9 digits")
    @Max(value = 999_999_999, message = "Loan's mobile number must be at most 9 digits")
    private Integer mobileNumber;

    @NotNull(message = "Money paid cannot be null")
    @PositiveOrZero(message = "Loan's money paid must be positive/zero")
    private Integer moneyPaid;
}
