package com.askie01.loans.service;

import com.askie01.loans.constants.LoanConstants;
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
public class LoanServiceImpl implements LoanService {

    private final LoanRepository loanRepository;

    /**
     * @param mobileNumber Mobile number of the customer
     */
    @Override
    public void createLoan(String mobileNumber) {
        final Optional<Loan> optionalLoan = loanRepository.findByMobileNumber(mobileNumber);
        if (optionalLoan.isPresent()) {
            throw new LoanAlreadyExistsException("Loan already registered with given mobileNumber: '" + mobileNumber + "'.");
        }
        loanRepository.save(createNewLoan(mobileNumber));
    }

    /**
     * @param mobileNumber Mobile number of the customer
     * @return the new loan details
     */
    private Loan createNewLoan(String mobileNumber) {
        final Loan loan = new Loan();
        final long randomLoanNumber = 100_000_000_000L + new Random().nextInt(900_000_000);
        loan.setLoanNumber(Long.toString(randomLoanNumber));
        loan.setMobileNumber(mobileNumber);
        loan.setLoanType(LoanConstants.HOME_LOAN);
        loan.setTotalLoan(LoanConstants.NEW_LOAN_LIMIT);
        loan.setAmountPaid(0);
        loan.setOutstandingAmount(LoanConstants.NEW_LOAN_LIMIT);
        return loan;
    }

    /**
     * @param mobileNumber Input mobile number
     * @return Loan details based on a given mobileNumber
     */
    @Override
    public LoanDTO getLoan(String mobileNumber) {
        final Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "mobileNumber", mobileNumber)
        );
        return LoanMapper.mapToLoanDTO(loan, new LoanDTO());
    }

    /**
     * @param loanDTO LoanDTO object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateLoan(LoanDTO loanDTO) {
        final Loan loan = loanRepository.findByLoanNumber(loanDTO.getLoanNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Loan", "LoanNumber", loanDTO.getLoanNumber())
        );
        LoanMapper.mapToLoan(loanDTO, loan);
        loanRepository.save(loan);
        return true;
    }

    /**
     * @param mobileNumber Input mobile number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    @Override
    public boolean deleteLoan(String mobileNumber) {
        final Loan loan = loanRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Loans", "mobileNumber", mobileNumber)
        );
        loanRepository.deleteById(loan.getLoanId());
        return true;
    }
}
