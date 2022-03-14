CREATE SCHEMA IF NOT EXISTS `dev_database` DEFAULT CHARACTER SET latin1 ;
USE `dev_database` ;

DROP TABLE IF EXISTS `dev_database`.`billing_information`;
DROP TABLE IF EXISTS `dev_database`.`food_order`;
DROP TABLE IF EXISTS `dev_database`.`user`;
DROP TABLE IF EXISTS `dev_database`.`restaurant`;
DROP TABLE IF EXISTS `dev_database`.`delivery_man`;
DROP TABLE IF EXISTS `dev_database`.`vehicle`;
DROP TABLE IF EXISTS `dev_database`.`geographical_information`;

CREATE TABLE `dev_database`.`geographical_information` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `country` varchar(20) NOT NULL,
  `city` varchar(20) NOT NULL,
  `state` varchar(20) NOT NULL,
  `zip_code` varchar(20) DEFAULT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `dev_database`.`vehicle` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `type` varchar(20) NOT NULL,
  `make` varchar(20) NOT NULL,
  `license_plate` varchar(20) NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `license_plate` (`license_plate`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



CREATE TABLE `dev_database`.`delivery_man` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(20) NOT NULL,
  `cellphone` varchar(20) NOT NULL,
  `vehicle_id` bigint NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cellphone` (`cellphone`),
  KEY `fkey_vehicle_del_man` (`vehicle_id`),
  CONSTRAINT `fkey_vehicle_del_man` FOREIGN KEY (`vehicle_id`) REFERENCES `vehicle` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dev_database`.`restaurant` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `owner_name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `cellphone` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `geo_info_id` bigint NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_geo_info_restaurant` (`geo_info_id`),
  CONSTRAINT `fkey_geo_info_restaurant` FOREIGN KEY (`geo_info_id`) REFERENCES `geographical_information` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dev_database`.`user` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(60) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `address` varchar(20) NOT NULL,
  `category` varchar(20) NOT NULL,
  `geo_info_id` bigint NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_geo_info_user` (`geo_info_id`),
  CONSTRAINT `fkey_geo_info_user` FOREIGN KEY (`geo_info_id`) REFERENCES `geographical_information` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dev_database`.`food_order` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `name` varchar(20) NOT NULL,
  `description` varchar(20) NOT NULL,
  `price` decimal(10,2) NOT NULL,
  `quantity` int NOT NULL,
  `status` varchar(20) NOT NULL,
  `restaurant_id` bigint NOT NULL,
  `del_man_id` bigint NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_restaurant_food_order` (`restaurant_id`),
  CONSTRAINT `fkey_restaurant_food_order` FOREIGN KEY (`restaurant_id`) REFERENCES `restaurant` (`id`) ON DELETE CASCADE,
  KEY `fkey_delivery_man_food_order` (`del_man_id`),
  CONSTRAINT `fkey_delivery_man_food_order` FOREIGN KEY (`del_man_id`) REFERENCES `delivery_man` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

CREATE TABLE `dev_database`.`billing_information` (
  `id` bigint NOT NULL AUTO_INCREMENT,
  `total_amount` decimal(10,2) NOT NULL,
  `bill_issue_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `user_id` bigint NOT NULL,
  `food_order_id` bigint NOT NULL,
  `date_create` datetime DEFAULT CURRENT_TIMESTAMP,
  `username_create` varchar(30) DEFAULT NULL,
  `date_update` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
  `username_update` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fkey_user_billing_information` (`user_id`),
  CONSTRAINT `fkey_user_billing_information` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE,
  KEY `fkey_food_order_billing_information` (`food_order_id`),
  CONSTRAINT `fkey_food_order_billing_information` FOREIGN KEY (`food_order_id`) REFERENCES `food_order` (`id`) ON DELETE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;