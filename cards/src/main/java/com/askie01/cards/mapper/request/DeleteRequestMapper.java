package com.askie01.cards.mapper.request;

import com.askie01.cards.entity.Card;
import com.askie01.cards.entity.CardType;
import com.askie01.cards.mapper.Mapper;
import com.askie01.cards.request.delete.DeleteRequest;
import com.askie01.cards.service.CardTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class DeleteRequestMapper implements Mapper<DeleteRequest, Card> {

    private final CardTypeService cardTypeService;
    private final RequestMapper requestMapper;

    @Override
    public Card map(DeleteRequest source, Card target) {
        final Card updatedTarget = requestMapper.map(source, target);
        mapCardNumber(source, updatedTarget);
        mapCardType(source, updatedTarget);
        return updatedTarget;
    }

    private void mapCardNumber(DeleteRequest source, Card target) {
        final Long cardNumber = source.getCardNumber();
        target.setCardNumber(cardNumber);
    }

    private void mapCardType(DeleteRequest source, Card target) {
        final String cardTypeName = source.getCardTypeName();
        final CardType cardType = cardTypeService.getCardType(cardTypeName);
        target.setCardType(cardType);
    }
}
