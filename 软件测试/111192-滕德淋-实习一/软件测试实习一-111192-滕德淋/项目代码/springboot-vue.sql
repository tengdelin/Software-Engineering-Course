-- phpMyAdmin SQL Dump
-- version 4.4.15.10
-- https://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: 2021-09-27 15:36:40
-- 服务器版本： 5.6.49-log
-- PHP Version: 5.6.40

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `springboot-vue`
--

-- --------------------------------------------------------

--
-- 表的结构 `Calc`
--

CREATE TABLE IF NOT EXISTS `Calc` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `plane_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '航班类型',
  `person_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '旅客类型',
  `vip_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT 'VIP类型',
  `seat_type` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '座舱类型',
  `region` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '区域',
  `num` int(11) DEFAULT NULL COMMENT '行李件数',
  `spec1` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行李1特殊',
  `spec2` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '行李2特殊',
  `length1` int(11) DEFAULT NULL COMMENT '行李1尺寸',
  `weight1` int(11) DEFAULT NULL COMMENT '行李1重量',
  `length2` int(11) DEFAULT NULL COMMENT '行李1尺寸',
  `weight2` int(11) DEFAULT NULL COMMENT '行李2重量',
  `price` int(11) DEFAULT NULL COMMENT '机票价格',
  `res` int(11) DEFAULT NULL COMMENT '计算结果'
) ENGINE=InnoDB AUTO_INCREMENT=206 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='托运信息表';

--
-- 转存表中的数据 `Calc`
--

INSERT INTO `Calc` (`id`, `plane_type`, `person_type`, `vip_type`, `seat_type`, `region`, `num`, `spec1`, `spec2`, `length1`, `weight1`, `length2`, `weight2`, `price`, `res`) VALUES
(1, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(2, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(3, '国际航班', 'p-1', '无', 's-3', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(4, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 980),
(5, '国际航班', 'p-1', '无', 's-5', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 980),
(6, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 980),
(7, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(8, '国际航班', 'p-1', '无', 's-2', 'r-2-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(9, '国际航班', 'p-1', '无', 's-2', 'r-3-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(10, '国际航班', 'p-1', '无', 's-2', 'r-4-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(11, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '普通行李', '', 150, 30, 0, 0, 0, 0),
(12, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '可免费运输的特殊行李', '', 150, 30, 0, 0, 0, 0),
(13, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '运动机械器具A', '', 150, 30, 0, 0, 0, 0),
(14, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '运动机械器具B', '', 150, 30, 0, 0, 0, 0),
(15, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '运动机械器具C', '', 150, 30, 0, 0, 0, 0),
(16, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '其他特殊行李A', '', 150, 30, 0, 0, 0, 0),
(17, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '其他特殊行李B', '', 150, 30, 0, 0, 0, 0),
(18, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 1, '其他特殊行李B', '', 200, 30, 0, 0, 0, 520),
(19, '国际航班', 'p-1', '无', 's-3', 'r-2-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 690),
(20, '国际航班', 'p-1', '无', 's-3', 'r-3-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 520),
(21, '国际航班', 'p-1', '无', 's-3', 'r-4-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 1040),
(22, '国际航班', 'p-1', '无', 's-3', 'r-5-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 520),
(23, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 1400),
(24, '国际航班', 'p-1', '无', 's-4', 'r-2-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 1100),
(25, '国际航班', 'p-1', '无', 's-4', 'r-3-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 520),
(26, '国际航班', 'p-1', '无', 's-4', 'r-4-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 2050),
(27, '国际航班', 'p-1', '无', 's-4', 'r-5-2', 1, '普通行李', '', 200, 30, 0, 0, 0, 830),
(28, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 1400),
(29, '国际航班', 'p-1', '无', 's-6', 'r-2-2', 1, '普通行李', '', 200, 30, 0, 0, 0, 1100),
(30, '国际航班', 'p-1', '无', 's-6', 'r-3-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 520),
(31, '国际航班', 'p-1', '无', 's-6', 'r-4-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 2050),
(32, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 1, '普通行李', '', 200, 30, 0, 0, 0, 830),
(33, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 1, '可免费运输的特殊行李', '', 200, 30, 0, 0, 0, 830),
(34, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 1, '运动机械器具A', '', 200, 30, 0, 0, 0, 830),
(35, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 1, '其他特殊行李A', '', 200, 30, 0, 0, 0, 830),
(36, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 1, '可免费运输的特殊行李', '', 200, 30, 0, 0, 0, 1400),
(37, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 1, '可免费运输的特殊行李', '', 200, 30, 0, 0, 0, 1100),
(38, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 1, '运动机械器具A', '', 200, 30, 0, 0, 0, 1100),
(39, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 1, '其他特殊行李A', '', 200, 30, 0, 0, 0, 1100),
(40, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 2200),
(41, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1960),
(42, '国际航班', 'p-1', '无', 's-2', 'r-2-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1380),
(43, '国际航班', 'p-1', '无', 's-2', 'r-3-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1040),
(44, '国际航班', 'p-1', '无', 's-2', 'r-4-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 2080),
(45, '国际航班', 'p-1', '无', 's-2', 'r-5-2', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1040),
(46, '国际航班', 'p-1', '无', 's-3', 'r-1-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1960),
(47, '国际航班', 'p-1', '无', 's-3', 'r-2-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1380),
(48, '国际航班', 'p-1', '无', 's-3', 'r-3-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1040),
(49, '国际航班', 'p-1', '无', 's-3', 'r-4-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 2080),
(50, '国际航班', 'p-1', '无', 's-3', 'r-5-2', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 1040),
(51, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 2, '其他特殊行李A', '普通行李', 200, 30, 200, 30, 0, 2800),
(52, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(53, '国际航班', 'p-1', '无', 's-4', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(54, '国际航班', 'p-1', '无', 's-4', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(55, '国际航班', 'p-1', '无', 's-4', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4100),
(56, '国际航班', 'p-1', '无', 's-4', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4100),
(57, '国际航班', 'p-1', '无', 's-4', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(58, '国际航班', 'p-1', '无', 's-5', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(59, '国际航班', 'p-1', '无', 's-5', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(60, '国际航班', 'p-1', '无', 's-5', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(61, '国际航班', 'p-1', '无', 's-5', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4100),
(62, '国际航班', 'p-1', '无', 's-5', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(63, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(64, '国际航班', 'p-1', '无', 's-6', 'r-2-2', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(65, '国际航班', 'p-1', '无', 's-6', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1690),
(66, '国际航班', 'p-1', '无', 's-6', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3430),
(67, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(68, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1960),
(69, '国际航班', 'p-2', '无', 's-2', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1380),
(70, '国际航班', 'p-2', '无', 's-2', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(71, '国际航班', 'p-2', '无', 's-2', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2080),
(72, '国际航班', 'p-2', '无', 's-2', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(73, '国际航班', 'p-2', '无', 's-3', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1960),
(74, '国际航班', 'p-2', '无', 's-3', 'r-2-2', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1380),
(75, '国际航班', 'p-2', '无', 's-3', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(76, '国际航班', 'p-2', '无', 's-3', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2080),
(77, '国际航班', 'p-2', '无', 's-3', 'r-5-2', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(78, '国际航班', 'p-2', '无', 's-4', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(79, '国际航班', 'p-2', '无', 's-4', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(80, '国际航班', 'p-2', '无', 's-4', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(81, '国际航班', 'p-2', '无', 's-4', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4100),
(82, '国际航班', 'p-2', '无', 's-4', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(83, '国际航班', 'p-2', '无', 's-5', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(84, '国际航班', 'p-2', '无', 's-5', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(85, '国际航班', 'p-2', '无', 's-5', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1040),
(86, '国际航班', 'p-2', '无', 's-5', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4100),
(87, '国际航班', 'p-2', '无', 's-5', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(88, '国际航班', 'p-2', '无', 's-6', 'r-1-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2800),
(89, '国际航班', 'p-2', '无', 's-6', 'r-2-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2200),
(90, '国际航班', 'p-2', '无', 's-6', 'r-3-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1690),
(91, '国际航班', 'p-2', '无', 's-6', 'r-4-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3430),
(92, '国际航班', 'p-2', '无', 's-6', 'r-5-1', 2, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1660),
(93, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3360),
(94, '国际航班', 'p-1', '无', 's-2', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2480),
(95, '国际航班', 'p-1', '无', 's-2', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(96, '国际航班', 'p-1', '无', 's-2', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3460),
(97, '国际航班', 'p-1', '无', 's-2', 'r-5-2', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1870),
(98, '国际航班', 'p-1', '无', 's-3', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3360),
(99, '国际航班', 'p-1', '无', 's-3', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2480),
(100, '国际航班', 'p-1', '无', 's-3', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(101, '国际航班', 'p-1', '无', 's-3', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3460),
(102, '国际航班', 'p-1', '无', 's-3', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1870),
(103, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(104, '国际航班', 'p-1', '无', 's-4', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(105, '国际航班', 'p-1', '无', 's-4', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(106, '国际航班', 'p-1', '无', 's-4', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 5480),
(107, '国际航班', 'p-1', '无', 's-4', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2490),
(108, '国际航班', 'p-1', '无', 's-5', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(109, '国际航班', 'p-1', '无', 's-5', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(110, '国际航班', 'p-1', '无', 's-5', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(111, '国际航班', 'p-1', '无', 's-5', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 5480),
(112, '国际航班', 'p-1', '无', 's-5', 'r-5-2', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2490),
(113, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(114, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(115, '国际航班', 'p-1', '无', 's-6', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2860),
(116, '国际航班', 'p-1', '无', 's-6', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4810),
(117, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2760),
(118, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3360),
(119, '国际航班', 'p-2', '无', 's-2', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2480),
(120, '国际航班', 'p-2', '无', 's-2', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(121, '国际航班', 'p-2', '无', 's-2', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3460),
(122, '国际航班', 'p-2', '无', 's-2', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1870),
(123, '国际航班', 'p-2', '无', 's-3', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3360),
(124, '国际航班', 'p-2', '无', 's-3', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2480),
(125, '国际航班', 'p-2', '无', 's-3', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(126, '国际航班', 'p-2', '无', 's-3', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3460),
(127, '国际航班', 'p-2', '无', 's-3', 'r-5-2', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 1870),
(128, '国际航班', 'p-2', '无', 's-4', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(129, '国际航班', 'p-2', '无', 's-4', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(130, '国际航班', 'p-2', '无', 's-4', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(131, '国际航班', 'p-2', '无', 's-4', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 5480),
(132, '国际航班', 'p-2', '无', 's-4', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2490),
(133, '国际航班', 'p-2', '无', 's-5', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(134, '国际航班', 'p-2', '无', 's-5', 'r-2-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(135, '国际航班', 'p-2', '无', 's-5', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2210),
(136, '国际航班', 'p-2', '无', 's-5', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 5480),
(137, '国际航班', 'p-2', '无', 's-5', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2490),
(138, '国际航班', 'p-2', '无', 's-6', 'r-1-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4200),
(139, '国际航班', 'p-2', '无', 's-6', 'r-2-2', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 3300),
(140, '国际航班', 'p-2', '无', 's-6', 'r-3-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2860),
(141, '国际航班', 'p-2', '无', 's-6', 'r-4-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 4810),
(142, '国际航班', 'p-2', '无', 's-6', 'r-5-1', 3, '普通行李', '普通行李', 200, 30, 200, 30, 0, 2760),
(143, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 14360),
(144, '国际航班', 'p-1', '无', 's-2', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8350),
(145, '国际航班', 'p-1', '无', 's-2', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(146, '国际航班', 'p-1', '无', 's-2', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9610),
(147, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 7740),
(148, '国际航班', 'p-1', '无', 's-3', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 7740),
(149, '国际航班', 'p-1', '无', 's-3', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 14360),
(150, '国际航班', 'p-1', '无', 's-4', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(151, '国际航班', 'p-1', '无', 's-4', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(152, '国际航班', 'p-1', '无', 's-4', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(153, '国际航班', 'p-1', '无', 's-4', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11630),
(154, '国际航班', 'p-1', '无', 's-4', 'r-5-2', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(155, '国际航班', 'p-1', '无', 's-5', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(156, '国际航班', 'p-1', '无', 's-5', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(157, '国际航班', 'p-1', '无', 's-5', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(158, '国际航班', 'p-1', '无', 's-5', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11630),
(159, '国际航班', 'p-1', '无', 's-5', 'r-5-2', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(160, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(161, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(162, '国际航班', 'p-1', '无', 's-6', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9220),
(163, '国际航班', 'p-1', '无', 's-6', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11170),
(164, '国际航班', 'p-1', '无', 's-6', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9120),
(165, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 14360),
(166, '国际航班', 'p-2', '无', 's-2', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8350),
(167, '国际航班', 'p-2', '无', 's-2', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(168, '国际航班', 'p-2', '无', 's-2', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9610),
(169, '国际航班', 'p-2', '无', 's-2', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 7740),
(170, '国际航班', 'p-2', '无', 's-3', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 14360),
(171, '国际航班', 'p-2', '无', 's-3', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8350),
(172, '国际航班', 'p-2', '无', 's-3', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(173, '国际航班', 'p-2', '无', 's-3', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9610),
(174, '国际航班', 'p-2', '无', 's-3', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 7740),
(175, '国际航班', 'p-2', '无', 's-4', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(176, '国际航班', 'p-2', '无', 's-4', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(177, '国际航班', 'p-2', '无', 's-4', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(178, '国际航班', 'p-2', '无', 's-4', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11630),
(179, '国际航班', 'p-2', '无', 's-4', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(180, '国际航班', 'p-2', '无', 's-5', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(181, '国际航班', 'p-2', '无', 's-5', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(182, '国际航班', 'p-2', '无', 's-5', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8150),
(183, '国际航班', 'p-2', '无', 's-5', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11630),
(184, '国际航班', 'p-2', '无', 's-5', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(185, '国际航班', 'p-2', '无', 's-6', 'r-1-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 15200),
(186, '国际航班', 'p-2', '无', 's-6', 'r-2-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9170),
(187, '国际航班', 'p-2', '无', 's-6', 'r-3-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9220),
(188, '国际航班', 'p-2', '无', 's-6', 'r-4-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11170),
(189, '国际航班', 'p-2', '无', 's-6', 'r-5-1', 7, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 9120),
(190, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 5360),
(191, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 5, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(192, '国际航班', 'p-1', '无', 's-2', 'r-1-1', 6, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11360),
(193, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 5360),
(194, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 5, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 8360),
(195, '国际航班', 'p-2', '无', 's-2', 'r-1-1', 6, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 11360),
(196, '国际航班', 'p-1', '无', 's-2', 'r-2-2', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 3580),
(197, '国际航班', 'p-1', '无', 's-2', 'r-3-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 3380),
(198, '国际航班', 'p-1', '无', 's-2', 'r-4-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 4840),
(199, '国际航班', 'p-1', '无', 's-2', 'r-5-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 2970),
(200, '国际航班', 'p-1', '无', 's-6', 'r-1-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 6200),
(201, '国际航班', 'p-1', '无', 's-6', 'r-2-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 4400),
(202, '国际航班', 'p-1', '无', 's-6', 'r-3-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 4450),
(203, '国际航班', 'p-1', '无', 's-6', 'r-4-1', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 6400),
(204, '国际航班', 'p-1', '无', 's-6', 'r-5-2', 4, '可免费运输的特殊行李', '普通行李', 200, 30, 200, 30, 0, 4350),
(205, '国内航班', 'p-1', 'v-1', 's-2', '0', 1, '普通行李', '', 100, 100, 0, 0, 1000, 450);

-- --------------------------------------------------------

--
-- 表的结构 `result`
--

CREATE TABLE IF NOT EXISTS `result` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `result` int(11) DEFAULT NULL COMMENT '计算结果'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='计算结果表';

-- --------------------------------------------------------

--
-- 表的结构 `student`
--

CREATE TABLE IF NOT EXISTS `student` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '姓名',
  `stu_id` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '学号',
  `home` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '家乡',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `banji` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '班级',
  `scores` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '绩点',
  `photo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '照片'
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=DYNAMIC COMMENT='学生信息表';

