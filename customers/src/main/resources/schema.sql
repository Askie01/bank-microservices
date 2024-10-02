CREATE TABLE countries
(
    id         BIGINT PRIMARY KEY AUTO_INCREMENT,
    name       VARCHAR(100) NOT NULL,
    created_at DATETIME     NOT NULL,
    created_by VARCHAR(20)  NOT NULL,
    updated_at DATETIME    DEFAULT NULL,
    updated_by VARCHAR(20) DEFAULT NULL
);

ALTER TABLE countries
    ADD CONSTRAINT unique_name
        UNIQUE (name);

CREATE TABLE customers
(
    id            BIGINT PRIMARY KEY AUTO_INCREMENT,
    first_name    VARCHAR(50)  NOT NULL,
    last_name     VARCHAR(50)  NOT NULL,
    birthdate     DATETIME     NOT NULL,
    email         VARCHAR(255) NOT NULL,
    mobile_number VARCHAR(20)  NOT NULL,
    country_id    BIGINT       NOT NULL,
    created_at    DATETIME     NOT NULL,
    created_by    VARCHAR(20)  NOT NULL,
    updated_at    DATETIME    DEFAULT NULL,
    updated_by    VARCHAR(20) DEFAULT NULL
);

ALTER TABLE customers
    ADD CONSTRAINT unique_email
        UNIQUE (email);

ALTER TABLE customers
    ADD CONSTRAINT unique_mobile_number
        UNIQUE (mobile_number);

ALTER TABLE customers
    ADD CONSTRAINT fk_customers_countries
        FOREIGN KEY (country_id) references countries (id);