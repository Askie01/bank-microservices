package org.askie01.accounts.mapper.request.account;

import lombok.Data;
import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.mapper.request.customer.CustomerCreateRequestMapper;
import org.askie01.accounts.request.account.update.UpdateRequest;
import org.askie01.accounts.request.customer.create.CustomerCreateRequest;
import org.askie01.accounts.service.account.type.AccountTypeService;
import org.springframework.stereotype.Component;

@Data
@Component
public class AccountUpdateRequestMapper implements Mapper<UpdateRequest, Account> {

    private final AccountTypeService accountTypeService;
    private final CustomerCreateRequestMapper customerCreateRequestMapper;

    @Override
    public Account map(UpdateRequest source, Account target) {
        final Account targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapAccountType(source, targetCopy);
        mapCustomer(source, targetCopy);
        return targetCopy;
    }

    private void mapId(UpdateRequest source, Account target) {
        final Long id = source.getId();
        target.setId(id);
    }

    private void mapAccountType(UpdateRequest source, Account target) {
        final String accountTypeName = source.getAccountTypeName();
        final AccountType accountType = accountTypeService.getAccountType(accountTypeName);
        target.setAccountType(accountType);
    }

    private void mapCustomer(UpdateRequest source, Account target) {
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
