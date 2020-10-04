-- schema create
DROP DATABASE IF EXISTS `sb`;
CREATE DATABASE `sb` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `sb`;

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `birthday` date NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'tom', 'm', '1989-02-15');
INSERT INTO `user` VALUES ('2', 'jerry', 'f', '1992-10-14');