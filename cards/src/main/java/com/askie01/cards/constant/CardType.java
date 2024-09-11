package com.askie01.cards.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardType {
    public static final String CREDIT = "Credit Card";
    public static final String DEBIT = "Debit Card";
    public static final String PREPAID = "Prepaid Card";
    public static final String VIRTUAL = "Virtual Card";
    public static final String BUSINESS = "Business Card";
    public static final String REWARD = "Reward Card";
}
