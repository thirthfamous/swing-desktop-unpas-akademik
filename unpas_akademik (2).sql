-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 17, 2017 at 01:19 PM
-- Server version: 10.1.28-MariaDB
-- PHP Version: 5.6.32

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Table structure for table `dosen`
--

CREATE TABLE `dosen` (
  `id_dosen` int(15) NOT NULL,
  `nama_dosen` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dosen`
--

INSERT INTO `dosen` (`id_dosen`, `nama_dosen`) VALUES
(1, 'Handoko Supeno'),
(2, 'Sandhika Galih');

-- --------------------------------------------------------

--
-- Table structure for table `dpp`
--

CREATE TABLE `dpp` (
  `id_dpp` int(15) NOT NULL,
  `status_dpp` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `dpp`
--

INSERT INTO `dpp` (`id_dpp`, `status_dpp`) VALUES
(0, 'belum lunas'),
(1, 'lunas');

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
  `id_dosen` int(15) NOT NULL,
  `id_dpp` int(15) NOT NULL DEFAULT '0'
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mhs`, `nrp`, `nama`, `alamat`, `jenis_kelamin`, `id_dosen`, `id_dpp`) VALUES
(1, '153040100', 'Reno Virgonata', 'Bandung', 'L', 1, 0),
(2, '153040102', 'Andrew', 'California', 'L', 2, 0),
(3, '153040103', 'Tom Penny', 'Jakarta', 'L', 1, 0),
(4, '153040104', 'Elissa Mahardini', 'Gorontalo', 'P', 2, 0),
(5, '153040105', 'Mikasa', 'Karawang', 'P', 1, 0),
(6, '153040106', 'Andy ', 'Jogjakarta', 'L', 1, 0),
(7, '153040107', 'Elsya', 'Bali', 'P', 2, 0),
(8, '153040108', 'Fabian', 'Jakarta', 'L', 2, 0),
(9, '153040109', 'Bambang', 'Medan', 'L', 2, 0),
(10, '153040110', 'Vinny', 'Solo', 'P', 1, 0),
(11, '153040111', 'Nadine', 'Bogor', 'P', 1, 0),
(12, '153040112', 'Lionel Yusuf', 'Manado', 'L', 2, 0),
(13, '153040113', 'Angel', 'Palembang', 'P', 2, 0),
(14, '153040114', 'Adi', 'Surabaya', 'L', 2, 0),
(15, '153040115', 'Sarah', 'Padang', 'P', 1, 0),
(16, '153040116', 'Irza', 'Malang', 'P', 2, 0),
(17, '153040117', 'Davio', 'Jakarta', 'L', 1, 0),
(18, '153040118', 'Bachtiar', 'Bandung', 'L', 1, 0),
(19, '153040119', 'Brian', 'Magelang', 'L', 1, 0),
(20, '153040120', 'Syafrina', 'Depok', 'P', 2, 0),
(21, '153040121', 'Lisa', 'Malang', 'P', 2, 0),
(22, '153040122', 'Putri', 'Bali', 'P', 2, 0),
(23, '153040123', 'Arif', 'Samarinda', 'L', 1, 0),
(24, '153040124', 'James', 'Sydney', 'L', 2, 0),
(25, '153040125', 'Chika', 'Kupang', 'P', 1, 0),
(26, '153040126', 'Chandra', 'Riau', 'L', 1, 0),
(27, '153040127', 'Amel', 'Bandung', 'P', 2, 0),
(28, '153040128', 'Linda', 'Palembang', 'P', 2, 0),
(29, '153040129', 'Fahri', 'Samarinda', 'L', 2, 0),
(30, '153040130', 'Bonar', 'Medan', 'L', 1, 0),
(31, '153040131', 'Wildan', 'Magelang', 'L', 1, 0),
(32, '153040132', 'Alda', 'Surabaya', 'P', 2, 0),
(33, '153040133', 'Melan', 'Lampung', 'P', 1, 0),
(34, '153040134', 'Adit', 'Mataram', 'L', 2, 0),
(35, '153040135', 'Fandi', 'Kupang', 'L', 1, 0),
(36, '153040136', 'Laura', 'Lombok', 'P', 2, 0),
(37, '153040137', 'Vian', 'Padang', 'L', 2, 0),
(38, '153040138', 'Achmad', 'Banten', 'L', 1, 0),
(39, '153040139', 'Dian', 'Jakarta', 'P', 2, 0),
(40, '153040140', 'Dwi', 'Solo', 'P', 1, 0),
(41, '153040141', 'Adam', 'Bandung', 'L', 1, 0),
(42, '153040142', 'Ayu', 'Jogjakarta', 'P', 1, 0),
(43, '153040143', 'Ribka', 'Madura', 'P', 2, 0),
(44, '153040144', 'Beni', 'Garut', 'L', 1, 0),
(45, '153040145', 'Agita', 'Makassar', 'P', 2, 0),
(46, '153040146', 'Alan', 'Magelang', 'L', 1, 0),
(47, '153040147', 'Nina', 'Balikpapan', 'P', 1, 0),
(48, '153040148', 'Ali', 'Subang', 'L', 2, 0),
(49, '153040149', 'Balqis', 'Riau', 'P', 1, 0),
(50, '153040150', 'Bunga', 'Tangerang', 'P', 2, 0),
(51, '153040151', 'Cahya', 'Jayapura', 'P', 1, 0),
(52, '153040152', 'Danang', 'Jogjakarta', 'L', 2, 0),
(53, '153040153', 'Danny', 'Singapore', 'L', 2, 0),
(54, '153040154', 'Ilham', 'Palu', 'L', 1, 0),
(55, '153040155', 'Dewandra', 'Tangerang', 'L', 2, 0),
(56, '154030156', 'Dhikatama', 'Jogjakarta', 'L', 2, 0),
(57, '153040157', 'Dilla', 'Sidoarjo', 'P', 1, 0),
(58, '153040158', 'Dinni', 'Batam', 'P', 2, 0),
(59, '153040159', 'Dito', 'Mataram', 'L', 1, 0),
(60, '153040160', 'Diva', 'Palembang', 'P', 1, 0),
(61, '153040161', 'Eko Widianto', 'Jayapura', 'L', 2, 0),
(62, '153040162', 'Elizabeth', 'Bali', 'P', 2, 0),
(63, '153040163', 'Engel', 'Semarang', 'P', 2, 0),
(64, '153040164', 'Excel Maulana', 'Padang', 'L', 1, 0),
(65, '153040165', 'Faiz', 'Lampung', 'L', 1, 0),
(66, '153040166', 'Fardian', 'Semarang', 'L', 2, 0),
(67, '153040167', 'Shafina', 'Jakarta', 'P', 1, 0),
(68, '153040168', 'Findri', 'Bandung', 'P', 2, 0),
(69, '153040169', 'Fariz', 'Bogor', 'L', 2, 0),
(70, '153040170', 'Garnish', 'Aceh', 'P', 1, 0),
(71, '153040171', 'Gary', 'Manado', 'L', 1, 0),
(72, '153040172', 'Gia', 'Bandung', 'L', 1, 0),
(73, '153040173', 'Gina', 'Subang', 'P', 1, 0),
(74, '153040174', 'Hanif', 'Jakarta', 'L', 2, 0),
(75, '153040175', 'Hira', 'Kupang', 'P', 2, 0),
(76, '153040176', 'Lili', 'Subang', 'P', 2, 0),
(77, '153040177', 'Iqa', 'Palu', 'P', 1, 0),
(78, '153040178', 'Irwan', 'Makassar', 'L', 2, 0),
(79, '153040179', 'Tari', 'Jambi', 'P', 2, 0),
(80, '153040180', 'Mita', 'Jonggol', 'P', 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `matakuliah`
--

CREATE TABLE `matakuliah` (
  `id_mk` int(15) NOT NULL,
  `nama_mk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `matakuliah`
--

INSERT INTO `matakuliah` (`id_mk`, `nama_mk`) VALUES
(1, 'Konstruksi Perangkat Lunak Berorientasi Objek'),
(2, 'Rekayasa Perangkat Lunak');

-- --------------------------------------------------------

--
-- Table structure for table `ngulang`
--

CREATE TABLE `ngulang` (
  `id_mhs` int(12) NOT NULL,
  `id_mk` int(15) NOT NULL,
  `ngulang_counter` int(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ngulang`
--

INSERT INTO `ngulang` (`id_mhs`, `id_mk`, `ngulang_counter`) VALUES
(0, 1, 2),
(0, 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `nilai_mk`
--

CREATE TABLE `nilai_mk` (
  `id_mk` int(15) NOT NULL,
  `id_mhs` int(12) NOT NULL,
  `index` varchar(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `nilai_mk`
--

INSERT INTO `nilai_mk` (`id_mk`, `id_mhs`, `index`) VALUES
(1, 0, 'a'),
(2, 0, 'a');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `id_user` int(15) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `hak_akses` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`id_user`, `username`, `password`, `hak_akses`) VALUES
(1, 'handoko', '688e8d637cfd31ef2ec8589e6ffadec', 'dosenwali'),
(2, 'wanda', '688e8d637cfd31ef2ec8589e6ffadec', 'dosenwali'),
(3, 'hendra', '688e8d637cfd31ef2ec8589e6ffadec', 'dikjar');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `dosen`
--
ALTER TABLE `dosen`
  ADD PRIMARY KEY (`id_dosen`);

--
-- Indexes for table `dpp`
--
ALTER TABLE `dpp`
  ADD PRIMARY KEY (`id_dpp`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mhs`);

--
-- Indexes for table `matakuliah`
--
ALTER TABLE `matakuliah`
  ADD PRIMARY KEY (`id_mk`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `dosen`
--
ALTER TABLE `dosen`
  MODIFY `id_dosen` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  MODIFY `id_mhs` int(12) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=83;

--
-- AUTO_INCREMENT for table `matakuliah`
--
ALTER TABLE `matakuliah`
  MODIFY `id_mk` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(15) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
