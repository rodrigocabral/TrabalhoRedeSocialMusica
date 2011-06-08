SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL';

CREATE SCHEMA IF NOT EXISTS `openmusic` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci ;
USE `openmusic` ;

-- -----------------------------------------------------
-- Table `openmusic`.`usuarios`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`usuarios` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `nome` VARCHAR(45) NOT NULL ,
  `sobrenome` VARCHAR(100) NULL DEFAULT NULL ,
  `email` VARCHAR(100) NOT NULL ,
  `senha` VARCHAR(45) NOT NULL ,
  `sexo` VARCHAR(1) NOT NULL ,
  `datanascimento` DATE NOT NULL ,
  `foto` VARCHAR(200) NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
