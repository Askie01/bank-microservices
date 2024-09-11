package com.askie01.loans.service;

import com.askie01.loans.constant.LoanLimit;
import com.askie01.loans.constant.LoanType;
import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.entity.Loan;
import com.askie01.loans.exception.LoanAlreadyExistsException;
import com.askie01.loans.exception.ResourceNotFoundException;
import com.askie01.loans.mapper.LoanMapper;
import com.askie01.loans.repository.LoanRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Data
@Service
public class LoanService {

    private final LoanRepository loanRepository;

    public void createLoan(String mobileNumber) {
        final Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber: '" + mobileNumber + "'.");
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    private Loan createNewLoan(String mobileNumber) {
        final Loan loan = new Loan();
        final long randomLoanNumber = 100_000_000_000L + new Random().nextInt(900_000_000);
        loan.setLoanNumber(Long.toString(randomLoanNumber));
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType(LoanType.HOME);
        loan.setTotalLoan(LoanLimit.HOME);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(LoanLimit.HOME);
        return loan;
    }

    public LoanDTO getLoan(String mobileNumber) {
        final Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.map(loan, new LoanDTO());
    }

    public void updateLoan(LoanDTO loanDTO) {
        final Loan loan = loanRepository.findByLoanNumber(loanDTO.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loanDTO.getLoanNumber())
        );
        LoanMapper.map(loanDTO, loan);
        loanRepository.save(loan);
    }

    public void deleteLoan(String mobileNumber) {
        final Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getId());
    }
}
