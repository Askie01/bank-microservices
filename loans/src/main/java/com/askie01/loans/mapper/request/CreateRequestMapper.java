package com.askie01.loans.mapper.request;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.entity.LoanType;
import com.askie01.loans.mapper.Mapper;
import com.askie01.loans.request.create.CreateRequest;
import com.askie01.loans.service.LoanTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class CreateRequestMapper implements Mapper<CreateRequest, Loan> {

    private final LoanTypeService loanTypeService;
    private final RequestMapper requestMapper;

    public Loan mapToLoan(CreateRequest request) {
        return map(request, new Loan());
    }

    @Override
    public Loan map(CreateRequest source, Loan target) {
        final Loan updatedTarget = requestMapper.map(source, target);
        mapLoanType(source, updatedTarget);
        mapMoneyLoaned(source, updatedTarget);
        return updatedTarget;
    }

    private void mapLoanType(CreateRequest source, Loan target) {
        final String loanTypeName = source.getLoanTypeName();
        final LoanType loanType = loanTypeService.getLoanType(loanTypeName);
        target.setLoanType(loanType);
    }

    private void mapMoneyLoaned(CreateRequest source, Loan target) {
        final BigDecimal moneyLoaned = source.getMoneyLoaned();
        target.setMoneyLoaned(moneyLoaned);
    }
}
