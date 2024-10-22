package com.askie01.loans.entity.loan.dto.development;

import com.askie01.loans.entity.loan.dto.abstraction.AdminLoanEntityDTO;
import com.askie01.loans.entity.loan.type.dto.development.AdminLoanTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoanDTO
        implements AdminLoanEntityDTO<Long, Integer, AdminLoanTypeDTO, Double, LocalDateTime, String> {
    private Long id;
    private Integer loanNumber;
    private AdminLoanTypeDTO loanTypeDTO;
    private Double moneyLoaned;
    private Double moneyPaid;
    private Double moneyRemaining;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
