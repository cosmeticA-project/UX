CREATE TABLE users (
                       user_id BIGSERIAL NOT NULL PRIMARY KEY,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       password_hash VARCHAR(255),
                       role VARCHAR(255) CHECK (role IN ('CLIENT', 'ADMIN'))
);

CREATE TABLE orders (
                        order_id BIGSERIAL NOT NULL PRIMARY KEY,
                        order_date TIMESTAMP(6),
                        user_id BIGINT,
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE product (
                         product_id BIGSERIAL NOT NULL PRIMARY KEY,
                         product_name VARCHAR(255),
                         description VARCHAR(255),
                         price NUMERIC(38,2),
                         stock INTEGER
);

CREATE TABLE order_detail (
                              order_detail_id BIGSERIAL NOT NULL PRIMARY KEY,
                              quantity INTEGER,
                              order_id BIGINT,
                              product_id BIGINT,
                              FOREIGN KEY (order_id) REFERENCES orders(order_id),
                              FOREIGN KEY (product_id) REFERENCES product(product_id)
);
