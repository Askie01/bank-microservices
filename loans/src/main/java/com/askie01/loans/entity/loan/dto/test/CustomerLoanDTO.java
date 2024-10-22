package com.askie01.loans.entity.loan.dto.test;

import com.askie01.loans.entity.loan.dto.abstraction.CustomerLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.test.CustomerLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

//  Add validation for this DTO class - to not allow user modify money loaned, paid or remaining.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoanDTO
        implements CustomerLoanEntityDTO<String, CustomerLoanTypeDTO, BigDecimal> {
    private String loanNumber;
    private CustomerLoanTypeDTO loanTypeDTO;
    private BigDecimal additionalPayment;
    private BigDecimal moneyLoaned; //  Total money loaned - not modifiable for user.
    private BigDecimal moneyPaid;   //  Total money paid by user - not modifiable for user.
    private BigDecimal moneyRemaining;  //  Total money remaining - not modifiable for user.
}
