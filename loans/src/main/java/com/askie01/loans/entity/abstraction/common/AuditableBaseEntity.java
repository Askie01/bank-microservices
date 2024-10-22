package com.askie01.loans.entity.abstraction.common;

import com.askie01.loans.common.Auditable;

public interface AuditableBaseEntity<ID, Time, User>
        extends BaseEntity<ID>, Auditable<Time, User> {
}
