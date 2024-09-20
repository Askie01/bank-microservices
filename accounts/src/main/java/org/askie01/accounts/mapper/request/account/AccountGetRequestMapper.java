package org.askie01.accounts.mapper.request.account;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.account.get.GetRequest;
import org.springframework.stereotype.Component;

@Component
public class AccountGetRequestMapper implements Mapper<GetRequest, Account> {

    @Override
    public Account map(GetRequest source, Account target) {
        final Account targetCopy = ObjectCopier.copy(target);
        mapCustomer(source, targetCopy);
        return targetCopy;
    }

    private void mapCustomer(GetRequest source, Account target) {
        final Customer customer = new Customer();
        final String mobileNumber = source.getMobileNumber();
        customer.setMobileNumber(mobileNumber);
        target.setCustomer(customer);
    }
}
