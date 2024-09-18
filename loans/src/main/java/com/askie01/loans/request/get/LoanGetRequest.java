package com.askie01.loans.request.get;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class LoanGetRequest implements GetRequest {

    @Pattern(regexp = "^\\+\\d{2,3} \\d{8,15}$",
            message = "Mobile number must start with '+' followed by 2-3 digits, a space, and 8-15 digits")
    private String mobileNumber;

    @NotEmpty(message = "Type name cannot be null/empty")
    private String loanTypeName;
}
