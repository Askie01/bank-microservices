package com.askie01.loans.request.delete;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoanDeleteRequest implements DeleteRequest {

    @Min(value = 100_000_000, message = "Number must be at least 100 000 000")
    @Max(value = 999_999_999, message = "Number must be at most 999 999 999")
    private Integer loanNumber;

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Type cannot be null/empty")
    private String loanTypeName;
}
