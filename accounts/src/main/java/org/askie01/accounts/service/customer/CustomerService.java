package org.askie01.accounts.service.customer;

import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.request.customer.create.CreateRequest;
import org.askie01.accounts.request.customer.delete.DeleteRequest;
import org.askie01.accounts.request.customer.get.GetRequest;
import org.askie01.accounts.request.customer.update.UpdateRequest;

public interface CustomerService {
    void createCustomer(CreateRequest request);

    Customer getCustomer(GetRequest request);

    void updateCustomer(UpdateRequest request);

    void deleteCustomer(DeleteRequest request);
}
