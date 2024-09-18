package com.askie01.cards.service;

import com.askie01.cards.entity.CardType;
import com.askie01.cards.exception.CardTypeAlreadyExistsException;
import com.askie01.cards.exception.ResourceNotFoundException;
import com.askie01.cards.repository.CardTypeRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultCardTypeService implements CardTypeService {

    private final CardTypeRepository cardTypeRepository;

    @Override
    public void createCardType(String name) {
        try {
            getCardType(name);
            throw new CardTypeAlreadyExistsException("CardType with name '" + name + "' already exists.");
        } catch (ResourceNotFoundException exception) {
            final CardType cardType = new CardType();
            cardType.setName(name);
            cardTypeRepository.save(cardType);
        }
    }

    @Override
    public CardType getCardType(String name) {
        return cardTypeRepository
                .findByName(name)
                .orElseThrow(() -> new ResourceNotFoundException("CardType", "name", name));
    }

    @Override
    public void updateCardType(String oldName, String newName) {
        final CardType cardType = getCardType(oldName);
        cardType.setName(newName);
        cardTypeRepository.save(cardType);
    }

    @Override
    public void deleteCardType(String name) {
        final CardType cardType = getCardType(name);
        cardTypeRepository.delete(cardType);
    }
}
