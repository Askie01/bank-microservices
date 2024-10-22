package com.askie01.loans.entity.loan;

import com.askie01.loans.entity.abstraction.common.AuditableBaseEntity;
import com.askie01.loans.entity.loan.type.LoanTypeEntity;

public interface LoanEntity<ID, Time, User, LoanNumber,
        LoanType extends LoanTypeEntity<?, ?, ?, ?>, Money>
        extends AuditableBaseEntity<ID, Time, User> {
    LoanNumber getLoanNumber();

    void setLoanNumber(LoanNumber loanNumber);

    LoanType getLoanType();

    void setLoanType(LoanType loanTypeEntity);

    Money getMoneyLoaned();

    void setMoneyLoaned(Money moneyLoaned);

    Money getMoneyPaid();

    void setMoneyPaid(Money moneyPaid);

    Money getMoneyRemaining();

    void setMoneyRemaining(Money moneyRemaining);
}
