package com.askie01.loans.service;

import com.askie01.loans.entity.LoanType;

public interface LoanTypeService {
    void createLoanType(String name);

    LoanType getLoanType(String name);

    void updateLoanType(String oldName, String newName);

    void deleteLoanType(String name);
}
