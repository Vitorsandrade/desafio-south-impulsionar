CREATE TABLE tb_product (

    id SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    price NUMERIC NOT NULL,
    category VARCHAR(30) NOT NULL,
    amount INT DEFAULT (0),
    code varchar (8),
    bar_code varchar (12),
    series varchar (5),
    manufacturing_date date,
    expiration_date date,
    description varchar(200),
    color varchar (25),
    material varchar (25)
);