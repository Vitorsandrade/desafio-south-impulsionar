CREATE TABLE product (

    id SERIAL PRIMARY KEY,
    name VARCHAR(60) NOT NULL,
    price NUMERIC NOT NULL,
    category VARCHAR(30) NOT NULL,
    amount INT DEFAULT (0)
);
