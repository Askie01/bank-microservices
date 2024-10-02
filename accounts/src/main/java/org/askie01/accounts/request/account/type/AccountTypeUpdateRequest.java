package org.askie01.accounts.request.account.type;

import lombok.Data;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.validation.ValidAccountTypeName;

/**
 * Represents a request for updating {@link AccountType}.
 * <p>
 * This class implements {@link UpdateRequest} interface and provides the necessary
 * details required for updating an {@link AccountType}, including validations for {@link AccountType#name}.
 * </p>
 */
@Data
public class AccountTypeUpdateRequest implements UpdateRequest {

    /**
     * The name of the {@link AccountType}.
     * <p>
     * This field is validated by {@link ValidAccountTypeName} annotation to ensure
     * that it meets specific naming criteria before processing the request.
     * </p>
     */
    @ValidAccountTypeName
    private String name;
}
