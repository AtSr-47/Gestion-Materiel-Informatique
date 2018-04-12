-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 13 juin 2017 à 02:49
-- Version du serveur :  10.1.22-MariaDB
-- Version de PHP :  7.1.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `gestion_materiel`
--

-- --------------------------------------------------------

--
-- Structure de la table `admin`
--

CREATE TABLE `admin` (
  `id_ad` int(11) NOT NULL,
  `Username` varchar(50) NOT NULL,
  `Nom` varchar(25) NOT NULL,
  `Prenom` varchar(25) NOT NULL,
  `Password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `admin`
--

INSERT INTO `admin` (`id_ad`, `Username`, `Nom`, `Prenom`, `Password`, `email`) VALUES
(1, 'Admin', 'Srai', 'Athmane', 'callofduty', 'atmansm47@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `configuration`
--

CREATE TABLE `configuration` (
  `id_config` int(100) NOT NULL,
  `OS` varchar(50) NOT NULL,
  `CPU` varchar(50) NOT NULL,
  `RAM` varchar(25) NOT NULL,
  `HDD` varchar(25) NOT NULL,
  `Graphics` varchar(50) NOT NULL,
  `Serie` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `configuration`
--

INSERT INTO `configuration` (`id_config`, `OS`, `CPU`, `RAM`, `HDD`, `Graphics`, `Serie`) VALUES
(6, 'windows 7 Pro', 'Core i5 vPro', '4 Go', '500 Go Go', 'Intel(R) Graphics family', 'TRF14502BD'),
(7, 'windows XP Pro SP2', 'intel pentium R 4 cpu 3,00 GHz', '1,00 GB', '140 Go Go', 'ntel® Q 35 expresse chipsed family', 'CZC8261B4S'),
(8, 'windows 7 Pro  ', 'Intel core i5  cpu 650 3,20GHZ ', '2,00 GB ', '320 Go  Go', 'Intel(R) Graphics Media Accelerator HD', 'CZC10928Z4'),
(9, 'windows 7 Pro ', 'Core i5 vPro ', '4 Go ', '500 Go  Go', 'Intel(R) Graphics family ', 'TRF14502BR');

-- --------------------------------------------------------

--
-- Structure de la table `materiel`
--

CREATE TABLE `materiel` (
  `Serie` varchar(50) NOT NULL,
  `reference` varchar(25) NOT NULL,
  `Etat` varchar(25) DEFAULT NULL,
  `Date_debut_us` date NOT NULL,
  `Date_fin_us` date DEFAULT NULL,
  `Nom_Complet` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `materiel`
--

INSERT INTO `materiel` (`Serie`, `reference`, `Etat`, `Date_debut_us`, `Date_fin_us`, `Nom_Complet`) VALUES
(' FATSQ0C8FY830O', 'Souris hp', 'Utilisé', '2001-06-15', NULL, 'BAIROUK'),
('BAULH0IQR2L0OI', 'clavie hp ', 'Reformer', '2001-06-15', '2017-06-09', 'Bouhmad'),
('BAULHOLRZOVIHQ', 'Clavie hp', 'Utilisé', '2001-06-15', NULL, 'A_Elfadeli'),
('CNC03601N0', 'Souris hp', 'Utilisé', '2002-06-15', NULL, 'A_Elfadeli'),
('CNC205NY3C', 'ecran hp', 'Reformer', '2002-06-15', '2017-06-15', 'Bouhmad'),
('CNC205NYQW', 'ecran hp', 'Utilisé', '2002-06-15', NULL, 'BAIROUK'),
('CZC10928Z4', 'HP media center pc m 7000', 'Utilisé', '2002-06-15', NULL, 'A_Elfadeli'),
('CZC8261B4S', 'HP media center pc m 7000', 'Reformer', '2003-06-15', '2017-06-09', 'KARIMI'),
('TRF14502BD', 'HP Compaq 8200 Elite CMT', 'Utilisé', '2003-06-15', NULL, 'BAIROUK'),
('TRF14502BR', 'HP Compaq 8200 Elite CMT ', 'Reformer', '2003-06-15', '2017-06-02', 'Bouhmad');

-- --------------------------------------------------------

--
-- Structure de la table `type`
--

CREATE TABLE `type` (
  `id_type` int(50) NOT NULL,
  `type_mat` varchar(25) NOT NULL,
  `Inventaire` varchar(30) NOT NULL,
  `Serie` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `type`
--

INSERT INTO `type` (`id_type`, `type_mat`, `Inventaire`, `Serie`) VALUES
(20, 'Unité Centrale', 'OR0037', 'TRF14502BD'),
(21, 'Ecran', 'OR0037', 'CNC205NYQW'),
(22, 'Souris', 'Q121234', ' FATSQ0C8FY830O'),
(23, 'Unité Centrale', 'OR0050', 'CZC8261B4S'),
(24, 'Unité Centrale', 'OR0081 ', 'CZC10928Z4'),
(25, 'Souris', 'Q1313', 'CNC03601N0'),
(26, 'Clavie', 'q&é&', 'BAULHOLRZOVIHQ'),
(27, 'Unité Centrale', 'Q6756', 'TRF14502BR'),
(28, 'Ecran', 'Q122', 'CNC205NY3C'),
(29, 'Clavie', 'Q21323', 'BAULH0IQR2L0OI');

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `Nom_Complet` varchar(50) NOT NULL,
  `Service` varchar(30) NOT NULL,
  `N_Etage` int(11) NOT NULL,
  `Depart` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`Nom_Complet`, `Service`, `N_Etage`, `Depart`) VALUES
('Abdelkbir', 'service de la documentation', 2, 'D.A.F'),
('Abderahim', 'service de la documentation', 2, 'D.A.F'),
('A_Elfadeli', 'service informatique', 3, 'S.I'),
('BAIROUK', 'service informatique', 3, 'D.G.U'),
('Bouhmad', 'service du personnel', 4, 'D.E'),
('Channouq', 'service informatique', 3, 'D.G.U'),
('DIRECTEUR', 'service financier et comptable', 2, 'D.G'),
('Dirhaj', 'service informatique', 3, 'D.G.U'),
('el mehboul', 'service du personnel', 4, 'D.E'),
('Hallab', 'service de la documentation', 2, 'D.A.F'),
('HAYA ALLA ALI SALEM', 'service du personnel', 4, 'D.E'),
('iqbal', 'service du personnel', 4, 'D.E'),
('KARIMI', 'service informatique', 3, 'S.I'),
('Soumia', 'service de la documentation', 2, 'D.A.F'),
('youssef ', 'service financier et comptable', 2, 'D.G'),
('Zouhair', 'service informatique', 3, 'D.G.U');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`id_ad`);

--
-- Index pour la table `configuration`
--
ALTER TABLE `configuration`
  ADD PRIMARY KEY (`id_config`),
  ADD KEY `FK_Configuration_Serie` (`Serie`);

--
-- Index pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD PRIMARY KEY (`Serie`),
  ADD KEY `FK_Materiel_Nom_Complet` (`Nom_Complet`);

--
-- Index pour la table `type`
--
ALTER TABLE `type`
  ADD PRIMARY KEY (`id_type`),
  ADD KEY `FK_Type_Serie` (`Serie`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`Nom_Complet`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `admin`
--
ALTER TABLE `admin`
  MODIFY `id_ad` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;
--
-- AUTO_INCREMENT pour la table `configuration`
--
ALTER TABLE `configuration`
  MODIFY `id_config` int(100) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;
--
-- AUTO_INCREMENT pour la table `type`
--
ALTER TABLE `type`
  MODIFY `id_type` int(50) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `configuration`
--
ALTER TABLE `configuration`
  ADD CONSTRAINT `FK_Configuration_Serie` FOREIGN KEY (`Serie`) REFERENCES `materiel` (`Serie`);

--
-- Contraintes pour la table `materiel`
--
ALTER TABLE `materiel`
  ADD CONSTRAINT `FK_Materiel_Nom_Complet` FOREIGN KEY (`Nom_Complet`) REFERENCES `utilisateur` (`Nom_Complet`);

--
-- Contraintes pour la table `type`
--
ALTER TABLE `type`
  ADD CONSTRAINT `FK_Type_Serie` FOREIGN KEY (`Serie`) REFERENCES `materiel` (`Serie`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
