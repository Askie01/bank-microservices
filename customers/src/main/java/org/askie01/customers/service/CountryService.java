package org.askie01.customers.service;

import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.entity.Country;
import org.springframework.stereotype.Service;

/**
 * {@link Service} interface for managing {@link Country} entities.
 * <p>
 * This interface defines the operations to {@code create}, {@code get}, {@code update}, and {@code delete}
 * {@link Country} entities.
 * </p>
 * <p>
 * Implementation of this interface handles business logic for interacting with {@link CountryDTO} objects.
 * </p>
 */
public interface CountryService {

    /**
     * Creates a new {@link Country} object from provided {@link CountryDTO} object.
     *
     * @param countryDTO the {@link CountryDTO} object containing creation data.
     */
    void createCountry(CountryDTO countryDTO);

    /**
     * Retrieves {@link CountryDTO} object based on the provided {@code id}.
     *
     * @param id the ID of {@link Country} to be retrieved.
     * @return {@link CountryDTO} representing {@link Country} with the specified {@code id}.
     */
    CountryDTO getCountryDTO(Long id);

    /**
     * Updates an existing {@link Country} entity with provided {@link CountryDTO} object data.
     *
     * @param countryDTO the {@link CountryDTO} object with update details.
     */
    void updateCountry(CountryDTO countryDTO);

    /**
     * Deletes {@link Country} with the specified {@code id}.
     *
     * @param id the ID of {@link Country} to be deleted.
     */
    void deleteCountry(Long id);
}
