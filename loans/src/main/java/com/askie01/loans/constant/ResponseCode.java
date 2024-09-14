package com.askie01.loans.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseCode {
    public static final Integer OK = 200;
    public static final Integer CREATED = 201;
    public static final Integer BAD_REQUEST = 400;
    public static final Integer NOT_FOUND = 404;
    public static final Integer EXPECTATION_FAILED = 417;
    public static final Integer INTERVAL_SERVER_ERROR = 500;
}
