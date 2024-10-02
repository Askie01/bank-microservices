package org.askie01.customers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.askie01.customers.entity.Country;
import org.askie01.customers.validation.ValidCountryName;
import org.askie01.customers.validation.ValidId;

/**
 * Data Transfer Object (DTO) representing {@link Country}.
 * This class encapsulates country data that is transferred between layers or services.
 * <p>
 * Validation constraints are applied to ensure that the data compile with
 * the required format and constraints before being processed.
 * </p>
 * <p>
 * Usage:
 * This DTO is used as a part of the request/response model in REST APIs and services
 * that interact with country-related data.
 * </p>
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CountryDTO {

    /**
     * The unique identifier for {@link Country}.
     * <p>
     * This field is validated with {@link ValidId} custom validation.
     * </p>
     */
    @ValidId
    private Long id;

    /**
     * The name of {@link Country}.
     * <p>
     * This field is validated with {@link ValidCountryName} custom validation.
     * </p>
     */
    @ValidCountryName
    private String name;
}
