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
 * {@link Mapper} implementation that handles mapping between {@link CustomerDTO} and {@link Customer}.
 * <p>
 * This class provides methods to map all fields from {@link CustomerDTO} object to {@link Customer} object.
 * No vice versa (for reversed mapping check {@link CountryMapper}).
 * </p>
 * <p>
 * This class makes use of {@link ObjectCopier} to create a {@code target} copy before mapping -
 * which results in {@code map} method returning updated version of {@code target} object.
 * </p>
 */
@Data
@Slf4j
@Component
public class CustomerDTOMapper implements Mapper<CustomerDTO, Customer> {

    private final CountryDTOMapper countryDTOMapper;

    /**
     * Maps {@link CustomerDTO} object to newly created {@link Customer} object.
     *
     * @param customerDTO the {@link CustomerDTO} object containing details to be mapped.
     * @return newly created {@link Customer} object containing mapped data.
     */
    public Customer mapToCustomer(CustomerDTO customerDTO) {
        log.atDebug().log("Attempting to map '{}' to a new Customer.", customerDTO);
        return map(customerDTO, new Customer());
    }

    /**
     * Maps data from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object containing fields to be mapped.
     * @param target the {@link Customer} object, to which data will be mapped.
     * @return the updated {@code target} object of type {@link Customer}.
     */
    @Override
    public Customer map(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map '{}' to '{}'.", source, target);
        final Customer targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapFirstName(source, targetCopy);
        mapLastName(source, targetCopy);
        mapBirthdate(source, targetCopy);
        mapEmail(source, targetCopy);
        mapMobileNumber(source, targetCopy);
        mapCountryDTO(source, targetCopy);
        log.atInfo().log("Successfully mapped '{}' to '{}'.", source, targetCopy);
        return targetCopy;
    }

    /**
     * Maps {@code id} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code id} field to be mapped.
     * @param target the {@link Customer} object to which {@code id} field will be mapped.
     */
    private void mapId(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map id: '{}' from '{}' to '{}'.", source.getId(), source, target);
        final Long id = source.getId();
        target.setId(id);
        log.atDebug().log("Successfully mapped id: '{}' from '{}' to '{}'.", id, source, target);
    }

    /**
     * Maps {@code firstName} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code firstName} field to be mapped.
     * @param target the {@link Customer} object to which {@code firstName} field will be mapped.
     */
    private void mapFirstName(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map firstName: '{}' from '{}' to '{}'.", source.getFirstName(), source, target);
        final String firstName = source.getFirstName();
        target.setFirstName(firstName);
        log.atDebug().log("Successfully mapped firstNamed: '{}' from '{}' to '{}'.", firstName, source, target);
    }

    /**
     * Maps {@code lastName} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code lastName} field to be mapped.
     * @param target the {@link Customer} object to which {@code lastName} field will be mapped.
     */
    private void mapLastName(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map lastName: '{}' from '{}' to '{}'.", source.getLastName(), source, target);
        final String lastName = source.getLastName();
        target.setLastName(lastName);
        log.atDebug().log("Successfully mapped lastName: '{}' from '{}' to '{}'.", lastName, source, target);
    }

    /**
     * Maps {@code birthdate} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code birthdate} field to be mapped.
     * @param target the {@link Customer} object to which {@code birthdate} field will be mapped.
     */
    private void mapBirthdate(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map birthdate: '{}' from '{}' to '{}'.", source.getBirthdate(), source, target);
        final LocalDate birthdate = source.getBirthdate();
        target.setBirthdate(birthdate);
        log.atDebug().log("Successfully mapped birthdate: '{}' from '{}' to '{}'.", birthdate, source, target);
    }

    /**
     * Maps {@code email} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code email} field to be mapped.
     * @param target the {@link Customer} object to which {@code email} field will be mapped.
     */
    private void mapEmail(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map email: '{}' from '{}' to '{}'.", source.getEmail(), source, target);
        final String email = source.getEmail();
        target.setEmail(email);
        log.atDebug().log("Successfully mapped email: '{}' from '{}' to '{}'.", email, source, target);
    }

    /**
     * Maps {@code mobileNumber} field from {@link CustomerDTO} object to {@link Customer} object.
     *
     * @param source the {@link CustomerDTO} object with {@code mobileNumber} field to be mapped.
     * @param target the {@link Customer} object to which {@code mobileNumber} field will be mapped.
     */
    private void mapMobileNumber(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map mobileNumber: '{}' from '{}' to '{}'.", source.getMobileNumber(), source, target);
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
        log.atDebug().log("Successfully mapped mobileNumber: '{}' from '{}' to '{}'.", mobileNumber, source, target);
    }

    /**
     * Maps {@code countryDTO} field from {@link CustomerDTO} object to tbe corresponding {@code country}
     * field of {@link Customer} object.
     * <p>
     * This method uses {@link CountryDTOMapper} to map {@code countryDTO} field to {@code country} field.
     * </p>
     *
     * @param source the {@link CustomerDTO} object with {@code countryDTO} field to be mapped.
     * @param target the {@link Customer} object to which {@code country} field will be mapped.
     */
    private void mapCountryDTO(CustomerDTO source, Customer target) {
        log.atDebug().log("Attempting to map countryDTO: '{}' from '{}' to '{}'.", source.getCountryDTO(), source, target);
        final CountryDTO countryDTO = source.getCountryDTO();
        final Country country = countryDTOMapper.mapToCountry(countryDTO);
        target.setCountry(country);
        log.atDebug().log("Successfully mapped countryDTO: '{}' from '{}' to country: '{}' in '{}'.", countryDTO, source, country, target);
    }
}
