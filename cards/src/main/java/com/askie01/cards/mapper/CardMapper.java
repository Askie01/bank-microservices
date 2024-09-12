package com.askie01.cards.mapper;

import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.entity.Card;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class CardMapper {

    public static CardDTO mapToCardDTO(Card card) {
        final CardDTO cardDTO = new CardDTO();
        return map(card, cardDTO);
    }

    public static CardDTO map(Card source, CardDTO target) {
        mapNumber(source, target);
        mapType(source, target);
        mapMobileNumber(source, target);
        mapMoneyLimit(source, target);
        mapMoneyUsed(source, target);
        mapMoneyAvailable(source, target);
        return target;
    }

    private static void mapNumber(Card source, CardDTO target) {
        final long number = source.getNumber();
        target.setNumber(number);
    }

    private static void mapType(Card source, CardDTO target) {
        final String type = source.getType();
        target.setType(type);
    }

    private static void mapMobileNumber(Card source, CardDTO target) {
        final int mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapMoneyLimit(Card source, CardDTO target) {
        final int moneyLimit = source.getMoneyLimit();
        target.setMoneyLimit(moneyLimit);
    }

    private static void mapMoneyUsed(Card source, CardDTO target) {
        final int moneyUsed = source.getMoneyUsed();
        target.setMoneyUsed(moneyUsed);
    }

    private static void mapMoneyAvailable(Card source, CardDTO target) {
        final int moneyAvailable = source.getMoneyAvailable();
        target.setMoneyAvailable(moneyAvailable);
    }
}
