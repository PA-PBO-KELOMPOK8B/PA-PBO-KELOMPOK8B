-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 21, 2024 at 12:30 PM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `baru`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` char(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jumlah` char(30) NOT NULL,
  `peminjaman_id_peminjaman` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `jumlah`, `peminjaman_id_peminjaman`) VALUES
('001', 'Penggaris', '10', '2321'),
('002', 'Spidol', '20', '2321'),
('003', 'Penghapus', '15', '2321'),
('004', 'Kursi Dosen', '5', '2322'),
('005', 'Kursi Mahasiswa', '50', '2322'),
('006', 'Meja Dosen', '3', '2323'),
('007', 'Proyektor', '6', '2323');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mahasiswa` char(10) NOT NULL,
  `nim` varchar(12) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mahasiswa`, `nim`, `nama`, `password`) VALUES
('121', '23678964', 'Ricky', 'ricky1'),
('122', '23678977', 'Mita', 'mita1'),
('123', '23678993', 'Raizky', 'raizky1'),
('124', '23678958', 'Alvin', 'alvin1');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` int(11) NOT NULL,
  `nama_ruangan` varchar(25) DEFAULT NULL,
  `nama_barang` varchar(25) DEFAULT NULL,
  `tanggal_peminjaman` date NOT NULL DEFAULT current_timestamp(),
  `tanggal_kembali` date DEFAULT NULL,
  `status` varchar(25) DEFAULT 'Pending',
  `tipe_peminjaman` varchar(25) DEFAULT NULL,
  `jam_pemakaian` varchar(5) DEFAULT NULL,
  `ruangan_id_ruangan` char(5) DEFAULT NULL,
  `mahasiswa_id_mahasiswa` char(10) DEFAULT NULL,
  `staff_id_staff` char(10) DEFAULT NULL,
  `riwayat_peminjaman_id_riwayat` char(10) DEFAULT NULL,
  `id_barang` char(5) DEFAULT NULL,
  `kuantitas` char(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `nama_ruangan`, `nama_barang`, `tanggal_peminjaman`, `tanggal_kembali`, `status`, `tipe_peminjaman`, `jam_pemakaian`, `ruangan_id_ruangan`, `mahasiswa_id_mahasiswa`, `staff_id_staff`, `riwayat_peminjaman_id_riwayat`, `id_barang`, `kuantitas`) VALUES
(455, '', NULL, '2024-11-21', '2024-11-22', 'Disetujui', 'Barang dan Ruangan', '', '12', '121', '243021', '341', '', ''),
(456, '', NULL, '2024-11-22', '2024-11-23', 'Disetujui', 'Barang', '', '14', '121', '243021', '337', '', ''),
(457, '', NULL, '2024-11-23', '2024-11-24', 'Ditolak', 'Ruangan', '', '13', '122', '243022', '340', '', ''),
(458, '', NULL, '2024-11-24', '2024-11-25', 'Disetujui', 'Barang', '', '15', '122', '243022', '338', '', ''),
(459, '', NULL, '2024-11-25', '2024-11-26', 'Disetujui', 'Barang dan Ruangan', '', '16', '121', '243024', '339', '', ''),
(460, 'C303', NULL, '2017-08-22', NULL, 'Pending', NULL, '09:88', NULL, 'MHS001', NULL, NULL, NULL, NULL),
(461, 'C303', NULL, '2017-08-22', NULL, 'Pending', NULL, '09:88', NULL, 'MHS001', NULL, NULL, NULL, NULL),
(462, NULL, NULL, '2022-11-11', NULL, 'Pending', NULL, NULL, NULL, NULL, NULL, NULL, '001', '1'),
(463, 'C303', NULL, '2023-12-24', NULL, 'Pending', NULL, '08.00', NULL, 'MHS001', NULL, NULL, NULL, NULL),
(464, NULL, NULL, '2023-12-16', NULL, 'Pending', NULL, NULL, NULL, NULL, NULL, NULL, '001', '2'),
(465, NULL, NULL, '2023-08-10', NULL, 'Pending', 'Barang', NULL, NULL, NULL, NULL, NULL, '002', '3'),
(466, NULL, NULL, '2023-08-10', NULL, 'Ditolak', 'Barang', NULL, NULL, NULL, NULL, NULL, '002', '3'),
(467, 'C303', NULL, '2024-08-18', NULL, 'Disetujui', 'Ruangan', '09.00', NULL, 'MHS001', NULL, NULL, NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_peminjaman`
--

