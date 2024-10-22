package com.askie01.loans.entity.loan.dto.abstraction;

import com.askie01.loans.entity.loan.type.dto.abstraction.CustomerLoanTypeEntityDTO;

public interface CustomerLoanEntityDTO<LoanNumber,
        LoanTypeDTO extends CustomerLoanTypeEntityDTO<?>, Money>
        extends LoanEntityDTO<LoanNumber, LoanTypeDTO, Money> {

    Money getAdditionalPayment();

    void setAdditionalPayment(Money additionalPayment);
}
