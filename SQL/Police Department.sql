-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema mydb
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `police` DEFAULT CHARACTER SET utf8 ;
USE `police` ;

-- -----------------------------------------------------
-- Table `police`.`Officer`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Officer` (
  `Badge` INT NOT NULL,
  `Surname` VARCHAR(45) NULL,
  `Post` VARCHAR(45) NULL,
  `Enrolment` DATE NULL,
  `Birthday` DATE NULL,
  PRIMARY KEY (`Badge`),
  UNIQUE INDEX `Badge_UNIQUE` (`Badge` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`Boat`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Boat` (
  `Boat_Num` INT NOT NULL,
  `Mark` VARCHAR(45) NULL,
  `Engine_Num` INT NULL,
  `Color` VARCHAR(45) NULL,
  `Recorder` INT NULL,
  PRIMARY KEY (`Boat_Num`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`District`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`District` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `Priority` VARCHAR(45) NULL,
  `Enter_Coordinates` VARCHAR(45) NULL,
  `Exit_Coordinates` VARCHAR(45) NULL,
  PRIMARY KEY (`ID`),
  UNIQUE INDEX `ID District_UNIQUE` (`ID` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`Patrol`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Patrol` (
  `ID` INT NOT NULL,
  `Boat_Num` INT NOT NULL,
  `District` INT NOT NULL,
  `Start` DATE NULL,
  `End` DATE NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_table1_Boat1_idx` (`Boat_Num` ASC),
  INDEX `fk_table1_District1_idx` (`District` ASC),
  CONSTRAINT `fk_table1_Boat1`
    FOREIGN KEY (`Boat_Num`)
    REFERENCES `police`.`Boat` (`Boat_Num`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_table1_District1`
    FOREIGN KEY (`District`)
    REFERENCES `police`.`District` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`Patrol Result`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Patrol Result` (
  `ID` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `Patrol_ID` INT NOT NULL,
  `Intruders` INT NULL,
  `Loss` VARCHAR(500) NULL,
  `Reward` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Patrol Result_table11_idx` (`Patrol_ID` ASC),
  CONSTRAINT `fk_Patrol Result_table11`
    FOREIGN KEY (`Patrol_ID`)
    REFERENCES `police`.`Patrol` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`Stats`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Stats` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `Officer_Badge` INT NOT NULL,
  `Intruders` INT NULL,
  `Patrols` INT NULL,
  PRIMARY KEY (`ID`),
  INDEX `fk_Stats_Officer1_idx` (`Officer_Badge` ASC),
  CONSTRAINT `fk_Stats_Officer1`
    FOREIGN KEY (`Officer_Badge`)
    REFERENCES `police`.`Officer` (`Badge`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `police`.`Patrol_Check`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `police`.`Patrol_Check` (
  `ID` INT NOT NULL,
  `Officer_Badge` INT NOT NULL,
  `Patrol_ID` INT NOT NULL,
  INDEX `fk_Officer_has_Boat_Officer1_idx` (`Officer_Badge` ASC),
  PRIMARY KEY (`ID`),
  INDEX `fk_Boat_Check_Patrol1_idx` (`Patrol_ID` ASC),
  CONSTRAINT `fk_Officer_has_Boat_Officer1`
    FOREIGN KEY (`Officer_Badge`)
    REFERENCES `police`.`Officer` (`Badge`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Boat_Check_Patrol1`
    FOREIGN KEY (`Patrol_ID`)
    REFERENCES `police`.`Patrol` (`ID`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
