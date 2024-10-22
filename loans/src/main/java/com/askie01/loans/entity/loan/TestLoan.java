package com.askie01.loans.entity.loan;

import com.askie01.loans.entity.abstraction.test.AbstractAuditableBaseEntity;
import com.askie01.loans.entity.loan.type.TestLoanType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
public class TestLoan extends AbstractAuditableBaseEntity
        implements LoanEntity<String, LocalDate, String, String, TestLoanType, BigDecimal> {

    private String loanNumber;

    @ManyToOne
    private TestLoanType loanType;
    private BigDecimal moneyLoaned;
    private BigDecimal moneyPaid;
    private BigDecimal moneyRemaining;
}
