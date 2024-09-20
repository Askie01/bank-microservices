CREATE TABLE customers
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(20)  NOT NULL,
    last_name     VARCHAR(40)  NOT NULL,
    email         VARCHAR(100) NOT NULL,
    mobile_number VARCHAR(20)  NOT NULL,
    created_at    DATETIME(6)  NOT NULL,
    created_by    VARCHAR(8)   NOT NULL,
    updated_at    DATETIME(6) DEFAULT NULL,
    updated_by    VARCHAR(8)  DEFAULT NULL
);

ALTER TABLE customers
    ADD CONSTRAINT unique_email
        UNIQUE (email);

ALTER TABLE customers
    ADD CONSTRAINT unique_mobile_number
        UNIQUE (mobile_number);

CREATE TABLE account_types
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

ALTER TABLE account_types
    ADD CONSTRAINT unique_name
        UNIQUE (name);

CREATE TABLE accounts
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    login           VARCHAR(50) NOT NULL,
    password        VARCHAR(50) NOT NULL,
    account_type_id BIGINT      NOT NULL,
    customer_id     BIGINT      NOT NULL,
    created_at      DATETIME(6) NOT NULL,
    created_by      VARCHAR(8)  NOT NULL,
    updated_at      DATETIME(6) DEFAULT NULL,
    updated_by      VARCHAR(8)  DEFAULT NULL
);

ALTER TABLE accounts
    ADD CONSTRAINT fk_accounts_customers
        FOREIGN KEY (customer_id) REFERENCES customers (id);

ALTER TABLE accounts
    ADD CONSTRAINT fk_accounts_account_types
        FOREIGN KEY (account_type_id) REFERENCES account_types (id);

ALTER TABLE accounts
    ADD CONSTRAINT unique_customer_id_account_type_id
        UNIQUE (customer_id, account_type_id);

commit;