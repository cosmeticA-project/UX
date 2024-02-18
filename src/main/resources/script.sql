-- Table pour les utilisateurs
CREATE TABLE users (
                       user_id BIGSERIAL NOT NULL PRIMARY KEY,
                       email VARCHAR(255),
                       name VARCHAR(255),
                       password_hash VARCHAR(255),
                       role VARCHAR(255) CHECK (role IN ('CLIENT', 'ADMIN'))
);

-- Table pour les commandes
CREATE TABLE orders (
                        order_id BIGSERIAL NOT NULL PRIMARY KEY,
                        order_date TIMESTAMP(6),
                        user_id BIGINT,
                        address VARCHAR(255),
                        FOREIGN KEY (user_id) REFERENCES users(user_id)
);

-- Table pour les produits
CREATE TABLE product (
                         product_id BIGSERIAL NOT NULL PRIMARY KEY,
                         product_name VARCHAR(255),
                         description VARCHAR(255),
                         price NUMERIC(38,2),
                         stock INTEGER
);

-- Table pour les détails de commande
CREATE TABLE order_detail (
                              order_detail_id BIGSERIAL NOT NULL PRIMARY KEY,
                              quantity INTEGER,
                              order_id BIGINT,
                              product_id BIGINT,
                              FOREIGN KEY (order_id) REFERENCES orders(order_id),
                              FOREIGN KEY (product_id) REFERENCES product(product_id)
);

CREATE TABLE Cart (
                      cart_id SERIAL PRIMARY KEY,
                      user_id INT,
                      FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE CartItem (
                          cart_item_id SERIAL PRIMARY KEY,
                          cart_id INT,
                          product_id INT,
                          quantity INT,
                          FOREIGN KEY (cart_id) REFERENCES Cart(cart_id),
                          FOREIGN KEY (product_id) REFERENCES Product(product_id)
);
