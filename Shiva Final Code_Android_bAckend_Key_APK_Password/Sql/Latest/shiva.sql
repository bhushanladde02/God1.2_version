-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: May 03, 2015 at 07:37 PM
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
-- Table structure for table `oldernewsdetails`
--

CREATE TABLE IF NOT EXISTS `oldernewsdetails` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(10000) CHARACTER SET utf8 NOT NULL,
  `details` varchar(10000) CHARACTER SET utf8 NOT NULL,
  `lastupdated` varchar(11) CHARACTER SET utf8 NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci AUTO_INCREMENT=12 ;

--
-- Dumping data for table `oldernewsdetails`
--

INSERT INTO `oldernewsdetails` (`id`, `title`, `details`, `lastupdated`) VALUES
(10, 'जन्मदिन काय सांगतो', 'जन्मदिन काय सांगतो', '2015/05/03'),
(11, 'जन्मदिन काय सांगतो', 'जन्मदिन काय सांगतो', '2015/05/03');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
