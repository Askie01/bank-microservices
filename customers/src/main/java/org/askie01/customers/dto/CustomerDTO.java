package org.askie01.customers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.askie01.customers.entity.Country;
import org.askie01.customers.entity.Customer;
import org.askie01.customers.validation.*;

import java.time.LocalDate;

/**
 * Data Transfer Object (DTO) representing a {@link Customer}.
 * This class encapsulates customer data that is transferred between layers or services.
 * <p>
 * Validation constraints are applied to ensure that the data compiles with
 * the required format and constraints before being processed.
 * </p>
 * <p>
 * Usage:
 * This DTO is used as a part of the request/response model in REST APIs and services
 * that interact with customer-related data.
 * </p>
 */
@Data
public class CustomerDTO {

    /**
     * The unique identifier for {@link Customer}.
     * <p>
     * This field is validated with {@link ValidId} custom validation.
     * </p>
     */
    @ValidId
    private Long id;

    /**
     * The first name of {@link Customer}.
     * <p>
     * This field is validated with {@link ValidFirstName} custom validation.
     * </p>
     */
    @ValidFirstName
    private String firstName;

    /**
     * The last name of {@link Customer}.
     * <p>
     * This field is validated with {@link ValidLastName} custom validation.
     * </p>
     */
    @ValidLastName
    private String lastName;

    /**
     * Birthdate of {@link Customer}.
     * <p>
     * This field is validated with {@link ValidBirthdate} custom validation.
     * </p>
     */
    @ValidBirthdate
    private LocalDate birthdate;

    /**
     * Email of {@link Customer}.
     * <p>
     * This field is validated with {@link ValidEmail} custom validation.
     * </p>
     */
    @ValidEmail
    private String email;

    /**
     * Mobile number of {@link Customer}.
     * <p>
     * This field is validated with {@link ValidMobileNumber} custom validation.
     * </p>
     */
    @ValidMobileNumber
    private String mobileNumber;

    /**
     * {@link Country} reference of {@link Customer}.
     * <p>
     * This field is validated with {@link NotNull} validation to ensure it's not null.
     * </p>
     */
    @NotNull(message = "CountryDTO cannot be null.")
    private CountryDTO countryDTO;
}
