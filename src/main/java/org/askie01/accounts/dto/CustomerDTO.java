package org.askie01.accounts.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CustomerDTO {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountDTO accountDTO;
}
