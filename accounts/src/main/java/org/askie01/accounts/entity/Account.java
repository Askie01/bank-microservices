package org.askie01.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
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

    private String login;
    private String password;

    @ManyToOne
    private AccountType accountType;

    @ManyToOne
    private Customer customer;
}
