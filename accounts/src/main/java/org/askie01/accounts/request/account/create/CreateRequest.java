package org.askie01.accounts.request.account.create;

public interface CreateRequest {
    String getLogin();

    String getPassword();

    String getAccountTypeName();

    String getFirstName();

    String getLastName();

    String getEmail();

    String getMobileNumber();
}
