-- phpMyAdmin SQL Dump
-- version 4.2.12deb2+deb8u2
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Mar 27 Février 2018 à 11:51
-- Version du serveur :  5.5.58-0+deb8u1
-- Version de PHP :  5.6.33-0+deb8u1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de données :  `fabien_3i017`
--

-- --------------------------------------------------------

--
-- Structure de la table `Friends`
--

CREATE TABLE IF NOT EXISTS `Friends` (
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Friends`
--

INSERT INTO `Friends` (`id_user`, `id_friend`, `time`) VALUES
(0, 38, '2018-02-23 14:41:48'),
(0, 34852189, '2018-02-23 13:46:42'),
(40, 34, '2018-02-23 13:52:11'),
(40, 36, '2018-02-23 13:58:53'),
(40, 34852189, '2018-02-23 13:51:48');

-- --------------------------------------------------------

--
-- Structure de la table `Sessions`
--

CREATE TABLE IF NOT EXISTS `Sessions` (
  `id_user` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `key` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `isroot` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Sessions`
--

INSERT INTO `Sessions` (`id_user`, `time`, `key`, `isroot`, `expired`) VALUES
(40, '2018-02-22 21:55:04', 'FkTNawQOvZHtYheKubpimZJCxVGPJkbZ', 0, 0),
(40, '2018-02-22 21:56:04', 'MOuziYfOmGMHFYsqIPIESVTtaEWvmwGG', 0, 0),
(40, '2018-02-22 21:56:21', 'VbhVbwNylugcRHVryysiegOOwfrRtQhk', 0, 0),
(40, '2018-02-22 21:59:01', 'xfOBtAcMsbotPovzbrRiGFLEjELALAWb', 0, 0),
(40, '2018-02-22 21:59:18', 'iHbtgtSoLjsrijyNhhoLFVigvNBuFyUG', 0, 0),
(40, '2018-02-22 21:59:43', 'PfHHmSmLKyBwMAHgRqznfoHPvMJDqdTK', 0, 0),
(40, '2018-02-22 21:59:51', 'XHGlDKpcMeoVJSGLdjFrvfSUQBddVosl', 0, 0),
(40, '2018-02-22 22:19:37', 'FDhjLdnAXxbaojJjlESbgqwqTpJjPHim', 0, 0),
(40, '2018-02-22 22:59:02', 'QeXvuvlBWwCEhKvOVweJmRbPRkVSUMTk', 0, 0),
(40, '2018-02-22 23:06:22', 'JvcGNjPrhxrJRtdydUrGmXHbIDeslBYu', 0, 0),
(40, '2018-02-22 23:14:55', 'JTRPUmcDjRzXaVHXqSddkamxGVEdJDqw', 0, 0),
(40, '2018-02-22 23:16:21', 'SzQElCbFlsruzFxYWUxrCeTmCIeZfDjq', 0, 0),
(40, '2018-02-22 23:17:17', 'cCyqKVsLAwPMLKTpyIflANTHqeBnJEwf', 0, 0),
(40, '2018-02-22 23:17:51', 'hHifrKIBCZiZiMbwGYMwMZvIgoenGHAa', 0, 0),
(40, '2018-02-22 23:20:02', 'kZBoviOUdhnqCAEIVtTMnqMuEiMGvnLJ', 0, 0),
(40, '2018-02-22 23:21:14', 'cnMQILZZVKbeWvZREjFIdfmIbjABVuhD', 0, 0),
(40, '2018-02-22 23:23:27', 'LynIRfeAgICdXYSZJrcSOMPWTvdGkbki', 0, 0),
(40, '2018-02-22 23:23:37', 'YjiXtAYBkwEqYvAsoQmCSfdnJBVHVBUV', 0, 0),
(40, '2018-02-22 23:27:51', 'icSUcwKJbnIjRUFFIBDqXFNFUrYtbqGT', 0, 0),
(40, '2018-02-22 23:31:26', 'rFnhdbEMPcbkNUNJhSKSJkfxiErNvfGt', 0, 0),
(40, '2018-02-23 13:32:29', 'vVRXCntuLKHqQHCYGUXiRLzxWABECalt', 0, 1),
(40, '2018-02-23 13:17:59', 'BAIjpgGzeTkczqYFuZZgrBYsnPrRreoo', 0, 0),
(40, '2018-02-23 13:22:33', 'jgAoxGWhXcRbGVxcsoJdgooGMTCEEwYP', 0, 0),
(40, '2018-02-23 13:25:11', 'ByEjjWBWcxrcEVBNewsiWfTjMqErbEHT', 0, 0),
(40, '2018-02-23 13:32:29', 'JhsYKuQsSzLwlLXLWPCvMGTwAAmxOpMA', 0, 0);

-- --------------------------------------------------------

--
-- Structure de la table `Users`
--

CREATE TABLE IF NOT EXISTS `Users` (
`id` int(64) NOT NULL,
  `login` varchar(64) DEFAULT NULL,
  `password` blob,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=119 DEFAULT CHARSET=latin1;

--
-- Contenu de la table `Users`
--

INSERT INTO `Users` (`id`, `login`, `password`, `prenom`, `nom`) VALUES
(40, '3408748', 0x6d6f6e6d6470, 'Fabien', 'Tang'),
(118, '34587425', 0x746f746f, 'mane', 'toto');

--
-- Index pour les tables exportées
--

--
-- Index pour la table `Friends`
--
ALTER TABLE `Friends`
 ADD PRIMARY KEY (`id_user`,`id_friend`);

--
-- Index pour la table `Users`
--
ALTER TABLE `Users`
 ADD PRIMARY KEY (`id`), ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `Users`
--
ALTER TABLE `Users`
MODIFY `id` int(64) NOT NULL AUTO_INCREMENT,AUTO_INCREMENT=119;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
