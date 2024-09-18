package com.askie01.cards.service;

import com.askie01.cards.entity.Card;
import com.askie01.cards.exception.CardAlreadyExistsException;
import com.askie01.cards.exception.ResourceNotFoundException;
import com.askie01.cards.mapper.request.CreateRequestMapper;
import com.askie01.cards.mapper.request.DeleteRequestMapper;
import com.askie01.cards.mapper.request.GetRequestMapper;
import com.askie01.cards.mapper.request.UpdateRequestMapper;
import com.askie01.cards.repository.CardRepository;
import com.askie01.cards.request.create.CreateRequest;
import com.askie01.cards.request.delete.DeleteRequest;
import com.askie01.cards.request.get.GetRequest;
import com.askie01.cards.request.update.UpdateRequest;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class DefaultCardService implements CardService {

    private final CardRepository cardRepository;
    private final CreateRequestMapper createRequestMapper;
    private final GetRequestMapper getRequestMapper;
    private final UpdateRequestMapper updateRequestMapper;
    private final DeleteRequestMapper deleteRequestMapper;

    @Override
    public void createCard(CreateRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final boolean cardExists = cardRepository
                .findByMobileNumber(mobileNumber)
                .isPresent();

        if (cardExists) {
            throw new CardAlreadyExistsException("Card with mobileNumber: '" + mobileNumber + "' already exists.");
        }

        final Card card = createRequestMapper.mapToCard(request);
        cardRepository.save(card);
    }

    @Override
    public Card getCard(GetRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final Card card = cardRepository.
                findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        final Card updatedCard = getRequestMapper.map(request, card);

        if (card.equals(updatedCard)) {
            return updatedCard;
        } else {
            throw new ResourceNotFoundException("Card", "getRequest", request.toString());
        }
    }

    @Override
    public void updateCard(UpdateRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final Card card = cardRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        final Card updatedCard = updateRequestMapper.map(request, card);

        final boolean sameCardNumber = updatedCard
                .getCardNumber()
                .equals(card.getCardNumber());

        final boolean sameMobileNumber = updatedCard
                .getMobileNumber()
                .equals(card.getMobileNumber());

        if (sameCardNumber && sameMobileNumber) {
            cardRepository.save(updatedCard);
        } else {
            throw new ResourceNotFoundException("Card", "updateRequest", request.toString());
        }
    }

    @Override
    public void deleteCard(DeleteRequest request) {
        final String mobileNumber = request.getMobileNumber();
        final Card card = cardRepository
                .findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Card", "mobileNumber", mobileNumber));
        final Card updatedCard = deleteRequestMapper.map(request, card);

        if (card.equals(updatedCard)) {
            cardRepository.delete(updatedCard);
        } else {
            throw new ResourceNotFoundException("Card", "deleteRequest", request.toString());
        }
    }
}
