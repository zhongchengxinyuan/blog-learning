create database blog;

-- 用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(24) NOT NULL,
  `password` varchar(16) NOT NULL,
  `nickname` varchar(24) DEFAULT NULL,
  `gender` tinyint(1) NOT NULL,
  `avatar` text DEFAULT NULL,
  `birth_date` datetime NOT NULL,
  `phone_number` varchar(20) NOT NULL,
  `address` varchar(200) DEFAULT NULL,
  `create_time` datetime NOT NULL,
  `latest_login_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `unique_username` (`username`),
  KEY `index_create_time` (`create_time`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;