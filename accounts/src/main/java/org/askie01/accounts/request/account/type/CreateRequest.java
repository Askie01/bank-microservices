package org.askie01.accounts.request.account.type;

import org.askie01.accounts.controller.AccountTypeController;
import org.askie01.accounts.entity.AccountType;

/**
 * Represents a request for creating a new {@link AccountType}.
 * <p>
 * This interface defines the contract for the data required to create an {@link AccountType}
 * in the {@link AccountTypeController}.
 * </p>
 * <p>
 * Implementation of this interface should provide the necessary details for creating {@link AccountType}.
 * </p>
 */
public interface CreateRequest {
    /**
     * Gets the name of the {@link AccountType}
     *
     * @return the name of {@link AccountType}
     */
    String getName();
}
