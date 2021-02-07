DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo /*!40100 DEFAULT CHARACTER SET UTF8MB4 */;
USE demo;

CREATE TABLE IF NOT EXISTS user (
    id INT(11) NOT NULL AUTO_INCREMENT,
    username VARCHAR(20) NOT NULL,
    password VARCHAR(20) NOT NULL,
    gender VARCHAR(1),
    birthday DATE,
    PRIMARY KEY (id),
    UNIQUE KEY name (username)
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4;

INSERT INTO user(username,gender,password,birthday) VALUES ('tom', 'm', 'tom','1989-02-15');
INSERT INTO user(username,gender,password,birthday) VALUES ('jerry', 'f','jerry', '1992-10-14');

CREATE TABLE IF NOT EXISTS tb_t_attendance_data (
    id INT PRIMARY KEY AUTO_INCREMENT,
    loginName VARCHAR(60) DEFAULT NULL COMMENT '',
    fullName VARCHAR(60) DEFAULT NULL COMMENT '',
    status VARCHAR(20) DEFAULT NULL COMMENT '',
    startAt DATETIME DEFAULT NULL COMMENT '',
    endAt DATETIME DEFAULT NULL COMMENT '',
    deskName VARCHAR(20) DEFAULT NULL COMMENT '',
    siteName VARCHAR(20) DEFAULT NULL COMMENT '',
    floorName VARCHAR(20) DEFAULT NULL COMMENT ''
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='csv data';

CREATE TABLE IF NOT EXISTS tb_t_employee (
    id INT(11) PRIMARY KEY AUTO_INCREMENT,
    last_name VARCHAR(50),
    email VARCHAR(50),
    gender CHAR(1),
    age INT
)  ENGINE=INNODB DEFAULT CHARSET=UTF8MB4 COMMENT='employee';

INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Tom','tom@atguigu.com',1,22);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Jerry','jerry@atguigu.com',0,25);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('Black','black@atguigu.com',1,30);
INSERT INTO tb_t_employee(last_name,email,gender,age) VALUES('White','white@atguigu.com',0,35)
