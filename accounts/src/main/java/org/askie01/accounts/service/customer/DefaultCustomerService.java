package org.askie01.accounts.service.customer;

import lombok.Data;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.exception.CustomerAlreadyExistsException;
import org.askie01.accounts.exception.ResourceNotFoundException;
import org.askie01.accounts.mapper.request.customer.CustomerCreateRequestMapper;
import org.askie01.accounts.mapper.request.customer.CustomerDeleteRequestMapper;
import org.askie01.accounts.mapper.request.customer.CustomerGetRequestMapper;
import org.askie01.accounts.mapper.request.customer.CustomerUpdateRequestMapper;
import org.askie01.accounts.repository.CustomerRepository;
import org.askie01.accounts.request.customer.create.CreateRequest;
import org.askie01.accounts.request.customer.delete.DeleteRequest;
import org.askie01.accounts.request.customer.get.GetRequest;
import org.askie01.accounts.request.customer.update.UpdateRequest;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerCreateRequestMapper customerCreateRequestMapper;
    private final CustomerGetRequestMapper customerGetRequestMapper;
    private final CustomerUpdateRequestMapper customerUpdateRequestMapper;
    private final CustomerDeleteRequestMapper customerDeleteRequestMapper;

    @Override
    public void createCustomer(CreateRequest request) {
        final String email = request.getEmail();
        final String mobileNumber = request.getMobileNumber();
        final boolean uniqueEmail = uniqueEmail(email);
        final boolean uniqueMobileNumber = uniqueMobileNumber(mobileNumber);

        if (!uniqueEmail) {
            throw new CustomerAlreadyExistsException("Customer with email '" + email + "' already exists.");
        } else if (!uniqueMobileNumber) {
            throw new CustomerAlreadyExistsException("Customer with mobileNumber '" + mobileNumber + "' already exists.");
        } else {
            final Customer customer = customerCreateRequestMapper.mapToCustomer(request);
            customerRepository.save(customer);
        }
    }

    private boolean uniqueEmail(String email) {
        return customerRepository.findByEmail(email).isEmpty();
    }

    private boolean uniqueMobileNumber(String mobileNumber) {
        return customerRepository.findByMobileNumber(mobileNumber).isEmpty();
    }

    @Override
    public Customer getCustomer(GetRequest request) {
        final Long id = customerGetRequestMapper
                .mapToCustomer(request)
                .getId();
        return getCustomerById(id);
    }

    public Customer getCustomerById(Long id) {
        return customerRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "id", id));
    }

    @Override
    public void updateCustomer(UpdateRequest request) {
        final Customer updatedCustomer = customerUpdateRequestMapper.mapToCustomer(request);
        final String email = updatedCustomer.getEmail();
        final String mobileNumber = updatedCustomer.getMobileNumber();
        final boolean uniqueEmail = uniqueEmail(email);
        final boolean uniqueMobileNumber = uniqueMobileNumber(mobileNumber);

        if (!uniqueEmail) {
            throw new CustomerAlreadyExistsException("Customer with email '" + email + "' already exists.");
        } else if (!uniqueMobileNumber) {
            throw new CustomerAlreadyExistsException("Customer with mobileNumber '" + mobileNumber + "' already exists.");
        } else {
            customerRepository.save(updatedCustomer);
        }
    }

    @Override
    public void deleteCustomer(DeleteRequest request) {
        final Customer customer = customerDeleteRequestMapper.mapToCustomer(request);
        customerRepository.delete(customer);
    }
}
