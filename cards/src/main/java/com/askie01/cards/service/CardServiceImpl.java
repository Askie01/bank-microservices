package com.askie01.cards.service;

import com.askie01.cards.constant.CardConstants;
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
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;

    /**
     * @param mobileNumber Mobile number of the Customer
     */
    @Override
    public void createCard(String mobileNumber) {
        final Optional<Card> optionalCard = cardRepository.findByMobileNumber(mobileNumber);
        if (optionalCard.isPresent()) {
            throw new CardAlreadyExistsException("Card already registered with given mobileNumber: '" + mobileNumber + "'.");
        }
        cardRepository.save(createNewCard(mobileNumber));
    }

    /**
     * @param mobileNumber Mobile number of the Customer
     * @return the new card details
     */
    private Card createNewCard(String mobileNumber) {
        final Card card = new Card();
        final long randomCardNumber = 100_000_000_000L + new Random().nextInt(900_000_000);
        card.setCardNumber(Long.toString(randomCardNumber));
        card.setMobileNumber(mobileNumber);
        card.setCardType(CardConstants.CREDIT_CARD);
        card.setTotalLimit(CardConstants.NEW_CARD_LIMIT);
        card.setAmountUsed(0);
        card.setAvailableAmount(CardConstants.NEW_CARD_LIMIT);
        return card;
    }

    /**
     * @param mobileNumber Input mobile number
     * @return Card details based on a given mobileNumber
     */
    @Override
    public CardDTO getCard(String mobileNumber) {
        final Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        return CardMapper.mapToCardDTO(card, new CardDTO());
    }

    /**
     * @param cardDTO CardDTO object
     * @return boolean indicating if the update of card details is successful or not
     */
    @Override
    public boolean updateCard(CardDTO cardDTO) {
        final Card card = cardRepository.findByCardNumber(cardDTO.getCardNumber()).orElseThrow(
                () -> new ResourceNotFoundException("Card", "CardNumber", cardDTO.getCardNumber())
        );
        CardMapper.mapToCard(cardDTO, card);
        cardRepository.save(card);
        return true;
    }

    /**
     * @param mobileNumber Input mobile number
     * @return boolean indicating if the delete of card details is successful or not
     */
    @Override
    public boolean deleteCard(String mobileNumber) {
        final Card card = cardRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber)
        );
        cardRepository.deleteById(card.getCardId());
        return true;
    }
}
