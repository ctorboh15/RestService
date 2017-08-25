CREATE SCHEMA 'RestApp';

CREATE TABLE `RestApp`.`Customer` (
  `customerID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `firstName` VARCHAR(20) NOT NULL,
  `lastName` VARCHAR(20) NOT NULL,
  `email` VARCHAR(40) NULL,
  `mobile` VARCHAR(15) NULL,
  `dateOfBirth` DATETIME NULL,
  `activeIND` CHAR(1) NOT NULL,
  PRIMARY KEY (`customerID`));
