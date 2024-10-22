package com.askie01.loans.entity.loan.dto.abstraction;

import com.askie01.loans.entity.dto.abstraction.BaseEntityDTO;
import com.askie01.loans.entity.loan.type.dto.abstraction.SupportLoanTypeEntityDTO;

public interface SupportLoanEntityDTO<ID, LoanNumber,
        LoanTypeDTO extends SupportLoanTypeEntityDTO<?, ?>, Money>
        extends BaseEntityDTO<ID>,
        LoanEntityDTO<LoanNumber, LoanTypeDTO, Money> {
}
