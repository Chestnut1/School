-- phpMyAdmin SQL Dump
-- version 4.0.10.20
-- https://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generato il: Mar 08, 2021 alle 22:14
-- Versione del server: 10.1.31-MariaDB
-- Versione PHP: 5.6.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `agenziamatrimoniale`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `abbinamenti`
--

CREATE TABLE IF NOT EXISTS `abbinamenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idUtente1` int(11) DEFAULT NULL,
  `idUtente2` int(11) DEFAULT NULL,
  `giudizio1` int(3) NOT NULL DEFAULT '0',
  `giudizio2` int(3) NOT NULL DEFAULT '0',
  `scartato` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=151 ;

--
-- Dump dei dati per la tabella `abbinamenti`
--

INSERT INTO `abbinamenti` (`id`, `idUtente1`, `idUtente2`, `giudizio1`, `giudizio2`, `scartato`) VALUES
(88, 2, 1, 0, 0, 0),
(89, 5, 1, 0, 0, 0),
(90, 7, 1, 0, 0, 0),
(91, 2, 1, 0, 0, 0),
(92, 5, 1, 0, 0, 0),
(93, 7, 1, 0, 0, 0),
(94, 2, 4, 0, 0, 0),
(95, 5, 4, 0, 0, 0),
(96, 7, 4, 0, 0, 0),
(97, 2, 4, 0, 0, 0),
(98, 5, 4, 0, 0, 0),
(99, 7, 4, 0, 0, 0),
(100, 2, 6, 0, 0, 0),
(101, 5, 6, 0, 0, 0),
(102, 7, 6, 0, 0, 0),
(103, 2, 6, 0, 0, 0),
(104, 5, 6, 0, 0, 0),
(105, 7, 6, 0, 0, 0),
(106, 2, 1, 0, 0, 0),
(107, 5, 1, 0, 0, 0),
(108, 7, 1, 0, 0, 0),
(109, 2, 1, 0, 0, 0),
(110, 5, 1, 0, 0, 0),
(111, 7, 1, 0, 0, 0),
(112, 2, 4, 0, 0, 0),
(113, 5, 4, 0, 0, 0),
(114, 7, 4, 0, 0, 0),
(115, 2, 4, 0, 0, 0),
(116, 5, 4, 0, 0, 0),
(117, 7, 4, 0, 0, 0),
(118, 2, 6, 0, 0, 0),
(119, 5, 6, 0, 0, 0),
(120, 7, 6, 0, 0, 0),
(121, 2, 6, 0, 0, 0),
(122, 5, 6, 0, 0, 0),
(123, 7, 6, 0, 0, 0);

-- --------------------------------------------------------

--
-- Struttura della tabella `tbltemp1`
--

CREATE TABLE IF NOT EXISTS `tbltemp1` (
  `idUtente1` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `tbltemp2`
--

CREATE TABLE IF NOT EXISTS `tbltemp2` (
  `idUtente2` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE IF NOT EXISTS `utenti` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nome` varchar(25) NOT NULL,
  `sesso` tinyint(1) NOT NULL,
  `eta` int(4) NOT NULL,
  `altezza` float NOT NULL,
  `peso` float NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `amministrazione` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 AUTO_INCREMENT=10 ;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `nome`, `sesso`, `eta`, `altezza`, `peso`, `nickname`, `password`, `amministrazione`) VALUES
(1, 'Paperino', 1, 18, 180.5, 80, 'paperino', 'password', 0),
(2, 'Paperina', 0, 18, 170, 60, 'paperina', 'password', 0),
(3, 'puppetMaster', 1, 50, 180.5, 80, 'master', 'password', 1),
(4, 'Gastone', 1, 35, 190, 90, 'gastone', 'password', 0),
(5, 'Brigitta', 0, 45, 170, 60, 'brigitta', 'password', 0),
(6, 'Paperone', 1, 70, 170, 80, 'paperone', 'password', 0),
(7, 'Amelia', 0, 65, 150, 60, 'amelia', 'password', 0);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
