CREATE TABLE IF NOT EXISTS tb_product
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(60),
    price NUMERIC,
    category VARCHAR,
    amount INT,
    code varchar,
    bar_code varchar,
    series varchar,
    manufacturing_date date,
    expiration_date date,
    description varchar(200),
    color varchar,
    material varchar
);
