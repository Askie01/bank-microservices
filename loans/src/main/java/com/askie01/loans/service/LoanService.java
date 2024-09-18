package com.askie01.loans.service;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.request.create.CreateRequest;
import com.askie01.loans.request.delete.DeleteRequest;
import com.askie01.loans.request.get.GetRequest;
import com.askie01.loans.request.update.UpdateRequest;

public interface LoanService {
    void createLoan(CreateRequest request);

    Loan getLoan(GetRequest request);

    void updateLoan(UpdateRequest request);

    void deleteLoan(DeleteRequest request);
}
