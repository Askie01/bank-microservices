package com.askie01.loans.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
public class Loan extends AuditableEntity {
    private Long number;
    private String type;
    private Integer mobileNumber;
    private Integer moneyLoaned;
    private Integer moneyPaid;
    private Integer moneyRemaining;
}
