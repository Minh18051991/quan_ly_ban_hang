CREATE DATABASE IF NOT EXISTS case_study_3;
USE case_study_3;

-- Create table Customer
CREATE TABLE customer
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(100) NOT NULL,
    address    VARCHAR(255),
    phone      VARCHAR(20),
    email      VARCHAR(100),
    is_deleted BOOLEAN DEFAULT FALSE
);

-- Create table Account
CREATE TABLE account
(
    id          INT AUTO_INCREMENT PRIMARY KEY,
    customer_id INT UNIQUE,
    username    VARCHAR(50) UNIQUE NOT NULL,
    password    VARCHAR(255)       NOT NULL,
    created_at  DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_deleted  BOOLEAN  DEFAULT FALSE,
    FOREIGN KEY (customer_id) REFERENCES customer (id)
);

-- Create table ProductCategory
CREATE TABLE product_category
(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL
);

-- Create table Product
CREATE TABLE product
(
    id                  INT AUTO_INCREMENT PRIMARY KEY,
    product_category_id INT,
    product_name        VARCHAR(100) NOT NULL,
    description         TEXT,
    price               DOUBLE       NOT NULL,
    image               TEXT,
    created_at          DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_deleted          BOOLEAN  DEFAULT FALSE,
    FOREIGN KEY (product_category_id) REFERENCES product_category (id)
);

-- Create table stock
CREATE TABLE stock
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    product_id INT,
    quantity   INT,
    created_at DATETIME DEFAULT CURRENT_TIMESTAMP,
    is_deleted BOOLEAN  DEFAULT FALSE,
    FOREIGN KEY (product_id) REFERENCES product (id)
);

-- Create table Order
CREATE TABLE order_bill
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status     BOOLEAN  DEFAULT FALSE,
    is_deleted BOOLEAN  DEFAULT FALSE,
    FOREIGN KEY (account_id) REFERENCES account (id)
);

-- Create table OrderDetails
CREATE TABLE order_details
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    order_id   INT,
    product_id INT,
    quantity   INT NOT NULL,
    FOREIGN KEY (order_id) REFERENCES order_bill (id),
    FOREIGN KEY (product_id) REFERENCES product (id)
);

-- Create table Role
CREATE TABLE role
(
    id   INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)
);

-- Create table Permissions
CREATE TABLE permissions
(
    id         INT PRIMARY KEY AUTO_INCREMENT,
    role_id    INT,
    account_id INT,
    FOREIGN KEY (role_id) REFERENCES role (id),
    FOREIGN KEY (account_id) REFERENCES account (id)
);
-- San Pham
INSERT INTO product_category (product_name)
VALUES ('Điện thoại'),
       ('Laptop'),
       ('Máy tính bảng');
INSERT INTO product (product_category_id, product_name, description, price, image, created_at)
VALUES (1, 'Iphone 12 Pro Max', 'iPhone 12 Pro Max là thiết bị điện thoại với chip A14 Bionic', 12000000,
        'https://cdn.tgdd.vn/Products/Images/42/213031/iphone-12-xanh-la-1-1-750x500.jpg', '2012/12/12'),
       (2, 'Macbook Pro 16', 'Macbook Pro 16 2020 là laptop cao cấp với chip M1', 28000000,
        'https://cdn.tgdd.vn/Products/Images/44/325306/apple-macbook-air-m2-2022-16gb-256gb-10gpu-2-750x500.jpg',
        '2022/01/01'),
       (2, 'Macbook Pro 16 PRO', 'Macbook Pro 16 2020 là laptop cao cấp với chip M1 HANG 99%', 22000000,
        'https://cdn.tgdd.vn/Products/Images/44/325306/apple-macbook-air-m2-2022-16gb-256gb-10gpu-2-750x500.jpg',
        '2022/01/01'),
       (3, 'IPAD 9', ' WiFi 64GB', 6400000,
        'https://cdn.tgdd.vn/Products/Images/522/247517/ipad-9-wifi-trang-1-750x500.jpg', '2022/01/01'),
       (3, 'IPAD 11', 'WiFi 512GB', 9000000,
        'https://cdn.tgdd.vn/Products/Images/522/325534/ipad-pro-13-inch-m4-lte-sliver-1-750x500.jpg', '2022/01/01'),
       (1, 'XIAOMI 11', '14C 6GB/128GB', 12400000,
        'https://cdnv2.tgdd.vn/mwg-static/tgdd/Products/Images/42/329008/redmi-14c-xanh-duong-1-638618466993077110-750x500.jpg',
        '2022/01/01')
;
-- Kho
INSERT INTO stock(product_id, quantity)
VALUES (1, 2),
       (1, 4),
       (2, 3),
       (4, 1),
       (4, 5),
       (3, 1),
       (1, 9),
       (5, 5),
       (6, 4)
;
-- Chức Năng
INSERT INTO role (name)
VALUES ('Admin'),
       ('User')
;
-- Khách Hàng
INSERT INTO customer (name, address, phone, email)
VALUES ('Đặng Hữu Hải Minh', '245 Thanh Sơn', '0774524480', 'minhdhh91@gmail.com'),
       ('Nguyen Van A', '123, Hai Ba Trung', '0987654321', 'nguyenvana@gmail.com'),
       ('Nguyen Van B', '456, Hai Ba Trung', '0912345678', 'nguyenvanb@gmail.com'),
       ('Nguyen Van C', '789, Hai Ba Trung', '0998765432', 'nguyenvanc@gmail.com'),
       ('Nguyen Van D', '123, Hai Ba Trung', '0932165478', 'nguyenvand@gmail.com');
-- Tài Khoản
INSERT INTO account (customer_id, username, password)
VALUES (1, 'admin123', '123456'),
       (2, 'usera', 'usera'),
       (3, 'userb', 'userb'),
       (4, 'userc', 'userc'),
       (5, 'userd', 'userd');
-- Phân Quyền
INSERT INTO permissions (role_id, account_id)
VALUES (1, 1),
       (2, 1),
       (2, 2),
       (2, 3),
       (2, 4),
       (2, 5);
-- Đơn Hàng
INSERT INTO order_bill (account_id)
VALUES (2),
       (3),
       (4),
       (5);
-- Chi Tiết Đơn Hàng
INSERT INTO order_details (order_id, product_id, quantity)
VALUES (1, 1, 2),
       (1, 3, 1),
       (2, 2, 3),
       (2, 4, 2),
       (3, 5, 1),
       (4, 6, 5);







