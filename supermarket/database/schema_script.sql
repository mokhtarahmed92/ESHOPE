SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `mydb` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `mydb` ;

-- -----------------------------------------------------
-- Table `mydb`.`ITEM`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ITEM` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `NAME` VARCHAR(150) NOT NULL ,
  `PRICE` DECIMAL NOT NULL ,
  PRIMARY KEY (`ID`) ,
  UNIQUE INDEX `NAME_UNIQUE` (`NAME` ASC) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`OFFER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`OFFER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `COUNT` INT NOT NULL ,
  `PRICE` DECIMAL NOT NULL ,
  `ITEM_ID` INT NOT NULL ,
  PRIMARY KEY (`ID`, `ITEM_ID`) ,
  INDEX `fk_OFFER_ITEM1` (`ITEM_ID` ASC) ,
  CONSTRAINT `fk_OFFER_ITEM1`
    FOREIGN KEY (`ITEM_ID` )
    REFERENCES `mydb`.`ITEM` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ORDER`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ORDER` (
  `ID` INT NOT NULL AUTO_INCREMENT ,
  `DESCRIPTION` VARCHAR(500) NULL ,
  PRIMARY KEY (`ID`) )
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `mydb`.`ORDER_ITEMS`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `mydb`.`ORDER_ITEMS` (
  `ITEM_ID` INT NOT NULL ,
  `ORDER_ID` INT NOT NULL ,
  PRIMARY KEY (`ITEM_ID`, `ORDER_ID`) ,
  INDEX `fk_ITEM_has_ORDER_ORDER1` (`ORDER_ID` ASC) ,
  INDEX `fk_ITEM_has_ORDER_ITEM1` (`ITEM_ID` ASC) ,
  CONSTRAINT `fk_ITEM_has_ORDER_ITEM1`
    FOREIGN KEY (`ITEM_ID` )
    REFERENCES `mydb`.`ITEM` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_ITEM_has_ORDER_ORDER1`
    FOREIGN KEY (`ORDER_ID` )
    REFERENCES `mydb`.`ORDER` (`ID` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
