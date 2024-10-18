package com.askie01.loans.entity.loan.dto.base;

import com.askie01.loans.entity.loan.type.dto.base.DefaultLoanTypeDTO;
import com.askie01.loans.entity.loan.dto.abstraction.LoanDTO;
import com.askie01.loans.validation.ValidId;
import com.askie01.loans.validation.ValidLoanNumber;
import com.askie01.loans.validation.ValidMoney;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultLoanDTO implements LoanDTO<Long> {

    @ValidId
    private Long id;

    @ValidLoanNumber
    private Integer loanNumber;

    private DefaultLoanTypeDTO defaultLoanTypeDTO;

    @ValidMoney
    private BigDecimal moneyLoaned;

    @ValidMoney
    private BigDecimal moneyPaid;

    @ValidMoney
    private BigDecimal moneyRemaining;
}
