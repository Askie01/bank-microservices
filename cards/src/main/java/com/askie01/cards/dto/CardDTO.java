package com.askie01.cards.dto;

import lombok.Data;

@Data
public class CardDTO {
    private Long number;
    private String type;
    private Integer mobileNumber;
    private Integer moneyLimit;
    private Integer moneyUsed;
    private Integer moneyAvailable;
}
