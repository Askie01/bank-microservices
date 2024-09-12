package com.askie01.cards.mapper;

import com.askie01.cards.entity.Card;
import com.askie01.cards.requests.CardUpdateRequest;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardUpdateRequestMapper {

    public static Card mapToCard(CardUpdateRequest request) {
        final Card card = new Card();
        return map(request, card);
    }

    public static Card map(CardUpdateRequest source, Card target) {
        mapNumber(source, target);
        mapMobileNumber(source, target);
        mapType(source, target);
        mapMoneyLimit(source, target);
        mapMoneyUsed(source, target);
        return target;
    }

    private static void mapNumber(CardUpdateRequest source, Card target) {
        final Long number = source.getNumber();
        target.setNumber(number);
    }

    private static void mapMobileNumber(CardUpdateRequest source, Card target) {
        final Integer mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapType(CardUpdateRequest source, Card target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapMoneyLimit(CardUpdateRequest source, Card target) {
        final Integer moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }

    private static void mapMoneyUsed(CardUpdateRequest source, Card target) {
        final Integer moneyUsed = source.getMoneyUsed();
        target.setMoneyUsed(moneyUsed);
    }
}
