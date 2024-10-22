package com.askie01.loans.entity.abstraction.development;

import com.askie01.loans.entity.abstraction.common.NamedEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public abstract class AbstractNamedEntity extends AbstractBaseEntity
        implements NamedEntity<Long, String> {
    private String name;
}