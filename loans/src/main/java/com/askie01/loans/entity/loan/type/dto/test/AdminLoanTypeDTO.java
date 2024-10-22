package com.askie01.loans.entity.loan.type.dto.test;

import com.askie01.loans.entity.loan.type.dto.abstraction.AdminLoanTypeEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AdminLoanTypeDTO implements AdminLoanTypeEntityDTO<String, String, LocalDate, String> {
    private String id;
    private String name;
    private LocalDate createdAt;
    private String createdBy;
    private LocalDate updatedAt;
    private String updatedBy;
}
