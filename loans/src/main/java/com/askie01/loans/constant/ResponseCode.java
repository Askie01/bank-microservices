package com.askie01.loans.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseCode {
    public static final String OK = "200";
    public static final String CREATED = "201";
    public static final String EXPECTATION_FAILED = "417";
    public static final String SERVER_ERROR = "500";
}
