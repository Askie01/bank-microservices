CREATE TABLE loan_types
(
    id   INTEGER PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(20) NOT NULL
);

ALTER TABLE loan_types
    ADD CONSTRAINT unique_name
        UNIQUE (name);

CREATE TABLE loans
(
    id              BIGINT PRIMARY KEY AUTO_INCREMENT,
    loan_number     INTEGER        NOT NULL,
    loan_type_id    INTEGER        NOT NULL,
    mobile_number   VARCHAR(20)    NOT NULL,
    money_loaned    DECIMAL(10, 2) NOT NULL,
    money_paid      DECIMAL(10, 2) NOT NULL DEFAULT 0.00,
    money_remaining DECIMAL(10, 2) NOT NULL,
    created_at      DATETIME(6)    NOT NULL,
    created_by      VARCHAR(8)     NOT NULL,
    updated_at      DATETIME(6)             DEFAULT NULL,
    updated_by      VARCHAR(8)              DEFAULT NULL
);

ALTER TABLE loans
    ADD CONSTRAINT unique_number
        UNIQUE (loan_number);

ALTER TABLE loans
    ADD CONSTRAINT unique_mobile_number
        UNIQUE (mobile_number);

ALTER TABLE loans
    ADD CONSTRAINT fk_loans_loan_types
        FOREIGN KEY Loans (loan_type_id) REFERENCES loan_types (id);

CREATE TRIGGER generate_loan_number_before_insert_on_loans
    BEFORE INSERT
    ON loans
    FOR EACH ROW
BEGIN
    IF NEW.loan_number IS NULL THEN
        SET NEW.loan_number = FLOOR(100000000 + RAND() * 900000000);
    end if;
end;

CREATE TRIGGER check_money_paid_before_insert_on_loans
    BEFORE INSERT
    ON loans
    FOR EACH ROW
BEGIN
    IF NEW.money_paid IS NULL THEN
        SET NEW.money_paid = 0;
    end if;
end;

CREATE TRIGGER set_money_remaining_before_insert_on_loans
    BEFORE INSERT
    ON loans
    FOR EACH ROW
    SET NEW.money_remaining = NEW.money_loaned;

CREATE TRIGGER check_money_loaned_before_update_on_loans
    BEFORE UPDATE
    ON loans
    FOR EACH ROW
BEGIN
    IF NEW.money_loaned IS NULL THEN
        SET NEW.money_loaned = OLD.money_loaned;
    end if;
end;

CREATE TRIGGER check_money_paid_before_update_on_loans
    BEFORE UPDATE
    ON loans
    FOR EACH ROW
BEGIN
    IF NEW.money_paid IS NULL THEN
        SET NEW.money_paid = OLD.money_paid;
    end if;
end;

CREATE TRIGGER calculate_money_remaining_before_update_on_loans
    BEFORE UPDATE
    ON loans
    FOR EACH ROW
    SET NEW.money_remaining = (NEW.money_loaned - NEW.money_paid);