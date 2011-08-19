/*
SQLyog Enterprise - MySQL GUI v8.14 
MySQL - 5.1.41 : Database - openmusic
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`openmusic` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `openmusic`;

/*Table structure for table `amigos` */

DROP TABLE IF EXISTS `amigos`;

CREATE TABLE `amigos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idamigo1` int(11) NOT NULL,
  `idamigo2` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idamigo1` (`id`),
  KEY `idamigo2` (`id`),
  CONSTRAINT `idamigo1` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idamigo2` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `amigos` */

insert  into `amigos`(`id`,`idamigo1`,`idamigo2`) values (1,1,2),(2,1,3),(3,4,1),(4,3,2);

/*Table structure for table `recado` */

DROP TABLE IF EXISTS `recado`;

CREATE TABLE `recado` (
  `id` int(11) NOT NULL,
  `idusuario` int(11) NOT NULL,
  `idamigo` int(11) NOT NULL,
  `recado` longtext NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idamigos` (`id`),
  KEY `idamigo` (`idamigo`),
  KEY `idusuario` (`idusuario`),
  CONSTRAINT `idamigo` FOREIGN KEY (`idamigo`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idusuario` FOREIGN KEY (`idusuario`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `recado` */

/*Table structure for table `solicitacoes` */

DROP TABLE IF EXISTS `solicitacoes`;

CREATE TABLE `solicitacoes` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idsolicitador` int(11) NOT NULL,
  `idsolicitado` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `idsolicitador` (`id`),
  KEY `idsolicitado` (`id`),
  CONSTRAINT `idsolicitado` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `idsolicitador` FOREIGN KEY (`id`) REFERENCES `usuarios` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

/*Data for the table `solicitacoes` */

/*Table structure for table `usuarios` */

DROP TABLE IF EXISTS `usuarios`;

CREATE TABLE `usuarios` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(45) NOT NULL,
  `sobrenome` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `senha` varchar(45) DEFAULT NULL,
  `sexo` varchar(1) DEFAULT NULL,
  `datanascimento` date DEFAULT NULL,
  `foto` varchar(200) DEFAULT NULL,
  `cidade` varchar(100) DEFAULT NULL,
  `estado` varchar(2) DEFAULT NULL,
  `pais` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;

/*Data for the table `usuarios` */

insert  into `usuarios`(`id`,`nome`,`sobrenome`,`email`,`senha`,`sexo`,`datanascimento`,`foto`,`cidade`,`estado`,`pais`) values (1,'Marcelo',NULL,'hernane.analista@gmail.com','123',NULL,NULL,NULL,NULL,NULL,NULL),(2,'Rodrigo',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(3,'Alberto',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL),(4,'Isaque',NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
