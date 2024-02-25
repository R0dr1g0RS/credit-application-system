CREATE TABLE credit
(
    id                    BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    credit_code           UUID                                    NOT NULL,
    credit_value          DECIMAL                                 NOT NULL,
    day_first_installment date                                    NOT NULL,
    number_of_instalments INT                                     NOT NULL,
    status                SMALLINT,
    customer_id           BIGINT,
    CONSTRAINT pk_credit PRIMARY KEY (id)
);

ALTER TABLE credit
    ADD CONSTRAINT uc_credit_credit_code UNIQUE (credit_code);

ALTER TABLE credit
    ADD CONSTRAINT FK_CREDIT_ON_CUSTOMER FOREIGN KEY (customer_id) REFERENCES customer (id);