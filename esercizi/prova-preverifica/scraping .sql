-- phpMyAdmin SQL Dump
-- version 4.0.10.20
-- https://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generato il: Apr 16, 2021 alle 11:59
-- Versione del server: 10.1.31-MariaDB
-- Versione PHP: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `scraping`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `dati`
--

CREATE TABLE IF NOT EXISTS `dati` (
  `idDati` int(11) NOT NULL AUTO_INCREMENT,
  `URLestratto` varchar(255) NOT NULL,
  `idURLorigine` int(11) NOT NULL,
  `protocollo` varchar(10) NOT NULL,
  `duplicato` tinyint(1) NOT NULL,
  PRIMARY KEY (`idDati`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Struttura della tabella `inputurl`
--

CREATE TABLE IF NOT EXISTS `inputurl` (
  `idURL` int(11) NOT NULL AUTO_INCREMENT,
  `URL` varchar(50) NOT NULL,
  `protocollo` varchar(10) NOT NULL,
  PRIMARY KEY (`idURL`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
