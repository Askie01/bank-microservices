package org.askie01.accounts.service;

import lombok.Data;
import org.askie01.accounts.constant.AccountConstants;
import org.askie01.accounts.dto.CustomerDTO;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.Customer;
import org.askie01.accounts.mapper.CustomerMapper;
import org.askie01.accounts.repositories.AccountRepository;
import org.askie01.accounts.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Random;

@Data
@Service
public class AccountServiceImpl implements AccountService {

    private final AccountRepository accountRepository;
    private final CustomerRepository customerRepository;

    @Override
    public void createAccount(CustomerDTO customerDTO) {
        final Customer customer = CustomerMapper.mapToCustomer(customerDTO, new Customer());
        Customer savedCustomer = customerRepository.save(customer);
        accountRepository.save(createAccount(savedCustomer));
    }

    private Account createAccount(Customer customer) {
        final Account account = new Account();
        account.setCustomerId(customer.getCustomerId());
        final long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);

        account.setAccountId(randomAccountNumber);
        account.setAccountType(AccountConstants.SAVINGS);
        account.setBranchAddress(AccountConstants.ADDRESS);
        return account;
    }
}
