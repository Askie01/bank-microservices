package org.askie01.accounts.mapper.request.customer;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.customer.get.GetRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerGetRequestMapper implements Mapper<GetRequest, Customer> {

    public Customer mapToCustomer(GetRequest request) {
        return map(request, new Customer());
    }

    @Override
    public Customer map(GetRequest source, Customer target) {
        final Customer targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        return targetCopy;
    }

    private void mapId(GetRequest source, Customer target) {
        final Long id = source.getId();
        target.setId(id);
    }
}
