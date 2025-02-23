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
	(1,'Mike','Andrews','mikey@mail.com'),
	(2,'John','Bravo','johnnybravo@mail.com'),
	(3,'Brian','Griffin','b.ryan@mail.com'),
	(4,'Peter','Jason','jppeter@mail.com'),
	(5,'Miguel','Hulk','greenmonster@mail.com');

