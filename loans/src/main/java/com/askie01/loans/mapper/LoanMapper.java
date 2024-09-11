package com.askie01.loans.mapper;

import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.entity.Loan;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanMapper {

    public static LoanDTO map(Loan source, LoanDTO target) {
        mapLoanNumber(source, target);
        mapLoanType(source, target);
        mapMobileNumber(source, target);
        mapTotalLoan(source, target);
        mapAmountPaid(source, target);
        mapOutstandingAmount(source, target);
        return target;
    }

    private static void mapLoanNumber(Loan source, LoanDTO target) {
        final String loanNumber = source.getLoanNumber();
        target.setLoanNumber(loanNumber);
    }

    private static void mapLoanType(Loan source, LoanDTO target) {
        final String loanType = source.getLoanType();
        target.setLoanType(loanType);
    }

    private static void mapMobileNumber(Loan source, LoanDTO target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapTotalLoan(Loan source, LoanDTO target) {
        final int totalLoan = source.getTotalLoan();
        target.setTotalLoan(totalLoan);
    }

    private static void mapAmountPaid(Loan source, LoanDTO target) {
        final int amountPaid = source.getAmountPaid();
        target.setAmountPaid(amountPaid);
    }

    private static void mapOutstandingAmount(Loan source, LoanDTO target) {
        final int outstandingAmount = source.getOutstandingAmount();
        target.setOutstandingAmount(outstandingAmount);
    }

    public static Loan map(LoanDTO source, Loan target) {
        mapLoanNumber(source, target);
        mapLoanType(source, target);
        mapMobileNumber(source, target);
        mapTotalLoan(source, target);
        mapAmountPaid(source, target);
        mapOutstandingAmount(source, target);
        return target;
    }

    private static void mapLoanNumber(LoanDTO source, Loan target) {
        final String loanNumber = source.getLoanNumber();
        target.setLoanNumber(loanNumber);
    }

    private static void mapLoanType(LoanDTO source, Loan target) {
        final String loanType = source.getLoanType();
        target.setLoanType(loanType);
    }

    private static void mapMobileNumber(LoanDTO source, Loan target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapTotalLoan(LoanDTO source, Loan target) {
        final int totalLoan = source.getTotalLoan();
        target.setTotalLoan(totalLoan);
    }

    private static void mapAmountPaid(LoanDTO source, Loan target) {
        final int amountPaid = source.getAmountPaid();
        target.setAmountPaid(amountPaid);
    }

    private static void mapOutstandingAmount(LoanDTO source, Loan target) {
        final int outstandingAmount = source.getOutstandingAmount();
        target.setOutstandingAmount(outstandingAmount);
    }
}
