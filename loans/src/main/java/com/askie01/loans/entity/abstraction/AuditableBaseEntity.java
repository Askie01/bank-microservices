package com.askie01.loans.entity.abstraction;

import com.askie01.loans.common.Auditable;

public interface AuditableBaseEntity<ID, Time, Message>
        extends BaseEntity<ID>, Auditable<Time, Message> {
}
