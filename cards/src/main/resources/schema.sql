CREATE TABLE card_types
(
    id   BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

ALTER TABLE card_types
    ADD CONSTRAINT unique_name
        UNIQUE (name);

CREATE TABLE cards
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    card_number     BIGINT         NOT NULL,
    card_type_id    INTEGER        NOT NULL,
    mobile_number   VARCHAR(20)    NOT NULL,
    money_limit     DECIMAL(10, 2) NOT NULL,
    money_used      DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    money_available DECIMAL(10, 2) NOT NULL,
    created_at      DATETIME(6)    NOT NULL,
    created_by      VARCHAR(8)     NOT NULL,
    updated_at      DATETIME(6)             DEFAULT NULL,
    updated_by      VARCHAR(8)              DEFAULT NULL
);

ALTER TABLE cards
    ADD CONSTRAINT unique_number
        UNIQUE (card_number);

ALTER TABLE cards
    ADD CONSTRAINT unique_mobile_number
        UNIQUE (mobile_number);

ALTER TABLE cards
    ADD CONSTRAINT fk_cards_card_types
        FOREIGN KEY cards (card_type_id) REFERENCES card_types (id);

CREATE TRIGGER generate_card_number_before_insert_on_cards
    BEFORE INSERT
    ON cards
    FOR EACH ROW
BEGIN
    IF NEW.card_number IS NULL THEN
        SET NEW.card_number = FLOOR(1000000000000000 + RAND() * 9000000000000000);
    END IF;
END;

CREATE TRIGGER check_money_used_before_insert_on_cards
    BEFORE INSERT
    ON cards
    FOR EACH ROW
BEGIN
    IF NEW.money_used IS NULL THEN
        SET NEW.money_used = 0;
    END IF;
END;

CREATE TRIGGER set_money_available_before_insert_on_cards
    BEFORE INSERT
    ON cards
    FOR EACH ROW
    SET new.money_available = NEW.money_limit;

CREATE TRIGGER check_money_limit_before_update_on_cards
    BEFORE UPDATE
    ON cards
    FOR EACH ROW
BEGIN
    IF NEW.money_limit IS NULL THEN
        SET NEW.money_limit = OLD.money_limit;
    END IF;
END;

CREATE TRIGGER check_money_used_before_update_on_cards
    BEFORE UPDATE
    ON cards
    FOR EACH ROW
BEGIN
    IF NEW.money_used IS NULL THEN
        SET NEW.money_used = OLD.money_used;
    END IF;
END;

CREATE TRIGGER calculate_money_available_before_update_on_cards
    BEFORE UPDATE
    ON cards
    FOR EACH ROW
    SET NEW.money_available = (NEW.money_limit - NEW.money_used);