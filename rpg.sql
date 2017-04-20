-- phpMyAdmin SQL Dump
-- version 4.6.5.2
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 20-Abr-2017 às 05:21
-- Versão do servidor: 10.1.21-MariaDB
-- PHP Version: 5.6.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rpg`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `classe`
--

CREATE TABLE `classe` (
  `classeID` int(10) UNSIGNED NOT NULL,
  `nome` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `classe`
--

INSERT INTO `classe` (`classeID`, `nome`) VALUES
(1, 'Alquimista'),
(2, 'Amazona'),
(3, 'Arqueiro'),
(4, 'Assassino'),
(5, 'Bárbaro'),
(6, 'Bardo'),
(7, 'Bruxo'),
(8, 'Caçador'),
(9, 'Cavaleiro'),
(10, 'Clérigo'),
(11, 'Demonologista'),
(12, 'Druida'),
(13, 'Elementalista'),
(14, 'Feiticeiro'),
(15, 'Guerreiro'),
(16, 'Ladino'),
(17, 'Mago'),
(18, 'Necromante'),
(19, 'Paladino'),
(20, 'Pirata'),
(21, 'Pistoleiro'),
(22, 'Ranger'),
(23, 'Samurai'),
(24, 'Shinobi'),
(25, 'Telepata'),
(26, 'Vigilante');

-- --------------------------------------------------------

--
-- Estrutura da tabela `personagem`
--

CREATE TABLE `personagem` (
  `personagemID` int(10) UNSIGNED NOT NULL,
  `usuarioID` int(10) UNSIGNED NOT NULL,
  `nome` varchar(64) NOT NULL,
  `nivel` int(11) NOT NULL,
  `racaID` int(10) UNSIGNED NOT NULL,
  `classeID` int(10) UNSIGNED NOT NULL,
  `forca` int(11) NOT NULL,
  `habilidade` int(11) NOT NULL,
  `resistencia` int(11) NOT NULL,
  `armadura` int(11) NOT NULL,
  `vida` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `personagem`
--

INSERT INTO `personagem` (`personagemID`, `usuarioID`, `nome`, `nivel`, `racaID`, `classeID`, `forca`, `habilidade`, `resistencia`, `armadura`, `vida`) VALUES
(8, 1, 'Teste', 1, 15, 12, 231, 231, 21, 21, 112),
(10, 1, 'ghtd', 1, 15, 12, 231, 231, 21, 21, 112),
(11, 1, 'ghtd', 1, 15, 12, 231, 231, 21, 21, 112);

-- --------------------------------------------------------

--
-- Estrutura da tabela `raca`
--

CREATE TABLE `raca` (
  `racaID` int(10) UNSIGNED NOT NULL,
  `nome` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `raca`
--

INSERT INTO `raca` (`racaID`, `nome`) VALUES
(1, 'Humano'),
(2, 'Anão'),
(3, 'Elfo'),
(4, 'Elfo Negro'),
(5, 'Gnomo'),
(6, 'Halfling'),
(7, 'Meio-Elfo'),
(8, 'Meio-Orc'),
(9, 'Alien'),
(10, 'Anfíbio'),
(11, 'Centauro'),
(12, 'Goblin'),
(13, 'Kemono'),
(14, 'Meio-Dragão'),
(15, 'Minotauro'),
(16, 'Ogre'),
(17, 'Troglodita'),
(18, 'Anjo'),
(19, 'Demônio'),
(20, 'Fada'),
(21, 'Licantropo'),
(22, 'Meio-Abissal'),
(23, 'Meio-Celestial'),
(24, 'Meio-Gênio'),
(25, 'Androide'),
(26, 'Ciborgue'),
(27, 'Golem'),
(28, 'Mecha'),
(29, 'Esqueleto'),
(30, 'Fantasma'),
(31, 'Múmia'),
(32, 'Vampiro'),
(33, 'Zumbi');

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `usuarioID` int(10) UNSIGNED NOT NULL,
  `nome` varchar(64) NOT NULL,
  `email` varchar(64) NOT NULL,
  `login` varchar(64) NOT NULL,
  `senha` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`usuarioID`, `nome`, `email`, `login`, `senha`) VALUES
(1, 'Usuário 1', 'user01@user.com', 'user01', '123456'),
(2, 'Vinicius Faria', 'vini@hot.com', 'vini', 'vini'),
(3, 'Teste', 'teste', 'teste', 'teste'),
(6, 'teste3', 'teste3', 'teste2', 'teste2'),
(7, 'admin', 'admin', 'admin', 'admin');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `classe`
--
ALTER TABLE `classe`
  ADD PRIMARY KEY (`classeID`);

--
-- Indexes for table `personagem`
--
ALTER TABLE `personagem`
  ADD PRIMARY KEY (`personagemID`),
  ADD KEY `racaID` (`racaID`),
  ADD KEY `classeID` (`classeID`),
  ADD KEY `usuarioID` (`usuarioID`);

--
-- Indexes for table `raca`
--
ALTER TABLE `raca`
  ADD PRIMARY KEY (`racaID`);

--
-- Indexes for table `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`usuarioID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `classe`
--
ALTER TABLE `classe`
  MODIFY `classeID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;
--
-- AUTO_INCREMENT for table `personagem`
--
ALTER TABLE `personagem`
  MODIFY `personagemID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `raca`
--
ALTER TABLE `raca`
  MODIFY `racaID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;
--
-- AUTO_INCREMENT for table `usuario`
--
ALTER TABLE `usuario`
  MODIFY `usuarioID` int(10) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
--
-- Constraints for dumped tables
--

--
-- Limitadores para a tabela `personagem`
--
ALTER TABLE `personagem`
  ADD CONSTRAINT `personagem_ibfk_1` FOREIGN KEY (`racaID`) REFERENCES `raca` (`racaID`),
  ADD CONSTRAINT `personagem_ibfk_2` FOREIGN KEY (`classeID`) REFERENCES `classe` (`classeID`),
  ADD CONSTRAINT `personagem_ibfk_3` FOREIGN KEY (`usuarioID`) REFERENCES `usuario` (`usuarioID`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
