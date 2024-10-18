package com.askie01.loans.entity.abstraction;

public interface AuditableNamedEntity<ID, Name, Time, Message>
        extends AuditableBaseEntity<ID, Time, Message>, NamedEntity<ID, Name> {
}
