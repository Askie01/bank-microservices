package org.askie01.accounts.service;

import org.askie01.accounts.dto.CustomerDTO;

public interface AccountService {
    /**
     * @param customerDTO - CustomerDTO object
     */
      void createAccount(CustomerDTO customerDTO);

    /**
     * @param mobileNumber
     * @return
     */
    CustomerDTO getAccount(String mobileNumber);

}
