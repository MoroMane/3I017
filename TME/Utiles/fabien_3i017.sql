-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  Dim 22 avr. 2018 à 23:19
-- Version du serveur :  10.1.31-MariaDB
-- Version de PHP :  7.2.4

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
  `id_user` int(11) NOT NULL,
  `id_friend` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `friends`
--

INSERT INTO `friends` (`id_user`, `id_friend`, `time`) VALUES
(0, 38, '2018-02-23 14:41:48'),
(0, 34852189, '2018-02-23 13:46:42'),
(40, 34, '2018-02-23 13:52:11'),
(40, 36, '2018-02-23 13:58:53'),
(40, 34852189, '2018-02-23 13:51:48');

-- --------------------------------------------------------

--
-- Structure de la table `sessions`
--

CREATE TABLE `sessions` (
  `id_user` int(11) NOT NULL,
  `time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `key` varchar(255) CHARACTER SET utf16 COLLATE utf16_bin NOT NULL,
  `isroot` tinyint(1) NOT NULL,
  `expired` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `sessions`
--

INSERT INTO `sessions` (`id_user`, `time`, `key`, `isroot`, `expired`) VALUES
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
(40, '2018-02-23 13:32:29', 'JhsYKuQsSzLwlLXLWPCvMGTwAAmxOpMA', 0, 0),
(40, '2018-02-27 13:06:19', 'oPgzAKpwHAktjmJUpmCziJXSlKbCLeCI', 0, 0),
(40, '2018-02-27 13:36:50', 'evBCZguYmzichYzjITbzWFBLdwhQtxlc', 0, 0),
(40, '2018-04-17 19:18:40', 'ZPCwMoSuKfZvqaaVrVJKMvnnjZjVJIsh', 0, 0),
(40, '2018-04-17 19:19:33', 'NzHjmMNrFLJAfONdPUnxzqmFpDvRjiwn', 0, 0),
(40, '2018-04-17 19:20:37', 'wXHHTapKDlnenWIrtoqdtPvtrKvYiBwk', 0, 0),
(40, '2018-04-17 19:21:35', 'HNxLbRbcbmCBHeFpfhEFhnumBkGStrmT', 0, 0),
(40, '2018-04-17 19:23:30', 'hNbVZKspgJEqiSzvSuttMSSWPwiUVnWb', 0, 0),
(40, '2018-04-17 19:24:39', 'NQguiDZwSpebIQNWUMjAhFLHDPxqwhmz', 0, 0),
(40, '2018-04-17 19:25:34', 'foZjWochKUoHVwSxdHrDgmFyFShOKCgw', 0, 0),
(40, '2018-04-17 19:26:41', 'PEByORGFiaLcboGxxaBVcmQjwjMTybfM', 0, 0),
(40, '2018-04-17 19:42:10', 'WHjVsNGaSDORSEsBDdLAHGlZwbmaFzSC', 0, 0),
(40, '2018-04-17 19:49:45', 'vmCzfpIyKSFvpdNUnUGpdsWuvjQnLeCC', 0, 0),
(40, '2018-04-17 20:42:06', 'ghZANquEIQyLLxKOJuACLPsxuSqtzlkW', 0, 0),
(40, '2018-04-17 20:42:14', 'jMHrqjgeCsAXsSAvOveusNguIlhnLDaj', 0, 0),
(40, '2018-04-17 20:42:26', 'JsVXFWxiuhpzrJrCDLqMSDCXPVXtTIbn', 0, 0),
(40, '2018-04-17 20:43:14', 'ckJbfxEuunXdrsGeNelfjgAlWEOdyVua', 0, 0),
(40, '2018-04-17 20:43:22', 'BwKiOutEWkazjUPvFbBrOuZnQWLrzVSn', 0, 0),
(40, '2018-04-17 20:44:27', 'qwsNGdPiFVWKqyZlIuHbwhTeqpMrwvBK', 0, 0),
(40, '2018-04-17 20:45:55', 'eYqNoRnvHbmuZNnioFNWSLXTAeFahmtq', 0, 0),
(40, '2018-04-17 20:48:28', 'SKnEGIDGmTAusoJKjiUmqsQFSpJrygkv', 0, 0),
(40, '2018-04-17 20:49:37', 'VuOthCQqQmwWYFsiGtsGRdVOJEwLyamu', 0, 0),
(40, '2018-04-17 20:49:47', 'SqmiNkAYQKRAkykBsSgRpIuvexUvCled', 0, 0),
(40, '2018-04-17 20:50:04', 'laRYIGodvqKMtiIQTGaQquhgoEVIunMG', 0, 0),
(40, '2018-04-17 20:51:47', 'QohSHAUgXZLpcThVbFzngFDfZgJCmAsW', 0, 0),
(40, '2018-04-17 20:53:51', 'xDLoJrXTadphhvxbKrBaDUUVgOEaJKKM', 0, 0),
(40, '2018-04-17 20:54:01', 'sOXhcHCBkdNoSqvuTiHRhiCjQCtVFegv', 0, 0),
(40, '2018-04-17 20:54:06', 'ZCjKLiIlKCnMtntalMLdqiRsNgffyXwM', 0, 0),
(40, '2018-04-17 20:55:49', 'ntGcEGWUrcaCHfwrhwHmvfclRMoBGUmF', 0, 0),
(40, '2018-04-17 20:57:04', 'pVuDsJlhDWMFNMwPmfdkVZDjNCdwpluM', 0, 0),
(40, '2018-04-17 20:57:15', 'bYOuPowVrWwRqtolhxwWmTLOJHERWstA', 0, 0),
(40, '2018-04-17 20:59:28', 'qRIskFKenCcmVbsKLCmghxgKJQMCooQB', 0, 0),
(40, '2018-04-17 20:59:34', 'XvFHfcbMARudvOGbXQtJRaTARpRpPdUD', 0, 0),
(40, '2018-04-17 21:03:42', 'OqfFISjIyFVajknLAhVnaJUJBLChaGdI', 0, 0),
(40, '2018-04-17 21:06:37', 'GZAAKifHgOjcNqoyQOPhvPhCSGXgOtCt', 0, 0),
(40, '2018-04-17 21:24:57', 'OoUBsIwubvVLDpcrzCALlHagwopZAOEs', 0, 0),
(40, '2018-04-17 21:26:56', 'KHQVWiOqtfcgFRbZlaTJRDAoTzbBudlc', 0, 0),
(40, '2018-04-17 21:27:37', 'VzdxpXiHzjIMrKDwJdaNLIfUDrtEmGtX', 0, 0),
(40, '2018-04-17 21:28:17', 'zgFNpoFiBYjfVLCHjexPUdykQlZZYOfV', 0, 0),
(40, '2018-04-17 21:29:33', 'LKworWuVQHkrOatXTuQBwoYoemNZJreh', 0, 0),
(40, '2018-04-17 21:32:46', 'TdOjVPFlHXFahduSJytNfACJvYDKVRQR', 0, 0),
(40, '2018-04-17 21:37:54', 'TizekdjarsWZEyNWOVPUZUCyvUoWgmyk', 0, 0),
(40, '2018-04-17 21:42:46', 'ZyeqpUcAlpTZxXfkUoExNUUywOWLInjP', 0, 0),
(40, '2018-04-17 21:44:04', 'vcWxouFDLPHZZEHhVoxAHntBThgWWnyX', 0, 0),
(40, '2018-04-17 21:49:58', 'tzpFmWxkLFkGguKXpNqZpRutxNQtLtGP', 0, 0),
(40, '2018-04-17 21:53:38', 'odJWDbHEuRfnyPULnHfpqUXAyLFqlpNf', 0, 0),
(40, '2018-04-17 21:58:06', 'iCSIctaqfqGXXcXFSkfqGnBlLKNkNirr', 0, 0),
(40, '2018-04-17 21:59:46', 'vUHIYDgfLSWtCKPRKTAWzrQJcTMOKqDu', 0, 0),
(40, '2018-04-17 22:11:40', 'asGUZVfBzmnsbxlTYaRxwnZMrIExiVcV', 0, 0),
(40, '2018-04-17 22:12:45', 'kCuLJNljATsIDPtXjhxqCQDNhBtCanwR', 0, 0),
(40, '2018-04-17 22:19:47', 'HOGqQqqrFUEctoKpjGaMKDETKFaZbhFP', 0, 0),
(40, '2018-04-17 22:23:34', 'FalaQjJbozECmnSTnpqzuRwFjbJbauLB', 0, 0),
(40, '2018-04-20 14:31:36', 'vOeAPVwsoeJtgoHCjzHunTdDxzupMOzP', 0, 0),
(40, '2018-04-20 14:33:45', 'rCCWqYHBxhJzZwWugWEfywBuWNpfIxKp', 0, 0),
(40, '2018-04-20 14:36:40', 'oPXvwSKwePByzrttAImnhkSjmaCFuwnr', 0, 0),
(40, '2018-04-20 14:38:45', 'GuElRqbsQTXStAqoPalOEkUhObXSOKLh', 0, 0),
(40, '2018-04-20 14:43:57', 'hyuZASmARpgEnZDZnTmaKfPceiHQpntC', 0, 0),
(40, '2018-04-20 14:44:39', 'ScUkRGHnCQTbdbuzSnoEKZzwzUnkrBej', 0, 0),
(40, '2018-04-20 14:50:04', 'MEJkaEdxWGshiucqWMXbCopCRqfagFWo', 0, 0),
(40, '2018-04-20 14:50:10', 'iiNVSSQaPaObdTYuoWMzdPxvxvUDeiYx', 0, 0),
(40, '2018-04-20 14:50:15', 'WKnaFtaxxcPjONmXccnLZFcLdRTieqKY', 0, 0),
(40, '2018-04-20 14:51:05', 'hGJEjZzXOXRQAduGxMtZltnJypAKmLDX', 0, 0),
(40, '2018-04-20 14:51:23', 'MvUFqzuuviTAXLcnuRJxXXkDikvZKMLW', 0, 0),
(40, '2018-04-20 14:57:37', 'WBLDYCMpmmiaTLXfkuZYPADQFhTZgcIL', 0, 0),
(40, '2018-04-20 14:58:09', 'WtsYobwMzkTHpSyATvESdfzPdGbIezWJ', 0, 0),
(40, '2018-04-20 14:59:21', 'yznYwBhEbtyYYkLRqkcBquyIspTEaRvA', 0, 0),
(40, '2018-04-20 15:08:15', 'YrLgzVqHbvYqmsEGtkbQgPHjTOndIfWC', 0, 0),
(40, '2018-04-20 15:08:22', 'trZfEpvlYyrblgRRhRooEOauWZVPWMYk', 0, 0),
(40, '2018-04-20 15:11:10', 'liKhtVBTmXjKhuOvMDvzIMTJArQkgwoe', 0, 0),
(40, '2018-04-20 15:12:56', 'HyGXNrbPAcluxOIlMMyrLBUMtUncMaRV', 0, 0),
(40, '2018-04-20 15:20:19', 'kwQpZzgZvfPBRMdruKbgwlJEmgfvEgZu', 0, 0),
(40, '2018-04-20 15:50:24', 'NhRqYazaCdJlhjXUOpvoIGClrqFmSUVn', 0, 0),
(40, '2018-04-20 16:12:48', 'VwBVGoWcGNzQdDoFpzbQucCKsRIZGXof', 0, 0),
(40, '2018-04-20 16:14:02', 'OvBvSaQhQtNEsPourWmwJQSIaurDCsjh', 0, 0),
(40, '2018-04-20 16:27:54', 'FJTeETUoiVDyqPOTGLFcvSrUbzgBKHtN', 0, 0),
(40, '2018-04-20 16:28:59', 'BFHkwJleqcJtbiNeDwHxXLAhoDuNhCvj', 0, 0),
(40, '2018-04-20 16:29:49', 'npAWbVsGvyjIrzQSjKLTkPtiMnCYiuqd', 0, 0),
(40, '2018-04-20 16:30:28', 'oRUUVdWzSrdYrQKSLyYbJQjouxSVLFZG', 0, 0),
(40, '2018-04-20 16:33:18', 'XmFBubuIOgswHoIMrGOufbpbZSDEfPiY', 0, 0),
(40, '2018-04-20 16:36:43', 'nejLxvZkrvgdfLOSzqdlxcWPIqtDXbWE', 0, 0),
(40, '2018-04-20 18:09:13', 'uAABVelWcGwFVWDLvbNYHEoXjPYXOlAw', 0, 0),
(40, '2018-04-20 18:10:36', 'slKIljwVxRLRBXhzkcoMPfrYVKKUkRgB', 0, 0),
(40, '2018-04-20 18:12:28', 'cWeulyRoinhKgHKXXvCTqbYiovMBgAqH', 0, 0),
(40, '2018-04-20 18:19:07', 'qJRLqWLmbpBUpVwaNMMoDqzwvDrEZzuF', 0, 0),
(40, '2018-04-20 18:20:46', 'ZsZzOKhQEAwTSfVblHzGCFJszACOnuJs', 0, 0),
(40, '2018-04-20 18:26:35', 'vRtYiWcHWjZZnOrkACWgwhXRkucgDxEo', 0, 0),
(40, '2018-04-20 18:28:27', 'FilfmictIKyNFRWpaKHnPvyZMsbpAYUb', 0, 0),
(40, '2018-04-20 18:36:35', 'PkIATSjhDqvBVWZaqlyHIBypSIrfAaCt', 0, 0),
(40, '2018-04-20 18:39:36', 'PdOrEOmjAnnKNbLvGQXzRryuoCEfuJuh', 0, 0),
(40, '2018-04-20 18:41:34', 'UnKUPYGhNBRRsXLajjBLBiEEayCDlFfJ', 0, 0),
(40, '2018-04-20 18:44:38', 'wDiNsEkFltpgipuYjMGKYJdAFUXbEloE', 0, 0),
(121, '2018-04-22 16:13:18', 'WPGtwZuYcEFdHLIFGRVWvrTLSxCtnlKn', 0, 0),
(121, '2018-04-22 16:15:37', 'ltqLZgJHERyFSIexbwmbTNsTbHAIuYHe', 0, 0),
(40, '2018-04-22 16:15:46', 'UAhNoQFYtKCMWcBxFzSVaMRiATYSgDtb', 0, 0),
(121, '2018-04-22 16:16:08', 'wOnZwGaTBnXuCdxgDwsYZlHiWsxhdJfc', 0, 0),
(40, '2018-04-22 16:17:54', 'jBNRvSCygihvmlJHcwcStdTbmUoJOpSF', 0, 0),
(121, '2018-04-22 16:18:55', 'WhEhUITIaxsZXPkiwglwUXmANdPMCqMQ', 0, 0),
(121, '2018-04-22 16:21:42', 'RbvmHfNvZTsWTjTEhHhjcTxYMnjluJEk', 0, 0),
(121, '2018-04-22 16:22:33', 'BTeyfpAeQhxBCFgBlFbKAzhgSihrXAVC', 0, 0),
(121, '2018-04-22 16:22:42', 'ESXMUCPumiCTKkGzLQBqOFSAENYCfDdk', 0, 0),
(121, '2018-04-22 16:23:15', 'uUnyZyrXCuoAUEFpbRdpXSQOaJmZdcNl', 0, 0),
(121, '2018-04-22 16:24:10', 'qOjwVkCrKRZaGvTVpMFLElWALGUHCEOt', 0, 0),
(121, '2018-04-22 16:30:08', 'nixWppWLxAPQjHuWiLlaNuZLwTKtlUyc', 0, 0),
(121, '2018-04-22 16:31:14', 'wrfTSbhhDidbDKJembPYsQQQViNRNxxv', 0, 0),
(122, '2018-04-22 16:31:54', 'okJaAYwMumRbUPBBmQxmsulhlUQlsuky', 0, 0),
(122, '2018-04-22 16:32:39', 'RxfsiqReYsgdxavQLYKZYPSNncoLblWY', 0, 0),
(40, '2018-04-22 16:36:58', 'OZBZoPxabCSGxxKogioAVVRChiFsVhKR', 0, 0),
(40, '2018-04-22 16:39:31', 'BEKcUhbqTCZnmLUihrXsXvZdxJjinzvU', 0, 0),
(40, '2018-04-22 16:43:43', 'NEhJfqahjYsXNyoIsuIzZsNymMjSOonc', 0, 0),
(40, '2018-04-22 16:45:04', 'DtuRMfttIihNZptXeOhwAEtMUPHLpzrA', 0, 0),
(40, '2018-04-22 16:48:30', 'mqKUqYPIDUjrMQUCURdxEvNqKZxORGeC', 0, 0),
(40, '2018-04-22 16:50:03', 'dBNTPOlrhThKuvXTYtSoPdsWWSoknlss', 0, 0),
(40, '2018-04-22 16:51:39', 'sJNzvJaHJrcEJyzWLYSNIjVjuHAiLEKO', 0, 0),
(40, '2018-04-22 16:53:58', 'ohffjuRCJFtwAoRRdXaFSLgoUIPgHFBr', 0, 0),
(40, '2018-04-22 16:55:17', 'BZZYPZkIidvPQjDjpvVJoAWxSOLQXySg', 0, 0),
(123, '2018-04-22 16:56:25', 'JfHQLdEjQZEUHVVQNiZZGxoIRWcXWIcj', 0, 0),
(40, '2018-04-22 17:25:12', 'AnwyAAqjtgOuTmbGMvHoDMORrhZhMoQa', 0, 0),
(40, '2018-04-22 17:33:42', 'AyKNasjcVTlbeUcroNkjrMGuYzhCNPhZ', 0, 0),
(40, '2018-04-22 17:35:24', 'CCUlfWqLnDCIMwyjqizhEEypzcRvDfFB', 0, 0),
(40, '2018-04-22 17:36:41', 'IPZOjiySZvrbFkVnrQedzChQJlNDhBRC', 0, 0),
(40, '2018-04-22 17:37:51', 'qtLwjDceRszKKmtsujjdgGuoVtarDCqO', 0, 0),
(40, '2018-04-22 17:38:52', 'pfKvFzrSbKdimkJEmFXvVjYqPlkhJYMS', 0, 0),
(40, '2018-04-22 17:40:21', 'TyEylAJixMZEaOrbbxoLeoivoxSVOPAS', 0, 0),
(40, '2018-04-22 17:41:22', 'TsjxBQueXmGSmcqheMIPXzyalUFLGwjZ', 0, 0),
(40, '2018-04-22 17:43:59', 'gZLhXcqUPYAmICIfUqwhwoyQjXPjHwUa', 0, 0),
(40, '2018-04-22 17:45:23', 'LjahCdyfPACfLsIKOovuvwpnNIrGVpQC', 0, 0),
(40, '2018-04-22 17:47:05', 'vHicjEhURxgAjrjqTYPIzipECkjcXnKX', 0, 0),
(40, '2018-04-22 17:48:01', 'anCeTeFhWZvVKOWVLYRxwPQQSRxPvOkB', 0, 0),
(40, '2018-04-22 17:52:02', 'AICXnWjqToKMXaeTCeuyOvWcjtyawvKX', 0, 0),
(40, '2018-04-22 17:56:49', 'iyypFPRYFDvJLYtBbxTTOAMJBedUOIMo', 0, 0),
(40, '2018-04-22 17:57:53', 'voqBgzZHrMFWWqeWmSXmKuMmrDcqGaGx', 0, 0),
(40, '2018-04-22 18:07:28', 'dpWsoJWPaZsQbqjxYrBWzEuDBmobGniD', 0, 0),
(40, '2018-04-22 18:09:30', 'ovizomvHmfCAVJgTlYafYgGzhlkJepGJ', 0, 0),
(40, '2018-04-22 19:14:53', 'xzmKJsFYREVoNTuEelIcouXTNJIZXvtV', 0, 0),
(40, '2018-04-22 19:17:45', 'alrWwuBSzZJGgnTMOSIExrGVmDZgQYGE', 0, 0),
(40, '2018-04-22 19:18:47', 'DUVVvjULzFmmWDqupnrgsyHDsuyPxDpt', 0, 0),
(40, '2018-04-22 21:01:46', 'ZAEWGhOrcNvkKsEmOjbjBsfTPvGOjWkl', 0, 0),
(40, '2018-04-22 21:04:00', 'JAWpmiomzQyodAPpyrVnUIytCORturYO', 0, 0),
(40, '2018-04-22 21:05:02', 'yEullsmoDdHKpqaGtphlgsahBvzfRYSp', 0, 0),
(119, '2018-04-22 21:06:32', 'dPDsIVCDAfOGIdikjBNNahyRpDTILods', 0, 0),
(120, '2018-04-22 21:11:09', 'hFlhiiJhynWTaBlzAQwHSzZRZWxWePvE', 0, 0),
(40, '2018-04-22 21:14:47', 'LfLqyeRQZFDSxKTROwyCfKGmewfFqBiu', 0, 0),
(120, '2018-04-22 21:15:03', 'PltkKbAbNXzBfmBoLUxotQqWPtBTlQSN', 0, 0),
(120, '2018-04-22 21:18:38', 'ScJmmYTvANwQbILeRIaBpALjAtKFdxBK', 0, 0);

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
(40, '3408748', 0x6d6f6e6d6470, 'Fabien', 'Tang'),
(118, '34587425', 0x746f746f, 'mane', 'toto');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `friends`
--
ALTER TABLE `friends`
  ADD PRIMARY KEY (`id_user`,`id_friend`);

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
  MODIFY `id` int(64) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=121;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
