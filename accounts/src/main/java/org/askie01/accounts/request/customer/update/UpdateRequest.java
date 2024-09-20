package org.askie01.accounts.request.customer.update;

public interface UpdateRequest {
    Long getId();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getMobileNumber();
}
