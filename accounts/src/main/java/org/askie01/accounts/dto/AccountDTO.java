package org.askie01.accounts.dto;

import lombok.Data;
import org.askie01.accounts.entity.Account;
import org.askie01.accounts.entity.AccountType;

/**
 * Data Transfer Object (DTO) for representing an {@link Account}.
 * <p>
 * This class encapsulates the details of an account, including its identifier,
 * login credentials, associated {@link AccountTypeDTO}, and the {@link CustomerDTO} who owns the account.
 * </p>
 */
@Data
public class AccountDTO {

    /**
     * The unique identifier of the {@link Account}.
     *
     * @return the ID of the {@link Account}.
     */
    private Long id;

    /**
     * The login name associated with the {@link Account}.
     *
     * @return the login name for the {@link Account}.
     */
    private String login;

    /**
     * The password for the {@link Account}.
     * <p>
     * This value should be stored securely (e.g. hashed) and not exposed.
     * </p>
     *
     * @return the password associated with the {@link Account}.
     */
    private String password;

    /**
     * The {@link AccountTypeDTO} associated with this {@link Account},
     * which defines the type of account (e.g. SAVING, CHECKING).
     *
     * @return the {@link AccountType} information.
     */
    private AccountTypeDTO accountTypeDTO;

    /**
     * The {@link CustomerDTO} representing the customer who owns the {@link Account}.
     *
     * @return the customer information associated with the customer.
     */
    private CustomerDTO customerDTO;
}
