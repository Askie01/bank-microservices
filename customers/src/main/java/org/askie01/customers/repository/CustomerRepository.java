package org.askie01.customers.repository;

import org.askie01.customers.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * {@link Repository} interface for {@link Customer} entities.
 * <p>
 * Extends {@link JpaRepository} to provide basic CRUD operations and additional query methods for {@link Customer} objects.
 * </p>
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    /**
     * Retrieves {@link Optional} containing {@link Customer} based on the provided {@code email}.
     *
     * @param email the email address of {@link Customer} to be retrieved.
     * @return {@link Optional} containing the matching {@link Customer}, or an empty {@link Optional} if no match is found.
     */
    Optional<Customer> findByEmail(String email);

    /**
     * Retrieves {@link Optional} containing {@link Customer} based on the provided {@code mobileNumber}.
     *
     * @param mobileNumber the mobile number of {@link Customer} to be retrieved.
     * @return {@link Optional} containing the matching {@link Customer}, or an empty {@link Optional} if no match is found.
     */
    Optional<Customer> findByMobileNumber(String mobileNumber);
}
