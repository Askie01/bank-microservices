package org.askie01.accounts.service;

import org.askie01.accounts.dto.CustomerDTO;

public interface AccountService {
    /**
     * @param customerDTO CustomerDTO object
     */
    void createAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber Input Mobile Number
     * @return Accounts Details based on a given mobilePhone
     */
    CustomerDTO getAccount(String mobileNumber);

    /**
     * @param customerDTO CustomerDTO object
     * @return boolean indicating if the update of Account details is successful or not
     */
    boolean updateAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber input Mobile Number
     * @return boolean indicating if the delete of Account details is successful or not
     */
    boolean deleteAccount(String mobileNumber);
}
