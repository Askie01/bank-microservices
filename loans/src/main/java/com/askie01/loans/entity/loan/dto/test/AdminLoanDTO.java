package com.askie01.loans.entity.loan.dto.test;

import com.askie01.loans.entity.loan.dto.abstraction.AdminLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.test.AdminLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoanDTO
        implements AdminLoanEntityDTO<String, String, AdminLoanTypeDTO, BigDecimal, LocalDate, String> {
    private String id;
    private String loanNumber;
    private AdminLoanTypeDTO loanTypeDTO;
    private BigDecimal moneyLoaned;
    private BigDecimal moneyPaid;
    private BigDecimal moneyRemaining;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;
}
