package com.askie01.loans.entity.loan.type.dto.base;

import com.askie01.loans.entity.loan.type.dto.abstraction.LoanTypeDTO;
import com.askie01.loans.validation.ValidId;
import com.askie01.loans.validation.ValidLoanTypeName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefaultLoanTypeDTO implements LoanTypeDTO<Long, String> {

    @ValidId
    private Long id;

    @ValidLoanTypeName
    private String name;
}
