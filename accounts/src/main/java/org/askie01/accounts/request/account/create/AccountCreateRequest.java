package org.askie01.accounts.request.account.create;

import lombok.Data;
import org.askie01.accounts.validation.*;

@Data
public class AccountCreateRequest implements CreateRequest {

    @ValidLogin
    private String login;

    @ValidPassword
    private String password;

    @ValidAccountTypeName
    private String accountTypeName;

    @ValidFirstName
    private String firstName;

    @ValidLastName
    private String lastName;

    @ValidEmail
    private String email;

    @ValidMobileNumber
    private String mobileNumber;
}
