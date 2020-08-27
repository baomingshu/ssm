CREATE DATABASE  IF NOT EXISTS `test` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `test`;

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
DROP TABLE IF EXISTS customer_service;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE customer_service (
  id int(11) auto_increment NOT NULL,
  customerName varchar(50) NOT NULL,
  customerNum varchar(50) DEFAULT NULL,
  phoneNum varchar(50) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY customerName (customerName)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO customer_service VALUES (1,'气球','1','13344444444',1);
INSERT INTO customer_service VALUES (2,'我我','1','13344444444',1);
INSERT INTO customer_service VALUES (3,'嗯嗯','1','13344444444',1);
INSERT INTO customer_service VALUES (4,'软软','1','13344444444',1);
INSERT INTO customer_service VALUES (5,'天天','1','13344444444',1);
INSERT INTO customer_service VALUES (6,'亿元','1','13344444444',1);
DROP TABLE IF EXISTS member;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE member (
  id int(11) auto_increment NOT NULL,
  `NAME` varchar(50) DEFAULT NULL,
  nickname varchar(50) DEFAULT NULL,
  phoneNum varchar(50) DEFAULT NULL,
  email varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO member VALUES (1,'张三','小三','18888888888','zs@163.com');

DROP TABLE IF EXISTS orders;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE orders (
  id int(11) auto_increment NOT NULL,
  orderNum varchar(50) NOT NULL,
  orderTime timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  peopleCount int(11) DEFAULT NULL,
  orderDesc varchar(500) DEFAULT NULL,
  payType int(11) DEFAULT NULL,
  orderStatus int(11) DEFAULT NULL,
  productId int(11) DEFAULT NULL,
  memberId int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY orderNum (orderNum),
  KEY productId (productId),
  KEY memberId (memberId),
  CONSTRAINT orders_ibfk_1 FOREIGN KEY (productId) REFERENCES product (id),
  CONSTRAINT orders_ibfk_2 FOREIGN KEY (memberId) REFERENCES member (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO orders VALUES (1,'12345','2020-08-23 15:05:22',2,'没什么',1,1,1,1);
INSERT INTO orders VALUES (2,'54321','2018-02-03 12:00:00',2,'没什么',0,1,2,1);
INSERT INTO orders VALUES (3,'67890','2020-08-23 15:05:22',2,'没什么',2,1,3,1);
INSERT INTO orders VALUES (4,'98765','2020-08-23 15:05:22',2,'没什么',1,1,4,1);
INSERT INTO orders VALUES (5,'11111','2020-08-23 15:05:22',2,'没什么',2,1,1,1);
INSERT INTO orders VALUES (6,'22222','2018-02-03 12:00:00',2,'没什么',0,1,2,1);
INSERT INTO orders VALUES (7,'33333','2020-08-23 15:05:22',2,'没什么',1,1,3,1);
INSERT INTO orders VALUES (8,'44444','2020-08-23 15:05:22',2,'没什么',1,1,4,1);
INSERT INTO orders VALUES (9,'55555','2020-08-23 15:05:22',2,'没什么',2,1,4,1);
DROP TABLE IF EXISTS traveller;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE traveller (
  id int(11) auto_increment NOT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  sex varchar(20) DEFAULT NULL,
  phoneNum varchar(20) DEFAULT NULL,
  credentialsType int(11) DEFAULT NULL,
  credentialsNum varchar(50) DEFAULT NULL,
  travellerType int(11) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO traveller VALUES (1,'张龙','男','13333333333',0,'123456789009876543',0);
INSERT INTO traveller VALUES (2,'张小龙','男','15555555555',0,'987654321123456789',1);
DROP TABLE IF EXISTS order_traveller;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE order_traveller (
  orderId int(11) auto_increment NOT NULL DEFAULT '0',
  travellerId int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (orderId,travellerId),
  KEY travellerId (travellerId),
  CONSTRAINT order_traveller_ibfk_1 FOREIGN KEY (orderId) REFERENCES `orders` (id),
  CONSTRAINT order_traveller_ibfk_2 FOREIGN KEY (travellerId) REFERENCES traveller (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO order_traveller VALUES (1,1);
INSERT INTO order_traveller VALUES (2,1);
INSERT INTO order_traveller VALUES (5,1);
INSERT INTO order_traveller VALUES (7,1);
INSERT INTO order_traveller VALUES (3,2);
INSERT INTO order_traveller VALUES (4,2);
INSERT INTO order_traveller VALUES (6,2);
INSERT INTO order_traveller VALUES (8,2);
INSERT INTO order_traveller VALUES (9,2);
DROP TABLE IF EXISTS permission;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE permission (
  id int(11) auto_increment NOT NULL,
  permissionName varchar(50) DEFAULT NULL,
  url varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO permission VALUES (1,'user findAll','/user/findAll.do');
INSERT INTO permission VALUES (2,'user findById','/user/findById.do');
INSERT INTO permission VALUES (3,'user save','/user/save.do');
DROP TABLE IF EXISTS product;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE product (
  id int(11) auto_increment NOT NULL,
  productnum varchar(50) NOT NULL,
  productname varchar(50) DEFAULT NULL,
  cityname varchar(50) DEFAULT NULL,
  departuretime varchar(50) DEFAULT NULL,
  productprice int(11) DEFAULT NULL,
  productdesc varchar(500) DEFAULT NULL,
  productstatus int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY product (id,productnum)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO product VALUES (1,'itcast-002','北京三日游','北京','2018-10-10 10:10:00',1200,'不错的旅行',1);
INSERT INTO product VALUES (2,'itcast-003','上海五日游','上海','2020-08-19 16:04:36',1800,'魔都我来了',0);
INSERT INTO product VALUES (3,'itcast-001','北京三日游','北京','2018-10-10 10:10:00',1200,'不错的旅行',1);
INSERT INTO product VALUES (4,'itcast-004','南平半年游','哈尔滨','2019-12-29 18:45:00',10,'好',1);
DROP TABLE IF EXISTS role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE role (
  id int(11) auto_increment NOT NULL,
  roleName varchar(50) DEFAULT NULL,
  roleDesc varchar(50) DEFAULT NULL,
  PRIMARY KEY (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO role VALUES (1111,'ADMIN','vip');
INSERT INTO role VALUES (2222,'USER','vip');
INSERT INTO role VALUES (3333,'user','vip');
INSERT INTO role VALUES (4444,'user','vip');
INSERT INTO role VALUES (5555,'user','vip');
INSERT INTO role VALUES (6666,'user','vip');
INSERT INTO role VALUES (7777,'user','vip');
INSERT INTO role VALUES (7778,'test','测试能否添加');
DROP TABLE IF EXISTS role_permission;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE role_permission (
  permissionId int(11) NOT NULL DEFAULT '0',
  roleId int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (permissionId,roleId),
  KEY roleId (roleId),
  CONSTRAINT role_permission_ibfk_1 FOREIGN KEY (permissionId) REFERENCES permission (id),
  CONSTRAINT role_permission_ibfk_2 FOREIGN KEY (roleId) REFERENCES role (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO role_permission VALUES (1,1111);
INSERT INTO role_permission VALUES (2,1111);
INSERT INTO role_permission VALUES (1,2222);

DROP TABLE IF EXISTS users;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE users (
  id int(11) auto_increment NOT NULL,
  email varchar(50) NOT NULL,
  username varchar(50) DEFAULT NULL,
  `PASSWORD` varchar(300) DEFAULT NULL,
  phoneNum varchar(20) DEFAULT NULL,
  `STATUS` int(11) DEFAULT NULL,
  PRIMARY KEY (id),
  UNIQUE KEY email (email)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO users VALUES (111,'tom@itcast.cn','tom','$2a$10$tJHudmJh6MRPdiL7mv0yfe0nZJbDHuhl7sSTnqNC4DauMik9ppi4K','13333333333',1);
INSERT INTO users VALUES (112,'tom@itcast2.cn','tom2','$2a$10$tDibKbrN9JAUpkRaO4WCvOYprUC7viexg1CNEsSNpr9kq/V9jRMOy','13333333333',1);
INSERT INTO users VALUES (113,'tom@itcast3.cn','tom3','$2a$10$7x0.7jv6WZrtE10g2EQcI.gtEef6NoYK0x1mYHaxC/tsnmjaE5z46','13333333333',0);
INSERT INTO users VALUES (114,'tom@itcast4.cn','tom4','$2a$10$Sh3EdpMLqObz3GoYO/W2LO.W79vBHQD/qMc.I9XW00e0XePgw6e7y','13333333333',1);
INSERT INTO users VALUES (115,'tom@itcast5.cn','tom5','$2a$10$vWBMdToofC1B1/7HpG6MSeIAUSiDlVtCP4Qlz6IscnV3ghNUqQKQa','13333333333',1);
INSERT INTO users VALUES (116,'tom@itcast6.cn','tom6','$2a$10$pBpR0fkHMjalZQQYp/pNXONy6s4RUeVGb97zIJ8pt./uSvzLMLwMS','13333333333',1);
INSERT INTO users VALUES (117,'tom@itcast7.cn','tom7','$2a$10$lwgvf4wE5XGGbgE18Vy6be3os9AtrJp5P5c0gXU1gnfv05RmutoYm','13333333333',1);
INSERT INTO users VALUES (118,'tom@itcast8.cn','tom8','$2a$10$tCvF7Yldt/VHABzjoXxgi.mksqHYCUnw9C2uGy45kAyu9694ldlge','13333333333',1);
DROP TABLE IF EXISTS users_role;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE users_role (
  userId int(11) NOT NULL DEFAULT '0',
  roleId int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (userId,roleId),
  KEY roleId (roleId),
  CONSTRAINT users_role_ibfk_1 FOREIGN KEY (userId) REFERENCES `users` (id),
  CONSTRAINT users_role_ibfk_2 FOREIGN KEY (roleId) REFERENCES role (id)
);
/*!40101 SET character_set_client = @saved_cs_client */;

INSERT INTO users_role VALUES (111,1111);
INSERT INTO users_role VALUES (112,2222);
INSERT INTO users_role VALUES (113,3333);
INSERT INTO users_role VALUES (114,4444);
INSERT INTO users_role VALUES (115,5555);
INSERT INTO users_role VALUES (116,6666);
INSERT INTO users_role VALUES (117,7777);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

