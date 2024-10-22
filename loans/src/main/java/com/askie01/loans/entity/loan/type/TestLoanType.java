package com.askie01.loans.entity.loan.type;

import com.askie01.loans.entity.abstraction.test.AbstractAuditableNamedEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDate;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loan_types")
public class TestLoanType extends AbstractAuditableNamedEntity
        implements LoanTypeEntity<String, String, LocalDate, String> {
}
