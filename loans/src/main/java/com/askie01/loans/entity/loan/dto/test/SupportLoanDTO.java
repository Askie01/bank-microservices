package com.askie01.loans.entity.loan.dto.test;

import com.askie01.loans.entity.loan.dto.abstraction.SupportLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.test.SupportLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportLoanDTO
        implements SupportLoanEntityDTO<String, String, SupportLoanTypeDTO, BigDecimal> {
    private String id;
    private String loanNumber;
    private SupportLoanTypeDTO loanTypeDTO;
    private BigDecimal moneyLoaned;
    private BigDecimal moneyPaid;
    private BigDecimal moneyRemaining;
}
