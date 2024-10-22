package com.askie01.loans.entity.abstraction.production;

import com.askie01.loans.entity.abstraction.common.AuditableNamedEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractAuditableNamedEntity extends AbstractAuditableBaseEntity
        implements AuditableNamedEntity<String, String, LocalDate, String> {
    private String name;
}
