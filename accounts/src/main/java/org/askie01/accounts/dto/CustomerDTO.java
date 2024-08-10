package org.askie01.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Schema(
        description = "Schema to hold Customer & Account information"
)
public class CustomerDTO {

    @Schema(
            description = "Name of the customer",
            example = "Adam Kowalski"
    )
    @NotEmpty(message = "Name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @Schema(
            description = "Email of the customer",
            example = "adam.kowalski@gmail.com"
    )
    @NotEmpty(message = "Email address cannot be null or empty")
    @Email(message = "Email address should be a valid value")
    private String email;

    @Schema(
            description = "Customer mobile number",
            example = "123456789"
    )
    @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
    private String mobileNumber;

    @Schema(
            example = "new AccountDTO(1, AccountConstants.SAVINGS, \"125 Main Street, New York\")"
    )
    private AccountDTO accountDTO;
}
