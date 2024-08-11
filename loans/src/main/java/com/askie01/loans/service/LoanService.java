package com.askie01.loans.service;

import com.askie01.loans.dto.LoanDTO;

public interface LoanService {
    /***
     * @param mobileNumber Mobile number of the customer
     */
    void createLoan(String mobileNumber);

    /**
     * @param mobileNumber Input mobile number
     * @return Loan details based on a given mobileNumber
     */
    LoanDTO getLoan(String mobileNumber);

    /**
     * @param loanDTO LoanDTO object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateLoan(LoanDTO loanDTO);

    /**
     * @param mobileNumber Input mobile number
     * @return boolean indicating if the delete of loan details is successful or not
     */
    boolean deleteLoan(String mobileNumber);
}
