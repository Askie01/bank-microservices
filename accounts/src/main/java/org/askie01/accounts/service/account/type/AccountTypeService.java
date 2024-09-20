package org.askie01.accounts.service.account.type;

import org.askie01.accounts.entity.AccountType;

public interface AccountTypeService {
    void createAccountType(String name);

    AccountType getAccountType(String name);

    void updateAccountType(String oldName, String newName);

    void deleteAccountType(String name);
}
