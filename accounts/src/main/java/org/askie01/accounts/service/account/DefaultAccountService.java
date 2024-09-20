package org.askie01.accounts.service.account;

import lombok.Data;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.mapper.request.account.AccountCreateRequestMapper;
import org.askie01.accounts.request.account.create.CreateRequest;
import org.askie01.accounts.request.account.delete.DeleteRequest;
import org.askie01.accounts.request.account.get.GetRequest;
import org.askie01.accounts.request.account.update.UpdateRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Data
@Service
public class DefaultAccountService implements AccountService {


    private final AccountCreateRequestMapper accountCreateRequestMapper;

    @Override
    public void createAccount(CreateRequest request) {
        final Account account = accountCreateRequestMapper.mapToAccount(request);

    }

    @Override
    public List<Account> getAccounts(GetRequest request) {
        return List.of();
    }

    @Override
    public void updateAccount(UpdateRequest request) {

    }

    @Override
    public void deleteAccount(DeleteRequest request) {

    }
}
