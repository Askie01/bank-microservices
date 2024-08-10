package org.askie01.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
@Schema(
        description = "Schema to hold Account information"
)
public class AccountDTO {

    @Schema(
            description = "Account ID bound to specific customer's account.",
            example = "1"
    )
    @NotEmpty(message = "AccountId cannot be null or empty")
    @Pattern(regexp = "(^$[0-9])", message = "Account ID can only contain digits.")
    private Long accountId;

    @Schema(
            description = "Account type",
            example = "AccountConstants.SAVINGS"
    )
    @NotEmpty(message = "AccountType cannot be null or empty")
    private String accountType;

    @Schema(
            description = "Customer account ",
            example = "125 Main Street, New York"
    )
    @NotEmpty(message = "BranchAddress cannot be null or empty")
    private String branchAddress;
}
