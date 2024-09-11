package org.askie01.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "accounts")
public class Account extends AuditableEntity {
    @OneToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private String type;
    private String address;
}
