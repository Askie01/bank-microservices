package com.askie01.cards.mapper.request;

import com.askie01.cards.entity.Card;
import com.askie01.cards.entity.CardType;
import com.askie01.cards.mapper.Mapper;
import com.askie01.cards.request.get.GetRequest;
import com.askie01.cards.service.CardTypeService;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class GetRequestMapper implements Mapper<GetRequest, Card> {

    private final CardTypeService cardTypeService;
    private final RequestMapper requestMapper;

    @Override
    public Card map(GetRequest source, Card target) {
        final Card updatedTarget = requestMapper.map(source, target);
        mapCardType(source, updatedTarget);
        return updatedTarget;
    }

    private void mapCardType(GetRequest source, Card target) {
        final String cardTypeName = source.getCardTypeName();
        final CardType cardType = cardTypeService.getCardType(cardTypeName);
        target.setCardType(cardType);
    }
}
