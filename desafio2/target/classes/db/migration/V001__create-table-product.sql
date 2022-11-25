CREATE TABLE tb_product (

    id SERIAL PRIMARY KEY,
    name VARCHAR(60),
    price NUMERIC,
    category VARCHAR(30),
    amount INT DEFAULT (0),
    code varchar (10),
    bar_code varchar (15),
    series varchar (8),
    manufacturing_date date,
    expiration_date date,
    description varchar(200),
    color varchar (25),
    material varchar (25)
);