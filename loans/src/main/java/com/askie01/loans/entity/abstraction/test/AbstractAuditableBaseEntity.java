package com.askie01.loans.entity.abstraction.test;

import com.askie01.loans.entity.abstraction.common.AuditableBaseEntity;
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

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class AbstractAuditableBaseEntity extends AbstractBaseEntity
        implements AuditableBaseEntity<String, LocalDate, String> {

    @CreatedDate
    @Column(updatable = false)
    private LocalDate createdAt;

    @CreatedBy
    @Column(updatable = false)
    private String createdBy;

    @LastModifiedDate
    @Column(insertable = false)
    private LocalDate updatedAt;

    @LastModifiedBy
    @Column(insertable = false)
    private String updatedBy;
}
