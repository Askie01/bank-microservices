package com.askie01.loans.entity.abstraction;

import com.askie01.loans.common.Nameable;

public interface NamedEntity<ID, Name>
        extends BaseEntity<ID>, Nameable<Name> {
}
