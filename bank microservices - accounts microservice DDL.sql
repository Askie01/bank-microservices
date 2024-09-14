CREATE TABLE customers (
  id bigint,
  name varchar(255) DEFAULT NULL,
  email varchar(255) NOT NULL,
  mobile_number varchar(255) NOT NULL,
  created_at datetime(6) NOT NULL,
  created_by varchar(255) NOT NULL,
  updated_at datetime(6) DEFAULT NULL,
  updated_by varchar(255) DEFAULT NULL
);

ALTER TABLE customers
ADD CONSTRAINT pk_id 
PRIMARY KEY (id);

ALTER TABLE customers
MODIFY id bigint AUTO_INCREMENT;

CREATE TABLE accounts (
  id bigint,
  type varchar(255) NOT NULL,
  address varchar(255) NOT NULL,
  customer_id bigint NOT NULL,
  created_at datetime(6) NOT NULL,
  created_by varchar(255) NOT NULL,
  updated_at datetime(6) DEFAULT NULL,
  updated_by varchar(255) DEFAULT NULL
);

ALTER TABLE accounts
ADD CONSTRAINT pk_id
PRIMARY KEY (id);

ALTER TABLE accounts
MODIFY id bigint AUTO_INCREMENT;

ALTER TABLE accounts
ADD CONSTRAINT unique_customer_id
UNIQUE(customer_id);

ALTER TABLE accounts
ADD CONSTRAINT fk_customer_id
FOREIGN KEY (customer_id) REFERENCES customers(id);

commit;