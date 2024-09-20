package org.askie01.accounts.request.customer.get;

import lombok.Data;
import org.askie01.accounts.validation.ValidId;

@Data
public class CustomerGetRequest implements GetRequest {

    @ValidId
    private Long id;
}
