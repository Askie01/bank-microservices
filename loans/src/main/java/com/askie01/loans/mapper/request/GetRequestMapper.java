package com.askie01.loans.mapper.request;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.entity.LoanType;
import com.askie01.loans.mapper.Mapper;
import com.askie01.loans.request.get.GetRequest;
import com.askie01.loans.service.LoanTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GetRequestMapper implements Mapper<GetRequest, Loan> {

    private final LoanTypeService loanTypeService;
    private final RequestMapper requestMapper;

    @Override
    public Loan map(GetRequest source, Loan target) {
        final Loan updatedTarget = requestMapper.map(source, target);
        mapLoanType(source, updatedTarget);
        return updatedTarget;
    }

    private void mapLoanType(GetRequest source, Loan target) {
        final String loanTypeName = source.getLoanTypeName();
        final LoanType loanType = loanTypeService.getLoanType(loanTypeName);
        target.setLoanType(loanType);
    }
}
