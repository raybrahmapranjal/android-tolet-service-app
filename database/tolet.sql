-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Mar 20, 2023 at 10:04 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tolet`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin_log`
--

CREATE TABLE `admin_log` (
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `admin_log`
--

INSERT INTO `admin_log` (`username`, `password`) VALUES
('pranjal', 'pran1');

-- --------------------------------------------------------

--
-- Table structure for table `owner_details`
--

CREATE TABLE `owner_details` (
  `OwnerID` int(30) NOT NULL,
  `HouseOwner` varchar(30) NOT NULL,
  `HouseAddress` varchar(200) NOT NULL,
  `Phone` bigint(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `owner_details`
--

INSERT INTO `owner_details` (`OwnerID`, `HouseOwner`, `HouseAddress`, `Phone`) VALUES
(2, 'Arup', 'Christan Basti', 9797977),
(4, 'pranjal', 'AIDC', 6767678),
(5, 'dipu', 'joynagar', 9706002551),
(6, 'bhum', 'joynagar', 94012354);

-- --------------------------------------------------------

--
-- Table structure for table `owner_property`
--

CREATE TABLE `owner_property` (
  `PropertyID` int(30) NOT NULL,
  `OwnerID` int(200) NOT NULL,
  `PType_ID` int(200) NOT NULL,
  `Type` varchar(30) NOT NULL,
  `Rent` varchar(200) NOT NULL,
  `AC` text NOT NULL,
  `Garage` text NOT NULL,
  `SwimmingPool` text NOT NULL,
  `Inverter` text NOT NULL,
  `Localities` varchar(30) NOT NULL,
  `pic` varchar(500) NOT NULL,
  `Status1` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `owner_property`
--

INSERT INTO `owner_property` (`PropertyID`, `OwnerID`, `PType_ID`, `Type`, `Rent`, `AC`, `Garage`, `SwimmingPool`, `Inverter`, `Localities`, `pic`, `Status1`) VALUES
(34, 6, 3, 'Single', '68566', 'Yes', 'No', 'Yes', 'Yes', 'kahilipara', '20.jpg', 0),
(103, 6, 2, '4BHK', '78566', 'Yes', 'No', 'Yes', 'Yes', 'maligaon', '14.jpg', 0),
(109, 2, 5, 'independent house', '78562', 'Yes', 'Yes', 'Yes', 'Yes', 'basista', '24.jpg', 0),
(121, 4, 1, '2BHK', '9800', 'No', 'No', 'Yes', 'Yes', 'ganeshguri', '7.jpg', 0),
(127, 5, 3, 'Single ', '996458', 'Yes', 'No', 'Yes', 'Yes', 'paltan bazar', '4.jpg', 0),
(134, 2, 1, '2BHK', '8988', 'No', 'No', 'Yes', 'Yes', 'chandmari', '2.jpg', 0),
(254, 4, 2, '4BHK', '84655', 'Yes', 'Yes', 'Yes', 'Yes', 'ganeshguri', '19.jpg', 0),
(291, 2, 6, '5BHK', '65897', 'Yes', 'No', 'Yes', 'Yes', 'Manipuri Basti', '16.jpg', 0),
(312, 4, 5, 'independent house', '48652', 'Yes', 'Yes', 'Yes', 'Yes', 'shilpukhuri', '21.jpg', 0),
(540, 4, 4, '3BHK', '46879', 'Yes', 'No', 'Yes', 'Yes', 'noonmati', '18.jpg', 0),
(543, 6, 4, '3BHK', '55789', 'Yes', 'Yes', 'Yes', 'Yes', 'zoo road', '8.jpg', 0),
(590, 4, 6, '5BHK', '87566', 'Yes', 'Yes', 'Yes', 'Yes', 'khanapara', '13.jpg', 0),
(671, 6, 5, 'independent house', '45230', 'Yes', 'No', 'Yes', 'Yes', 'beltola', '12.jpg', 0),
(768, 5, 6, '5BHK', '56255', 'Yes', 'Yes', 'Yes', 'Yes', 'ambari', '15.jpg', 0),
(788, 2, 3, 'Single', '25636', 'Yes', 'No', 'Yes', 'Yes', 'bhangaghar', '10.jpg', 0),
(902, 4, 2, '4BHK', '45628', 'Yes', 'Yes', 'Yes', 'Yes', 'christan basti', '17.jpg', 0),
(911, 4, 1, '2BHK', '28955', 'No', 'No', 'Yes', 'Yes', 'ABC', '23.jpg', 0);

-- --------------------------------------------------------

--
-- Table structure for table `propertytype`
--

CREATE TABLE `propertytype` (
  `PType_ID` int(200) NOT NULL,
  `P_Type` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `propertytype`
--

INSERT INTO `propertytype` (`PType_ID`, `P_Type`) VALUES
(1, '2BHK'),
(2, '4BHK'),
(3, 'Single'),
(4, '3BHK'),
(5, 'Independent'),
(6, '5BHK');

-- --------------------------------------------------------

--
-- Table structure for table `rent`
--

CREATE TABLE `rent` (
  `username` varchar(30) NOT NULL,
  `PropertyID` int(30) NOT NULL,
  `price` double NOT NULL,
  `Odate` date NOT NULL,
  `RentID` int(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `rent`
--

INSERT INTO `rent` (`username`, `PropertyID`, `price`, `Odate`, `RentID`) VALUES
('0', 127, 127, '0000-00-00', 7),
('0', 788, 3, '0000-00-00', 8),
('pran', 911, 1, '0000-00-00', 9),
('pran', 543, 55789, '0000-00-00', 10),
('pran', 127, 996458, '0000-00-00', 11),
('pran', 254, 84655, '2020-10-08', 12),
('pran', 254, 84655, '2020-10-08', 13),
('pran', 902, 45628, '2020-11-18', 14),
('bhumika', 902, 45628, '2020-09-11', 15),
('bhumika', 543, 55789, '2020-09-12', 16);

-- --------------------------------------------------------

--
-- Table structure for table `signup`
--

CREATE TABLE `signup` (
  `username` varchar(30) NOT NULL,
  `password` varchar(15) NOT NULL,
  `name` text NOT NULL,
  `address` varchar(50) NOT NULL,
  `phone` bigint(12) NOT NULL,
  `email` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1 COLLATE=latin1_swedish_ci;

--
-- Dumping data for table `signup`
--

INSERT INTO `signup` (`username`, `password`, `name`, `address`, `phone`, `email`) VALUES
('arup', '465', 'gdhs', 'dhdj', 2722777, 'zhsh'),
('ashiq', '69876', 'Ayash', 'hshhhzz', 7267276, 'ash78@gmail.com'),
('bhumika', '123456', 'bhumika', 'jaynagar', 6900650710, 'raybhumika@gmail.com'),
('deep', '698', 'deepankar', 'hsh', 72626266, 'deep18@gmail.com'),
('guriya', '123', 'sjsj', 'jddj', 2828, 'zjjz@gamil.com'),
('pran', '123', 'pran', 'snsn', 123, 'nznz'),
('sanku', '1234', 'sankar', 'sjsj', 1273, 'xnxnd');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin_log`
--
ALTER TABLE `admin_log`
  ADD PRIMARY KEY (`username`);

--
-- Indexes for table `owner_details`
--
ALTER TABLE `owner_details`
  ADD PRIMARY KEY (`OwnerID`);

--
-- Indexes for table `owner_property`
--
ALTER TABLE `owner_property`
  ADD PRIMARY KEY (`PropertyID`),
  ADD KEY `OwnerID` (`OwnerID`),
  ADD KEY `owner_property_ibfk_1` (`PType_ID`);

--
-- Indexes for table `propertytype`
--
ALTER TABLE `propertytype`
  ADD PRIMARY KEY (`PType_ID`);

--
-- Indexes for table `rent`
--
ALTER TABLE `rent`
  ADD PRIMARY KEY (`RentID`),
  ADD KEY `username` (`username`),
  ADD KEY `PropertyID` (`PropertyID`);

--
-- Indexes for table `signup`
--
ALTER TABLE `signup`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `propertytype`
--
ALTER TABLE `propertytype`
  MODIFY `PType_ID` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `rent`
--
ALTER TABLE `rent`
  MODIFY `RentID` int(200) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `rent`
--
ALTER TABLE `rent`
  ADD CONSTRAINT `rent_ibfk_1` FOREIGN KEY (`PropertyID`) REFERENCES `owner_property` (`PropertyID`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
