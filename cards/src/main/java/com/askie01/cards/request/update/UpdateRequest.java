package com.askie01.cards.request.update;

import com.askie01.cards.request.Request;

import java.math.BigDecimal;

public interface UpdateRequest extends Request {
    Long getCardNumber();

    String getCardTypeName();

    BigDecimal getMoneyLimit();

    BigDecimal getMoneyUsed();
}
