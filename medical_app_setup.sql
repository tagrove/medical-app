-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema Medical_App
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Medical_App
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Medical_App` DEFAULT CHARACTER SET utf8 ;
USE `Medical_App` ;

-- -----------------------------------------------------
-- Table `Medical_App`.`illness`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`illness` (
  `illnessName` VARCHAR(25) NOT NULL,
  `symptoms` LONGTEXT NULL,
  `treatments` LONGTEXT NULL,
  `medications` LONGTEXT NULL,
  `severityLevel` INT NULL,
  PRIMARY KEY (`illnessName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`medication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`medication` (
  `medName` VARCHAR(25) NOT NULL,
  `conflictingMeds` LONGTEXT NULL,
  `pillShape` VARCHAR(25) NULL,
  `pillColor` VARCHAR(25) NULL,
  `pillMarking` VARCHAR(25) NULL,
  `sideEffects` LONGTEXT NULL,
  PRIMARY KEY (`medName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`user`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`user` (
  `userName` VARCHAR(25) NOT NULL,
  `password` VARCHAR(25) NULL,
  `email` VARCHAR(25) NULL,
  `salt` VARCHAR(45) NULL,
  PRIMARY KEY (`userName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`conflictingMed`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`conflictingMed` (
  `medName` VARCHAR(25) NOT NULL,
  `conflictingMeds` LONGTEXT NULL,
  PRIMARY KEY (`medName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`symptom`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`symptom` (
  `symptomName` VARCHAR(25) NOT NULL,
  `illnesses` LONGTEXT NULL,
  PRIMARY KEY (`symptomName`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`session`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`session` (
  `sessionID` INT NOT NULL,
  `expire` DATETIME NULL,
  `userName` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`sessionID`, `userName`),
  INDEX `fk_session_user_idx` (`userName` ASC),
  CONSTRAINT `fk_session_user`
    FOREIGN KEY (`userName`)
    REFERENCES `Medical_App`.`user` (`userName`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Medical_App`.`sideEffects`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Medical_App`.`sideEffects` (
  `sideEffectName` VARCHAR(25) NOT NULL,
  `medications` LONGTEXT NULL,
  PRIMARY KEY (`sideEffectName`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
