DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo /*!40100 DEFAULT CHARACTER SET utf8 */;
USE demo;

CREATE TABLE IF NOT EXISTS user (
  id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(20) NOT NULL,
  password varchar(20) NOT NULL,
  gender varchar(1),
  birthday date,
  PRIMARY KEY (id),
  UNIQUE KEY name (username)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS tb_t_attendance_data (
  id int PRIMARY KEY AUTO_INCREMENT,
  loginName varchar(60) DEFAULT NULL COMMENT '',
  fullName varchar(60) DEFAULT NULL COMMENT '',
  status varchar(20) DEFAULT NULL COMMENT '',
  startAt DATETIME DEFAULT NULL COMMENT '',
  endAt DATETIME DEFAULT NULL COMMENT '',
  deskName varchar(20) DEFAULT NULL COMMENT '',
  siteName varchar(20) DEFAULT NULL COMMENT '',
  floorName varchar(20) DEFAULT NULL COMMENT ''
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='csv data';

INSERT INTO user(username,gender,password,birthday) VALUES ('tom', 'm', 'tom','1989-02-15');
INSERT INTO user(username,gender,password,birthday) VALUES ('jerry', 'f','jerry', '1992-10-14');
