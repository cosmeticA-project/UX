CREATE TABLE IF NOT EXISTS cart (
                                    cart_id bigserial NOT NULL,
                                    user_id bigint,
                                    PRIMARY KEY (cart_id),
                                    CONSTRAINT FKg5uhi8vpsuy0lgloxk2h4w5o6 FOREIGN KEY (user_id) REFERENCES users
);

CREATE TABLE IF NOT EXISTS cart_item (
                                         quantity integer NOT NULL,
                                         cart_id bigint,
                                         cart_item_id bigserial NOT NULL,
                                         product_id bigint,
                                         PRIMARY KEY (cart_item_id),
                                         CONSTRAINT FK1uobyhgl1wvgt1jpccia8xxs3 FOREIGN KEY (cart_id) REFERENCES cart,
                                         CONSTRAINT FKjcyd5wv4igqnw413rgxbfu4nv FOREIGN KEY (product_id) REFERENCES product
);

CREATE TABLE IF NOT EXISTS order_detail (
                                            quantity integer,
                                            order_detail_id bigserial NOT NULL,
                                            order_id bigint,
                                            product_id bigint,
                                            PRIMARY KEY (order_detail_id),
                                            CONSTRAINT FKrws2q0si6oyd6il8gqe2aennc FOREIGN KEY (order_id) REFERENCES orders,
                                            CONSTRAINT FKb8bg2bkty0oksa3wiq5mp5qnc FOREIGN KEY (product_id) REFERENCES product
);

CREATE TABLE IF NOT EXISTS orders (
                                      order_date timestamp(6),
                                      order_id bigserial NOT NULL,
                                      user_id bigint,
                                      address varchar(255),
                                      PRIMARY KEY (order_id),
                                      CONSTRAINT FK32ql8ubntj5uh44ph9659tiih FOREIGN KEY (user_id) REFERENCES users
);

CREATE TABLE IF NOT EXISTS product (
                                       price numeric(38,2),
                                       stock integer,
                                       product_id bigserial NOT NULL,
                                       description varchar(255),
                                       product_name varchar(255),
                                       PRIMARY KEY (product_id)
);

CREATE TABLE IF NOT EXISTS users (
                                     user_id bigserial NOT NULL,
                                     email varchar(255),
                                     name varchar(255),
                                     password_hash varchar(255),
                                     role varchar(255) CHECK (role in ('CLIENT','ADMIN')),
                                     PRIMARY KEY (user_id)
);
