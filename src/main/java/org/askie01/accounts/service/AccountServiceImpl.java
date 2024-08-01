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
import org.askie01.accounts.repositories.AccountRepository;
import org.askie01.accounts.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Data
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        final Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        final Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDTO.getMobileNumber());
        if (optionalCustomer.isPresent()) {
            throw new MobilePhoneAlreadyExistsException("Mobile phone: '" + customerDTO.getMobileNumber() + "' already exists");
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("Anonymous");
        final Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(savedCustomer));
    }

    private Account createAccount(Customer customer) {
        final Account account = new Account();
        account.setCustomer(customer);
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        account.setCreatedAt(LocalDateTime.now());
        account.setCreatedBy("Anonymous");
        return account;
    }

    /**
     * @param mobileNumber
     * @return
     */
    @Override
    public CustomerDTO getAccount(String mobileNumber) {
        final Customer customer = customerRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "mobileNumber", mobileNumber));

        final Account account = accountRepository
                .findByCustomer(customer)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "customerId", customer.getCustomerId().toString()));

        final CustomerDTO customerDTO = CustomerMapper.mapToCustomerDTO(customer, new CustomerDTO());
        final AccountDTO accountDTO = AccountMapper.mapToAccountDTO(account, new AccountDTO());
        customerDTO.setAccountDTO(accountDTO);
        return customerDTO;
    }
}
