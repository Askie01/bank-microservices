package com.askie01.loans.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String OK = "Request processed successfully";
    public static final String CREATED = "Loan created successfully";
    public static final String EXPECTATION_FAILED = "Delete operation failed.";
    public static final String SERVER_ERROR = "Server error occurred.";
}
