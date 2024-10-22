package com.askie01.loans.entity.loan.type.dto.abstraction;

import com.askie01.loans.entity.dto.abstraction.NamedEntityDTO;

public interface SupportLoanTypeEntityDTO<ID, Name>
        extends NamedEntityDTO<ID, Name>, LoanTypeEntityDTO<Name> {
}
