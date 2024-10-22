package com.askie01.loans.entity.loan.type;

import com.askie01.loans.entity.abstraction.development.AbstractAuditableNamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loan_types")
public class DevelopmentLoanType extends AbstractAuditableNamedEntity
        implements LoanTypeEntity<Long, String, LocalDateTime, String> {
}
