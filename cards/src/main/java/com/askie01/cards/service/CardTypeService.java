package com.askie01.cards.service;

import com.askie01.cards.entity.CardType;

public interface CardTypeService {
    void createCardType(String name);

    CardType getCardType(String name);

    void updateCardType(String oldName, String newName);

    void deleteCardType(String name);
}
