package org.askie01.customers.entity;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

/**
 * Represents an abstract entity that contains a name attribute, intended to be
 * extended by other entity classes that need a named property.
 * <p>
 * This class extends {@link AuditableEntity}, inheriting audit-related fields.
 * </p>
 * <p>
 * This class is annotated with {@link MappedSuperclass}, meaning it is a base class
 * whose properties will be inherited by its subclasses in the JPA entity hierarchy,
 * but it will not be mapped to a database table directly.
 * </p>
 * <p>
 * Subclasses of {@code NamedEntity} can inherit and add further properties as needed,
 * while also leveraging auditing features from the superclass.
 * </p>
 *
 * @see AuditableEntity
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class NamedEntity extends AuditableEntity {

    /**
     * The name of the entity. This field is intended to store the entity's name.
     */
    private String name;
}
