CREATE TABLE `bookers` (
  `booker_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `booker_first_name` varchar(255) NOT NULL,
  `booker_last_name` varchar(255) NOT NULL,
  `phone_num` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  `booker_email` varchar(255) NOT NULL,
  PRIMARY KEY (`booker_id`),
  UNIQUE KEY `UK_1hi4paq25qwdljjwjbicrjkce` (`booker_email`),
  KEY `FK23mn81pyyq1mrqcx0jo2qhv67` (`city_id`),
  CONSTRAINT `FK23mn81pyyq1mrqcx0jo2qhv67` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb3;

CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `booker_address` varchar(255) DEFAULT NULL,
  `client_email` varchar(255) NOT NULL,
  `client_first_name` varchar(255) NOT NULL,
  `client_last_name` varchar(255) NOT NULL,
  `client_phone_num` varchar(255) NOT NULL,
  `booker_password` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  PRIMARY KEY (`client_id`),
  KEY `FKhvj87763ko5y5uukwc6wyf0v6` (`city_id`),
  CONSTRAINT `FKhvj87763ko5y5uukwc6wyf0v6` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `bookings` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `time_stamp` date NOT NULL,
  `booker_id` int NOT NULL,
  `client_id` int NOT NULL,
  `restaurant_id` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `FK7m7tuf8c4xa60tu49ne570os9` (`booker_id`),
  KEY `FKqb0hw90djslecy59mnes8lbtq` (`client_id`),
  KEY `FK3pv7kriicofgxo9l3kgpjbi9i` (`restaurant_id`),
  CONSTRAINT `FK3pv7kriicofgxo9l3kgpjbi9i` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
  CONSTRAINT `FK7m7tuf8c4xa60tu49ne570os9` FOREIGN KEY (`booker_id`) REFERENCES `bookers` (`booker_id`),
  CONSTRAINT `FKqb0hw90djslecy59mnes8lbtq` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;


CREATE TABLE `cities` (
  `city_id` varchar(255) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `restaurants` (
  `restaurant_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `contact_num` varchar(255) NOT NULL,
  `restaurant_name` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  PRIMARY KEY (`restaurant_id`),
  KEY `FKqxinx5shi9vp70a0huwi3bhqv` (`city_id`),
  CONSTRAINT `FKqxinx5shi9vp70a0huwi3bhqv` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
