package com.askie01.loans.entity.base;

import com.askie01.loans.entity.abstraction.NamedEntity;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@MappedSuperclass
public class DefaultNamedEntity extends DefaultBaseEntity implements NamedEntity<Long, String> {
    private String name;
}
