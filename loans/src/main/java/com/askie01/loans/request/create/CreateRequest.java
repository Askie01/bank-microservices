package com.askie01.loans.request.create;

import com.askie01.loans.request.Request;

import java.math.BigDecimal;

public interface CreateRequest extends Request {
    String getLoanTypeName();

    BigDecimal getMoneyLoaned();
}
