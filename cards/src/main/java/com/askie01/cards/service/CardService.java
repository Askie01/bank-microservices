package com.askie01.cards.service;

import com.askie01.cards.constant.CardLimit;
import com.askie01.cards.constant.CardType;
import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.entity.Card;
import com.askie01.cards.exception.CardAlreadyExistsException;
import com.askie01.cards.exception.ResourceNotFoundException;
import com.askie01.cards.mapper.CardMapper;
import com.askie01.cards.repository.CardRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Data
@Service
public class CardService {

    private final CardRepository cardRepository;

    public void createCard(String mobileNumber) {
        final Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        if (optionalCard.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber: '" + mobileNumber + "'.");
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    private Card createNewCard(String mobileNumber) {
        final Card card = new Card();
        final long randomCardNumber = 100_000_000_000L + new Random().nextInt(900_000_000);
        card.setCardNumber(Long.toString(randomCardNumber));
        card.setMobileNumber(mobileNumber);
        card.setCardType(CardType.CREDIT);
        card.setTotalLimit(CardLimit.DEFAULT);
        card.setAmountUsed(0);
        card.setAvailableAmount(CardLimit.DEFAULT);
        return card;
    }

    public CardDTO getCard(String mobileNumber) {
        final Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardMapper.map(card, new CardDTO());
    }

    public void updateCard(CardDTO cardDTO) {
        final Card card = cardRepository.findByCardNumber(cardDTO.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardDTO.getCardNumber())
        );
        CardMapper.map(cardDTO, card);
        cardRepository.save(card);
    }

    public void deleteCard(String mobileNumber) {
        final Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(card.getId());
    }
}
