package org.askie01.customers.mapper;

import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.copier.ObjectCopier;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.entity.Country;
import org.springframework.stereotype.Component;

/**
 * {@link Mapper} implementation that handles mapping between {@link CountryDTO} and {@link Country}.
 * <p>
 * This class provides methods to map fields from {@link CountryDTO} to a new or existing {@link Country} object
 * No vice versa (for reversed mapping check {@link CountryMapper}).
 * </p>
 * <p>
 * This class makes use of {@link ObjectCopier} to create a {@code target} copy before mapping - which
 * results in {@code map} method returning updated version of {@code target} object.
 * </p>
 */
@Slf4j
@Component
public class CountryDTOMapper implements Mapper<CountryDTO, Country> {

    /**
     * Maps provided {@link CountryDTO} to a new {@link Country} object.
     *
     * @param countryDTO the {@link CountryDTO} to be mapped.
     * @return newly created {@link Country} object with values from {@link CountryDTO}.
     */
    public Country mapToCountry(CountryDTO countryDTO) {
        log.atDebug().log("Attempting to map '{}' to new Country", countryDTO);
        return map(countryDTO, new Country());
    }

    /**
     * Maps provided {@link CountryDTO} to an existing {@link Country} object.
     *
     * @param source the {@link CountryDTO} that contains the source data.
     * @param target the {@link Country} object to which data will be mapped.
     * @return the updated {@link Country} object after mapping fields from {@link CountryDTO}.
     */
    @Override
    public Country map(CountryDTO source, Country target) {
        log.atDebug().log("Attempting to map '{}' to '{}'.", source, target);
        final Country targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapName(source, targetCopy);
        log.atInfo().log("Successfully mapped '{}' to '{}'.", source, targetCopy);
        return targetCopy;
    }

    /**
     * Maps {@code id} field from {@link CountryDTO} to {@link Country} object.
     *
     * @param source the {@link CountryDTO} object containing {@code id} to be mapped.
     * @param target the {@link Country} object, to which {@code id} will be mapped.
     */
    private void mapId(CountryDTO source, Country target) {
        log.atDebug().log("Attempting to map id: '{}' from '{}' to '{}'", source.getId(), source, target);
        final Long id = source.getId();
        target.setId(id);
        log.atDebug().log("Successfully mapped id: '{}' from '{}' to '{}'.", source.getId(), source, target);
    }

    /**
     * Maps {@code name} field from {@link CountryDTO} to {@link Country} object.
     *
     * @param source the {@link CountryDTO} object containing {@code name} to be mapped.
     * @param target the {@link Country} object, to which {@code name} will be mapped.
     */
    private void mapName(CountryDTO source, Country target) {
        log.atDebug().log("Attempting to map name: '{}' from '{}' to '{}'.", source.getName(), source, target);
        final String name = source.getName();
        target.setName(name);
        log.atDebug().log("Successfully mapped name: '{}' from '{}' to '{}'.", source.getName(), source, target);
    }
}
