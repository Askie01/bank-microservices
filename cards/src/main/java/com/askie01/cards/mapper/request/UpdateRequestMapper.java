package com.askie01.cards.mapper.request;

import com.askie01.cards.entity.Card;
import com.askie01.cards.entity.CardType;
import com.askie01.cards.mapper.Mapper;
import com.askie01.cards.request.update.UpdateRequest;
import com.askie01.cards.service.CardTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class UpdateRequestMapper implements Mapper<UpdateRequest, Card> {

    private final CardTypeService cardTypeService;
    private final RequestMapper requestMapper;

    public Card mapToCard(UpdateRequest request) {
        return map(request, new Card());
    }

    @Override
    public Card map(UpdateRequest source, Card target) {
        final Card updatedTarget = requestMapper.map(source, target);
        mapCardNumber(source, updatedTarget);
        mapCardType(source, updatedTarget);
        mapMoneyLimit(source, updatedTarget);
        mapMoneyUsed(source, updatedTarget);
        return updatedTarget;
    }

    private void mapCardNumber(UpdateRequest source, Card target) {
        final Long cardNumber = source.getCardNumber();
        target.setCardNumber(cardNumber);
    }

    private void mapCardType(UpdateRequest source, Card target) {
        final String cardTypeName = source.getCardTypeName();
        final CardType cardType = cardTypeService.getCardType(cardTypeName);
        target.setCardType(cardType);
    }

    private void mapMoneyLimit(UpdateRequest source, Card target) {
        final BigDecimal moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }

    private void mapMoneyUsed(UpdateRequest source, Card target) {
        final BigDecimal moneyUsed = source.getMoneyUsed();
        target.setMoneyUsed(moneyUsed);
    }
}
