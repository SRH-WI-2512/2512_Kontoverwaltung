-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 15. Nov 2022 um 09:32
-- Server-Version: 10.4.19-MariaDB
-- PHP-Version: 8.0.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `2512_kontodb`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `festzinskonto`
--

CREATE TABLE `festzinskonto` (
  `kontonummer` int(11) NOT NULL,
  `laufzeit` int(11) DEFAULT NULL,
  `abgelaufeneZeit` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `festzinskonto`
--

INSERT INTO `festzinskonto` (`kontonummer`, `laufzeit`, `abgelaufeneZeit`) VALUES
(4, 10, 0);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `giro`
--

CREATE TABLE `giro` (
  `kontonummer` int(11) NOT NULL,
  `kreditlimit` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `giro`
--

INSERT INTO `giro` (`kontonummer`, `kreditlimit`) VALUES
(1, 1000),
(2, 5000);

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `konto`
--

CREATE TABLE `konto` (
  `kontonummer` int(11) NOT NULL,
  `kontoinhaber` varchar(30) DEFAULT NULL,
  `kontostand` double DEFAULT NULL,
  `kontotyp` char(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `konto`
--

INSERT INTO `konto` (`kontonummer`, `kontoinhaber`, `kontostand`, `kontotyp`) VALUES
(1, 'Donald', 500, 'G'),
(2, 'Mickey', -500.1, 'G'),
(3, 'Dagobert', 20, 'S'),
(4, 'Goofy', 250000, 'F');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `sparkonto`
--

CREATE TABLE `sparkonto` (
  `kontonummer` int(11) NOT NULL,
  `zinssatz` double DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Daten für Tabelle `sparkonto`
--

INSERT INTO `sparkonto` (`kontonummer`, `zinssatz`) VALUES
(3, 0.05),
(4, 0.1);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `festzinskonto`
--
ALTER TABLE `festzinskonto`
  ADD PRIMARY KEY (`kontonummer`);

--
-- Indizes für die Tabelle `giro`
--
ALTER TABLE `giro`
  ADD PRIMARY KEY (`kontonummer`);

--
-- Indizes für die Tabelle `konto`
--
ALTER TABLE `konto`
  ADD PRIMARY KEY (`kontonummer`);

--
-- Indizes für die Tabelle `sparkonto`
--
ALTER TABLE `sparkonto`
  ADD PRIMARY KEY (`kontonummer`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
