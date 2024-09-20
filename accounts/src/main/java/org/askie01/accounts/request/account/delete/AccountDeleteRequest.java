package org.askie01.accounts.request.account.delete;

import lombok.Data;
import org.askie01.accounts.validation.ValidId;

@Data
public class AccountDeleteRequest implements DeleteRequest {

    @ValidId
    private Long id;
}
