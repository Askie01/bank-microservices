package org.askie01.accounts.request.account.type;

import lombok.Data;
import org.askie01.accounts.entity.AccountType;
import org.askie01.accounts.validation.ValidAccountTypeName;

/**
 * Represents a request for creating a new {@link AccountType}.
 * <p>
 * This class implements {@link CreateRequest} interface and provides the necessary
 * details required for creating an {@link AccountType}, including validations for {@link AccountType#name}.
 * </p>
 */
@Data
public class AccountTypeCreateRequest implements CreateRequest {

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
