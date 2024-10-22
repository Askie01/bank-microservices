package com.askie01.loans.entity.loan.dto.development;

import com.askie01.loans.entity.loan.dto.abstraction.CustomerLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.development.CustomerLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//  Add validation for this DTO class - to not allow user modify money loaned, paid or remaining.
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoanDTO
        implements CustomerLoanEntityDTO<Integer, CustomerLoanTypeDTO, Double> {
    private Integer loanNumber;
    private CustomerLoanTypeDTO loanTypeDTO;
    private Double additionalPayment;
    private Double moneyLoaned; //  Total money loaned - not modifiable for user.
    private Double moneyPaid;   //  Total money paid by user - not modifiable for user.
    private Double moneyRemaining;  //  Total money remaining - not modifiable for user.
}
