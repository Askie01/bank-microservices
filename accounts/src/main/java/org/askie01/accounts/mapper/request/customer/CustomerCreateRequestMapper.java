package org.askie01.accounts.mapper.request.customer;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.customer.create.CreateRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerCreateRequestMapper implements Mapper<CreateRequest, Customer> {

    public Customer mapToCustomer(CreateRequest request) {
        return map(request, new Customer());
    }

    @Override
    public Customer map(CreateRequest source, Customer target) {
        final Customer targetCopy = ObjectCopier.copy(target);
        mapFirstName(source, targetCopy);
        mapLastName(source, targetCopy);
        mapEmail(source, targetCopy);
        mapMobileNumber(source, targetCopy);
        return targetCopy;
    }

    private void mapFirstName(CreateRequest source, Customer target) {
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
    }

    private void mapLastName(CreateRequest source, Customer target) {
        final String lastName = source.getLastName();
        target.setLastName(lastName);
    }

    private void mapEmail(CreateRequest source, Customer target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private void mapMobileNumber(CreateRequest source, Customer target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }
}
