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
  `cidade` VARCHAR(100) NOT NULL ,
  `estado` VARCHAR(2) NOT NULL ,
  `pais` VARCHAR(100) NOT NULL ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1
COLLATE = latin1_swedish_ci;


-- -----------------------------------------------------
-- Table `openmusic`.`solicitacoes`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`solicitacoes` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `idsolicitador` INT NOT NULL ,
  `idsolicitado` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idsolicitador` (`id` ASC) ,
  INDEX `idsolicitado` (`id` ASC) ,
  CONSTRAINT `idsolicitador`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idsolicitado`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `openmusic`.`amigos`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`amigos` (
  `id` INT NOT NULL ,
  `idamigo1` INT NOT NULL ,
  `idamigo2` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idamigo1` (`id` ASC) ,
  INDEX `idamigo2` (`id` ASC) ,
  CONSTRAINT `idamigo1`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idamigo2`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `openmusic`.`recado`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`recado` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `recado` LONGTEXT NOT NULL ,
  `idusuario` INT NOT NULL ,
  `idamigo` INT NOT NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idenviou` (`id` ASC) ,
  INDEX `idrecebeu` (`id` ASC) ,
  CONSTRAINT `idenviou`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE,
  CONSTRAINT `idrecebeu`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE CASCADE
    ON UPDATE CASCADE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `openmusic`.`musicas`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`musicas` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `idusuario` INT NOT NULL ,
  `nome` VARCHAR(300) NULL ,
  `arquivo` VARCHAR(300) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idusuario` (`id` ASC) ,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `openmusic`.`mixagens`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `openmusic`.`mixagens` (
  `id` INT NOT NULL AUTO_INCREMENT ,
  `idusuario` INT NULL ,
  `idmusica` INT NULL ,
  `arquivo` VARCHAR(300) NULL ,
  PRIMARY KEY (`id`) ,
  INDEX `idusuario` (`id` ASC) ,
  INDEX `idmusica` (`id` ASC) ,
  CONSTRAINT `idusuario`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`usuarios` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idmusica`
    FOREIGN KEY (`id` )
    REFERENCES `openmusic`.`musicas` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;



SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
