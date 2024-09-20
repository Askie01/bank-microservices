package org.askie01.accounts.request.account.update;

import lombok.Data;
import org.askie01.accounts.validation.*;

@Data
public class AccountUpdateRequest implements UpdateRequest {

    @ValidId
    private Long id;

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
