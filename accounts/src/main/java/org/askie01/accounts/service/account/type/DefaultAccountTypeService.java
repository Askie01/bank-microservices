package org.askie01.accounts.service.account.type;

import lombok.Data;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.exception.AccountTypeAlreadyExistsException;
import org.askie01.accounts.exception.ResourceNotFoundException;
import org.askie01.accounts.repository.AccountTypeRepository;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultAccountTypeService implements AccountTypeService {

    private final AccountTypeRepository accountTypeRepository;

    @Override
    public void createAccountType(String name) {
        try {
            getAccountType(name);
            throw new AccountTypeAlreadyExistsException("AccountType with name '" + name + "' already exists.");
        } catch (ResourceNotFoundException exception) {
            final AccountType accountType = new AccountType();
            accountType.setName(name);
            accountTypeRepository.save(accountType);
        }
    }

    @Override
    public AccountType getAccountType(String name) {
        return accountTypeRepository
                .findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("AccountType", "name", name));
    }

    @Override
    public void updateAccountType(String oldName, String newName) {
        final AccountType accountType = getAccountType(oldName);
        accountType.setName(newName);
        accountTypeRepository.save(accountType);
    }

    @Override
    public void deleteAccountType(String name) {
        final AccountType accountType = getAccountType(name);
        accountTypeRepository.delete(accountType);
    }
}
