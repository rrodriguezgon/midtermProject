-- DELETE DATA

DELETE FROM admin;

DELETE FROM account_holder;

DELETE FROM third_party;

DELETE FROM ROLE;

DELETE FROM credit_card_account;

DELETE FROM checking_account;

DELETE FROM student_checking_account;

DELETE FROM savings_account;

DELETE FROM account_key;

DELETE FROM TRANSFER;

DELETE FROM account;

DELETE FROM user;

-- CREATE DATA

-- Admin user
INSERT INTO user VALUES
(1,"$2a$10$idXLlnGkrVH8zPP9PoSAJe8UnikHBUGqGP4by446ChsS5exPEdp4q","admin");
INSERT INTO admin VALUES (1);
INSERT INTO role (role, user_id) VALUES
("ROLE_ADMIN", 1);

-- credit card Holder + credit card Account
INSERT INTO user (id, username, password) VALUES
(2,'creditHolder','');
INSERT INTO account_holder (birthday, first_name,last_name,	mailing_address,city,country,number,street,id) VALUES
('1992-02-15','Kiowa','Ugalde Villamarin','mailingAddress','city','country','number','street',2);
INSERT INTO role (role, user_id) VALUES
("ROLE_HOLDER", 2);
INSERT INTO account VALUES
(1,	'40.00','1435.00','USD','2020-06-25','40.00','2020-06-25',2,null);
INSERT INTO credit_card_account VALUES
('100','0.2','120','0.3',1);

-- checking holder + checking Account
INSERT INTO user (id, username, password) VALUES
(3,'checkingHolder','');
INSERT INTO account_holder (birthday, first_name,last_name,	mailing_address,city,country,number,street,id) VALUES
('1992-02-15','Candela','Melcon Barrenechea','mailingAddress','city','country','number','street',3);
INSERT INTO role (role, user_id) VALUES
("ROLE_HOLDER", 3);
INSERT INTO account VALUES
(2,	'40.00','1435.00','USD','2020-06-25','40.00','2020-06-25',3,null);
INSERT INTO account_key VALUES
(1000,1,2);
INSERT INTO checking_account VALUES
('250.00',12,'250.00',12,2);

-- student holder + Student Checking Account
INSERT INTO user (id, username, password) VALUES
(4,'studentHolder','');
INSERT INTO account_holder (birthday, first_name,last_name,	mailing_address,city,country,number,street,id) VALUES
('1999-02-15','Nuria','Barral Meleon','mailingAddress','city','country','number','street',4);
INSERT INTO role (role, user_id) VALUES
("ROLE_HOLDER", 4);
INSERT INTO account VALUES
(3,	'40.00','1435.00','USD','2020-06-25','40.00','2020-06-25',4,3);
INSERT INTO account_key VALUES
(1000,1,3);
INSERT INTO student_checking_account VALUES
(3);

-- saving holder + saving Account
INSERT INTO user (id, username, password) VALUES
(5,'savingHolder','');
INSERT INTO account_holder (birthday, first_name,last_name,	mailing_address,city,country,number,street,id) VALUES
('1992-02-15','Andoni','Iturralde Cantabrana','mailingAddress','city','country','number','street',5);
INSERT INTO role (role, user_id) VALUES
("ROLE_HOLDER", 5);
INSERT INTO account VALUES
(4,	'40.00','1435.00','USD','2020-06-25','40.00','2020-06-25',5,null);
INSERT INTO account_key VALUES
(1000,1,4);
INSERT INTO savings_account VALUES
('0.0025','0.0025','1000',4);

-- Transactions
INSERT INTO transfer VALUES
(1,'500.00','2020-06-23 11:33:01.895000',1,1,2),
(2,'500.00','2020-06-23 11:33:01.895000',1,1,3),
(3,'500.00','2020-06-23 11:33:01.895000',1,1,4),
(4,'500.00','2020-06-23 11:33:01.895000',1,1,4),
(5,'500.00','2020-06-23 11:33:01.895000',1,2,1),
(6,'500.00','2020-06-23 11:33:01.895000',1,2,2),
(7,'500.00','2020-06-23 11:33:01.895000',1,2,3),
(8,'500.00','2020-06-23 11:33:01.895000',1,2,4),
(9,'500.00','2020-06-23 11:33:01.895000',1,2,4);

INSERT INTO transfer VALUES
(10,'500.00','2020-06-23 11:33:01.895000',1,null,2),
(11,'500.00','2020-06-23 11:33:01.895000',1,1,null),
(12,'500.00','2020-06-23 11:33:01.895000',1,null,4),
(13,'500.00','2020-06-23 11:33:01.895000',1,2,null),
(14,'500.00','2020-06-23 11:33:01.895000',1,null,1),
(15,'500.00','2020-06-23 11:33:01.895000',1,3,null),
(16,'500.00','2020-06-23 11:33:01.895000',1,null,3),
(17,'500.00','2020-06-23 11:33:01.895000',1,4,null),
(18,'500.00','2020-06-23 11:33:01.895000',1,null,4);