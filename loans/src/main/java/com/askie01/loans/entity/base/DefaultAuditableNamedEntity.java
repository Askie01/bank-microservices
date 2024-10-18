package com.askie01.loans.entity.base;

import com.askie01.loans.entity.abstraction.AuditableNamedEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class DefaultAuditableNamedEntity extends DefaultAuditableBaseEntity implements AuditableNamedEntity<Long, String, LocalDateTime, String> {
    private String name;
}
