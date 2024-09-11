package com.askie01.cards.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardLimit {
    public static final int DEFAULT = 100_000;
    public static final int STUDENT = 200_000;
    public static final int REWARD = 300_000;
    public static final int PREMIUM = 500_000;
    public static final int BUSINESS = 1_000_000;
}
