package com.askie01.loans.entity.loan.dto.abstraction;

import com.askie01.loans.entity.dto.abstraction.AuditableBaseEntityDTO;
import com.askie01.loans.entity.loan.type.dto.abstraction.AdminLoanTypeEntityDTO;

public interface AdminLoanEntityDTO<ID, LoanNumber,
        LoanTypeDTO extends AdminLoanTypeEntityDTO<?, ?, ?, ?>,
        Money, Time, User>
        extends AuditableBaseEntityDTO<ID, Time, User>,
        LoanEntityDTO<LoanNumber, LoanTypeDTO, Money> {
}
