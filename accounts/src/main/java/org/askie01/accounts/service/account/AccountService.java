package org.askie01.accounts.service.account;

import org.askie01.accounts.entity.Account;
import org.askie01.accounts.request.account.create.CreateRequest;
import org.askie01.accounts.request.account.delete.DeleteRequest;
import org.askie01.accounts.request.account.get.GetRequest;
import org.askie01.accounts.request.account.update.UpdateRequest;

import java.util.List;

public interface AccountService {
    void createAccount(CreateRequest request);

    List<Account> getAccounts(GetRequest request);

    void updateAccount(UpdateRequest request);

    void deleteAccount(DeleteRequest request);
}
