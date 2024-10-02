package org.askie01.customers.dto;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

/**
 * Data Transfer Object (DTO) for managing customer related contact information.
 * <p>
 * This class is used to bind properties from an external configuration file
 * </p>
 * <p>
 * (e.g. {@code application.properties}) with the prefix {@code customers}.
 * </p>
 */
@Data
@ConfigurationProperties(prefix = "customers")
public class CustomerContactInformationDTO {

    /**
     * A {@code message} to be displayed or used in contact information
     */
    private String message;

    /**
     * A {@link Map} of contact details, where the key represents the type of contact (e.g. name, email),
     * and the value is the corresponding contact information.
     */
    private Map<String, String> contactDetails;

    /**
     * A {@link List} of IDs for support personnel who are currently on call for account-related issues.
     */
    private List<Integer> onCallSupport;
}
