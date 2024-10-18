package com.askie01.loans.common;

public interface Auditable<Time, Message> {
    Time getCreatedAt();

    Message getCreatedBy();

    Time getUpdatedAt();

    Message getUpdatedBy();
}
