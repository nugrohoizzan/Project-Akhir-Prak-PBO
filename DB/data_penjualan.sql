-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 29 Bulan Mei 2023 pada 14.47
-- Versi server: 10.4.28-MariaDB
-- Versi PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `data_penjualan`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `kendaraann`
--

CREATE TABLE `kendaraann` (
  `kode` varchar(20) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `no_telepon` int(13) NOT NULL,
  `alamat` varchar(50) NOT NULL,
  `jenis` varchar(30) NOT NULL,
  `merk` varchar(30) NOT NULL,
  `harga` varchar(30) NOT NULL,
  `pajak` varchar(20) NOT NULL,
  `total` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `kendaraann`
--

INSERT INTO `kendaraann` (`kode`, `nama`, `no_telepon`, `alamat`, `jenis`, `merk`, `harga`, `pajak`, `total`) VALUES
('TR001', 'Daffa', 90908, 'jl. in aja dulu, menyesal kemudian', 'NMAX 155', 'Yamaha', '31615000', '3161500', '34776500'),
('TR002', 'Nugroho', 76789, 'jl. yg lurus asik serta lucu', 'PCX', 'Honda', '40500000', '4050000', '44550000'),
('TR003', '', 5677889, 'jl. sm km lebi asik daripada sendiri', 'Mio M3 125', 'Yamaha', '17405000', '1740500', '19145500');

-- --------------------------------------------------------

--
-- Struktur dari tabel `pengguna`
--

CREATE TABLE `pengguna` (
  `id_pengguna` char(11) NOT NULL,
  `username` varchar(50) NOT NULL,
  `password` varchar(30) NOT NULL,
  `nama_pengguna` varchar(30) NOT NULL,
  `jabatan` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data untuk tabel `pengguna`
--

INSERT INTO `pengguna` (`id_pengguna`, `username`, `password`, `nama_pengguna`, `jabatan`) VALUES
('12321015222', 'admin', 'admin', 'Nugroho Izza', 'Bagian keuangan');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `kendaraann`
--
ALTER TABLE `kendaraann`
  ADD PRIMARY KEY (`kode`);

--
-- Indeks untuk tabel `pengguna`
--
ALTER TABLE `pengguna`
  ADD PRIMARY KEY (`id_pengguna`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
