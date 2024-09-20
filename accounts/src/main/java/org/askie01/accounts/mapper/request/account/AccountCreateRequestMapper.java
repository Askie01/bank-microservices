package org.askie01.accounts.mapper.request.account;

import lombok.Data;
import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.mapper.request.customer.CustomerCreateRequestMapper;
import org.askie01.accounts.request.account.create.CreateRequest;
import org.askie01.accounts.request.customer.create.CustomerCreateRequest;
import org.askie01.accounts.service.account.type.AccountTypeService;
import org.springframework.stereotype.Component;

@Data
@Component
public class AccountCreateRequestMapper implements Mapper<CreateRequest, Account> {

    private final AccountTypeService accountTypeService;
    private final CustomerCreateRequestMapper customerCreateRequestMapper;

    public Account mapToAccount(CreateRequest request) {
        return map(request, new Account());
    }

    @Override
    public Account map(CreateRequest source, Account target) {
        final Account targetCopy = ObjectCopier.copy(target);
        mapLogin(source, targetCopy);
        mapPassword(source, targetCopy);
        mapAccountType(source, targetCopy);
        mapCustomer(source, targetCopy);
        return targetCopy;
    }

    private void mapLogin(CreateRequest source, Account target) {
        final String login = source.getLogin();
        target.setLogin(login);
    }

    private void mapPassword(CreateRequest source, Account target) {
        final String password = source.getPassword();
        target.setPassword(password);
    }

    private void mapAccountType(CreateRequest source, Account target) {
        final String accountTypeName = source.getAccountTypeName();
        final AccountType accountType = accountTypeService.getAccountType(accountTypeName);
        target.setAccountType(accountType);
    }

    private void mapCustomer(CreateRequest source, Account target) {
        final CustomerCreateRequest customerCreateRequest = new CustomerCreateRequest(
                source.getFirstName(),
                source.getLastName(),
                source.getEmail(),
                source.getMobileNumber()
        );
        final Customer customer = customerCreateRequestMapper.mapToCustomer(customerCreateRequest);
        target.setCustomer(customer);
    }
}
