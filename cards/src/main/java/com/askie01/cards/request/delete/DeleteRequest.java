package com.askie01.cards.request.delete;

import com.askie01.cards.request.Request;

public interface DeleteRequest extends Request {
    Long getCardNumber();

    String getCardTypeName();
}
