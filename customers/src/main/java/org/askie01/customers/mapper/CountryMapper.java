package org.askie01.customers.mapper;

import lombok.extern.slf4j.Slf4j;
import org.askie01.customers.copier.ObjectCopier;
import org.askie01.customers.dto.CountryDTO;
import org.askie01.customers.entity.Country;
import org.springframework.stereotype.Component;

/**
 * {@link Mapper} implementation that handles mapping between {@link Country} and {@link CountryDTO}.
 * <p>
 * This class provides methods to map all fields from {@link Country} object to {@link CountryDTO} object.
 * No vice versa (for reversed mapping check {@link CountryDTOMapper}).
 * </p>
 * <p>
 * This class makes use of {@link ObjectCopier} to create a {@code target} copy before mapping - which
 * results in {@code map} method returning updated version of {@code target} object.
 * </p>
 */
@Slf4j
@Component
public class CountryMapper implements Mapper<Country, CountryDTO> {

    /**
     * Maps {@link Country} object to newly created {@link CountryDTO} object.
     *
     * @param country the {@link Country} object containing details to be mapped.
     * @return newly created {@link CountryDTO} object containing mapped data.
     */
    public CountryDTO mapToCountryDTO(Country country) {
        log.atDebug().log("Attempting to map '{}' to a new CountryDTO.", country);
        return map(country, new CountryDTO());
    }

    /**
     * Maps data from {@link Country} object to {@link CountryDTO} object.
     *
     * @param source the {@link Country} object containing fields to be mapped.
     * @param target the {@link CountryDTO} object, to which data will be mapped.
     * @return the updated {@code target} object of type {@link CountryDTO}.
     */
    @Override
    public CountryDTO map(Country source, CountryDTO target) {
        log.atDebug().log("Attempting to map '{}' to '{}'.", source, target);
        final CountryDTO targetCopy = ObjectCopier.copy(target);
        mapId(source, targetCopy);
        mapName(source, targetCopy);
        log.atInfo().log("Successfully mapped '{}' to '{}'.", source, targetCopy);
        return targetCopy;
    }

    /**
     * Maps {@code id} field from {@link Country} object to {@link CountryDTO} object.
     *
     * @param source the {@link Country} object containing {@code id} to be mapped.
     * @param target the {@link CountryDTO} object to which {@code id} will be mapped.
     */
    private void mapId(Country source, CountryDTO target) {
        log.atDebug().log("Attempting to map id: '{}' from '{}' to '{}'.", source.getId(), source, target);
        final Long id = source.getId();
        target.setId(id);
        log.atDebug().log("Successfully mapped id: '{}' from '{}' to '{}'.", id, source, target);
    }

    /**
     * Maps {@code name} field from {@link Country} object to {@link CountryDTO} object.
     *
     * @param source the {@link Country} object containing {@code name} field to be mapped.
     * @param target the {@link CountryDTO} object to which {@code name} field will be mapped.
     */
    private void mapName(Country source, CountryDTO target) {
        log.atDebug().log("Attempting to map name: '{}' from '{}' to '{}'.", source.getName(), source, target);
        final String name = source.getName();
        target.setName(name);
        log.atDebug().log("Successfully mapped name: '{}' from '{}' to '{}'.", name, source, target);
    }
}
