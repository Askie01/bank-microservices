package com.askie01.cards.service;

import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.entity.Card;
import com.askie01.cards.exception.CardAlreadyExistsException;
import com.askie01.cards.exception.ResourceNotFoundException;
import com.askie01.cards.mapper.CardCreationRequestMapper;
import com.askie01.cards.mapper.CardMapper;
import com.askie01.cards.mapper.CardUpdateRequestMapper;
import com.askie01.cards.repository.CardRepository;
import com.askie01.cards.requests.CardCreationRequest;
import com.askie01.cards.requests.CardUpdateRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Data
@Service
public class CardService {

    private final CardRepository cardRepository;

    public void createCard(CardCreationRequest request) {
        final Integer mobileNumber = request.getMobileNumber();
        final Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        final boolean cardExists = optionalCard.isPresent();
        if (cardExists) {
            throw new CardAlreadyExistsException("Card with mobileNumber: '" + mobileNumber + "' already exists.");
        }
        final Card card = createNewCard(request);
        cardRepository.save(card);
    }

    private Card createNewCard(CardCreationRequest request) {
        final Card card = CardCreationRequestMapper.mapToCard(request);
        final long randomCardNumber = 1000_0000_0000_0000L + new Random().nextLong(9000_0000_0000_0000L);
        card.setNumber(randomCardNumber);
        card.setMoneyAvailable(0);
        card.setMoneyUsed(0);
        return card;
    }

    public CardDTO getCardDTO(Integer mobileNumber) {
        final Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        final boolean cardExists = optionalCard.isPresent();
        if (!cardExists) {
            throw new ResourceNotFoundException("Card", "mobileNumber", mobileNumber);
        }
        final Card card = optionalCard.get();
        return CardMapper.mapToCardDTO(card);
    }

    public void updateCard(CardUpdateRequest request) {
        final Long cardNumber = request.getNumber();
        final Optional<Card> optionalCard = cardRepository.findByNumber(cardNumber);
        final boolean cardExists = optionalCard.isPresent();
        if (!cardExists) {
            throw new ResourceNotFoundException("Card", "CardNumber", cardNumber);
        }
        final Card card = optionalCard.get();
        CardUpdateRequestMapper.map(request, card);
        cardRepository.save(card);
    }

    public void deleteCard(Integer mobileNumber) {
        final Optional<Card> cardOptional = cardRepository.findByMobileNumber(mobileNumber);
        final boolean cardExists = cardOptional.isPresent();
        if (!cardExists) {
            throw new ResourceNotFoundException("Card", "mobileNumber", mobileNumber);
        }
        final Card card = cardOptional.get();
        final Long id = card.getId();
        cardRepository.deleteById(id);
    }
}
