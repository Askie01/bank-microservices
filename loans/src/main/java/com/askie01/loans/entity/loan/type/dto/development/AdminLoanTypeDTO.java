package com.askie01.loans.entity.loan.type.dto.development;

import com.askie01.loans.entity.loan.type.dto.abstraction.AdminLoanTypeEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoanTypeDTO implements AdminLoanTypeEntityDTO<Long, String, LocalDateTime, String> {
    private Long id;
    private String name;
    private LocalDateTime createdAt;
    private String createdBy;
    private LocalDateTime updatedAt;
    private String updatedBy;
}
