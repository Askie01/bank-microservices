package org.askie01.accounts.request.customer.update;

import lombok.Data;
import org.askie01.accounts.validation.*;

@Data
public class CustomerUpdateRequest implements UpdateRequest {

    @ValidId
    private Long id;

    @ValidFirstName
    private String firstName;

    @ValidLastName
    private String lastName;

    @ValidEmail
    private String email;

    @ValidMobileNumber
    private String mobileNumber;
}
