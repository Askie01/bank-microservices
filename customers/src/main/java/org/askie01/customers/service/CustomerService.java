package org.askie01.customers.service;

import org.askie01.customers.dto.CustomerDTO;
import org.askie01.customers.entity.Customer;

/**
 * Service interface for managing {@link Customer} related operations.
 * <p>
 * This interface defines methods to {@code create}, {@code get}, {@code update}, and {@code delete} customers.
 * Implementation of this interface handles business logic for interacting with {@link CustomerDTO} objects.
 * </p>
 */
public interface CustomerService {

    /**
     * Creates a new {@link Customer} object from provided {@link CustomerDTO} object.
     *
     * @param customerDTO the {@link CustomerDTO} object containing creation data.
     */
    void createCustomer(CustomerDTO customerDTO);

    /**
     * Retrieves {@link CustomerDTO} object based on the provided {@code id}.
     *
     * @param id unique ID of {@link CustomerDTO} to be retrieved.
     * @return {@link CustomerDTO} containing {@link Customer} details.
     */
    CustomerDTO getCustomerDTO(Long id);

    /**
     * Updates an existing {@link Customer} entity with provided {@link CustomerDTO} object data.
     *
     * @param customerDTO the {@link CustomerDTO} object with update details.
     */
    void updateCustomer(CustomerDTO customerDTO);

    /**
     * Deletes a {@link Customer} with the specified {@code id}.
     *
     * @param id unique ID of {@link Customer} to be deleted.
     */
    void deleteCustomer(Long id);
}
