package org.askie01.customers.mapper;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.copier.ObjectCopier;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.dto.CustomerDTO;
import org.askie01.customers.entity.Country;
import org.askie01.customers.entity.Customer;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * {@link Mapper} implementation that handles mapping between {@link Customer} and {@link CustomerDTO}.
 * <p>
 * This class provides methods to map all fields from {@link Customer} object to {@link CustomerDTO} object.
 * No vice versa (for reversed mapping check {@link CustomerDTOMapper}).
 * </p>
 * <p>
 * This class makes use of {@link ObjectCopier} to crate a {@code target} copy before mapping - which results
 * in {@code map} method returning updated version of {@code target} object.
 * </p>
 */
@Data
@Slf4j
@Component
public class CustomerMapper implements Mapper<Customer, CustomerDTO> {

    private final CountryMapper countryMapper;

    /**
     * Maps {@link Customer} object to a newly created {@link CustomerDTO} object.
     *
     * @param customer the {@link Customer} object containing fields to be mapped.
     * @return newly created {@link CustomerDTO} object containing mapped fields.
     */
    public CustomerDTO mapToCustomerDTO(Customer customer) {
        log.atDebug().log("Attempting to map '{}' to a new CustomerDTO.", customer);
        return map(customer, new CustomerDTO());
    }

    /**
     * Maps data from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with fields to be mapped.
     * @param target the {@link CustomerDTO} object, to which fields will be mapped.
     * @return the updated {@code target} object of type {@link CustomerDTO}.
     */
    @Override
    public CustomerDTO map(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map '{}' to '{}'.", source, target);
        final CustomerDTO targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapFirstName(source, targetCopy);
        mapLastName(source, targetCopy);
        mapBirthdate(source, targetCopy);
        mapEmail(source, targetCopy);
        mapMobileNumber(source, targetCopy);
        mapCountry(source, targetCopy);
        log.atInfo().log("Successfully mapped '{}' to '{}'.", source, targetCopy);
        return targetCopy;
    }

    /**
     * Maps {@code id} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code id} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code id} field will be mapped.
     */
    private void mapId(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map id: '{}' from '{}' to '{}'.", source.getId(), source, target);
        final Long id = source.getId();
        target.setId(id);
        log.atDebug().log("Successfully mapped id: '{}' from '{}' to '{}'.", id, source, target);
    }

    /**
     * Maps {@code firstName} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code firstName} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code fistName} field will be mapped.
     */
    private void mapFirstName(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map firstName: '{}' from '{}' to '{}'.", source.getFirstName(), source, target);
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
        log.atDebug().log("Successfully mapped firstName: '{}' from '{}' to '{}'.", firstName, source, target);
    }

    /**
     * Maps {@code lastName} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code lastName} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code lastName} field will be mapped.
     */
    private void mapLastName(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map lastName: '{}' from '{}' to '{}'.", source.getLastName(), source, target);
        final String lastName = source.getLastName();
        target.setLastName(lastName);
        log.atDebug().log("Successfully mapped lastName: '{}' from '{}' to '{}'.", lastName, source, target);
    }

    /**
     * Maps {@code birthdate} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code birthdate} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code birthdate} field will be mapped.
     */
    private void mapBirthdate(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map birthdate: '{}' from '{}' to '{}'.", source.getBirthdate(), source, target);
        final LocalDate birthdate = source.getBirthdate();
        target.setBirthdate(birthdate);
        log.atDebug().log("Successfully mapped birthdate: '{}' from '{}' to '{}'.", birthdate, source, target);
    }

    /**
     * Maps {@code email} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code email} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code email} field will be mapped.
     */
    private void mapEmail(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map email: '{}' from '{}' to '{}'.", source.getEmail(), source, target);
        final String email = source.getEmail();
        target.setEmail(email);
        log.atDebug().log("Successfully mapped email: '{}' from '{}' to '{}'.", email, source, target);
    }

    /**
     * Maps {@code mobileNumber} field from {@link Customer} object to {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code mobileNumber} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code mobileNumber} field will be mapped.
     */
    private void mapMobileNumber(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map mobileNumber: '{}' from '{}' to '{}'.", source.getMobileNumber(), source, target);
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
        log.atDebug().log("Successfully mapped mobileNumber: '{}' from '{}' to '{}'.", mobileNumber, source, target);
    }

    /**
     * Maps {@code country} field from {@link Customer} object to the corresponding {@code countryDTO} field of {@link CustomerDTO} object.
     *
     * @param source the {@link Customer} object with {@code country} field to be mapped.
     * @param target the {@link CustomerDTO} object to which {@code countryDTO} field will be mapped.
     */
    private void mapCountry(Customer source, CustomerDTO target) {
        log.atDebug().log("Attempting to map country: '{}' from '{}' to '{}'.", source.getCountry(), source, target);
        final Country country = source.getCountry();
        final CountryDTO countryDTO = countryMapper.mapToCountryDTO(country);
        target.setCountryDTO(countryDTO);
        log.atDebug().log("Successfully mapped country: '{}' from '{}' to countryDTO '{}' in '{}'.", country, source, countryDTO, target);
    }
}
