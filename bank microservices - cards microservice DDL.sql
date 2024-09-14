CREATE TABLE cards (
  id bigint,
  number bigint NOT NULL,
  type varchar(255) NOT NULL,
  mobile_number int NOT NULL,
  money_limit int NOT NULL,
  money_used int NOT NULL DEFAULT 0,
  money_available int NOT NULL,
  created_at datetime(6) NOT NULL,
  created_by varchar(255) NOT NULL,
  updated_at datetime(6) DEFAULT NULL,
  updated_by varchar(255) DEFAULT NULL
);

ALTER TABLE cards
ADD CONSTRAINT pk_id
PRIMARY KEY (id);

ALTER TABLE cards
MODIFY id bigint AUTO_INCREMENT;

ALTER TABLE cards
ADD CONSTRAINT unique_number
UNIQUE (number);

ALTER TABLE cards
ADD CONSTRAINT unique_mobile_number
UNIQUE (mobile_number);

CREATE TRIGGER before_money_insert_in_cards
BEFORE INSERT ON cards
FOR EACH ROW
SET 
new.money_available = (new.money_limit - new.money_used);

CREATE TRIGGER after_money_update_in_cards
BEFORE UPDATE ON cards
FOR EACH ROW
SET new.money_available = (new.money_limit - new.money_used);

commit;