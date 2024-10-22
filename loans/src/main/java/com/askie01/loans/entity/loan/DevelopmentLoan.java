package com.askie01.loans.entity.loan;

import com.askie01.loans.entity.abstraction.development.AbstractAuditableBaseEntity;
import com.askie01.loans.entity.loan.type.DevelopmentLoanType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
public class DevelopmentLoan extends AbstractAuditableBaseEntity
        implements LoanEntity<Long, LocalDateTime, String, Integer, DevelopmentLoanType, Double> {

    private Integer loanNumber;

    @ManyToOne
    private DevelopmentLoanType loanType;
    private Double moneyLoaned;
    private Double moneyPaid;
    private Double moneyRemaining;
}
