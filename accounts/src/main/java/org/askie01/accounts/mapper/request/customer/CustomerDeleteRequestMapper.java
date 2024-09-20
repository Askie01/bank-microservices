package org.askie01.accounts.mapper.request.customer;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.customer.delete.DeleteRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerDeleteRequestMapper implements Mapper<DeleteRequest, Customer> {

    public Customer mapToCustomer(DeleteRequest request) {
        return map(request, new Customer());
    }

    @Override
    public Customer map(DeleteRequest source, Customer target) {
        final Customer targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        return targetCopy;
    }

    private void mapId(DeleteRequest source, Customer target) {
        final Long id = source.getId();
        target.setId(id);
    }
}
