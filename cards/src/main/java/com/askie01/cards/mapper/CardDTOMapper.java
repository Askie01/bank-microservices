package com.askie01.cards.mapper;

import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.entity.Card;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardDTOMapper {

    public static Card mapToCard(CardDTO cardDTO) {
        final Card card = new Card();
        return map(cardDTO, card);
    }

    public static Card map(CardDTO source, Card target) {
        mapNumber(source, target);
        mapType(source, target);
        mapMobileNumber(source, target);
        mapMoneyLimit(source, target);
        mapMoneyUsed(source, target);
        mapMoneyAvailable(source, target);
        return target;
    }

    private static void mapNumber(CardDTO source, Card target) {
        final long number = source.getNumber();
        target.setNumber(number);
    }

    private static void mapType(CardDTO source, Card target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapMobileNumber(CardDTO source, Card target) {
        final int mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapMoneyLimit(CardDTO source, Card target) {
        final int moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }

    private static void mapMoneyUsed(CardDTO source, Card target) {
        final int moneyUsed = source.getMoneyUsed();
        target.setMoneyUsed(moneyUsed);
    }

    private static void mapMoneyAvailable(CardDTO source, Card target) {
        final int moneyAvailable = source.getMoneyAvailable();
        target.setMoneyAvailable(moneyAvailable);
    }
}
