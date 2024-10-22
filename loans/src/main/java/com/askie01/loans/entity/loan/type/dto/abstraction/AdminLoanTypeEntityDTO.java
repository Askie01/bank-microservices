package com.askie01.loans.entity.loan.type.dto.abstraction;

import com.askie01.loans.entity.dto.abstraction.AuditableNamedEntityDTO;

public interface AdminLoanTypeEntityDTO<ID, Name, Time, User>
        extends AuditableNamedEntityDTO<ID, Name, Time, User>, LoanTypeEntityDTO<Name> {
}
