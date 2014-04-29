-- phpMyAdmin SQL Dump
-- version 4.0.9
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 29, 2014 at 06:40 PM
-- Server version: 5.5.34
-- PHP Version: 5.4.22

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
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
  `title` varchar(10000) NOT NULL,
  `details` varchar(10000) NOT NULL,
  `lastupdated` varchar(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Dumping data for table `oldernewsdetails`
--

INSERT INTO `oldernewsdetails` (`id`, `title`, `details`, `lastupdated`) VALUES
(3, 'Hii', 'HOLJLLJ', '2014/04/29'),
(4, 'Hii', 'HHHHHH', '2014/04/29'),
(5, 'JJ', 'jJJ', '2014/04/29');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
