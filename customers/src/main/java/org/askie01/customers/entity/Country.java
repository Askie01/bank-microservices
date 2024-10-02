package org.askie01.customers.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents a {@link Country} entity in the system, inheriting from {@link NamedEntity},
 * which provides a {@code name} field and auditing properties.
 * <p>
 * This entity maps to the {@code countries} table in the database, and it extends the
 * {@link NamedEntity} class to include additional auditing fields and functionality from its superclass.
 * </p>
 *
 * @see NamedEntity
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "countries")
public class Country extends NamedEntity {

}
