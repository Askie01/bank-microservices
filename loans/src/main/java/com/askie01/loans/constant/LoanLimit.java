package com.askie01.loans.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class LoanLimit {
    public static final int PERSONAL = 100_000;
    public static final int EDUCATION = 200_000;
    public static final int AUTO = 300_000;
    public static final int HOME = 500_000;
    public static final int BUSINESS = 1_000_000;
}
