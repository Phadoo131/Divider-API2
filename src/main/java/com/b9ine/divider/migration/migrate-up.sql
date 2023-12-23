CREATE TABLE `cities` (
  `city_id` varchar(255) NOT NULL,
  `city_name` varchar(255) NOT NULL,
  PRIMARY KEY (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `bookers` (
  `booker_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `booker_email` varchar(255) NOT NULL,
  `booker_first_name` varchar(255) NOT NULL,
  `booker_last_name` varchar(255) NOT NULL,
  `phone_num` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`booker_id`),
  UNIQUE KEY `uk_booker_email` (`booker_email`),
  KEY `fk_city_booker` (`city_id`),
  CONSTRAINT `fk_city_booker` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
  CONSTRAINT `fk_user_client` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `clients` (
  `client_id` int NOT NULL AUTO_INCREMENT,
  `booker_address` varchar(255) DEFAULT NULL,
  `client_email` varchar(255) NOT NULL,
  `client_first_name` varchar(255) NOT NULL,
  `client_last_name` varchar(255) NOT NULL,
  `client_phone_num` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  `user_id` int NOT NULL,
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `uk_client_email` (`client_email`),
  UNIQUE KEY `uk_user_client` (`user_id`),
  KEY `fk_city_client` (`city_id`),
  CONSTRAINT `fk_city_client` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`),
  CONSTRAINT `fk_user_client` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `restaurants` (
  `restaurant_id` int NOT NULL AUTO_INCREMENT,
  `address` varchar(255) NOT NULL,
  `contact_num` varchar(255) NOT NULL,
  `restaurant_name` varchar(255) NOT NULL,
  `city_id` varchar(255) NOT NULL,
  PRIMARY KEY (`restaurant_id`),
  KEY `fk_city_restaurant` (`city_id`),
  CONSTRAINT `fk_city_restaurant` FOREIGN KEY (`city_id`) REFERENCES `cities` (`city_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `bookings` (
  `booking_id` int NOT NULL AUTO_INCREMENT,
  `status` varchar(255) NOT NULL,
  `time_stamp` date NOT NULL,
  `booker_id` int NOT NULL,
  `client_id` int NOT NULL,
  `restaurant_id` int NOT NULL,
  PRIMARY KEY (`booking_id`),
  KEY `fk_booker_booking` (`booker_id`),
  KEY `fk_client_booking` (`client_id`),
  KEY `fk_restaurant_booking` (`restaurant_id`),
  CONSTRAINT `fk_restaurant_booking` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurants` (`restaurant_id`),
  CONSTRAINT `fk_booker_booking` FOREIGN KEY (`booker_id`) REFERENCES `bookers` (`booker_id`),
  CONSTRAINT `fk_client_booking` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `roles` (
  `role_id` int NOT NULL AUTO_INCREMENT,
  `role_name` varchar(255) NOT NULL,
  PRIMARY KEY (`role_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `users` (
  `user_id` int NOT NULL AUTO_INCREMENT,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `booker_id` int NOT NULL,
  `client_id` int NOT NULL,
  PRIMARY KEY (`user_id`),
  KEY `fk_booker_user` (`booker_id`),
  KEY `fk_client_user` (`client_id`),
  CONSTRAINT `fk_booker_user` FOREIGN KEY (`booker_id`) REFERENCES `bookers` (`booker_id`),
  CONSTRAINT `fk_client_user` FOREIGN KEY (`client_id`) REFERENCES `clients` (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;

CREATE TABLE `user_roles` (
  `user_id` int NOT NULL,
  `role_id` int NOT NULL,
  KEY `fk_role_user` (`role_id`),
  KEY `fk_user_role` (`user_id`),
  CONSTRAINT `fk_role_user` FOREIGN KEY (`role_id`) REFERENCES `roles` (`role_id`),
  CONSTRAINT `fk_user_role` FOREIGN KEY (`user_id`) REFERENCES `users` (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3;
