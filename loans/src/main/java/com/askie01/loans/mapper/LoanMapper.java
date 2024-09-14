package com.askie01.loans.mapper;

import com.askie01.loans.copier.LoanDTOCopier;
import com.askie01.loans.dto.LoanDTO;
import com.askie01.loans.entity.Loan;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanMapper {

    public static LoanDTO mapToLoanDTO(Loan loan) {
        return map(loan, new LoanDTO());
    }

    public static LoanDTO map(Loan source, LoanDTO target) {
        final LoanDTO targetCopy = LoanDTOCopier.copy(target);
        mapNumber(source, targetCopy);
        mapType(source, targetCopy);
        mapMobileNumber(source, targetCopy);
        mapMoneyLoaned(source, targetCopy);
        mapMoneyPaid(source, targetCopy);
        mapMoneyRemaining(source, targetCopy);
        return targetCopy;
    }

    private static void mapNumber(Loan source, LoanDTO target) {
        final Long number = source.getNumber();
        target.setNumber(number);
    }

    private static void mapType(Loan source, LoanDTO target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapMobileNumber(Loan source, LoanDTO target) {
        final Integer mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapMoneyLoaned(Loan source, LoanDTO target) {
        final Integer moneyLoaned = source.getMoneyLoaned();
        target.setMoneyLoaned(moneyLoaned);
    }

    private static void mapMoneyPaid(Loan source, LoanDTO target) {
        final Integer moneyPaid = source.getMoneyPaid();
        target.setMoneyPaid(moneyPaid);
    }

    private static void mapMoneyRemaining(Loan source, LoanDTO target) {
        final Integer moneyRemaining = source.getMoneyRemaining();
        target.setMoneyRemaining(moneyRemaining);
    }
}
