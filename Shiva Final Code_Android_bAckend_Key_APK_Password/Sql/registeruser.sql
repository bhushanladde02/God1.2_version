-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 10, 2015 at 08:28 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `shiva`
--

-- --------------------------------------------------------

--
-- Table structure for table `registeruser`
--

CREATE TABLE IF NOT EXISTS `registeruser` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(1000) NOT NULL,
  `address` varchar(1000) NOT NULL,
  `email` varchar(1000) NOT NULL,
  `phone` decimal(20,0) NOT NULL,
  `position` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `city` varchar(1000) NOT NULL,
  `pannumber` varchar(1000) CHARACTER SET latin1 COLLATE latin1_bin NOT NULL,
  `gender` varchar(1000) NOT NULL,
  `matrialstatus` varchar(1000) NOT NULL,
  `age` varchar(1000) NOT NULL,
  `country` varchar(1000) NOT NULL,
  `department` varchar(1000) NOT NULL,
  `deviceid` varchar(1000) NOT NULL,
  `lastupdatedate` varchar(1000) NOT NULL,
  PRIMARY KEY (`id`,`phone`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
