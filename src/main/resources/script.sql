CREATE TYPE user_role AS ENUM ('CLIENT', 'ADMIN');

CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       name VARCHAR(100),
                       email VARCHAR(100) UNIQUE,
                       password_hash VARCHAR(100),
                       role user_role
);

CREATE TABLE product (
                         product_id SERIAL PRIMARY KEY,
                         product_name VARCHAR(100),
                         description TEXT,
                         price NUMERIC(10, 2),
                         stock INT
);

CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id INT REFERENCES users(user_id),
                        order_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                        UNIQUE (user_id, order_date)
);

CREATE TABLE order_detail (
                              order_detail_id SERIAL PRIMARY KEY,
                              order_id INT REFERENCES orders(order_id),
                              product_id INT REFERENCES product(product_id),
                              quantity INT,
                              UNIQUE (order_id, product_id)
);
