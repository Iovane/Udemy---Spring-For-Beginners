CREATE DATABASE  IF NOT EXISTS `employee_directory`;
USE `employee_directory`;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;

CREATE TABLE `employee` (
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(45) DEFAULT NULL,
  `last_name` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

--
-- Data for table `employee`
--

INSERT INTO `employee` VALUES
   (1,'Leslie','Andrews','leslie@practice.com'),
   (2,'Emma','Baumgarten','emma@practice.com'),
   (3,'Avani','Gupta','avani@practice.com'),
   (4,'Yuri','Petrov','yuri@practice.com'),
   (5,'Juan','Vega','juan@practice.com');

