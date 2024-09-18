package com.askie01.cards.constant;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ResponseMessage {
    public static final String OK = "Request processed successfully.";
    public static final String CARD_CREATED = "Card created successfully.";
    public static final String CARD_TYPE_CREATED = "Card type created successfully.";
    public static final String EXPECTATION_FAILED = "Delete operation failed.";
    public static final String SERVER_ERROR = "Server error occurred.";
}
