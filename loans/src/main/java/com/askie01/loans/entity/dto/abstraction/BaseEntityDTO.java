package com.askie01.loans.entity.dto.abstraction;

import com.askie01.loans.common.Identifiable;
import com.askie01.loans.dto.abstraction.DTO;

public interface BaseEntityDTO<ID>
        extends Identifiable<ID>, DTO {
}
