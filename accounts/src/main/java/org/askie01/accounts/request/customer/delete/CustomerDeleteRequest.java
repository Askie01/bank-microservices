package org.askie01.accounts.request.customer.delete;

import lombok.Data;
import org.askie01.accounts.validation.ValidId;

@Data
public class CustomerDeleteRequest implements DeleteRequest {

    @ValidId
    private Long id;
}
