package org.askie01.accounts.request.customer.create;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.askie01.accounts.validation.ValidEmail;
import org.askie01.accounts.validation.ValidFirstName;
import org.askie01.accounts.validation.ValidLastName;
import org.askie01.accounts.validation.ValidMobileNumber;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerCreateRequest implements CreateRequest {

    @ValidFirstName
    private String firstName;

    @ValidLastName
    private String lastName;

    @ValidEmail
    private String email;

    @ValidMobileNumber
    private String mobileNumber;
}
