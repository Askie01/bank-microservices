package com.askie01.loans.entity.dto.abstraction;

import com.askie01.loans.common.Auditable;

public interface AuditableBaseEntityDTO<ID, Time, User>
        extends BaseEntityDTO<ID>, Auditable<Time, User> {
}
