package com.askie01.loans.entity.loan.dto.development;

import com.askie01.loans.entity.loan.dto.abstraction.SupportLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.development.SupportLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportLoanDTO
        implements SupportLoanEntityDTO<Long, Integer, SupportLoanTypeDTO, Double> {
    private Long id;
    private Integer loanNumber;
    private SupportLoanTypeDTO loanTypeDTO;
    private Double moneyLoaned;
    private Double moneyPaid;
    private Double moneyRemaining;
}
