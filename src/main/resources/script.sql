CREATE TABLE users (
                       user_id SERIAL PRIMARY KEY,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       password_hash VARCHAR(255),
                       role VARCHAR(255) CHECK (role IN ('CLIENT', 'ADMIN'))
);

CREATE TABLE product (
                         product_id SERIAL PRIMARY KEY,
                         product_name VARCHAR(255),
                         description VARCHAR(255),
                         price NUMERIC(38,2),
                         stock INTEGER
);


CREATE TABLE orders (
                        order_id SERIAL PRIMARY KEY,
                        user_id BIGINT REFERENCES users,
                        order_date TIMESTAMP,
                        address VARCHAR(255)
);


CREATE TABLE cart (
                      cart_id SERIAL PRIMARY KEY,
                      user_id BIGINT REFERENCES users
);

CREATE TABLE cart_item (
                           cart_item_id SERIAL PRIMARY KEY,
                           cart_id BIGINT REFERENCES cart,
                           product_id BIGINT REFERENCES product,
                           quantity INTEGER NOT NULL
);

CREATE TABLE order_detail (
                              order_detail_id SERIAL PRIMARY KEY,
                              order_id BIGINT REFERENCES orders,
                              product_id BIGINT REFERENCES product,
                              quantity INTEGER NOT NULL
);




