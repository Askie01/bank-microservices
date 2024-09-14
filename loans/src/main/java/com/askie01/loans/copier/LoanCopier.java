package com.askie01.loans.copier;

import com.askie01.loans.entity.Loan;

import java.time.LocalDateTime;

public class LoanCopier {
    public static Loan copy(Loan loan) {
        final Loan copy = new Loan();
        copyId(loan, copy);
        copyCreatedAt(loan, copy);
        copyCreatedBy(loan, copy);
        copyUpdatedAt(loan, copy);
        copyUpdatedBy(loan, copy);
        copyNumber(loan, copy);
        copyType(loan, copy);
        copyMobileNumber(loan, copy);
        copyMoneyLoaned(loan, copy);
        copyMoneyPaid(loan, copy);
        copyMoneyRemaining(loan, copy);
        return copy;
    }

    private static void copyId(Loan source, Loan target) {
        final Long id = source.getId();
        target.setId(id);
    }

    private static void copyCreatedAt(Loan source, Loan target) {
        final LocalDateTime createdAt = source.getCreatedAt();
        target.setCreatedAt(createdAt);
    }

    private static void copyCreatedBy(Loan source, Loan target) {
        final String createdBy = source.getCreatedBy();
        target.setCreatedBy(createdBy);
    }

    private static void copyUpdatedAt(Loan source, Loan target) {
        final LocalDateTime updatedAt = source.getUpdatedAt();
        target.setUpdatedAt(updatedAt);
    }

    private static void copyUpdatedBy(Loan source, Loan target) {
        final String updatedBy = source.getUpdatedBy();
        target.setUpdatedBy(updatedBy);
    }

    private static void copyNumber(Loan source, Loan target) {
        final Long number = source.getNumber();
        target.setNumber(number);
    }

    private static void copyType(Loan source, Loan target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void copyMobileNumber(Loan source, Loan target) {
        final Integer mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void copyMoneyLoaned(Loan source, Loan target) {
        final Integer moneyLoaned = source.getMoneyLoaned();
        target.setMoneyLoaned(moneyLoaned);
    }

    private static void copyMoneyPaid(Loan source, Loan target) {
        final Integer moneyPaid = source.getMoneyPaid();
        target.setMoneyPaid(moneyPaid);
    }

    private static void copyMoneyRemaining(Loan source, Loan target) {
        final Integer moneyRemaining = source.getMoneyRemaining();
        target.setMoneyRemaining(moneyRemaining);
    }
}
