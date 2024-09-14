package com.askie01.loans.service;

import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.entity.Loan;
import com.askie01.loans.exception.LoanAlreadyExistsException;
import com.askie01.loans.exception.ResourceNotFoundException;
import com.askie01.loans.mapper.LoanMapper;
import com.askie01.loans.repository.LoanRepository;
import com.askie01.loans.request.create.CreateLoanRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Data
@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public void createLoan(CreateLoanRequest request) {
        final Integer mobileNumber = request.getMobileNumber();
        final Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        final boolean loanExists = optionalLoan.isPresent();
        if (loanExists) {
            throw new LoanAlreadyExistsException("Loan with mobileNumber: '" + mobileNumber + "' already exists.");
        }
        final Loan loan = createNewLoan(request);
        loanRepository.save(loan);
    }

    private Loan createNewLoan(CreateLoanRequest request) {
        final Loan loan = LoanCreationRequestMapper.mapToLoan(request);
        final Long randomLoanNumber = 1000_0000_0000_0000L + new Random().nextLong(9000_0000_0000_0000L);
        loan.setNumber(randomLoanNumber);
        loan.setMoneyPaid(0);
        final Integer moneyLoaned = loan.getMoneyLoaned();
        loan.setMoneyRemaining(moneyLoaned);
        return loan;
    }

    public LoanDTO getLoanDTO(Integer mobileNumber) {
        final Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        final boolean loanExists = optionalLoan.isPresent();
        if (!loanExists) {
            throw new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber);
        }
        final Loan loan = optionalLoan.get();
        return LoanMapper.mapToLoanDTO(loan);
    }

    public void updateLoan(LoanUpdateRequest request) {
        final Long loanNumber = request.getNumber();
        final Optional<Loan> optionalLoan = loanRepository.findByNumber(loanNumber);
        final boolean loanExists = optionalLoan.isPresent();
        if (!loanExists) {
            throw new ResourceNotFoundException("Loan", "number", loanNumber);
        }
        final Loan loan = optionalLoan.get();
        LoanUpdateRequestMapper.map(request, loan);
        loanRepository.save(loan);
    }

    public void deleteLoan(Integer mobileNumber) {
        final Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        final boolean loanExists = optionalLoan.isPresent();
        if (!loanExists) {
            throw new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber);
        }
        final Loan loan = optionalLoan.get();
        final Long id = loan.getId();
        loanRepository.deleteById(id);
    }
}
