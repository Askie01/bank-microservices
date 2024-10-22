package com.askie01.loans.entity.dto.abstraction;

public interface AuditableNamedEntityDTO<ID, Name, Time, User>
        extends AuditableBaseEntityDTO<ID, Time, User>, NamedEntityDTO<ID, Name> {
}
