package com.askie01.cards.service;

import com.askie01.cards.entity.Card;
import com.askie01.cards.request.create.CreateRequest;
import com.askie01.cards.request.delete.DeleteRequest;
import com.askie01.cards.request.get.GetRequest;
import com.askie01.cards.request.update.UpdateRequest;

public interface CardService {
    void createCard(CreateRequest request);

    Card getCard(GetRequest request);

    void updateCard(UpdateRequest request);

    void deleteCard(DeleteRequest request);
}
