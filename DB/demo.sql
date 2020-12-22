DROP DATABASE IF EXISTS demo;
CREATE DATABASE demo /*!40100 DEFAULT CHARACTER SET utf8 */;
USE demo;

CREATE TABLE IF NOT EXISTS user (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(20) NOT NULL,
  gender varchar(1),
  birthday date,
  PRIMARY KEY (id),
  UNIQUE KEY name (name)
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

INSERT INTO user(name,gender,birthday) VALUES ('tom', 'm', '1989-02-15');
INSERT INTO user(name,gender,birthday) VALUES ('jerry', 'f', '1992-10-14');
