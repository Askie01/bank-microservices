package com.askie01.loans.entity.abstraction.production;

import com.askie01.loans.entity.abstraction.common.BaseEntity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
public abstract class AbstractBaseEntity implements BaseEntity<String> {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
