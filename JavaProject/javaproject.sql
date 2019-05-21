-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: localhost:8889
-- Generation Time: May 21, 2019 at 08:57 PM
-- Server version: 5.7.25
-- PHP Version: 7.3.1

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `javaproject`
--

-- --------------------------------------------------------

--
-- Table structure for table `AnnéeScolaire`
--

CREATE TABLE `AnnéeScolaire` (
  `id` int(4) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Bulletin`
--

CREATE TABLE `Bulletin` (
  `id` int(11) NOT NULL,
  `trimestre_id` int(11) NOT NULL,
  `inscription_id` int(11) NOT NULL,
  `appréciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Classe`
--

CREATE TABLE `Classe` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `école_id` int(11) NOT NULL,
  `niveau_id` int(11) NOT NULL,
  `annéescolaire_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `DetailBulletin`
--

CREATE TABLE `DetailBulletin` (
  `id` int(11) NOT NULL,
  `bulletin_id` int(11) NOT NULL,
  `enseignement_id` int(11) NOT NULL,
  `appréciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Discipline`
--

CREATE TABLE `Discipline` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Ecole`
--

CREATE TABLE `Ecole` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Enseignement`
--

CREATE TABLE `Enseignement` (
  `id` int(11) NOT NULL,
  `classe_id` int(11) NOT NULL,
  `discipline_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Evaluation`
--

CREATE TABLE `Evaluation` (
  `id` int(11) NOT NULL,
  `detailbulletin_id` int(11) NOT NULL,
  `note` float NOT NULL,
  `appréciation` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Inscription`
--

CREATE TABLE `Inscription` (
  `id` int(11) NOT NULL,
  `classe_id` int(11) NOT NULL,
  `personne_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Niveau`
--

CREATE TABLE `Niveau` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Personne`
--

CREATE TABLE `Personne` (
  `id` int(11) NOT NULL,
  `nom` varchar(50) NOT NULL,
  `prénom` varchar(50) NOT NULL,
  `type` enum('enseignant','élève') DEFAULT 'élève'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Table structure for table `Trimestre`
--

CREATE TABLE `Trimestre` (
  `id` int(11) NOT NULL,
  `numéro` int(11) NOT NULL,
  `début` text NOT NULL,
  `fin` text NOT NULL,
  `annéescolaire_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `AnnéeScolaire`
--
ALTER TABLE `AnnéeScolaire`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Trimestre` (`trimestre_id`),
  ADD KEY `Inscription` (`inscription_id`);

--
-- Indexes for table `Classe`
--
ALTER TABLE `Classe`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Ecole` (`école_id`),
  ADD KEY `Niveau` (`niveau_id`),
  ADD KEY `AnnéeScolaire2` (`annéescolaire_id`);

--
-- Indexes for table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Bulletin` (`bulletin_id`),
  ADD KEY `Enseignement` (`enseignement_id`);

--
-- Indexes for table `Discipline`
--
ALTER TABLE `Discipline`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Ecole`
--
ALTER TABLE `Ecole`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Enseignement`
--
ALTER TABLE `Enseignement`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Classe` (`classe_id`),
  ADD KEY `Discipline` (`discipline_id`),
  ADD KEY `Personne` (`personne_id`);

--
-- Indexes for table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `DetailBulletin` (`detailbulletin_id`);

--
-- Indexes for table `Inscription`
--
ALTER TABLE `Inscription`
  ADD PRIMARY KEY (`id`),
  ADD KEY `Classe2` (`classe_id`),
  ADD KEY `Personne2` (`personne_id`);

--
-- Indexes for table `Niveau`
--
ALTER TABLE `Niveau`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Personne`
--
ALTER TABLE `Personne`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Trimestre`
--
ALTER TABLE `Trimestre`
  ADD PRIMARY KEY (`id`),
  ADD KEY `AnnéeScolaire` (`annéescolaire_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Bulletin`
--
ALTER TABLE `Bulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Classe`
--
ALTER TABLE `Classe`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Discipline`
--
ALTER TABLE `Discipline`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Ecole`
--
ALTER TABLE `Ecole`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Enseignement`
--
ALTER TABLE `Enseignement`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Evaluation`
--
ALTER TABLE `Evaluation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Inscription`
--
ALTER TABLE `Inscription`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Niveau`
--
ALTER TABLE `Niveau`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Personne`
--
ALTER TABLE `Personne`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `Trimestre`
--
ALTER TABLE `Trimestre`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `Bulletin`
--
ALTER TABLE `Bulletin`
  ADD CONSTRAINT `Inscription` FOREIGN KEY (`inscription_id`) REFERENCES `Inscription` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Trimestre` FOREIGN KEY (`trimestre_id`) REFERENCES `Trimestre` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Classe`
--
ALTER TABLE `Classe`
  ADD CONSTRAINT `AnnéeScolaire2` FOREIGN KEY (`annéescolaire_id`) REFERENCES `AnnéeScolaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Ecole` FOREIGN KEY (`école_id`) REFERENCES `Ecole` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Niveau` FOREIGN KEY (`niveau_id`) REFERENCES `Niveau` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `DetailBulletin`
--
ALTER TABLE `DetailBulletin`
  ADD CONSTRAINT `Bulletin` FOREIGN KEY (`bulletin_id`) REFERENCES `Bulletin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Enseignement` FOREIGN KEY (`enseignement_id`) REFERENCES `Enseignement` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Enseignement`
--
ALTER TABLE `Enseignement`
  ADD CONSTRAINT `Classe` FOREIGN KEY (`classe_id`) REFERENCES `Classe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Discipline` FOREIGN KEY (`discipline_id`) REFERENCES `Discipline` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Personne` FOREIGN KEY (`personne_id`) REFERENCES `Personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Evaluation`
--
ALTER TABLE `Evaluation`
  ADD CONSTRAINT `DetailBulletin` FOREIGN KEY (`detailbulletin_id`) REFERENCES `DetailBulletin` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Inscription`
--
ALTER TABLE `Inscription`
  ADD CONSTRAINT `Classe2` FOREIGN KEY (`classe_id`) REFERENCES `Classe` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `Personne2` FOREIGN KEY (`personne_id`) REFERENCES `Personne` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `Trimestre`
--
ALTER TABLE `Trimestre`
  ADD CONSTRAINT `AnnéeScolaire` FOREIGN KEY (`annéescolaire_id`) REFERENCES `AnnéeScolaire` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION;
