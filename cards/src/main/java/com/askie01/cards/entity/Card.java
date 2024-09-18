package com.askie01.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cards")
public class Card extends AuditableEntity {
    private Long cardNumber;

    @ManyToOne
    private CardType cardType;
    private String mobileNumber;
    private BigDecimal moneyLimit;
    private BigDecimal moneyUsed;
    private BigDecimal moneyAvailable;
}
