package org.askie01.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDTO {

    @NotEmpty(message = "AccountId cannot be null or empty")
    @Pattern(regexp = "(^$[0-9])", message = "Account ID can only contain digits.")
    private Long accountId;

    @NotEmpty(message = "AccountType cannot be null or empty")
    private String accountType;

    @NotEmpty(message = "BranchAddress cannot be null or empty")
    private String branchAddress;
}
