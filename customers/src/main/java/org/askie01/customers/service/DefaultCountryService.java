package org.askie01.customers.service;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.entity.Country;
import org.askie01.customers.exception.CountryNameAlreadyExistsException;
import org.askie01.customers.exception.ResourceNotFoundException;
import org.askie01.customers.mapper.CountryDTOMapper;
import org.askie01.customers.mapper.CountryMapper;
import org.askie01.customers.repository.CountryRepository;
import org.springframework.stereotype.Service;

/**
 * Default implementation of {@link CountryService} interface.
 * <p>
 * This service handles business logic to {@code create}, {@code get}, {@code update}, and {@code delete} {@link Country} entities.
 * </p>
 * <p>
 * It relies on {@link CountryRepository} for database interactions and {@link CountryDTOMapper} along with {@link CountryMapper} for object mappings.
 * </p>
 *
 * @see CountryNameAlreadyExistsException
 */
@Data
@Slf4j
@Service
public class DefaultCountryService implements CountryService {

    private final CountryRepository countryRepository;
    private final CountryDTOMapper countryDTOMapper;
    private final CountryMapper countryMapper;

    /**
     * Creates a new {@link Country} from the provided {@link CountryDTO}.
     * <p>
     * Ensures that the {@link Country#name} is unique before saving.
     * </p>
     *
     * @param countryDTO the {@link CountryDTO} object containing data for new {@link Country}.
     * @throws CountryNameAlreadyExistsException if a {@link Country} with the same {@code name} already exists.
     */
    @Override
    public void createCountry(CountryDTO countryDTO) {
        log.atDebug().log("Attempting to create a new Country from '{}'.", countryDTO);
        checkUniqueness(countryDTO);
        final Country country = countryDTOMapper.mapToCountry(countryDTO);
        countryRepository.save(country);
        log.atInfo().log("Successfully saved: '{}'.", country);
    }

    /**
     * Retrieves {@link CountryDTO} based on the provided {@code id}.
     *
     * @param id the ID of {@link Country} to retrieve.
     * @return the {@link CountryDTO} representing retrieved {@link Country}.
     * @throws ResourceNotFoundException if no {@link Country} is found with the provided {@code id}.
     */
    @Override
    public CountryDTO getCountryDTO(Long id) {
        log.atDebug().log("Attempting to retrieve CountryDTO with ID: '{}'.", id);
        final Country country = getCountry(id);
        final CountryDTO countryDTO = countryMapper.mapToCountryDTO(country);
        log.atInfo().log("Successfully retrieved: '{}'.", countryDTO);
        return countryDTO;
    }

    /**
     * Helper method to retrieve {@link Country} by its {@code id}.
     *
     * @param id the ID of {@link Country} to retrieve.
     * @return the retrieved {@link Country}.
     * @throws ResourceNotFoundException if {@link Country} is not found.
     */
    private Country getCountry(Long id) {
        return countryRepository.findById(id).orElseThrow(() -> {
            log.atError().log("Error occurred when retrieving Country with ID: '{}'.", id);
            return new ResourceNotFoundException("Country", "id", id);
        });
    }

    /**
     * Updates an existing {@link Country} with data from provided {@link CountryDTO} object.
     * <p>
     * Ensures that the {@link Country#name} is unique before updating.
     * </p>
     *
     * @param countryDTO the {@link CountryDTO} object containing update details for {@link Country}.
     * @throws CountryNameAlreadyExistsException if {@link Country} with the same {@code name} already exists.
     */
    @Override
    public void updateCountry(CountryDTO countryDTO) {
        log.atDebug().log("Attempting to update Country with ID: '{}'.", countryDTO.getId());
        checkUniqueness(countryDTO);
        final Long id = countryDTO.getId();
        final Country country = getCountry(id);
        final Country updatedCountry = countryDTOMapper.map(countryDTO, country);
        countryRepository.save(updatedCountry);
        log.atInfo().log("Successfully updated '{}' to '{}'.", country, updatedCountry);
    }

    /**
     * Deletes {@link Country} with the specified {@code id}.
     *
     * @param id the ID of {@link Country} to delete.
     * @throws ResourceNotFoundException if no {@link Country} is found with the provided {@code id}.
     */
    @Override
    public void deleteCountry(Long id) {
        log.atDebug().log("Attempting to delete Country with ID: '{}'.", id);
        final Country country = getCountry(id);
        countryRepository.delete(country);
        log.atInfo().log("Successfully deleted Country with ID: '{}'.", id);
    }

    /**
     * Checks the uniqueness of {@link Country#name} provided in {@link CountryDTO}.
     *
     * @param countryDTO the {@link CountryDTO} object to check uniqueness for.
     * @throws CountryNameAlreadyExistsException if a {@link Country} with the same {@code name} already exists.
     */
    private void checkUniqueness(CountryDTO countryDTO) {
        log.atDebug().log("Attempting to check uniqueness for: '{}'.", countryDTO);
        final String name = countryDTO.getName();
        final boolean uniqueName = countryRepository.findByName(name).isEmpty();

        if (!uniqueName) {
            log.atError().log("Error occurred when checking name uniqueness for: '{}'.", countryDTO);
            throw new CountryNameAlreadyExistsException(name);
        }
        log.atInfo().log("Successfully checked uniqueness for: '{}'.", countryDTO);
    }
}
