CREATE TABLE loans (
  id bigint,
  number int NOT NULL,
  type varchar(255) NOT NULL,
  mobile_number int NOT NULL,
  money_loaned int NOT NULL,
  money_paid int NOT NULL DEFAULT 0,
  money_remaining int NOT NULL,
  created_at datetime(6) NOT NULL,
  created_by varchar(255) NOT NULL,
  updated_at datetime(6) DEFAULT NULL,
  updated_by varchar(255) DEFAULT NULL
);

ALTER TABLE loans
ADD CONSTRAINT pk_id
PRIMARY KEY (id);

ALTER TABLE loans
MODIFY id bigint AUTO_INCREMENT;

ALTER TABLE loans
ADD CONSTRAINT unique_number
UNIQUE (number);

ALTER TABLE loans
ADD CONSTRAINT unique_mobile_number
UNIQUE (mobile_number);

CREATE TRIGGER before_money_insert_on_loans
BEFORE INSERT ON loans
FOR EACH ROW
SET NEW.money_remaining = (NEW.money_loaned - NEW.money_paid);

CREATE TRIGGER before_money_update_on_loans
BEFORE UPDATE ON loans
FOR EACH ROW
SET NEW.money_remaining = (NEW.money_loaned - NEW.money_paid);

commit;