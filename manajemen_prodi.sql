-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 10, 2024 at 05:47 PM
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
-- Database: `sistem manajemen peminjaman ruangan`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `id_barang` char(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jumlah` int(11) NOT NULL,
  `peminjaman_id_peminjaman` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`id_barang`, `nama`, `jumlah`, `peminjaman_id_peminjaman`) VALUES
('001', 'Spidol', 5, '222'),
('002', 'Penggaris', 6, '223'),
('003', 'Penghapus', 7, '223'),
('004', 'Kursi Dosen', 10, '223'),
('005', 'Kursi Mahasiswa', 130, '223'),
('006', 'Meja Dosen', 1, '223'),
('007', 'Proyektor', 1, '223');

-- --------------------------------------------------------

--
-- Table structure for table `mahasiswa`
--

CREATE TABLE `mahasiswa` (
  `id_mahasiswa` char(10) NOT NULL,
  `nim` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `mahasiswa`
--

INSERT INTO `mahasiswa` (`id_mahasiswa`, `nim`, `nama`, `password`) VALUES
('121', 23678964, 'Ricky', 'ricky1'),
('122', 23678963, 'Alvin', 'alvin1'),
('123', 23678977, 'Raizky', 'raisky1'),
('124', 23678970, 'Mita', 'mita1');

-- --------------------------------------------------------

--
-- Table structure for table `peminjaman`
--

CREATE TABLE `peminjaman` (
  `id_peminjaman` char(10) NOT NULL,
  `tanggal_peminjaman` datetime NOT NULL,
  `tanggal_kembali` datetime NOT NULL,
  `status` varchar(12) NOT NULL,
  `ruangan_id_ruangan` char(10) NOT NULL,
  `mahasiswa_id_mahasiswa` char(10) NOT NULL,
  `staff_id_staff` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `peminjaman`
--

INSERT INTO `peminjaman` (`id_peminjaman`, `tanggal_peminjaman`, `tanggal_kembali`, `status`, `ruangan_id_ruangan`, `mahasiswa_id_mahasiswa`, `staff_id_staff`) VALUES
('221', '2024-11-10 07:00:04', '2024-11-10 17:30:04', 'Selesai', '221', '121', '243021'),
('222', '2024-11-12 07:00:11', '2024-11-10 17:30:11', 'Selesai', '222', '122', '243022'),
('223', '2024-11-13 09:30:53', '2024-11-10 12:20:53', 'Belum Selesa', '223', '123', '243024'),
('224', '2024-11-14 13:00:32', '2024-11-10 14:30:32', 'Belum Selesa', '225', '124', '243021');

-- --------------------------------------------------------

--
-- Table structure for table `riwayat_peminjaman`
--

CREATE TABLE `riwayat_peminjaman` (
  `id_riwayat_peminjaman` char(10) NOT NULL,
  `tanggal_pengajuan` datetime NOT NULL,
  `tanggal_persetujuan` datetime NOT NULL,
  `status` varchar(10) NOT NULL,
  `peminjaman_id_peminjaman` char(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `riwayat_peminjaman`
--

INSERT INTO `riwayat_peminjaman` (`id_riwayat_peminjaman`, `tanggal_pengajuan`, `tanggal_persetujuan`, `status`, `peminjaman_id_peminjaman`) VALUES
('221', '2024-11-10 07:00:04', '2024-11-10 17:30:04', 'Selesai', '221'),
('222', '2024-11-10 07:00:11', '2024-11-10 17:30:11', 'Selesai', '222');

-- --------------------------------------------------------

--
-- Table structure for table `ruangan`
--

CREATE TABLE `ruangan` (
  `id_ruangan` char(20) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `gedung` varchar(10) NOT NULL,
  `fasilitas` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `ruangan`
--

INSERT INTO `ruangan` (`id_ruangan`, `nama`, `gedung`, `fasilitas`) VALUES
('221', 'C303', 'Gedung C', 'AC, Whiteboard,TV To'),
('222', 'C402', 'Gedung C', 'AC, Whiteboard,TV To'),
('223', 'C404', 'Gedung C', 'AC, Whiteboard,TV To'),
('224', 'C407', 'Gedung C', 'AC, Whiteboard,TV To'),
('225', 'D203', 'Gedung D', 'AC, Whiteboard,TV To'),
('226', 'D208', 'Gedung D', 'AC, Whiteboard,TV To'),
('227', 'D303', 'Gedung D', 'AC, Whiteboard,TV To'),
('228', 'D307', 'Gedung D', 'AC, Whiteboard,TV To'),
('229', 'D402', 'Gedung D', 'AC, Whiteboard,TV To'),
('230', 'D408', 'Gedung D', 'AC, Whiteboard,TV To');

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `id_staff` char(10) NOT NULL,
  `nama` varchar(20) NOT NULL,
  `jabatan` varchar(12) NOT NULL,
  `no_telp` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`id_staff`, `nama`, `jabatan`, `no_telp`) VALUES
('243021', 'Ilham', 'Staff', 8227866),
('243022', 'Agus', 'Staff', 8236783),
('243024', 'Eji', 'Staff', 82356788);

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
  ADD UNIQUE KEY `peminjaman__idxv1` (`ruangan_id_ruangan`),
  ADD KEY `peminjaman_mahasiswa_fk` (`mahasiswa_id_mahasiswa`),
  ADD KEY `peminjaman_staff_fk` (`staff_id_staff`);

--
-- Indexes for table `riwayat_peminjaman`
--
ALTER TABLE `riwayat_peminjaman`
  ADD PRIMARY KEY (`id_riwayat_peminjaman`),
  ADD UNIQUE KEY `riwayat_peminjaman__idx` (`peminjaman_id_peminjaman`);

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
-- Constraints for dumped tables
--

--
-- Constraints for table `barang`
--
ALTER TABLE `barang`
  ADD CONSTRAINT `barang_peminjaman_fk` FOREIGN KEY (`peminjaman_id_peminjaman`) REFERENCES `peminjaman` (`id_peminjaman`);

--
-- Constraints for table `peminjaman`
--
ALTER TABLE `peminjaman`
  ADD CONSTRAINT `peminjaman_mahasiswa_fk` FOREIGN KEY (`mahasiswa_id_mahasiswa`) REFERENCES `mahasiswa` (`id_mahasiswa`),
  ADD CONSTRAINT `peminjaman_ruangan_fk` FOREIGN KEY (`ruangan_id_ruangan`) REFERENCES `ruangan` (`id_ruangan`),
  ADD CONSTRAINT `peminjaman_staff_fk` FOREIGN KEY (`staff_id_staff`) REFERENCES `staff` (`id_staff`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
