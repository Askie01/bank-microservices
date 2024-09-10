package org.askie01.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AccountDTO {
    @NotEmpty(message = "id cannot be null or empty")
    @Pattern(regexp = "(^$[0-9])", message = "Account id can only contain digits.")
    private Long id;

    @NotEmpty(message = "Account type cannot be null or empty")
    private String type;

    @NotEmpty(message = "Account address cannot be null or empty")
    private String address;
}
