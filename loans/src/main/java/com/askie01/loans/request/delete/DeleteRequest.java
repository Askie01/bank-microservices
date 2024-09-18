package com.askie01.loans.request.delete;

import com.askie01.loans.request.Request;

public interface DeleteRequest extends Request {
    Integer getLoanNumber();

    String getLoanTypeName();
}
