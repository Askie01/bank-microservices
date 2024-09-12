package com.askie01.cards.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "cards")
public class Card extends AuditableEntity {
    private Long number;
    private String type;
    private Integer mobileNumber;
    private Integer moneyLimit;
    private Integer moneyUsed;
    private Integer moneyAvailable;
}
