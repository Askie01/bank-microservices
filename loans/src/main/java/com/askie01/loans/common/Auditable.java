package com.askie01.loans.common;

public interface Auditable<Time, User> {
    Time getCreatedAt();

    void setCreatedAt(Time time);

    User getCreatedBy();

    void setCreatedBy(User user);

    Time getUpdatedAt();

    void setUpdatedAt(Time time);

    User getUpdatedBy();

    void setUpdatedBy(User user);
}
