package com.askie01.loans.service;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.exception.LoanAlreadyExistsException;
import com.askie01.loans.exception.ResourceNotFoundException;
import com.askie01.loans.mapper.request.CreateRequestMapper;
import com.askie01.loans.mapper.request.DeleteRequestMapper;
import com.askie01.loans.mapper.request.GetRequestMapper;
import com.askie01.loans.mapper.request.UpdateRequestMapper;
import com.askie01.loans.repository.LoanRepository;
import com.askie01.loans.request.create.CreateRequest;
import com.askie01.loans.request.delete.DeleteRequest;
import com.askie01.loans.request.get.GetRequest;
import com.askie01.loans.request.update.UpdateRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultLoanService implements LoanService {

    private final LoanRepository loanRepository;
    private final CreateRequestMapper createRequestMapper;
    private final UpdateRequestMapper updateRequestMapper;
    private final GetRequestMapper getRequestMapper;
    private final DeleteRequestMapper deleteRequestMapper;

    public void createLoan(CreateRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final boolean loanExists = loanRepository
                .findByMobileNumber(mobileNumber)
                .isPresent();
        if (loanExists) {
            throw new LoanAlreadyExistsException("Loan with mobileNumber: '" + mobileNumber + "' already exists.");
        }
        final Loan loan = createRequestMapper.mapToLoan(request);
        loanRepository.save(loan);
    }

    @Override
    public Loan getLoan(GetRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final Loan loan = loanRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        final Loan updatedLoan = getRequestMapper.map(request, loan);

        if (updatedLoan.equals(loan)) {
            return loan;
        } else {
            throw new ResourceNotFoundException("Loan", "getRequest", request.toString());
        }
    }

    @Override
    public void updateLoan(UpdateRequest request) {
        final Integer loanNumber = request.getLoanNumber();
        final Loan loan = loanRepository
                .findByLoanNumber(loanNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "loanNumber", loanNumber));
        final Loan updatedLoan = updateRequestMapper.map(request, loan);

        final boolean sameLoanNumber = updatedLoan
                .getLoanNumber()
                .equals(loan.getLoanNumber());
        final boolean sameMobileNumber = updatedLoan
                .getMobileNumber()
                .equals(loan.getMobileNumber());

        if (sameLoanNumber && sameMobileNumber) {
            loanRepository.save(updatedLoan);
        } else {
            throw new ResourceNotFoundException("Loan", "updateRequest", request.toString());
        }
    }

    @Override
    public void deleteLoan(DeleteRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final Loan loan = loanRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber));
        final Loan updatedLoan = deleteRequestMapper.map(request, loan);

        if (loan.equals(updatedLoan)) {
            loanRepository.delete(updatedLoan);
        } else {
            throw new ResourceNotFoundException("Loan", "deleteRequest", request.toString());
        }
    }
}
