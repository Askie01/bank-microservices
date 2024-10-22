package com.askie01.loans.entity.abstraction.common;

public interface AuditableNamedEntity<ID, Name, Time, User>
        extends AuditableBaseEntity<ID, Time, User>, NamedEntity<ID, Name> {
}
