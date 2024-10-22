package com.askie01.loans.entity.loan.type.dto.production;

import com.askie01.loans.entity.loan.type.dto.abstraction.SupportLoanTypeEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SupportLoanTypeDTO implements SupportLoanTypeEntityDTO<String, String> {
    private String id;
    private String name;
}
