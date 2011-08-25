-- phpMyAdmin SQL Dump
-- version 2.10.1
-- http://www.phpmyadmin.net
-- 
-- Servidor: localhost
-- Tempo de Geração: Ago 24, 2011 as 10:36 PM
-- Versão do Servidor: 5.0.45
-- Versão do PHP: 5.2.5

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Banco de Dados: 'openmusic'
-- 

-- --------------------------------------------------------

-- 
-- Estrutura da tabela 'amigos'
-- 

CREATE TABLE amigos (
  id int(11) NOT NULL auto_increment,
  idamigo1 int(11) NOT NULL,
  idamigo2 int(11) NOT NULL,
  PRIMARY KEY  (id),
  KEY idamigo1 (id),
  KEY idamigo2 (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

-- 
-- Estrutura da tabela 'recado'
-- 

CREATE TABLE recado (
  id int(11) NOT NULL,
  idusuario int(11) NOT NULL,
  idamigo int(11) NOT NULL,
  recado longtext NOT NULL,
  PRIMARY KEY  (id),
  KEY idamigos (id),
  KEY idamigo (idamigo),
  KEY idusuario (idusuario)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

-- 
-- Estrutura da tabela 'solicitacoes'
-- 

CREATE TABLE solicitacoes (
  id int(11) NOT NULL auto_increment,
  idsolicitador int(11) NOT NULL,
  idsolicitado int(11) NOT NULL,
  PRIMARY KEY  (id),
  KEY idsolicitador (id),
  KEY idsolicitado (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

-- 
-- Estrutura da tabela 'usuarios'
-- 

CREATE TABLE usuarios (
  id int(11) NOT NULL auto_increment,
  nome varchar(45) NOT NULL,
  sobrenome varchar(100) default NULL,
  email varchar(100) default NULL,
  senha varchar(45) default NULL,
  sexo varchar(15) default NULL,
  datanascimento date default NULL,
  foto varchar(200) default NULL,
  cidade varchar(100) default NULL,
  estado varchar(2) default NULL,
  pais varchar(100) default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1;

-- 
-- Restrições para as tabelas dumpadas
-- 

-- 
-- Restrições para a tabela `amigos`
-- 
ALTER TABLE `amigos`
  ADD CONSTRAINT idamigo1 FOREIGN KEY (id) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT idamigo2 FOREIGN KEY (id) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Restrições para a tabela `recado`
-- 
ALTER TABLE `recado`
  ADD CONSTRAINT idamigo FOREIGN KEY (idamigo) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT idusuario FOREIGN KEY (idusuario) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE;

-- 
-- Restrições para a tabela `solicitacoes`
-- 
ALTER TABLE `solicitacoes`
  ADD CONSTRAINT idsolicitado FOREIGN KEY (id) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT idsolicitador FOREIGN KEY (id) REFERENCES usuarios (id) ON DELETE CASCADE ON UPDATE CASCADE;
