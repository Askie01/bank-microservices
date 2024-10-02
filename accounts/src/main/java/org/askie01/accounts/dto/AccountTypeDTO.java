package org.askie01.accounts.dto;

import lombok.Data;
import org.askie01.accounts.entity.AccountType;

/**
 * Data Transfer Object (DTO) for representing an {@link AccountType}.
 * <p>
 * This class contains the basic information required to identify an {@link AccountType},
 * including its unique identifier and name.
 * </p>
 */
@Data
public class AccountTypeDTO {

    /**
     * The unique identifier of the {@link AccountType}.
     *
     * @return the ID of the {@link AccountType}.
     */
    private Long id;

    /**
     * The name of the {@link AccountType}.
     *
     * @return the name of the {@link AccountType}.
     */
    private String name;
}
