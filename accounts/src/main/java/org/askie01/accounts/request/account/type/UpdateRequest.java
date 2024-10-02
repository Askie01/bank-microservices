package org.askie01.accounts.request.account.type;

import org.askie01.accounts.controller.AccountTypeController;
import org.askie01.accounts.entity.AccountType;

/**
 * Represents a request for updating {@link AccountType}.
 * <p>
 * This interface defines the contract for the data required to update an {@link AccountType}
 * in the {@link AccountTypeController}.
 * </p>
 * <p>
 * Implementation of this interface should provide the necessary details for updating {@link AccountType}.
 * </p>
 */
public interface UpdateRequest {
    /**
     * Gets the name of the {@link AccountType}
     *
     * @return the name of {@link AccountType}
     */
    String getName();
}
