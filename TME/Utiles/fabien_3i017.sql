-- phpMyAdmin SQL Dump
-- version 4.7.7
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  ven. 23 fév. 2018 à 00:32
-- Version du serveur :  10.1.30-MariaDB
-- Version de PHP :  7.2.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `fabien_3i017`
--

-- --------------------------------------------------------

--
-- Structure de la table `friends`
--

CREATE TABLE `friends` (
  `from` int(11) NOT NULL,
  `to` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `sessions`
--

CREATE TABLE `sessions` (
  `id_user` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `key` varchar(255) NOT NULL,
  `isroot` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sessions`
--

INSERT INTO `sessions` (`id_user`, `time`, `key`, `isroot`) VALUES
(40, '2018-02-22 21:55:04', 'FkTNawQOvZHtYheKubpimZJCxVGPJkbZ', 0),
(40, '2018-02-22 21:56:04', 'MOuziYfOmGMHFYsqIPIESVTtaEWvmwGG', 0),
(40, '2018-02-22 21:56:21', 'VbhVbwNylugcRHVryysiegOOwfrRtQhk', 0),
(40, '2018-02-22 21:59:01', 'xfOBtAcMsbotPovzbrRiGFLEjELALAWb', 0),
(40, '2018-02-22 21:59:18', 'iHbtgtSoLjsrijyNhhoLFVigvNBuFyUG', 0),
(40, '2018-02-22 21:59:43', 'PfHHmSmLKyBwMAHgRqznfoHPvMJDqdTK', 0),
(40, '2018-02-22 21:59:51', 'XHGlDKpcMeoVJSGLdjFrvfSUQBddVosl', 0),
(40, '2018-02-22 22:19:37', 'FDhjLdnAXxbaojJjlESbgqwqTpJjPHim', 0),
(40, '2018-02-22 22:59:02', 'QeXvuvlBWwCEhKvOVweJmRbPRkVSUMTk', 0),
(40, '2018-02-22 23:06:22', 'JvcGNjPrhxrJRtdydUrGmXHbIDeslBYu', 0),
(40, '2018-02-22 23:14:55', 'JTRPUmcDjRzXaVHXqSddkamxGVEdJDqw', 0),
(40, '2018-02-22 23:16:21', 'SzQElCbFlsruzFxYWUxrCeTmCIeZfDjq', 0),
(40, '2018-02-22 23:17:17', 'cCyqKVsLAwPMLKTpyIflANTHqeBnJEwf', 0),
(40, '2018-02-22 23:17:51', 'hHifrKIBCZiZiMbwGYMwMZvIgoenGHAa', 0),
(40, '2018-02-22 23:20:02', 'kZBoviOUdhnqCAEIVtTMnqMuEiMGvnLJ', 0),
(40, '2018-02-22 23:21:14', 'cnMQILZZVKbeWvZREjFIdfmIbjABVuhD', 0),
(40, '2018-02-22 23:23:27', 'LynIRfeAgICdXYSZJrcSOMPWTvdGkbki', 0),
(40, '2018-02-22 23:23:37', 'YjiXtAYBkwEqYvAsoQmCSfdnJBVHVBUV', 0),
(40, '2018-02-22 23:27:51', 'icSUcwKJbnIjRUFFIBDqXFNFUrYtbqGT', 0),
(40, '2018-02-22 23:31:26', 'rFnhdbEMPcbkNUNJhSKSJkfxiErNvfGt', 0);

-- --------------------------------------------------------

--
-- Structure de la table `users`
--

CREATE TABLE `users` (
  `id` int(64) NOT NULL,
  `login` varchar(64) DEFAULT NULL,
  `password` blob,
  `prenom` varchar(255) DEFAULT NULL,
  `nom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `users`
--

INSERT INTO `users` (`id`, `login`, `password`, `prenom`, `nom`) VALUES
(40, '3408748', 0x6d6f6e6d6470, 'Fabien', 'Tang');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`from`,`to`);

--
-- Index pour la table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `login` (`login`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `users`
--
ALTER TABLE `users`
  MODIFY `id` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=117;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
