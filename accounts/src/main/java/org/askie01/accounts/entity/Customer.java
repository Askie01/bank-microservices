package org.askie01.accounts.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "customers")
public class Customer extends AuditableEntity {
    private String name;
    private String email;
    private String mobileNumber;
}
