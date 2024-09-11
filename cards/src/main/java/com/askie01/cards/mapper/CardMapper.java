package com.askie01.cards.mapper;

import com.askie01.cards.dto.CardDTO;
import com.askie01.cards.entity.Card;

public class CardMapper {

    public static CardDTO map(Card source, CardDTO target) {
        mapCardNumber(source, target);
        mapCardType(source, target);
        mapMobileNumber(source, target);
        mapTotalLimit(source, target);
        mapAvailableAmount(source, target);
        mapAmountUsed(source, target);
        return target;
    }

    private static void mapCardNumber(Card source, CardDTO target) {
        final String cardNumber = source.getCardNumber();
        target.setCardNumber(cardNumber);
    }

    private static void mapCardType(Card source, CardDTO target) {
        final String cardType = source.getCardType();
        target.setCardType(cardType);
    }

    private static void mapMobileNumber(Card source, CardDTO target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapTotalLimit(Card source, CardDTO target) {
        final int totalLimit = source.getTotalLimit();
        target.setTotalLimit(totalLimit);
    }

    private static void mapAvailableAmount(Card source, CardDTO target) {
        final int availableAmount = source.getAvailableAmount();
        target.setAvailableAmount(availableAmount);
    }

    private static void mapAmountUsed(Card source, CardDTO target) {
        final int amountUsed = source.getAmountUsed();
        target.setAmountUsed(amountUsed);
    }

    public static Card map(CardDTO source, Card target) {
        mapCardNumber(source, target);
        mapCardType(source, target);
        mapMobileNumber(source, target);
        mapTotalLimit(source, target);
        mapAvailableAmount(source, target);
        mapAmountUsed(source, target);
        return target;
    }

    private static void mapCardNumber(CardDTO source, Card target) {
        final String cardNumber = source.getCardNumber();
        target.setCardNumber(cardNumber);
    }

    private static void mapCardType(CardDTO source, Card target) {
        final String cardType = source.getCardType();
        target.setCardType(cardType);
    }

    private static void mapMobileNumber(CardDTO source, Card target) {
        final String mobileNumber = source.getMobileNumber();
        target.setMobileNumber(mobileNumber);
    }

    private static void mapTotalLimit(CardDTO source, Card target) {
        final int totalLimit = source.getTotalLimit();
        target.setTotalLimit(totalLimit);
    }

    private static void mapAvailableAmount(CardDTO source, Card target) {
        final int availableAmount = source.getAvailableAmount();
        target.setAvailableAmount(availableAmount);
    }

    private static void mapAmountUsed(CardDTO source, Card target) {
        final int amountUsed = source.getAmountUsed();
        target.setAmountUsed(amountUsed);
    }
}
