CREATE TABLE user (
                        iduser int NOT NULL AUTO_INCREMENT,
                        name varchar(45) NOT NULL,
                        lastname varchar(45) NOT NULL,
                        userName varchar(45) NOT NULL,
                        password varchar(100) NOT NULL,
                        PRIMARY KEY (iduser)
);

CREATE TABLE subscription (
                                idsubscription int NOT NULL AUTO_INCREMENT,
                                start_date datetime NOT NULL,
                                finish_date datetime NOT NULL,
                                PRIMARY KEY (idsubscription)
);

CREATE TABLE subscription_user (
                                     id_user int NOT NULL,
                                     id_subscription int NOT NULL,
                                     PRIMARY KEY (id_user,id_subscription),
                                     CONSTRAINT fk_subscription_user_1 FOREIGN KEY (id_user) REFERENCES user (iduser),
                                     CONSTRAINT fk_subscription_user_2 FOREIGN KEY (id_subscription) REFERENCES subscription (idsubscription)
);

CREATE TABLE store (
                         idstore int NOT NULL AUTO_INCREMENT,
                         name varchar(45) NOT NULL,
                         nit varchar(45) NOT NULL,
                         owner int NOT NULL,
                         PRIMARY KEY (idstore),
                         CONSTRAINT fk_store_1 FOREIGN KEY (owner) REFERENCES user (iduser)
);

CREATE TABLE inventory (
                             idinventory int NOT NULL AUTO_INCREMENT,
                             idstore int NOT NULL,
                             PRIMARY KEY (idinventory),
                             CONSTRAINT fk_inventory_1 FOREIGN KEY (idstore) REFERENCES store (idstore)
);

CREATE TABLE stock (
                         idstock int NOT NULL AUTO_INCREMENT,
                         price float NOT NULL,
                         quantity float NOT NULL,
                         idinventory int NOT NULL,
                         PRIMARY KEY (idstock),
                         CONSTRAINT fk_stock_1 FOREIGN KEY (idinventory) REFERENCES inventory (idinventory)
);

CREATE TABLE product (
                           idproduct int NOT NULL AUTO_INCREMENT,
                           name varchar(45) NOT NULL,
                           code varchar(45) NOT NULL,
                           description varchar(100) DEFAULT NULL,
                           idstock int NOT NULL,
                           PRIMARY KEY (idproduct),
                           CONSTRAINT fk_product_1 FOREIGN KEY (idstock) REFERENCES stock (idstock)
);

CREATE TABLE purchase_order (
                         idorder int NOT NULL AUTO_INCREMENT,
                         date_order datetime NOT NULL,
                         id_inventory int NOT NULL,
                         PRIMARY KEY (idorder),
                         CONSTRAINT fk_order_1 FOREIGN KEY (id_inventory) REFERENCES inventory (idinventory)
);

CREATE TABLE order_product (
                                 idorder int NOT NULL,
                                 idproduct int NOT NULL,
                                 price float NOT NULL,
                                 quantity float NOT NULL,
                                 CONSTRAINT fk_order_product_1 FOREIGN KEY (idorder) REFERENCES purchase_order (idorder),
                                 CONSTRAINT fk_order_product_2 FOREIGN KEY (idproduct) REFERENCES product (idproduct)
);
