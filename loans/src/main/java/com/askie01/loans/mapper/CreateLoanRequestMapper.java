package com.askie01.loans.mapper;

import com.askie01.loans.entity.Loan;
import com.askie01.loans.request.create.CreateLoanRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CreateLoanRequestMapper {
    public static Loan mapToLoan(CreateLoanRequest request) {
        return map(request, new Loan());
    }

    public static Loan map(CreateLoanRequest source, Loan target) {
        final Loan updatedLoan = new Loan(target);
    }
}
