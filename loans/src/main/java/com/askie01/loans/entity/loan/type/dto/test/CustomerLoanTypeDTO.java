package com.askie01.loans.entity.loan.type.dto.test;

import com.askie01.loans.entity.loan.type.dto.abstraction.CustomerLoanTypeEntityDTO;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerLoanTypeDTO implements CustomerLoanTypeEntityDTO<String> {
    private String name;
}
