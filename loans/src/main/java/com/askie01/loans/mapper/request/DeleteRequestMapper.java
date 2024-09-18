package com.askie01.loans.mapper.request;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.entity.LoanType;
import com.askie01.loans.mapper.Mapper;
import com.askie01.loans.request.delete.DeleteRequest;
import com.askie01.loans.service.LoanTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DeleteRequestMapper implements Mapper<DeleteRequest, Loan> {

    private final LoanTypeService loanTypeService;
    private final RequestMapper requestMapper;

    @Override
    public Loan map(DeleteRequest source, Loan target) {
        final Loan updatedTarget = requestMapper.map(source, target);
        mapLoanNumber(source, updatedTarget);
        mapLoanType(source, updatedTarget);
        return updatedTarget;
    }

    private void mapLoanNumber(DeleteRequest source, Loan target) {
        final Integer loanNumber = source.getLoanNumber();
        target.setLoanNumber(loanNumber);
    }

    private void mapLoanType(DeleteRequest source, Loan target) {
        final String loanTypeName = source.getLoanTypeName();
        final LoanType loanType = loanTypeService.getLoanType(loanTypeName);
        target.setLoanType(loanType);
    }

}
