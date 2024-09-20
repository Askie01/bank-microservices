package org.askie01.accounts.request.account.update;

public interface UpdateRequest {

    Long getId();

    String getAccountTypeName();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getMobileNumber();
}
