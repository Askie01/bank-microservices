package com.askie01.loans.entity.loan.base;

import com.askie01.loans.entity.loan.type.base.DefaultLoanType;
import com.askie01.loans.entity.base.DefaultAuditableBaseEntity;
import com.askie01.loans.entity.loan.abstraction.Loan;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loans")
public class DefaultLoan extends DefaultAuditableBaseEntity implements Loan<Long, LocalDateTime, String> {

    private Integer loanNumber;

    @ManyToOne
    private DefaultLoanType defaultLoanType;
    private BigDecimal moneyLoaned;
    private BigDecimal moneyPaid;
    private BigDecimal moneyRemaining;
}
