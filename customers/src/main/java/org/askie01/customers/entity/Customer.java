package org.askie01.customers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

/**
 * Represents a {@link Customer} entity in the system, storing personal details
 * such as {@code firstName}, {@code lastName}, {@code birthdate}, {@code email}, and {@code mobileNumber}.
 * <p>
 * This class extends {@link AuditableEntity}, meaning it also inherits audit-related fields such as
 * created and modified timestamps.
 * </p>
 * <p>
 * The entity is mapped to the {@code customers} table in the database, and contains a
 * {@link OneToOne} relationship with the {@link Country} entity.
 * </p>
 * <p>
 * Relationships:
 *     <ul>
 *          <li>{@code country}: a {@link OneToOne} relationship to represent the customer's country of origin.</li>
 *     </ul>
 * </p>
 *
 * @see Country
 * @see AuditableEntity
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
public class Customer extends AuditableEntity {

    /**
     * The first name of customer.
     */
    private String firstName;

    /**
     * The last name of customer.
     */
    private String lastName;

    /**
     * The birthdate of customer, represented as {@link LocalDate}.
     */
    private LocalDate birthdate;

    /**
     * The email address of customer.
     */
    private String email;

    /**
     * The mobile number of customer.
     */
    private String mobileNumber;

    /**
     * The country associated with customer.
     * <p>
     * This is a {@link OneToOne} relationship with {@link Country} entity.
     * </p>
     */
    @OneToOne
    private Country country;
}
