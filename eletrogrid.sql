-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 23, 2022 at 11:24 AM
-- Server version: 5.6.17
-- PHP Version: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `eletrogrid`
--

-- --------------------------------------------------------

--
-- Table structure for table `complaintdb`
--

CREATE TABLE IF NOT EXISTS `complaintdb` (
  `ComID` int(6) NOT NULL AUTO_INCREMENT,
  `AccNO` varchar(30) NOT NULL,
  `Complaint` varchar(200) NOT NULL,
  `Name` varchar(80) NOT NULL,
  `Address` varchar(80) NOT NULL,
  `MobilePhone` varchar(10) NOT NULL,
  PRIMARY KEY (`ComID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Table structure for table `interupationdb`
--

CREATE TABLE IF NOT EXISTS `interupationdb` (
  `intID` int(6) NOT NULL AUTO_INCREMENT,
  `province` varchar(40) NOT NULL,
  `time` varchar(50) NOT NULL,
  `no_of_crew` varchar(30) NOT NULL,
  `vehicle_no` varchar(10) NOT NULL,
  `phone_no` varchar(10) NOT NULL,
  PRIMARY KEY (`intID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