CREATE TABLE `riwayat_peminjaman` (
  `id_riwayat` char(10) NOT NULL,
  `tanggal_pengajuan` date NOT NULL,
  `tanggal_persetujuan` date NOT NULL,
  `status` varchar(20) NOT NULL,
  `peminjaman_id_peminjaman` char(5) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `riwayat_peminjaman`
--

INSERT INTO `riwayat_peminjaman` (`id_riwayat`, `tanggal_pengajuan`, `tanggal_persetujuan`, `status`, `peminjaman_id_peminjaman`) VALUES
('337', '2024-11-27', '2024-11-27', 'Disetujui', '456'),
('338', '2024-11-28', '2024-11-28', 'Ditolak', '458'),
('339', '2024-11-29', '2024-11-29', 'Pending', '459'),
('340', '2024-11-30', '2024-11-30', 'Disetujui', '457'),
('341', '2024-11-21', '2024-11-12', 'Pending', '455');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` char(5) NOT NULL,
  `nama_ruangan` varchar(20) DEFAULT NULL,
  `gedung` varchar(25) NOT NULL,
  `fasilitas` varchar(100) NOT NULL,
  `status` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama_ruangan`, `gedung`, `fasilitas`, `status`) VALUES
('12', 'C303', 'Gedung C', 'AC, Whiteboard, TV', 'Tersedia'),
('13', 'C402', 'Gedung C', 'AC, Whiteboard, TV', 'Tersedia'),
('14', 'C404', 'Gedung C', 'AC, Whiteboard, TV', 'Tersedia'),
('15', 'C407', 'Gedung C', 'AC, Whiteboard, TV', 'Tersedia'),
('16', 'D203', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia'),
('17', 'D208', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia'),
('18', 'D303', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia'),
('19', 'D307', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia'),
('20', 'D402', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia'),
('21', 'D408', 'Gedung D', 'AC, Whiteboard, TV', 'Tersedia');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id_staff` char(10) NOT NULL,
  `nama` varchar(25) NOT NULL,
  `jabatan` varchar(20) NOT NULL,
  `no_telp` varchar(13) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id_staff`, `nama`, `jabatan`, `no_telp`) VALUES
('243021', 'amin', 'Staff', '0822567654555'),
('243022', 'Agus', 'Staff', '082292778654'),
('243024', 'Arif', 'Staff', '082292736899'),
('243025', 'Samsul', 'Staff', '088635765255');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`id_barang`),
  ADD KEY `barang_peminjaman_fk` (`peminjaman_id_peminjaman`);

--
-- Indexes for table `mahasiswa`
--
ALTER TABLE `mahasiswa`
  ADD PRIMARY KEY (`id_mahasiswa`);

--
-- Indexes for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD PRIMARY KEY (`id_peminjaman`),
  ADD UNIQUE KEY `peminjaman_ruangan_idx` (`ruangan_id_ruangan`),
  ADD UNIQUE KEY `peminjaman_rwyt_idx` (`riwayat_peminjaman_id_riwayat`),
  ADD KEY `peminjaman_mahasiswa_fk` (`mahasiswa_id_mahasiswa`),
  ADD KEY `peminjaman_staff_fk` (`staff_id_staff`);

--
-- Indexes for table `riwayat_peminjaman`
--
ALTER TABLE `riwayat_peminjaman`
  ADD PRIMARY KEY (`id_riwayat`),
  ADD UNIQUE KEY `rwyt_peminjaman_idx` (`peminjaman_id_peminjaman`);

--
-- Indexes for table `ruangan`
--
ALTER TABLE `ruangan`
  ADD PRIMARY KEY (`id_ruangan`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`id_staff`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `peminjaman`
--
ALTER TABLE `peminjaman`
  MODIFY `id_peminjaman` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=468;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
