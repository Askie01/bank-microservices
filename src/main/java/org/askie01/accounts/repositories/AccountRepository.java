package org.askie01.accounts.repositories;

import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {
    Optional<Account> findByCustomer(Customer customer);

    @Modifying
    @Transactional
    void deleteByCustomerCustomerId(Long id);
}
