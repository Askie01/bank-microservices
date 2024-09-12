package com.askie01.cards.mapper;

import com.askie01.cards.entity.Card;
import com.askie01.cards.requests.CardCreationRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardCreationRequestMapper {

    public static Card mapToCard(CardCreationRequest request) {
        final Card card = new Card();
        return map(request, card);
    }

    public static Card map(CardCreationRequest source, Card target) {
        mapMobileNumber(source, target);
        mapType(source, target);
        mapMoneyLimit(source, target);
        return target;
    }

    private static void mapMobileNumber(CardCreationRequest source, Card target) {
        final Integer mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapType(CardCreationRequest source, Card target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapMoneyLimit(CardCreationRequest source, Card target) {
        final Integer moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }
}
