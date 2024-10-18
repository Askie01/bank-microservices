package com.askie01.loans.entity.loan.abstraction;

import com.askie01.loans.entity.abstraction.AuditableBaseEntity;

public interface Loan<ID, Time, Message>
        extends AuditableBaseEntity<ID, Time, Message> {
}
