package org.askie01.accounts.dto;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Data Transfer Object (DTO) for representing a customer.
 * <p>
 * This class encapsulates the customer details, including personal information,
 * creation, and modification metadata.
 * </p>
 */
@Data
public class CustomerDTO {

    /**
     * The unique identifier of the customer
     *
     * @return the ID of the customer.
     */
    private Long id;

    /**
     * The first name of the customer.
     *
     * @return the first name of the customer.
     */
    private String firstName;

    /**
     * The last name of the customer.
     *
     * @return the last name of the customer.
     */
    private String lastName;

    /**
     * The email address of the customer.
     *
     * @return the email address of the customer.
     */
    private String email;

    /**
     * The mobile number of the customer.
     *
     * @return the mobile number of the customer.
     */
    private String mobileNumber;

    /**
     * The timestamp indicating when the customer was created.
     *
     * @return the creation timestamp of the customer.
     */
    private LocalDateTime createdAt;

    /**
     * The identifier of the user or system that created the customer.
     *
     * @return the creator of the customer.
     */
    private String createdBy;

    /**
     * The timestamp indicating when the customer was last updated.
     *
     * @return the last update timestamp of the customer.
     */
    private LocalDateTime updatedAt;

    /**
     * The identifier of the user or system that last updated the customer.
     *
     * @return the last updater of the customer.
     */
    private String updatedBy;
}
