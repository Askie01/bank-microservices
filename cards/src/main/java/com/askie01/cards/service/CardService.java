package com.askie01.cards.service;

import com.askie01.cards.dto.CardDTO;

public interface CardService {
    /**
     * @param mobileNumber Mobile number of the Customer
     */
    void createCard(String mobileNumber);

    /**
     * @param mobileNumber Input mobile number
     * @return Card details based on a given mobileNumber
     */
    CardDTO getCard(String mobileNumber);

    /**
     * @param cardDTO CardDTO object
     * @return boolean indicating if the update of card details is successful or not
     */
    boolean updateCard(CardDTO cardDTO);

    /**
     * @param mobileNumber Input mobile number
     * @return boolean indicating if the delete of card details is successful or not
     */
    boolean deleteCard(String mobileNumber);
}
