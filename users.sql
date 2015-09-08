DROP DATABASE IF EXISTS users;

CREATE DATABASE users DEFAULT CHARACTER SET 'utf8';

USE users;

CREATE TABLE `users` (
  `user_id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `firstName` varchar(255) NOT NULL,
  `surName` varchar(255) NOT NULL,
  `number` varchar(255) NOT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

set names 'utf8';

INSERT INTO `users`.`users` (`firstName`, `surName`, `number`) VALUES ('Anton', 'Dovzhenko', '+380665395865');
INSERT INTO `users`.`users` (`firstName`, `surName`, `number`) VALUES ('Maruna', 'Zlatogorska', '+380935428317');


