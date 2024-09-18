package com.askie01.loans.mapper.request;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.entity.LoanType;
import com.askie01.loans.mapper.Mapper;
import com.askie01.loans.request.update.UpdateRequest;
import com.askie01.loans.service.LoanTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class UpdateRequestMapper implements Mapper<UpdateRequest, Loan> {

    private final LoanTypeService loanTypeService;
    private final RequestMapper requestMapper;

    public Loan mapToLoan(UpdateRequest request) {
        return map(request, new Loan());
    }

    public Loan map(UpdateRequest source, Loan target) {
        final Loan updatedTarget = requestMapper.map(source, target);
        mapLoanNumber(source, updatedTarget);
        mapLoanType(source, updatedTarget);
        mapMoneyLoaned(source, updatedTarget);
        mapMoneyPaid(source, updatedTarget);
        return updatedTarget;
    }

    private void mapLoanNumber(UpdateRequest source, Loan target) {
        final Integer loanNumber = source.getLoanNumber();
        target.setLoanNumber(loanNumber);
    }

    private void mapLoanType(UpdateRequest source, Loan target) {
        final String loanTypeName = source.getLoanTypeName();
        final LoanType loanType = loanTypeService.getLoanType(loanTypeName);
        target.setLoanType(loanType);
    }

    private void mapMoneyLoaned(UpdateRequest source, Loan target) {
        final BigDecimal moneyLoaned = source.getMoneyLoaned();
        target.setMoneyLoaned(moneyLoaned);
    }

    private void mapMoneyPaid(UpdateRequest source, Loan target) {
        final BigDecimal moneyPaid = source.getMoneyPaid();
        target.setMoneyPaid(moneyPaid);
    }
}
