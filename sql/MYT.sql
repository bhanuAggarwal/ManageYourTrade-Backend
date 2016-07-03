-- phpMyAdmin SQL Dump
-- version 4.0.10deb1
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jul 03, 2016 at 06:57 PM
-- Server version: 5.5.44-0ubuntu0.14.04.1
-- PHP Version: 5.5.9-1ubuntu4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `MYT`
--

-- --------------------------------------------------------

--
-- Table structure for table `area_manager`
--

CREATE TABLE IF NOT EXISTS `area_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `area` varchar(150) DEFAULT NULL,
  `boss_id` int(11) DEFAULT NULL,
  `phone_no` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `company_admin_id` int(11) NOT NULL,
  `profile_pic` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=20 ;

--
-- Dumping data for table `area_manager`
--

INSERT INTO `area_manager` (`id`, `name`, `designation`, `area`, `boss_id`, `phone_no`, `email`, `password`, `company_admin_id`, `profile_pic`) VALUES
(2, 'Bhanu', 'Tech', 'KKR', 2, '9876543210', 'bhanu@gmail.com', 'bhanu', 0, ''),
(3, 'hhjb', 'bhj', 'bj', 2, 'bjh', 'bhj', 'bjhb', 0, ''),
(4, 'nishant', 'bhai', 'Kkr', 10, '9876', 'nishant@gmail.com', '1234', 0, ''),
(5, 'Bhanuj Verma', 'AM', 'KKR', 26, '1234', 'bhanuj.verma', '1234', 14, ''),
(6, 'Bhannu', 'Aggarwal', 'KKR', 27, '1234', 'bhanu@gmail.com', '1234', 14, ''),
(7, 'Pawan Kumar', 'AM', 'KKR', 26, '1232', 'pawan.kumar@gmail.com', '1234', 14, NULL),
(8, 'Pawan Kumar', 'AM', 'KKR', 26, '1232', 'pawan.kumar@gmail.com', '1234', 14, NULL),
(9, 'fnjsd', 'bhej', 'hbj', 26, '123', 'bhj', 'hjb', 14, 'http://172.16.173.211:8080/Bjkj/AM_9.jpg'),
(10, 'nkit', 'TSI', 'KKR', 26, '1233', 'ankit@gmail.com', '1234', 14, 'http://172.16.173.211:8080/Bjkj/AM_10.jpg'),
(11, 'Ankit', 'TSI', 'kkr', 26, '1234', 'bhanu@gmail.com', '1234', 14, 'http://172.16.173.211:8080/Bjkj/AM_11.jpg'),
(12, 'Ankit', 'TSI', 'kkr', 26, '1234', 'ank@gmail.com', '1234', 14, NULL),
(13, 'hj', 'hj', 'h', 26, '23', '2', '12', 14, 'http://172.16.173.211:8080/Bjkj/AM_13.jpg'),
(14, 'samplle', 'rwe', '23', 32, '121', 'nnk@fdj.fd', '1234', 14, 'http://localhost:8080/Bjkj/AM_14.jpg'),
(15, 'tagra', 'AM', 'G', 36, '1234356789', 't@gmai.com', '1234', 21, 'http://localhost:8080/Bhanu Aggarwal/AM_15.jpg'),
(16, 'ABC', 'A<', 'bjsdb', 36, '24124', 'b@gn.com', '1234', 21, 'http://localhost:8080/Bhanu Aggarwal/AM_16.jpg'),
(17, 'AM', 'AM', 'as', 39, '1234', 'am@gmail.com', '1234', 23, 'http://localhost:8080/HelloCompany/AM_17.jpg'),
(18, 'Gulmohar Singh', 'Area Manager', 'Campus 1', 42, '9978787111', 'gulmohar@gmail.com', '1234', 25, 'http://shineplayschool.com/images/professional-man.png'),
(19, 'Diksha Thakral', 'Area Manager', 'Campus 2', 42, '9978787122', 'diksha@gmail.com', '1234', 25, 'http://www.pic.cx/img89/ktmwhdsfakknvijgviyy.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `company`
--

CREATE TABLE IF NOT EXISTS `company` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `address` varchar(100) DEFAULT NULL,
  `description` varchar(250) DEFAULT NULL,
  `tin` varchar(50) DEFAULT NULL,
  `pan` varchar(50) DEFAULT NULL,
  `bank_name` varchar(100) DEFAULT NULL,
  `bank_account` varchar(100) DEFAULT NULL,
  `bank_address` varchar(100) DEFAULT NULL,
  `bank_ifsc` varchar(100) DEFAULT NULL,
  `reg_no` varchar(100) DEFAULT NULL,
  `logo` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Dumping data for table `company`
--

INSERT INTO `company` (`id`, `name`, `address`, `description`, `tin`, `pan`, `bank_name`, `bank_account`, `bank_address`, `bank_ifsc`, `reg_no`, `logo`) VALUES
(28, 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', NULL),
(29, 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', NULL),
(30, 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', NULL),
(31, 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', 'first', NULL),
(32, 'technolinks', 'plot  no  43, 16/2 mathura aroad', 'stainless steel', '', '', '', '', '', '', '', NULL),
(33, 'Bhanu', 'ahdbsbsa fsa', 'bdfsfsd fsdfdsfdsffdsbfdfdsffd fdshf dfd fd fd fdsfdsf dfd', '2', '2', '2', '12', '23', '12', '21', NULL),
(34, 'Bjkj', 'bjba', 'kj', '8', '8', '8', '8', '8', '8', '8', NULL),
(35, 'Bjkj', 'bjba', 'kj', '8', '8', '8', '8', '8', '8', '8', NULL),
(36, 'Bjkj', 'bjba', 'kj', '8', '8', '8', '8', '8', '8', '8', 'http://192.168.1.7:8080/fdfj/LOGO_40.jpg'),
(37, 'Sample', 'Hostel-9, National Institute of Technology Kurukshetra', NULL, '21', '2', 'vh', 'bhj', 'bh', 'hj', 'bhjh', NULL),
(38, 'Spring Useful References', 'Hostel-9, National Institute of Technology Kurukshetra', NULL, '23', '32', 'bhbhv', '3132', 'hjhgv', '312', '122321', NULL),
(39, 'Spring Useful References', 'Hostel-9, National Institute of Technology Kurukshetra', NULL, '13', '342', 'bhj', '23', 'fsfe', '342', '211', 'http://localhost:8080/Spring Useful References/LOGO_39.jpg'),
(40, 'fdfj', 'hjsdfjhjv', NULL, 'jv', 'i8', '67', '6767', '86', '7', '7', 'http://localhost:8080/fdfj/LOGO_40.jpg'),
(41, 'ddsfj', 'vjjhvhj', NULL, '423`', '6675', '66', '67', '576', '675', '675', 'http://localhost:8080/ddsfj/LOGO_41.jpg'),
(42, 'jbhj', 'h', NULL, '987', '78', '78', '7', '8', '7', '7', NULL),
(43, 'jbhj', 'h', NULL, '987', '78', '78', '7', '8', '7', '7', NULL),
(44, '', '', NULL, '', '', '', '', '', '', '', NULL),
(45, 'Bhanu Aggarwal', 'A68, Shyam Colony', NULL, '123', '1234', 'ICICI', '1234', 'dsadjn', '123', '123', 'http://localhost:8080/Bhanu Aggarwal/LOGO_45.jpg'),
(46, 'A B      C', 'fbsja', NULL, '231', '21231', 'nvvbjsd', '213', 'fufhsd', 'fgf', '213123', 'http://localhost:8080/A B      C/LOGO_46.jpg'),
(47, 'Hello Company', 'dfdsf', NULL, '1321', '231', 'hjhsdc', '231', 'bj', '21', '1221', 'http://192.168.1.7:8080/HelloCompany/LOGO_47.jpg'),
(48, 'Larsen & Toubro Limited', 'ekjfnvurn', NULL, 'efi;inrjv', 'jvjrk ', 'lnrjv j', 'djc rjkv l', 'dkjcnr lnv', 'nrv i', 'ejhhbfh4b', NULL),
(49, 'AFCONS INFRASTRUCTURE LIMITED', '403, Mercantile House, "KRISHNA", 15, Kasturba Gandhi Marg, New Delhi, Delhi 110001', NULL, 'efi;inrjv', 'jvjrk ', 'lnrjv j', 'djc rjkv l', 'dkjcnr lnv', 'nrv i', 'ejhhbfh4b', 'http://seeklogo.com/images/A/afcon-logo-0C43483693-seeklogo.com.gif'),
(50, 'KNR Construct', 'ekjfnvurn', NULL, 'efi;inrjv', 'jvjrk ', 'lnrjv j', 'djc rjkv l', 'dkjcnr lnv', 'nrv i', 'ejhhbfh4b', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `company_admin`
--

CREATE TABLE IF NOT EXISTS `company_admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_no` varchar(250) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `RM_no` int(11) DEFAULT NULL,
  `AM_no` int(11) DEFAULT NULL,
  `TSI_no` int(11) DEFAULT NULL,
  `Dealer_no` int(11) DEFAULT NULL,
  `profile_pic` varchar(300) NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=27 ;

--
-- Dumping data for table `company_admin`
--

INSERT INTO `company_admin` (`id`, `username`, `email`, `phone_no`, `password`, `RM_no`, `AM_no`, `TSI_no`, `Dealer_no`, `profile_pic`, `company_id`) VALUES
(24, 'Mr. Rajiv Khanna', 'rajiv.khanna@gmail.com', '7832864999', '1234', 1, 1, 1, 1, 'http://sammysouthallwebworks.co.uk/wp-content/uploads/2014/03/professional-profile-photography-west-midlands-01.jpg', 48),
(25, 'Mr. Manoj Shukla', 'manoj.shukla@gmail.com', '7836390000', '1234', 1, 1, 1, 1, 'http://vividphotography.com.au/wp-content/uploads/2015/02/C0115005_crop_fixed.jpg', 49),
(26, 'Miss. Anaira ', 'anaira@gmail.com', '98765456000', '1234', 1, 1, 1, 1, 'http://cosmo.cdn.assets.cougar.bauer-media.com.au/s3/digital-cougar-assets/Cosmo/2013/10/31/31535/201307193569726700career_HOME.jpg?Image=%2Fs3%2Fdigital-cougar-assets%2FCosmo%2F2013%2F10%2F31%2F31535%2F201307193569726700career_HOME.jpg&Width=650&AllowUpSizing=False&Mode=Crop', 50);

-- --------------------------------------------------------

--
-- Table structure for table `dealer`
--

CREATE TABLE IF NOT EXISTS `dealer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `phone_no` varchar(30) DEFAULT NULL,
  `address` varchar(200) DEFAULT NULL,
  `tin` varchar(150) DEFAULT NULL,
  `pan` varchar(150) DEFAULT NULL,
  `bank_name` varchar(200) DEFAULT NULL,
  `bank_account` varchar(200) DEFAULT NULL,
  `bank_address` varchar(200) DEFAULT NULL,
  `bank_ifsc` varchar(200) DEFAULT NULL,
  `reg_no` varchar(200) DEFAULT NULL,
  `boss_id` int(11) NOT NULL,
  `latitude` double NOT NULL,
  `longitude` double NOT NULL,
  `profile_pic` varchar(300) DEFAULT NULL,
  `rm_id` int(11) NOT NULL,
  `am_id` int(11) NOT NULL,
  `company_admin_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=12 ;

--
-- Dumping data for table `dealer`
--

INSERT INTO `dealer` (`id`, `name`, `password`, `email`, `phone_no`, `address`, `tin`, `pan`, `bank_name`, `bank_account`, `bank_address`, `bank_ifsc`, `reg_no`, `boss_id`, `latitude`, `longitude`, `profile_pic`, `rm_id`, `am_id`, `company_admin_id`) VALUES
(1, ' bhanu', 'nsdbsj', 'dasbja', '34324', 'bfjbsdjv vdjvd vdhv fh', '231231', '231', 'bjbjdb', 'bj', '232', '2313', 'fndskf dsf dsfds', 5, 0, 0, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 0),
(2, 'bjhb', 'jhbh', 'bj', 'bhb', 'bhj', '7', '676', '77', '687', '67', '76', '76', 5, 76, 67, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 0),
(3, 'bjhb', 'jhbh', 'bj', 'bhb', 'bhj', '7', '676', '77', '687', '67', '76', '76', 5, 76, 67, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 0),
(4, 'ghjg', '6787', 'vhjv', 'v', '67', '76', '76', '76', '7', '67', '67', '6876', 5, 676, 786, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 14),
(5, 'Sanju', 'sjkdfbdsj', 'khsdabs', '6836818', 'shbj', 'sfjb', '89', '89', '89', '89', '89', '899', 5, 2873, 9879, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 14),
(6, 'Sanju', 'bhanu', 'sanju@gmail.com', '1234', '123', '12', '21', '1212', '212', '1', '2', '21', 5, 1, 31, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 0, 0, 14),
(7, 'nh', '', 'hb', '13', '12', '121', '121', 'jhb', '21', 'njhb', '121h', '12', 9, 21.31, 12.32, 'http://172.16.173.111:8080/Bjkj/DEALER_7.jpg', 26, 11, 14),
(8, 'Tagra', '1234', 'abc@gmail.com', '123', 'njk', '121', '21', 'nnj', '121', 'bjj', '123', '21', 11, 12, 12, 'http://localhost:8080/Bjkj/DEALER_8.jpg', 27, 6, 14),
(9, 'Bhanu', '1234', 'bh@gmail.com', '12345678909', 'HSBDA', '1', '2', 'ICICI', '321312', 'nsdk', 'bhj32', '1234', 14, 12.34, 23.22, 'http://localhost:8080/Bhanu Aggarwal/DEALER_9.jpg', 36, 15, 21),
(10, 'Tagra', '1234', 'abc@gmail.com', '1234567890', 'asd', '12341', '34', 'gjghf', '86', 'gjg', '567', '6547', 15, 12.78, 56.98, 'http://192.168.1.7:8080/HelloCompany/CA_23.jpg', 39, 17, 23),
(11, 'Mr. Vivek Chahar', '1234', 'vivekchahar@gmail.com', '9878765678', 'sagds', '656', '65', 'gjh', '687', 'ghjg', '6786', '6768', 16, 56, 6, 'https://scontent.fdel1-1.fna.fbcdn.net/v/t1.0-9/13094107_10154085594563607_4390729432674730891_n.jpg?oh=2e9921412f17c36a7704dc42a4887a7c&oe=57DCA033', 42, 19, 25);

-- --------------------------------------------------------

--
-- Table structure for table `dealer_order`
--

CREATE TABLE IF NOT EXISTS `dealer_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `order_list` longtext NOT NULL,
  `dealer_id` int(11) NOT NULL,
  `tsi_id` int(11) DEFAULT NULL,
  `company_id` int(11) NOT NULL,
  `status` varchar(50) NOT NULL,
  `date_of_order` date NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=29 ;

--
-- Dumping data for table `dealer_order`
--

INSERT INTO `dealer_order` (`id`, `order_list`, `dealer_id`, `tsi_id`, `company_id`, `status`, `date_of_order`) VALUES
(1, 'item', 0, 0, 0, 'Updated', '0000-00-00'),
(2, 'shjdbsa', 0, 0, 0, '', '0000-00-00'),
(3, 'item', 2, 23, 1, 'new', '2016-03-08'),
(4, 'item', 2, 23, 1, 'new', '2016-03-22'),
(5, 'Order for Bjkj', 10, NULL, 36, 'new', '2016-06-19'),
(6, 'Order for Hello Company', 10, NULL, 47, 'new', '2016-06-19'),
(7, 'Order for Hello Company', 10, NULL, 47, 'new', '2016-06-19'),
(8, 'Order for Hello Company - Test 1', 10, NULL, 47, 'new', '2016-06-19'),
(9, 'Order for Hello Company - Test 2', 10, NULL, 47, 'new', '2016-06-19'),
(10, 'Order for Hello Company - Test 2', 10, NULL, 47, 'new', '2016-06-19'),
(11, 'Order for Hello Company - Test 2', 10, NULL, 47, 'new', '2016-06-19'),
(12, 'Order for Hello Company - Test 2', 10, NULL, 47, 'new', '2016-06-19'),
(13, 'Order for Hello Company - Test 2', 10, 15, 47, 'new', '2016-06-19'),
(14, 'Order for Hello Company -', 10, NULL, 47, 'new', '2016-06-19'),
(15, 'Order for Hello Company -', 10, NULL, 47, 'new', '2016-06-19'),
(16, 'Order for Hello Company -', 10, 15, 47, 'new', '2016-06-19'),
(17, 'Order for Hello Company', 10, 15, 47, 'new', '2016-06-19'),
(18, '10 bottles of Red paint.\n3 bottles of Blue paint.\n15 xl sized brushes.\n24 small brushes.', 11, 16, 49, 'ACCEPTED', '2016-06-20'),
(19, '2 dozen large nuts\n2 dozen large bolts\n4 kits of screw drivwrs  ', 11, 16, 49, 'REJECTED', '2016-06-20'),
(20, 'Test order...', 11, 16, 49, 'ACCEPTED', '2016-06-26'),
(21, 'notifications test..', 11, 16, 49, 'ACCEPTED', '2016-06-26'),
(22, 'test 2', 11, 16, 49, 'REJECTED', '2016-06-26'),
(23, 'order 1', 11, 16, 49, 'ACCEPTED', '2016-06-26'),
(24, 'order 2', 11, 16, 49, 'REJECTED', '2016-06-26'),
(25, 'order 3 gaand mra vikram\n', 11, 16, 49, 'ACCEPTED', '2016-06-26'),
(26, 'Testing Order Successful', 11, 16, 49, 'new', '2016-06-26'),
(27, 'screen hide test', 11, 16, 49, 'new', '2016-06-26'),
(28, 'yfurorjrukr', 11, 16, 49, 'new', '2016-06-26');

-- --------------------------------------------------------

--
-- Table structure for table `gcm_users`
--

CREATE TABLE IF NOT EXISTS `gcm_users` (
  `name` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `gcm_regid` varchar(500) DEFAULT NULL,
  `created_at` date DEFAULT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `imei` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uc_imei` (`imei`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=21 ;

--
-- Dumping data for table `gcm_users`
--

INSERT INTO `gcm_users` (`name`, `email`, `gcm_regid`, `created_at`, `id`, `imei`) VALUES
('Stacy', 'stacy@gmail.com', 'APA91bE29dS8S9d206s7LNg67rsPpuISrMvH4tBJ-8xpPod4BqFpecF-dICPIb1xai1yLC-tSegzHVIBLYR3v5mq0tGbOJy23fNUUMtOoOW5yh2AM1RZECoHRiSRcy8reyq__3b93iyv', '2016-06-27', 18, '353321062700268'),
('Dummy Name', 'bc@gmail.com', 'APA91bH2-_HPzGT6_ge0VHmMX01K4lJwp3CDom9H4nQsoYbN7kx2bmbhRLSoHXcsBoSHI1Zm6aJacNGUUUqKcfqY7vcextr-wLRLRFOrjjMrvPRKHkKAw_pHkg_UyHxGAG9yNQPfaEAG', '2016-06-26', 19, '867290027492940'),
('Dummy Name', 'bc@gmail.com', 'APA91bG-Ds9dphi07qHaML0Zo5dEtU8YDe_NEBX8duavK4O42RYhqbDho7nsEtu10ycz8beAVG8QKsUHBfbyO_dI43VNY6ShPxh3moBdSlY-39YCRi_Ib227QcCb3Wacm6qbbwQG1e3N', '2016-06-26', 20, '911441050460785');

-- --------------------------------------------------------

--
-- Table structure for table `regional_manager`
--

CREATE TABLE IF NOT EXISTS `regional_manager` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `area` varchar(150) DEFAULT NULL,
  `boss_id` int(11) DEFAULT NULL,
  `phone_no` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `profile_pic` varchar(300) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=51 ;

--
-- Dumping data for table `regional_manager`
--

INSERT INTO `regional_manager` (`id`, `name`, `designation`, `area`, `boss_id`, `phone_no`, `email`, `password`, `profile_pic`) VALUES
(2, 'Sanju', 'CO-Founder', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(3, 'Sanju aada', 'CO-Founder', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(4, 'Sanju', 'CO-Founder', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(5, 'Sansdfds', 'CO-Founder', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(6, 'dfsd fd fdsfds', 'CO-Founder', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(7, 'Sanjudsf', 'CO-Founder', 'Panipat fsd', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(8, 'Sanjufsdfds', 'CO-Founderfsdfd', 'Panipat', 1, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(9, 'Sanjdfdsfdfddds', 'CO-Founderfsdfd', 'Panipat', 12, '9876543210', 'sanjutagra@gmail.com', '12345', 'http://www.dmdude.com/wp-content/uploads/goals-image-300-x-300.jpg'),
(10, 'Chahar', 'Pappu', '98766', 12, '1234', 'chahar@gmail.com', '1233', NULL),
(11, 'bh', 'hb', '5788y', 12, 'kb', 'b', 'bj', NULL),
(12, 'bhvdws', 'hjbsj', 'bjh', 12, 'n', '1', '1', NULL),
(13, 'bsjf', 'bjh', 'b', 12, 'jhbh', 'b', 'jb', NULL),
(14, 'bsjf', 'bjh', 'b', 12, '131', 'b', 'jb', NULL),
(15, 'hvhg', 'hjg', '7', 12, '87', '78', '87', NULL),
(16, 'Sanjeev Tagra', 'gh', '56', 14, '56', 'sanjutagra@gmail.com', '1234', 'https://organicthemes.com/demo/profile/files/2012/12/profile_img.png'),
(17, 'bbj', 'hbj', 'hbj', 14, '78', 'gh', '7', NULL),
(18, 'bbj', 'hbj', 'hbj', 14, '78', 'gh', '7', NULL),
(19, 'BHanu', 'hbj', 'hbj', 14, '78', 'gh', '7', NULL),
(20, 'BHau', 'hbj', 'hbj', 14, '78', 'gh', '7', NULL),
(21, 'Bhanu', '123', '123', 14, '123', '123', '123', NULL),
(22, 'ppp', 'ppp', 'ppp', 14, '12', 'pp', 'p', NULL),
(23, 'Bhanu Aggarwal', 'RM', 'Kurukshetra', 14, '1243', 'bhanuaggarwal13@gmail.com', '1234', NULL),
(24, 'Bhanu Aggarwal', 'RM', 'Kurukshetra', 14, '1243', 'bhanuaggarwal13@gmail.com', '1234', NULL),
(25, 'Bhanu Aggarwal', 'RM', 'Kurukshetra', 14, '1243', 'bhanuaggarwal13@gmail.com', '1234', NULL),
(26, 'bhanu', 'bh', 'bh', 14, '123', 'bhanuaggarwal13@gmail.com', '1234', 'http://172.16.173.211:8080/Bjkj/RM_26.jpg'),
(27, 'Bhanuj', 'Designer', 'KKR', 14, '1234', 'bhanujverma@gmail.com', '1234', 'http://172.16.173.211:8080/Bjkj/RM_27.jpg'),
(28, 'hsa', 'bhj', 'uh', 14, '1', 'jbj', '12', 'http://172.16.173.211:8080/Bjkj/RM_28.jpg'),
(29, 'Sample', 'qw', 'qw', 14, '123', 'bh@fh.cm', '1234', NULL),
(30, 'Sampl', 'qe', '12', 14, '2', 'bh@fs.c', '1234', NULL),
(31, 'Sample', 'qwe', '123', 14, '123', 'bh@fnda.cnj', '1234', NULL),
(32, 'fdsjbj', 'bhjeb', 'hj', 14, '121', 'bbjs@fb.fdsf', '1234', 'http://localhost:8080/Bjkj/RM_32.jpg'),
(33, 'Sample', 'bhjeb', 'hj', 14, '121', 'bbjs@fb.fdsf', '1234', 'http://localhost:8080/Bjkj/RM_33.jpg'),
(34, 'BHanu', 'dfbdj', 'hsdjf', 14, '2323', 'bhj', '13', NULL),
(35, '', '', '', 21, '', '', '', NULL),
(36, 'Sanju', 'RM', 'GGN', 21, '1234567890', 'tagra@gmail.com', '1234', 'http://localhost:8080/Bhanu Aggarwal/RM_36.jpg'),
(37, 'Bhanu', 'RM', 'rm', 22, '1234', 'bhanu@rm.com', '1234', NULL),
(38, 'First', 'RM', 'FBD', 23, '1234', 'rm@gmail.com', '1234', NULL),
(39, 'RM', 'RM', 'FBD', 23, '1234', 'a@gmail.com', '1234', 'http://localhost:8080/HelloCompany/RM_39.jpg'),
(40, '', '', '', 23, '', '', '', NULL),
(41, '', '', '', 23, '', '', '', NULL),
(42, 'Stacy', 'Regional Manager', 'South Zone', 25, '8976590111', 'stacy@gmail.com', '1234', 'https://s-media-cache-ak0.pinimg.com/736x/94/43/b4/9443b453913f06f7433bb42317ab980e.jpg'),
(46, 'Shekhar Sharma', 'Regional Manager', 'North Zone', 25, '8976590133', 'shekhar@gmail.com', '', 'http://thispix.com/wp-content/uploads/2015/06/portrait-profile-007.jpg'),
(47, 'asdd', '1213', '1bj', 14, '1213', 'fdsfds@fdf.gd', '123', NULL),
(48, 'sample', 'nafkf', 'eek', 25, '123', 'nkj', '12', NULL),
(49, 'sample', 'nafkf', 'eek', 25, '123', 'nkj', '12', NULL),
(50, 'aba', 'hjgj', '879', 25, 'iy', '987', 'ui', 'http://localhost:8080/AFCONS_INFRASTRUCTURE_LIMITED/RM_50.jpg');

-- --------------------------------------------------------

--
-- Table structure for table `tsi`
--

CREATE TABLE IF NOT EXISTS `tsi` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) DEFAULT NULL,
  `designation` varchar(100) DEFAULT NULL,
  `area` varchar(150) DEFAULT NULL,
  `boss_id` int(11) DEFAULT NULL,
  `phone_no` varchar(30) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `password` varchar(100) DEFAULT NULL,
  `rm_id` int(11) NOT NULL,
  `company_admin_id` int(11) NOT NULL,
  `profile_pic` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Dumping data for table `tsi`
--

INSERT INTO `tsi` (`id`, `name`, `designation`, `area`, `boss_id`, `phone_no`, `email`, `password`, `rm_id`, `company_admin_id`, `profile_pic`) VALUES
(4, 'bhanu', 'dasjfbs', 'sjfb', 2, '41284914', 'bsdfbsdh@fhds.bdjg', 'bhanu', 0, 0, ''),
(5, 'Bhanu', 'Manager', 'KKR', 4, '987', 'bhanu@gmail.com', '1234', 0, 0, ''),
(6, 'Bhanu2', 'Manager', 'KKR', 4, '987', 'bhanu@gmail.com', '1234', 0, 0, ''),
(7, 'Pawan', 'TSI', 'KKR', 9, '123', 'pawan@fm.com', '1234', 26, 14, 'http://172.16.173.211:8080/Bjkj/TSI_7.jpg'),
(8, 'Pawan', 'TSI', 'KKR', 9, '123', 'pawan@fm.com', '1234', 26, 14, 'http://172.16.173.211:8080/Bjkj/TSI_8.jpg'),
(9, 'Pawan', 'TSI', '123', 11, '123', '123', '123', 26, 14, 'http://172.16.173.211:8080/Bjkj/TSI_9.jpg'),
(10, 'bshaj', 'bjh', 'hjb1213', 14, '3243', 'bh@gm.cm', '1234', 32, 14, 'http://localhost:8080/Bjkj/TSI_10.jpg'),
(11, 'BHnau', 'TSI', 'ajsbd', 6, '21', 'bhj@gn.ccon', '1233', 27, 14, 'http://localhost:8080/Bjkj/TSI_11.jpg'),
(12, 'Bhanu', 'TSI', 'FBD', 14, '1234', 'bhanuaggarwal13@gmail.com', '1234', 32, 14, 'http://localhost:8080/Bjkj/TSI_12.jpg'),
(13, 'Bhanu Aggarwal', 'TSI', 'FBD', 14, '1234', 'bhanuaggarwal13@gmail.com', '1234', 32, 14, 'http://localhost:8080/Bjkj/TSI_13.jpg'),
(14, 'AN', 'TSI', 'aa', 15, '1322534546', 'tsi@ggmak.com', '1234', 36, 21, 'http://localhost:8080/Bhanu Aggarwal/TSI_14.jpg'),
(15, 'Bhanu', 'TSI', 'fbd', 17, '1234', 'tsi@gmail.com', '1234', 39, 23, 'http://192.168.1.7:8080/HelloCompany/TSI_15.jpg'),
(16, 'Mr. Bhanuj Verma', 'vhjv', 'jbg', 19, '1234', 'bc@gmail.com', '1234', 42, 25, 'https://scontent.fdel1-2.fna.fbcdn.net/v/t1.0-9/12715267_1211738202187636_1026553225255273379_n.jpg?oh=f67bae6d655214b2f437b739d7965c2c&oe=580427C9');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(110) NOT NULL,
  `email` varchar(50) DEFAULT NULL,
  `phone_no` varchar(10) DEFAULT NULL,
  `type` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `reference_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100 ;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `name`, `email`, `phone_no`, `type`, `password`, `reference_id`) VALUES
(1, '0', 'bhanuaggarwal', 'first', 'CA', '1234', 0),
(2, '0', '9810123519', '', 'CA', '', 0),
(3, '0', 'bhanuaggarwal13@gmail.com', '982', 'CA', 'bha', 12),
(4, '0', '', '', 'RM', '', 0),
(5, '0', '', '', 'RM', '', 0),
(6, '0', '', '', 'RM', '', 0),
(7, '0', '', '', 'RM', '', 0),
(8, '0', '', '', 'RM', '', 0),
(9, '0', 'f', 'f', 'RM', 'f', 0),
(10, '0', 'jbhj', 'jb', 'RM', 'bhj', 0),
(11, '0', 'bhj', 'bjh', 'AM', 'bhanu', 2),
(12, '0', 'bj', 'bhb', 'RM', 'jhbh', 0),
(13, '0', 'bj', 'bhb', 'RM', 'jhbh', 0),
(14, '0', 'vhjv', 'v', 'RM', '6787', 0),
(16, '0', 'bhanu', '41284914', 'TSI', 'bhanu', 4),
(17, '0', 'khsdabs', '6836818', 'RM', 'sjkdfbdsj', 0),
(18, '0', '89', 'hj', 'RM', '89', 18),
(19, '0', 'bhanu@gmail.com', '987', 'TSI', '1234', 5),
(20, '0', 'sanju@gmail.com', '1234', 'DEALER', 'bhanu', 6),
(21, '0', 'nishant@gmail.com', '9876', 'AM', '1234', 4),
(22, 'Vivek Chahar', 'chahar@gmail.com', '1234', 'RM', '1234', 10),
(23, 'hvhg', '78', '87', 'RM', '87', 15),
(24, 'bhanuAggarwal', 'bhanua2@gmail.com', '1234', 'CA', '1234', 14),
(25, 'asff', 'g@g.com', '56', 'RM', '1234', 16),
(26, 'bbj', 'gh', '78', 'RM', '7', 17),
(27, 'bbj', 'gh', '78', 'RM', '7', 18),
(28, 'BHanu', 'gh', '78', 'RM', '7', 19),
(29, 'BHau', 'gh', '78', 'RM', '7', 20),
(30, 'Bhanu', '123', '123', 'RM', '123', 21),
(31, 'ppp', 'pp', '12', 'RM', 'p', 22),
(32, 'Bhanu Aggarwal', 'bhanuaggarwal13@gmail.com', '1243', 'RM', '1234', 23),
(33, 'Bhanu Aggarwal', 'bhanuaggarwal13@gmail.com', '1243', 'RM', '1234', 24),
(34, 'Bhanu Aggarwal', 'bhanuaggarwal13@gmail.com', '1243', 'RM', '1234', 25),
(35, 'bhanu', 'bhanuaggarwal13@gmail.com', '123', 'RM', '1234', 26),
(36, 'Bhanuj', 'bhanujverma@gmail.com', '1234', 'RM', '1234', 27),
(37, 'Bhanuj Verma', 'bhanuj.verma', '1234', 'AM', '1234', 5),
(38, 'Bhannu', 'bhanu@gmail.com', '1234', 'AM', '1234', 6),
(39, 'Pawan Kumar', 'pawan.kumar@gmail.com', '1232', 'AM', '1234', 7),
(40, 'Pawan Kumar', 'pawan.kumar@gmail.com', '1232', 'AM', '1234', 8),
(41, 'fnjsd', 'bhj', '123', 'AM', 'hjb', 9),
(42, 'nkit', 'ankit@gmail.com', '1233', 'AM', '1234', 10),
(43, 'Ankit', 'bhanu@gmail.com', '1234', 'AM', '1234', 11),
(44, 'Ankit', 'ank@gmail.com', '1234', 'AM', '1234', 12),
(45, 'Pawan', 'pawan@fm.com', '123', 'TSI', '1234', 7),
(46, 'Pawan', 'pawan@fm.com', '123', 'TSI', '1234', 8),
(47, 'Pawan', '123', '123', 'TSI', '123', 9),
(48, 'nh', 'hb', '13', 'DEALER', '', 7),
(49, 'hsa', 'jbj', '1', 'RM', '12', 28),
(50, 'hj', '2', '23', 'AM', '12', 13),
(51, 'Sample', 'bh@fh.cm', '123', 'RM', '1234', 29),
(52, 'Sampl', 'bh@fs.c', '2', 'RM', '1234', 30),
(53, 'Sample', 'bh@fnda.cnj', '123', 'RM', '1234', 31),
(54, 'fdsjbj', 'bbjs@fb.fdsf', '121', 'RM', '1234', 32),
(55, 'Sample', 'bbjs@fb.fdsf', '121', 'RM', '1234', 33),
(56, 'samplle', 'nnk@fdj.fd', '121', 'AM', '1234', 14),
(57, 'bshaj', 'bh@gm.cm', '3243', 'TSI', '1234', 10),
(58, 'BHnau', 'bhj@gn.ccon', '21', 'TSI', '1233', 11),
(59, 'Smaple', 'bhanuaggarwal13@gmail.com', '123', 'DEALER', '1234', 8),
(60, 'Bhanu', 'bhanuaggarwal13@gmail.com', '1234', 'TSI', '1234', 12),
(61, 'Bhanu Aggarwal', 'bhanuaggarwal13@gmail.com', '1234', 'TSI', '1234', 13),
(62, '1120449', 'bhanua2', NULL, 'CA', '1234', 15),
(63, 'admin', 'bhanuaggarwal13@gmail.com', NULL, 'CA', '1234', 16),
(64, 'wewqbj', 'vhgv', '786', 'CA', 'g', 17),
(65, 'samo', 'bh@gmail.com', '76786', 'CA', '1234', 18),
(66, 'jhgj', 'y', '7', 'CA', 'hj', 19),
(67, 'jhgj', 'y', '7', 'CA', '', 20),
(68, 'BHanu', 'bhj', '2323', 'RM', '13', 34),
(69, 'Bhanu', 'aggarwal@gmail.com', '9876543210', 'CA', '1234', 21),
(70, '', '', '', 'RM', '', 35),
(71, 'Sanju', 'tagra@gmail.com', '1234567890', 'RM', '1234', 36),
(72, 'tagra', 't@gmai.com', '1234356789', 'AM', '1234', 15),
(73, 'AN', 'tsi@ggmak.com', '1322534546', 'TSI', '1234', 14),
(74, 'ABC', 'b@gn.com', '24124', 'AM', '1234', 16),
(75, 'bhanua2', 'b@b.com', '1234', 'CA', '1234', 22),
(76, 'Bhanu', 'bhanu@rm.com', '1234', 'RM', '1234', 37),
(77, 'cyrex', 'cyrex@gmail.com', '1234', 'CA', '1234', 23),
(78, 'First', 'rm@gmail.com', '1234', 'RM', '1234', 38),
(79, 'RM', 'a@gmail.com', '1234', 'RM', '1234', 39),
(80, 'AM', 'am@gmail.com', '1234', 'AM', '1234', 17),
(81, 'Bhanu', 'tsi@gmail.com', '1234', 'TSI', '1234', 15),
(82, 'Tagra', 'abc@gmail.com', '1234567890', 'DEALER', '1234', 10),
(83, '', '', '', 'RM', '', 40),
(84, '', '', '', 'RM', '', 41),
(85, 'Mr. Rajiv Khanna', 'rajiv.khanna@gmail.com', '7832864999', 'CA', '1234', 24),
(86, 'Mr. Manoj Shukla', 'manoj.shukla@gmail.com', '7836390000', 'CA', '1234', 25),
(87, 'Stacy', 'stacy@gmail.com', '8976590111', 'RM', '1234', 42),
(91, 'Shekhar Sharma', 'shekhar@gmail.com', '8976590133', 'RM', '', 46),
(92, 'Gulmohar Singh', 'gulmohar@gmail.com', '9978787111', 'AM', '1234', 18),
(93, 'Diksha Thakral', 'diksha@gmail.com', '9978787122', 'AM', '1234', 19),
(94, 'Mr. Bhanuj Verma', 'bc@gmail.com', '1234', 'TSI', '1234', 16),
(95, 'Mr. Vivek Chahar', 'vivekchahar@gmail.com', '9878765678', 'DEALER', '1234', 11),
(96, 'asdd', 'fdsfds@fdf.gd', '1213', 'RM', '123', 47),
(97, 'sample', 'nkj', '123', 'RM', '12', 48),
(98, 'sample', 'nkj', '123', 'RM', '12', 49),
(99, 'aba', '987', 'iy', 'RM', 'ui', 50);

-- --------------------------------------------------------

--
-- Table structure for table `warehouse_bill`
--

CREATE TABLE IF NOT EXISTS `warehouse_bill` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `company_admin_id` int(11) NOT NULL,
  `dealer_id` int(11) NOT NULL,
  `invoice` varchar(300) DEFAULT NULL,
  `collection` varchar(300) DEFAULT NULL,
  `payment` varchar(300) DEFAULT NULL,
  `account` varchar(300) DEFAULT NULL,
  `cn` varchar(300) DEFAULT NULL,
  `dn` varchar(300) DEFAULT NULL,
  `sales_report` varchar(300) DEFAULT NULL,
  `amount` double NOT NULL,
  `creationTime` date NOT NULL,
  `company_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=100 ;

--
-- Dumping data for table `warehouse_bill`
--

INSERT INTO `warehouse_bill` (`id`, `company_admin_id`, `dealer_id`, `invoice`, `collection`, `payment`, `account`, `cn`, `dn`, `sales_report`, `amount`, `creationTime`, `company_id`) VALUES
(1, 14, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, '0000-00-00', 0),
(2, 14, 1, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, '0000-00-00', 0),
(3, 14, 5, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, '0000-00-00', 0),
(4, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '0000-00-00', 0),
(5, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '0000-00-00', 0),
(6, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(7, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(8, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(9, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(10, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(11, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(12, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '0000-00-00', 0),
(13, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(14, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(15, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(16, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(17, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(18, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(19, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 124, '2016-06-26', 0),
(20, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(21, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(22, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(23, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(24, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(25, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(26, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(27, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(28, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(29, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(30, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(31, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(32, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(33, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(34, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(35, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(36, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(37, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(38, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(39, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(40, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(41, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(42, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 112, '2016-06-26', 0),
(43, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(44, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(45, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(46, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(47, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(48, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 23, '2016-06-26', 0),
(49, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(50, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(51, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(52, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(53, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(54, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(55, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(56, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(57, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(58, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(59, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(60, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(61, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(62, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(63, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(64, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(65, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 6, '2016-06-26', 0),
(66, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(67, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(68, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(69, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(70, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(71, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(72, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(73, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(74, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(75, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(76, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(77, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(78, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(79, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(80, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(81, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(82, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(83, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(84, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 12, '2016-06-26', 0),
(85, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 13, '2016-06-26', 0),
(86, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(87, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(88, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 1234, '2016-06-26', 0),
(89, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(90, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(91, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(92, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(93, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(94, 25, 11, NULL, NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(95, 25, 11, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/invoice_95.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(96, 25, 11, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/invoice_96.jpg', NULL, NULL, NULL, NULL, NULL, NULL, 123, '2016-06-26', 0),
(97, 25, 11, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/invoice_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/collection_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/payment_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/account_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/cn_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/dn_97.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/26-06-2016/sales_report_97.jpg', 123, '2016-06-26', 0),
(98, 25, 11, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/invoice_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/collection_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/payment_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/account_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/cn_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/dn_98.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/sales_report_98.jpg', 6000, '2016-06-27', 49),
(99, 25, 11, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/invoice_99.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/collection_99.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/payment_99.jpg', 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/account_99.jpg', NULL, NULL, 'http://192.168.1.7:8080/AFCONS_INFRASTRUCTURE_LIMITED/South_Zone/Campus_2/jbg/Mr._Vivek_Chahar/27-06-2016/sales_report_99.jpg', 900, '2016-06-27', 49);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
