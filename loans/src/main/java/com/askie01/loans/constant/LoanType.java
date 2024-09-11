package com.askie01.loans.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanType {
    public static final String PERSONAL = "Personal Loan";
    public static final String EDUCATION = "Education Loan";
    public static final String AUTO = "Auto Loan";
    public static final String HOME = "Home Loan";
    public static final String BUSINESS = "Business Loan";
}