--
-- 转存表中的数据 `student`
--

INSERT INTO `student` (`id`, `name`, `stu_id`, `home`, `age`, `banji`, `scores`, `photo`) VALUES
(1, '滕德淋', '20191001171', '四川宜宾', 21, '111192', '3.48', 'http://localhost:9090/files/0fa1db8986c64842921812072c2a1b47'),
(2, '刘世龙', '20191000719', '山东泰安', 21, '111192', '3.22', 'http://localhost:9090/files/625a9963753143ffb911f128ef19c0e6'),
(3, '田浩然', '20191001000', '甘肃敦煌', 20, '111192', '2.69', 'http://localhost:9090/files/a112831035984f7fad5f2875d61178b0'),
(4, '赵文鹏', '20191001100', '山东滨州', 21, '111192', '3.70', 'http://localhost:9090/files/291b0fad50514c339149cc8ddd02d21a');

-- --------------------------------------------------------

--
-- 表的结构 `user`
--

CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL COMMENT 'ID',
  `username` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '用户名',
  `password` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '密码',
  `nick_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '昵称',
  `age` int(11) DEFAULT NULL COMMENT '年龄',
  `sex` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '性别',
  `address` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL COMMENT '地址',
  `role` int(11) DEFAULT NULL
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci ROW_FORMAT=COMPACT COMMENT='用户信息表';

--
-- 转存表中的数据 `user`
--

INSERT INTO `user` (`id`, `username`, `password`, `nick_name`, `age`, `sex`, `address`, `role`) VALUES
(1, 'tdl', '202cb962ac59075b964b07152d234b70', '小滕', 21, '男', '中国地质大学（武汉）未来城校区', 1),
(2, 'cug', '202cb962ac59075b964b07152d234b70', '地大', 20, '男', '武汉', 2),
(3, 'lsl', '202cb962ac59075b964b07152d234b70', '老刘', 22, '男', '地大', 2),
(4, 'thr', '202cb962ac59075b964b07152d234b70', '老田', 20, '男', '地大', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `Calc`
--
ALTER TABLE `Calc`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `result`
--
ALTER TABLE `result`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `student`
--
ALTER TABLE `student`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`) USING BTREE;

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `Calc`
--
ALTER TABLE `Calc`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',AUTO_INCREMENT=206;
--
-- AUTO_INCREMENT for table `result`
--
ALTER TABLE `result`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID';
--
-- AUTO_INCREMENT for table `student`
--
ALTER TABLE `student`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',AUTO_INCREMENT=5;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
