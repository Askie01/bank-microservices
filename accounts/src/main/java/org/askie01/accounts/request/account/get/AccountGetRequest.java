package org.askie01.accounts.request.account.get;

import lombok.Data;
import org.askie01.accounts.validation.ValidMobileNumber;

@Data
public class AccountGetRequest implements GetRequest {

    @ValidMobileNumber
    private String mobileNumber;
}
