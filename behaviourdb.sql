-- MySQL Workbench Forward Engineering
DROP SCHEMA IF EXISTS behaviourdb;
SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';
-- -----------------------------------------------------
-- Schema behaviourdb
-- -----------------------------------------------------
-- -----------------------------------------------------
-- Schema behaviourdb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `behaviourdb` DEFAULT CHARACTER SET utf8 ;
USE `behaviourdb` ;
-- -----------------------------------------------------
-- Table `behaviourdb`.`GPs`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `behaviourdb`.`gps` (
  `gp_id` INT NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(5) NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`gp_id`))
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `behaviourdb`.`patients`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `behaviourdb`.`patients` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nhs_number` INT NOT NULL,
  `first_name` VARCHAR(45) NOT NULL,
  `last_name` VARCHAR(45) NOT NULL,
  `gp_ID` INT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_patients_gps_idx` (`gp_ID` ASC),
  CONSTRAINT `fk_patients_gps`
    FOREIGN KEY (`gp_ID`)
    REFERENCES `behaviourdb`.`gps` (`gp_id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

-- -----------------------------------------------------
-- Table `behaviourdb`.`activities`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `behaviourdb`.`activities` (
  `activity_ID` INT NOT NULL AUTO_INCREMENT,
  `activity_name` VARCHAR(100) NOT NULL,
  `activity_date` DATETIME NOT NULL,
  `is_completed` TINYINT(1) NULL DEFAULT 0,
  `rating_before` INT NULL,
  `rating_after` INT NULL,
  `is_deleted` TINYINT(1) NULL,
  `is_favourite` TINYINT(1) NULL DEFAULT 0,
  `patient_id` INT NULL,
  PRIMARY KEY (`activity_ID`),
  INDEX `fk_activities_patients1_idx` (`patient_id` ASC),
  CONSTRAINT `fk_activities_patients1`
    FOREIGN KEY (`patient_id`)
    REFERENCES `behaviourdb`.`patients` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
insert into gps (gp_id, title, first_name, last_name) values (1, 'Dr', 'John', 'Smith');
insert into gps (gp_id, title, first_name, last_name) values (2, 'Dr', 'Daniel', 'Abbasi');
insert into gps (gp_id, title, first_name, last_name) values (3, 'Dr', 'Jamie', 'Highfield'); 
insert into gps (gp_id, title, first_name, last_name) values (4, 'Dr', 'Ahmed', 'Alsaab'); 
insert into gps (gp_id, title, first_name, last_name) values (5, 'Dr', 'Josh', 'Teague'); 
insert into gps (gp_id, title, first_name, last_name) values (6, 'Dr', 'Carl', 'Jones');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (1, 12345, 'Andres', 'Montgomery', '1');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (2, 45345, 'Alex', 'Young', '2');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (3, 64322, 'Kerry', 'Guzman', '3');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (4, 16543, 'Alfred', 'Farmer', '4');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (5, 55221, 'Jeannie', 'Miller', '5');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (6, 87643, 'Julius', 'Singleton', '6');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (7, 23456, 'Julie', 'Turner', '2');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (8, 43567, 'Josh', 'Norris', '3');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (9, 12763, 'Ellie', 'Varney', '6');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (10, 87539, 'Peter', 'Blakemore', '1');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (11, 45636, 'Sam', 'Jones', '5');
insert into patients (id, nhs_number, first_name, last_name, gp_id) values (12, 98245, 'Emily', 'Wood', '1');


insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (1, 'Running', '2017-08-10 11:01:17', 1, 3, 4, 0, 1, 1);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (2, 'Swimming', '2017-02-07 02:06:45', 1, 4, 4, 0, 0, 1);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (3, 'Running', '2016-12-26 06:16:52', 1, 1, 2, 0, 1, 1);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (4, 'Running', '2017-06-23 19:37:33', 0, 6, 5, 0, 1, 1);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (5, 'Swimming', '2017-05-18 04:53:33', 1, 1, 1, 0, 0, 1);


insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (6, 'Running', '2017-09-03 16:40:44', 0, 1, 3, 0, 1, 2);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (7, 'Running', '2017-04-11 00:20:25', 1, 4, 3, 1, 1, 2);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (8, 'Swimming', '2017-05-21 18:55:34', 0, 4, 5, 0, 1, 2);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (9, 'Swimming', '2017-01-11 23:23:14', 1, 2, 4, 1, 1, 2);
insert into activities (activity_id, activity_name, activity_date, is_completed, rating_before, rating_after, is_deleted, is_favourite, patient_id) values (10, 'Running', '2017-06-21 05:34:08', 1, 5, 1, 0, 0, 2);
