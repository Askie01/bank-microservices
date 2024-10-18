package com.askie01.loans.entity.dto.abstraction;

import com.askie01.loans.common.Nameable;

public interface NamedEntityDTO<ID, Name>
        extends BaseEntityDTO<ID>, Nameable<Name> {
}
