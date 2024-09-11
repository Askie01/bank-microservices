package org.askie01.accounts.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class AccountType {
    public static final String SAVINGS = "Savings";
    public static final String CHECKING = "Checking";
    public static final String FIXED_DEPOSIT = "Fixed Deposit";
    public static final String RECURRING_DEPOSIT = "Recurring Deposit";
    public static final String BUSINESS = "Business";
    public static final String JOINT = "Joint";
    public static final String LOAN = "Loan";
    public static final String CREDIT_CARD = "Credit Card";
}
