package org.askie01.customers.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * Abstract superclass for auditable entities.
 * <p>
 * This class automatically tracks and stores auditing information, such as
 * who created or last modified the entity, and when those action occurred.
 * Is uses Spring Data JPA's auditing features to populate the audit fields.
 * </p>
 * <p>
 * Inheriting entities will have these fields automatically managed by the framework.
 * The {@link AuditingEntityListener} listens for lifecycle events to populate the fields.
 * </p>
 *
 * @see BaseEntity
 * @see AuditingEntityListener
 */
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class AuditableEntity extends BaseEntity {

    /**
     * The date and time when the entity was created.
     * <p>
     * This field is automatically set by the persistence layer and cannot be updated.
     * </p>
     */
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    /**
     * The user or system identifier who created the entity.
     * <p>
     * This field is automatically set by the persistence layer and cannot be updated.
     * </p>
     */
    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    /**
     * The date and time when the entity was last modified.
     * <p>
     * This field is automatically set by the persistence layer and cannot be manually inserted.
     * </p>
     */
    @LastModifiedDate
    @Column(insertable = false)
    private LocalDateTime updatedAt;

    /**
     * Thw user os system identifier who last modified the entity.
     * <p>
     * This field is automatically set by the persistence layer and cannot be manually inserted.
     * </p>
     */
    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
