-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Creato il: Feb 26, 2021 alle 12:41
-- Versione del server: 10.4.17-MariaDB
-- Versione PHP: 8.0.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `agenziamatrimoniale`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `abbinamenti`
--

CREATE TABLE `abbinamenti` (
  `id` int(11) NOT NULL,
  `idUtente1` int(11) NOT NULL,
  `idUtente2` int(11) NOT NULL,
  `giudizio1` int(11) NOT NULL,
  `giudizio2` int(11) NOT NULL,
  `scartato` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struttura della tabella `utenti`
--

CREATE TABLE `utenti` (
  `id` int(11) NOT NULL,
  `nome` varchar(25) NOT NULL,
  `sesso` tinyint(1) NOT NULL,
  `eta` int(11) NOT NULL,
  `altezza` float NOT NULL,
  `peso` float NOT NULL,
  `nickname` varchar(10) NOT NULL,
  `password` varchar(16) NOT NULL,
  `amministratore` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `utenti`
--

INSERT INTO `utenti` (`id`, `nome`, `sesso`, `eta`, `altezza`, `peso`, `nickname`, `password`, `amministratore`) VALUES
(1, 'Paperino', 1, 20, 1.65, 60.02, 'Inopaper', 'paperino1', 0),
(2, 'Paperina', 0, 20, 1.63, 57, 'Inapaper', 'paperina2', 0),
(3, 'Gastone', 1, 42, 1.7, 80.02, 'OneGast', 'gastone3', 0),
(4, 'Brigitta', 0, 15, 1.56, 62.01, 'IttaBrig', 'brigitta4', 0),
(5, 'Paperone', 1, 70, 1.67, 50.05, 'OnePaper', 'paperone5', 0),
(6, 'Amelia', 0, 54, 1.49, 37, 'EliaAm', 'amelia6', 0),
(7, 'PuppetMaster', 1, 70, 1.9, 90.38, 'MasterPupp', 'puppetmaster7', 1);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `abbinamenti`
--
ALTER TABLE `abbinamenti`
  ADD PRIMARY KEY (`id`);

--
-- Indici per le tabelle `utenti`
--
ALTER TABLE `utenti`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `abbinamenti`
--
ALTER TABLE `abbinamenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT per la tabella `utenti`
--
ALTER TABLE `utenti`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
