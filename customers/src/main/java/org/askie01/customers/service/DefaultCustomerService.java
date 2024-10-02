package org.askie01.customers.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.dto.CustomerDTO;
import org.askie01.customers.entity.Country;
import org.askie01.customers.entity.Customer;
import org.askie01.customers.exception.EmailAlreadyExistsException;
import org.askie01.customers.exception.MobileNumberAlreadyExistsException;
import org.askie01.customers.exception.ResourceNotFoundException;
import org.askie01.customers.mapper.CustomerDTOMapper;
import org.askie01.customers.mapper.CustomerMapper;
import org.askie01.customers.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

/**
 * Default implementation of {@link CustomerService} interface.
 * <p>
 * This service handles business logic to {@code create}, {@code get}, {@code update}, and {@code delete}
 * {@link Customer} entities.
 * </p>
 * <p>
 * It relies on {@link CustomerRepository} for database interactions and {@link CustomerMapper} along with
 * {@link CustomerDTO} for object mappings.
 * </p>
 * <p>
 * It also has reference to {@link CountryService} for {@link Country} related operations.
 * </p>
 */
@Data
@Slf4j
@Service
public class DefaultCustomerService implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerDTOMapper customerDTOMapper;
    private final CountryService countryService;

    /**
     * Creates a new {@link Customer} from the provided {@link CustomerDTO} object.
     * <p>
     * Ensures that the associated {@link Country} exists and that the {@code email} along with {@code mobileNumber}
     * are unique before saving.
     * </p>
     *
     * @param customerDTO the {@link CustomerDTO} object containing data for new {@link Customer}.
     * @throws EmailAlreadyExistsException        if {@link Customer} with the same {@code email} already exists.
     * @throws MobileNumberAlreadyExistsException if {@link Customer} with the same {@code mobileNumber} already exists.
     * @throws ResourceNotFoundException          if the associated {@link Country} is not found.
     */
    @Override
    public void createCustomer(CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to create a new Customer from '{}'.", customerDTO);
        final CountryDTO countryDTO = customerDTO.getCountryDTO();
        checkCountryExistence(countryDTO);
        checkEmailUniqueness(customerDTO);
        checkMobileNumberUniqueness(customerDTO);
        final Customer customer = customerDTOMapper.mapToCustomer(customerDTO);
        customerRepository.save(customer);
        log.atInfo().log("Saved: '{}'.", customerDTO);
    }

    /**
     * Retrieves {@link CustomerDTO} based on the provided customer ID.
     *
     * @param id the ID of {@link Customer} to retrieve.
     * @return {@link CustomerDTO} representing the retrieved {@link Customer}.
     * @throws ResourceNotFoundException if no {@link Customer} is found with the provided ID.
     */
    @Override
    public CustomerDTO getCustomerDTO(Long id) {
        log.atDebug().log("Attempting to retrieve CustomerDTO with ID: '{}'.", id);
        final Customer customer = getCustomer(id);
        final CustomerDTO customerDTO = customerMapper.mapToCustomerDTO(customer);
        log.atInfo().log("Retrieved: '{}'.", customerDTO);
        return customerDTO;
    }

    /**
     * Helper method to retrieve {@link Customer} by its ID.
     *
     * @param id the ID of {@link Customer} to retrieve.
     * @return the retrieved {@link Customer}.
     * @throws ResourceNotFoundException if the {@link Customer} is not found.
     */
    private Customer getCustomer(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> {
            log.atError().log("Error occurred when retrieving Customer with ID: '{}'.", id);
            return new ResourceNotFoundException("Customer", "id", id);
        });
    }

    /**
     * Updates an existing {@link Customer} with the provided {@link CustomerDTO} data.
     * <p>
     * Ensures that the associated {@link Country} exists and that the {@code email} and
     * {@code mobileNumber} are unique before updating.
     * </p>
     *
     * @param customerDTO the {@link CustomerDTO} containing updated data for {@link Customer}.
     * @throws EmailAlreadyExistsException        if {@link Customer} with the same {@code email} already exists.
     * @throws MobileNumberAlreadyExistsException if {@link Customer} with the same {@code mobileNumber} already exists.
     * @throws ResourceNotFoundException          if the associated {@link Country} is not found or the {@link Customer#id} does not exist.
     */
    @Override
    public void updateCustomer(CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to update Customer from: '{}'.", customerDTO);
        final CountryDTO countryDTO = customerDTO.getCountryDTO();
        checkCountryExistence(countryDTO);
        checkEmailUniqueness(customerDTO);
        checkMobileNumberUniqueness(customerDTO);

        final Long id = customerDTO.getId();
        final Customer customer = getCustomer(id);
        final Customer updatedCustomer = customerDTOMapper.map(customerDTO, customer);
        customerRepository.save(updatedCustomer);
        log.atInfo().log("Updated '{}' to '{}'.", customer, updatedCustomer);
    }

    /**
     * Deletes {@link Customer} with the specified {@code id}.
     *
     * @param id the ID of {@link Customer} to delete.
     * @throws ResourceNotFoundException if no {@link Customer} is found with the provided {@code id}.
     */
    @Override
    public void deleteCustomer(Long id) {
        log.atDebug().log("Attempting to delete Customer with ID: '{}'.", id);
        final Customer customer = getCustomer(id);
        customerRepository.delete(customer);
        log.atInfo().log("Deleted Customer with ID: '{}'.", id);
    }

    /**
     * Checks if the {@link Country} associated with the {@link Customer} exists.
     *
     * @param countryDTO the {@link CountryDTO} to check for existence.
     * @throws ResourceNotFoundException if the {@link Country} does not exist.
     */
    private void checkCountryExistence(CountryDTO countryDTO) {
        log.atDebug().log("Attempting to check Country existence for: '{}'.", countryDTO);
        final Long id = countryDTO.getId();
        final CountryDTO countryDTOFromDatabase = countryService.getCountryDTO(id);
        final boolean countryExists = Objects.equals(countryDTO, countryDTOFromDatabase);

        if (!countryExists) {
            log.atError().log("Error occurred when checking existence for: '{}'.", countryDTO);
            throw new ResourceNotFoundException("Country", "countryDTO", countryDTO.toString());
        }
        log.atInfo().log("Successfully checked Country existence for: '{}'.", countryDTO);
    }

    /**
     * Checks if {@code email} of {@link Customer} is unique.
     *
     * @param customerDTO the {@link CustomerDTO} to check for {@code email} uniqueness.
     * @throws EmailAlreadyExistsException if the {@code email} is already in use by other {@link Customer}.
     */
    private void checkEmailUniqueness(CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to check email uniqueness for: '{}'.", customerDTO);
        final String email = customerDTO.getEmail();
        final Optional<Customer> optionalCustomer = customerRepository.findByEmail(email);
        final boolean emailTaken = optionalCustomer.isPresent();

        if (emailTaken) {
            final Long id = customerDTO.getId();
            final Long foundCustomerId = optionalCustomer.get().getId();
            final boolean sameId = (Objects.equals(id, foundCustomerId));

            if (!sameId) {
                log.atError().log("Error occurred when checking email uniqueness for: '{}'.", customerDTO);
                throw new EmailAlreadyExistsException(email);
            }
        }
        log.atInfo().log("Successfully checked email uniqueness for: '{}'.", customerDTO);
    }

    /**
     * Checks if {@code mobileNumber} of {@link Customer} is unique.
     *
     * @param customerDTO the {@link CustomerDTO} to check for {@code mobileNumber} uniqueness.
     * @throws MobileNumberAlreadyExistsException if the {@code mobileNumber} is already in use by another {@link Customer}.
     */
    private void checkMobileNumberUniqueness(CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to check mobileNumber uniqueness for: '{}'.", customerDTO);
        final String mobileNumber = customerDTO.getMobileNumber();
        final Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(mobileNumber);
        final boolean mobileNumberTaken = optionalCustomer.isPresent();

        if (mobileNumberTaken) {
            final Long id = customerDTO.getId();
            final Long foundCustomerId = optionalCustomer.get().getId();
            final boolean sameId = Objects.equals(id, foundCustomerId);

            if (!sameId) {
                log.atError().log("Error occurred when checking mobileNumber uniqueness for: '{}'.", customerDTO);
                throw new MobileNumberAlreadyExistsException(mobileNumber);
            }
        }
        log.atInfo().log("Successfully checked mobileNumber uniqueness for: '{}'.", customerDTO);
    }
}
