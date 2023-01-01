

CREATE TABLE Author(
                       `id_author` VARCHAR(20) NOT NULL,
                       `name` NVARCHAR(50),
                       `img` VARCHAR(200),
                       `information` text,
                       PRIMARY KEY(`id_author`)
);

CREATE TABLE Catalog(
                        `id_catalog` VARCHAR(20) NOT NULL,
                        `name` NVARCHAR(50),
                        `parent_id` VARCHAR(20),
                        PRIMARY KEY(`id_catalog`)
);


CREATE TABLE Publisher(
                          `id_p` VARCHAR(20) NOT NULL,
                          `name` VARCHAR(50),
                          PRIMARY KEY(`id_p`)
);


CREATE TABLE Publisher_company(
                                  `id_pc` VARCHAR(20) NOT NULL,
                                  `name` VARCHAR(50),
                                  PRIMARY KEY(`id_pc`)
);


CREATE TABLE Book(
                     `id_book` VARCHAR(20) NOT NULL,
                     `name` NVARCHAR(50),
                     `id_author` VARCHAR(20) NOT NULL,
                     `id_catalog` VARCHAR(20) NOT NULL,
                     `quantity` INT,
                     `prime_cost` DOUBLE,
                     `price` DOUBLE,
                     `discount_price` DOUBLE,
                     `isNew` BOOL,
                     `isActive` BOOL,
                     `id_pc` VARCHAR(20) NOT NULL,
                     `id_p` VARCHAR(20) NOT NULL,
                     `published_time` DATE,
                     `created` TIMESTAMP,
                     PRIMARY KEY(`id_book`),
                     FOREIGN KEY(`id_author`) REFERENCES Author(`id_author`),
                     FOREIGN KEY(`id_catalog`) REFERENCES Catalog(`id_catalog`),
                     FOREIGN KEY(`id_pc`) REFERENCES Publisher_company(`id_pc`),
                     FOREIGN KEY(`id_p`) REFERENCES Publisher(`id_p`)
);

CREATE TABLE Image_book(
                           `id_book` VARCHAR(20) NOT NULL PRIMARY KEY,
                           `image` VARCHAR(200)
);

CREATE TABLE Book_details(
                             `id_book` VARCHAR(20) NOT NULL PRIMARY KEY,
                             `year` INT,
                             `weight` DOUBLE,
                             `size` VARCHAR(20),
                             `page` INT,
                             `language` VARCHAR(10),
                             `description` TEXT,
                             FOREIGN KEY(`id_book`) REFERENCES Book(`id_book`)
);

CREATE TABLE Customer(
                         `id_user` VARCHAR(20) NOT NULL PRIMARY key,
                         `first_name` NVARCHAR(20),
                         `last_name` NVARCHAR(20),
                         `email` VARCHAR(30) NOT NULL,
                         `password` VARCHAR(30) NOT NULL,
                         `address` VARCHAR(30),
                         `phone` CHAR(10),
                         `role` VARCHAR(10),
                         `status` INT,
                         `created_time` TIMESTAMP
);

CREATE TABLE Transactions(
                             `id_transaction` VARCHAR(20) NOT NULL PRIMARY KEY,
                             `status` TEXT,
                             `id_user` VARCHAR(20) NOT NULL,
                             `name_customer` NVARCHAR(20),
                             `email_customer` VARCHAR(30),
                             `phone_customer` CHAR(10),
                             `quantity` INT,
                             `payment` NVARCHAR(20),
                             `payment_info` TEXT,
                             `messenger` TEXT,
                             `security` TEXT,
                             `created` TIMESTAMP,
                             FOREIGN KEY(`id_user`) REFERENCES Customer(`id_user`)
);

CREATE TABLE Discount(
                         `id_discount` VARCHAR(20) NOT NULL PRIMARY KEY,
                         `name` NVARCHAR(50),
                         `quantity` INT,
                         `percent_discount` VARCHAR(50),
                         `diktat` VARCHAR(50)
);

CREATE TABLE Bill(
                     `id_order` VARCHAR(20) NOT NULL PRIMARY key,
                     `id_user` VARCHAR(20) NOT NULL,
                     `shipping_info` TEXT,
                     `id_discount` VARCHAR(20) NOT NULL,
                     `ship_time` DATE,
                     `create_order_time` TIMESTAMP,
                     FOREIGN KEY(`id_user`) REFERENCES Customer(`id_user`),
                     FOREIGN KEY(`id_discount`) REFERENCES Discount(`id_discount`)
);

CREATE TABLE Rate(
                     `id_user` VARCHAR(20) NOT NULL,
                     `id_book` VARCHAR(20) NOT NULL,
                     `id_order` VARCHAR(20) NOT NULL,
                     `start_rate` INT,
                     `comment` TEXT,
                     `rate_time` TIMESTAMP,
                     PRIMARY KEY (`id_user`,`id_book`, `id_bill`),
                     FOREIGN KEY(`id_user`) REFERENCES Customer(`id_user`),
                     FOREIGN KEY(`id_book`) REFERENCES Book(`id_book`),
                     FOREIGN KEY(`id_order`) REFERENCES Bill(`id_order`)
)

CREATE TABLE Admin(
    `id_admin` VARCHAR(20) NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `username` VARCHAR(30) NOT NULL,
    `password` VARCHAR(30) NOT NULL
);

CREATE TABLE Slide_pr (
     `id_pr` VARCHAR(20) NOT NULL PRIMARY KEY,
    `name_pr` VARCHAR(50),
    `img` TEXT,
    `link` TEXT,
    `start_time` DATE,
    `finish_time` DATE,
    `create_time` TIMESTAMP
);


