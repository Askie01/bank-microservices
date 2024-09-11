package com.askie01.cards.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String OK = "Request processed successfully";
    public static final String CREATED = "Card created successfully";
    public static final String EXPECTATION_FAILED = "Delete operation failed. Please try again or contact Dev team";
    public static final String SERVER_ERROR = "An error occurred. Please try again or contact Dev team";
}