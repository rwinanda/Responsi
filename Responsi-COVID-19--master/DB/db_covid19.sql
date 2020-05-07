-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 07, 2020 at 06:28 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.1.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_covid19`
--

-- --------------------------------------------------------

--
-- Table structure for table `tabel_covid`
--

CREATE TABLE `tabel_covid` (
  `id` int(11) NOT NULL,
  `tanggal` varchar(50) NOT NULL,
  `negara` varchar(20) NOT NULL,
  `positif` int(11) NOT NULL,
  `sembuh` int(11) NOT NULL,
  `meninggal` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tabel_covid`
--

INSERT INTO `tabel_covid` (`id`, `tanggal`, `negara`, `positif`, `sembuh`, `meninggal`) VALUES
(62, '12 Maret 2020', 'Indonesia', 300, 23, 30);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tabel_covid`
--
ALTER TABLE `tabel_covid`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
