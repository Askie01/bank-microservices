package com.askie01.loans.entity.loan.dto.abstraction;

import com.askie01.loans.entity.loan.type.dto.abstraction.LoanTypeEntityDTO;

public interface LoanEntityDTO<LoanNumber,
        LoanTypeDTO extends LoanTypeEntityDTO<?>, Money> {
    LoanNumber getLoanNumber();

    void setLoanNumber(LoanNumber loanNumber);

    LoanTypeDTO getLoanTypeDTO();

    void setLoanTypeDTO(LoanTypeDTO loanTypeDTO);

    Money getMoneyLoaned();

    void setMoneyLoaned(Money moneyLoaned);

    Money getMoneyPaid();

    void setMoneyPaid(Money moneyPaid);

    Money getMoneyRemaining();

    void setMoneyRemaining(Money moneyRemaining);
}
