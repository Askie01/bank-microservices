package com.askie01.loans.copier;

import com.askie01.loans.dto.LoanDTO;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanDTOCopier {

    public static LoanDTO copy(LoanDTO loanDTO) {
        final LoanDTO copy = new LoanDTO();
        copyNumber(loanDTO, copy);
        copyType(loanDTO, copy);
        copyMobileNumber(loanDTO, copy);
        copyMoneyLoaned(loanDTO, copy);
        copyMoneyPaid(loanDTO, copy);
        copyMoneyRemaining(loanDTO, copy);
        return copy;
    }

    private static void copyNumber(LoanDTO source, LoanDTO target) {
        final Long number = source.getNumber();
        target.setNumber(number);
    }

    private static void copyType(LoanDTO source, LoanDTO target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void copyMobileNumber(LoanDTO source, LoanDTO target) {
        final Integer mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void copyMoneyLoaned(LoanDTO source, LoanDTO target) {
        final Integer moneyLoaned = source.getMoneyLoaned();
        target.setMoneyLoaned(moneyLoaned);
    }

    private static void copyMoneyPaid(LoanDTO source, LoanDTO target) {
        final Integer moneyPaid = source.getMoneyPaid();
        target.setMoneyPaid(moneyPaid);
    }

    private static void copyMoneyRemaining(LoanDTO source, LoanDTO target) {
        final Integer moneyRemaining = source.getMoneyRemaining();
        target.setMoneyRemaining(moneyRemaining);
    }
}
