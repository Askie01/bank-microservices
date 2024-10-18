package com.askie01.loans.entity.loan.type.base;

import com.askie01.loans.entity.base.DefaultAuditableNamedEntity;
import com.askie01.loans.entity.loan.type.abstraction.LoanType;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

//TODO - Check inheritance.
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "loan_types")
public class DefaultLoanType extends DefaultAuditableNamedEntity implements LoanType<Long, String, LocalDateTime, String> {

}