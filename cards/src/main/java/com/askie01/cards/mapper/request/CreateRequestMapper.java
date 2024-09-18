package com.askie01.cards.mapper.request;

import com.askie01.cards.entity.Card;
import com.askie01.cards.entity.CardType;
import com.askie01.cards.mapper.Mapper;
import com.askie01.cards.request.create.CreateRequest;
import com.askie01.cards.service.CardTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Data
@Component
public class CreateRequestMapper implements Mapper<CreateRequest, Card> {

    private final CardTypeService cardTypeService;
    private final RequestMapper requestMapper;

    public Card mapToCard(CreateRequest request) {
        return map(request, new Card());
    }

    @Override
    public Card map(CreateRequest source, Card target) {
        final Card updatedTarget = requestMapper.map(source, target);
        mapCardType(source, updatedTarget);
        mapMoneyLimit(source, updatedTarget);
        return updatedTarget;
    }

    private void mapCardType(CreateRequest source, Card target) {
        final String cardTypeName = source.getCardTypeName();
        final CardType cardType = cardTypeService.getCardType(cardTypeName);
        target.setCardType(cardType);
    }

    private void mapMoneyLimit(CreateRequest source, Card target) {
        final BigDecimal moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }
}
