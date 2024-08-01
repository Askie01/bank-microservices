package org.askie01.accounts.dto;

import lombok.Data;

@Data
public class AccountDTO {
    private Long accountId;
    private String accountType;
    private String branchAddress;
}
