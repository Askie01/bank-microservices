package com.askie01.loans.request.update;

import com.askie01.loans.request.Request;

import java.math.BigDecimal;

public interface UpdateRequest extends Request {
    Integer getLoanNumber();

    String getLoanTypeName();

    BigDecimal getMoneyLoaned();

    BigDecimal getMoneyPaid();
}
