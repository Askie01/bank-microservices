package com.askie01.cards.request.create;

import com.askie01.cards.request.Request;

import java.math.BigDecimal;

public interface CreateRequest extends Request {
    String getCardTypeName();

    BigDecimal getMoneyLimit();
}
