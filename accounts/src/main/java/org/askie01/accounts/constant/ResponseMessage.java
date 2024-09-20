package org.askie01.accounts.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String OK = "Request processed successfully.";
    public static final String ACCOUNT_CREATED = "Account created successfully.";
    public static final String ACCOUNT_TYPE_CREATED = "Account type created successfully.";
    public static final String CUSTOMER_CREATED = "Customer created successfully.";
    public static final String EXPECTATION_FAILED = "Delete operation failed.";
    public static final String SERVER_ERROR = "Server error occurred.";
}
