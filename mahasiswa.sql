-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Dec 16, 2017 at 02:06 PM
-- Server version: 10.1.13-MariaDB
-- PHP Version: 5.6.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `unpas_akademik`
--

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mhs` int(12) NOT NULL,
  `nrp` varchar(10) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `alamat` text NOT NULL,
  `jenis_kelamin` varchar(5) NOT NULL,
  `id_dosen` int(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mhs`, `nrp`, `nama`, `alamat`, `jenis_kelamin`, `id_dosen`) VALUES
(1, '153040100', 'Reno Virgonata', 'Bandung', 'L', 1),
(2, '153040102', 'Andrew', 'California', 'L', 2),
(3, '153040103', 'Tom Penny', 'Jakarta', 'L', 1),
(4, '153040104', 'Elissa Mahardini', 'Gorontalo', 'P', 2),
(5, '153040105', 'Mikasa', 'Karawang', 'P', 1),
(6, '153040106', 'Andy ', 'Jogjakarta', 'L', 1),
(7, '153040107', 'Elsya', 'Bali', 'P', 2),
(8, '153040108', 'Fabian', 'Jakarta', 'L', 2),
(9, '153040109', 'Bambang', 'Medan', 'L', 2),
(10, '153040110', 'Vinny', 'Solo', 'P', 1),
(11, '153040111', 'Nadine', 'Bogor', 'P', 1),
(12, '153040112', 'Lionel Yusuf', 'Manado', 'L', 2),
(13, '153040113', 'Angel', 'Palembang', 'P', 2),
(14, '153040114', 'Adi', 'Surabaya', 'L', 2),
(15, '153040115', 'Sarah', 'Padang', 'P', 1),
(16, '153040116', 'Irza', 'Malang', 'P', 2),
(17, '153040117', 'Davio', 'Jakarta', 'L', 1),
(18, '153040118', 'Bachtiar', 'Bandung', 'L', 1),
(19, '153040119', 'Brian', 'Magelang', 'L', 1),
(20, '153040120', 'Syafrina', 'Depok', 'P', 2),
(21, '153040121', 'Lisa', 'Malang', 'P', 2),
(22, '153040122', 'Putri', 'Bali', 'P', 2),
(23, '153040123', 'Arif', 'Samarinda', 'L', 1),
(24, '153040124', 'James', 'Sydney', 'L', 2),
(25, '153040125', 'Chika', 'Kupang', 'P', 1),
(26, '153040126', 'Chandra', 'Riau', 'L', 1),
(27, '153040127', 'Amel', 'Bandung', 'P', 2),
(28, '153040128', 'Linda', 'Palembang', 'P', 2),
(29, '153040129', 'Fahri', 'Samarinda', 'L', 2),
(30, '153040130', 'Bonar', 'Medan', 'L', 1),
(31, '153040131', 'Wildan', 'Magelang', 'L', 1),
(32, '153040132', 'Alda', 'Surabaya', 'P', 2),
(33, '153040133', 'Melan', 'Lampung', 'P', 1),
(34, '153040134', 'Adit', 'Mataram', 'L', 2),
(35, '153040135', 'Fandi', 'Kupang', 'L', 1),
(36, '153040136', 'Laura', 'Lombok', 'P', 2),
(37, '153040137', 'Vian', 'Padang', 'L', 2),
(38, '153040138', 'Achmad', 'Banten', 'L', 1),
(39, '153040139', 'Dian', 'Jakarta', 'P', 2),
(40, '153040140', 'Dwi', 'Solo', 'P', 1),
(41, '153040141', 'Adam', 'Bandung', 'L', 1),
(42, '153040142', 'Ayu', 'Jogjakarta', 'P', 1),
(43, '153040143', 'Ribka', 'Madura', 'P', 2),
(44, '153040144', 'Beni', 'Garut', 'L', 1),
(45, '153040145', 'Agita', 'Makassar', 'P', 2),
(46, '153040146', 'Alan', 'Magelang', 'L', 1),
(47, '153040147', 'Nina', 'Balikpapan', 'P', 1),
(48, '153040148', 'Ali', 'Subang', 'L', 2),
(49, '153040149', 'Balqis', 'Riau', 'P', 1),
(50, '153040150', 'Bunga', 'Tangerang', 'P', 2),
(51, '153040151', 'Cahya', 'Jayapura', 'P', 1),
(52, '153040152', 'Danang', 'Jogjakarta', 'L', 2),
(53, '153040153', 'Danny', 'Singapore', 'L', 2),
(54, '153040154', 'Ilham', 'Palu', 'L', 1),
(55, '153040155', 'Dewandra', 'Tangerang', 'L', 2),
(56, '154030156', 'Dhikatama', 'Jogjakarta', 'L', 2),
(57, '153040157', 'Dilla', 'Sidoarjo', 'P', 1),
(58, '153040158', 'Dinni', 'Batam', 'P', 2),
(59, '153040159', 'Dito', 'Mataram', 'L', 1),
(60, '153040160', 'Diva', 'Palembang', 'P', 1),
(61, '153040161', 'Eko Widianto', 'Jayapura', 'L', 2),
(62, '153040162', 'Elizabeth', 'Bali', 'P', 2),
(63, '153040163', 'Engel', 'Semarang', 'P', 2),
(64, '153040164', 'Excel Maulana', 'Padang', 'L', 1),
(65, '153040165', 'Faiz', 'Lampung', 'L', 1),
(66, '153040166', 'Fardian', 'Semarang', 'L', 2),
(67, '153040167', 'Shafina', 'Jakarta', 'P', 1),
(68, '153040168', 'Findri', 'Bandung', 'P', 2),
(69, '153040169', 'Fariz', 'Bogor', 'L', 2),
(70, '153040170', 'Garnish', 'Aceh', 'P', 1),
(71, '153040171', 'Gary', 'Manado', 'L', 1),
(72, '153040172', 'Gia', 'Bandung', 'L', 1),
(73, '153040173', 'Gina', 'Subang', 'P', 1),
(74, '153040174', 'Hanif', 'Jakarta', 'L', 2),
(75, '153040175', 'Hira', 'Kupang', 'P', 2),
(76, '153040176', 'Lili', 'Subang', 'P', 2),
(77, '153040177', 'Iqa', 'Palu', 'P', 1),
(78, '153040178', 'Irwan', 'Makassar', 'L', 2),
(79, '153040179', 'Tari', 'Jambi', 'P', 2),
(80, '153040180', 'Mita', 'Jonggol', 'P', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mhs`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_mhs` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
