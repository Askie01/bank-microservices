package com.askie01.loans.entity.loan.type.abstraction;

import com.askie01.loans.entity.abstraction.AuditableNamedEntity;

public interface LoanType<ID, Name, Time, Message>
        extends AuditableNamedEntity<ID, Name, Time, Message> {
}
