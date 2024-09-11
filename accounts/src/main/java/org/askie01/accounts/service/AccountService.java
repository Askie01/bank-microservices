package org.askie01.accounts.service;

import lombok.Data;
import org.askie01.accounts.constant.AccountConstants;
import org.askie01.accounts.dto.AccountDTO;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.exception.MobilePhoneAlreadyExistsException;
import org.askie01.accounts.exception.ResourceNotFoundException;
import org.askie01.accounts.mapper.AccountMapper;
import org.askie01.accounts.mapper.CustomerMapper;
import org.askie01.accounts.repository.AccountRepository;
import org.askie01.accounts.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    public void createAccount(CustomerDTO customerDTO) {
        final Customer customer = CustomerMapper.map(customerDTO, new Customer());
        final Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new MobilePhoneAlreadyExistsException("Mobile phone: '" + customerDTO.getMobileNumber() + "' already exists");
        }
        final Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(savedCustomer));
    }

    private Account createAccount(Customer customer) {
        final Account account = new Account();
        account.setCustomer(customer);
        account.setType(AccountConstants.SAVINGS);
        account.setAddress(AccountConstants.ADDRESS);
        return account;
    }

    public CustomerDTO getAccount(String mobileNumber) {
        final Customer customer = customerRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        final Account account = accountRepository
                .findByCustomer(customer)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getId().toString()));

        final CustomerDTO customerDTO = CustomerMapper.map(customer, new CustomerDTO());
        final AccountDTO accountDTO = AccountMapper.map(account, new AccountDTO());
        customerDTO.setAccountDTO(accountDTO);
        return customerDTO;
    }

    public boolean updateAccount(CustomerDTO customerDTO) {
        boolean isUpdated = false;
        final AccountDTO accountDTO = customerDTO.getAccountDTO();
        if (accountDTO != null) {
            final Account account = accountRepository
                    .findById(accountDTO.getId())
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Account", "AccountID", accountDTO.getId().toString())
                    );
            AccountMapper.map(accountDTO, account);
            final Account updatedAccount = accountRepository.save(account);

            final Long customerId = updatedAccount.getCustomer().getId();
            final Customer customer = customerRepository
                    .findById(customerId)
                    .orElseThrow(
                            () -> new ResourceNotFoundException("Customer", "CustomerID", customerId.toString())
                    );
            CustomerMapper.map(customerDTO, customer);
            customerRepository.save(customer);
            isUpdated = true;
        }

        return isUpdated;
    }

    public boolean deleteAccount(String mobileNumber) {
        final Customer customer = customerRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(
                        () -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber)
                );
        accountRepository.deleteByCustomerId(customer.getId());
        customerRepository.deleteById(customer.getId());
        return true;
    }
}
