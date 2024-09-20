package org.askie01.accounts.mapper.request.customer;

import org.askie01.accounts.copier.ObjectCopier;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.Mapper;
import org.askie01.accounts.request.customer.update.UpdateRequest;
import org.springframework.stereotype.Component;

@Component
public class CustomerUpdateRequestMapper implements Mapper<UpdateRequest, Customer> {

    public Customer mapToCustomer(UpdateRequest request) {
        return map(request, new Customer());
    }

    @Override
    public Customer map(UpdateRequest source, Customer target) {
        final Customer targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapFirstName(source, targetCopy);
        mapLastName(source, targetCopy);
        mapEmail(source, targetCopy);
        mapMobileNumber(source, targetCopy);
        return targetCopy;
    }

    private void mapId(UpdateRequest source, Customer target) {
        final Long id = source.getId();
        target.setId(id);
    }

    private void mapFirstName(UpdateRequest source, Customer target) {
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
    }

    private void mapLastName(UpdateRequest source, Customer target) {
        final String lastName = source.getLastName();
        target.setLastName(lastName);
    }

    private void mapEmail(UpdateRequest source, Customer target) {
        final String email = source.getEmail();
        target.setEmail(email);
    }

    private void mapMobileNumber(UpdateRequest source, Customer target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }
}
