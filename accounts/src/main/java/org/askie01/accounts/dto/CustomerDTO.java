package org.askie01.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CustomerDTO {

    @NotEmpty(message = "Customer name cannot be a null or empty")
    @Size(min = 5, max = 30, message = "The length of the customer name should be between 5 and 30")
    private String name;

    @NotEmpty(message = "Customer email cannot be null or empty")
    @Email(message = "Customer email should be a valid value")
    private String email;

    @Pattern(regexp = "(^$|[0-9]{9})", message = "Customer's mobile number must be exact 9 digits")
    private String mobileNumber;

    private AccountDTO accountDTO;
}
