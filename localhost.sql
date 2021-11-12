-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- 主机： localhost
-- 生成日期： 2021-11-12 17:14:51
-- 服务器版本： 5.6.49-log
-- PHP 版本： 7.4.13

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 数据库： `javaweb`
--
CREATE DATABASE IF NOT EXISTS `javaweb` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `javaweb`;

-- --------------------------------------------------------

--
-- 表的结构 `classify`
--

CREATE TABLE `classify` (
  `classifyId` int(11) NOT NULL,
  `name` varchar(64) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `classify`
--

INSERT INTO `classify` (`classifyId`, `name`) VALUES
(5, '编程学习'),
(6, '日常生活'),
(7, '失物招领'),
(8, '小道消息');

-- --------------------------------------------------------

--
-- 表的结构 `forum`
--

CREATE TABLE `forum` (
  `name` varchar(64) NOT NULL,
  `introduction` varchar(128) NOT NULL,
  `createDate` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `forum`
--

INSERT INTO `forum` (`name`, `introduction`, `createDate`) VALUES
('My BBS', '这就是个简单的论坛简介~~~', '2021-10-02 00:00:00.000000');

-- --------------------------------------------------------

--
-- 表的结构 `manager`
--

CREATE TABLE `manager` (
  `managerId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `level` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `manager`
--

INSERT INTO `manager` (`managerId`, `userId`, `level`, `sectionId`) VALUES
(1, 5, 1, 0);

-- --------------------------------------------------------

--
-- 表的结构 `posts`
--

CREATE TABLE `posts` (
  `postId` int(11) NOT NULL,
  `sectionId` int(11) NOT NULL,
  `userId` int(11) NOT NULL,
  `time` datetime NOT NULL,
  `title` varchar(128) NOT NULL,
  `content` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `posts`
--

INSERT INTO `posts` (`postId`, `sectionId`, `userId`, `time`, `title`, `content`) VALUES
(1, 20, 6, '2021-09-21 16:54:57', '听说学校又被水淹了？', '真的假的？'),
(2, 7, 6, '2021-09-21 16:55:23', '我特别讨厌写代码怎么办', '我快写死了啊啊啊'),
(3, 20, 6, '2021-09-21 16:55:57', '兄弟们，谁知道咱们学校医务室在哪', 'rt'),
(4, 19, 6, '2021-09-21 16:56:49', '半月谈：散装月饼“爆单”的新现象说明了什么？', '这个新闻你们看了吗'),
(5, 23, 6, '2021-09-21 16:57:13', '学校明年不收学费啦', '你们了解不？'),
(7, 15, 7, '2021-09-21 16:58:24', '关于征收论坛坛友月租的通知', '给我交钱！'),
(8, 8, 7, '2021-09-21 16:58:51', '这代码报错啊，谁能帮我解决一下，有偿', '联系qq2222222'),
(9, 24, 7, '2021-09-21 16:59:13', '听说新生是六人间？', '真的假的？'),
(10, 12, 7, '2021-09-21 16:59:33', 'html谁会写啊，好难', '啊啊啊啊啊啊'),
(12, 7, 10, '2021-09-21 22:41:33', 'servlet怎么用啊', '谁能教教我'),
(13, 20, 5, '2021-09-22 13:08:18', 'ceshi', 'ceshi');

-- --------------------------------------------------------

--
-- 表的结构 `reply`
--

CREATE TABLE `reply` (
  `replyId` int(16) NOT NULL,
  `postId` int(16) NOT NULL,
  `userId` int(16) NOT NULL,
  `content` varchar(128) NOT NULL,
  `time` datetime(6) NOT NULL,
  `isReply` int(16) NOT NULL,
  `toReplyId` int(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `reply`
--

INSERT INTO `reply` (`replyId`, `postId`, `userId`, `content`, `time`, `isReply`, `toReplyId`) VALUES
(1, 1, 5, '弱智吗', '2021-09-21 15:28:33.000000', 0, 0),
(2, 1, 5, '撒旦', '2021-09-21 15:28:59.000000', 0, 0),
(3, 10, 5, '士大夫', '2021-09-21 15:30:02.000000', 0, 0),
(4, 2, 5, '现在', '2021-09-21 15:30:50.000000', 0, 0),
(5, 11, 5, '的撒', '2021-09-21 15:34:12.000000', 0, 0),
(6, 6, 6, '我可没见到', '2021-09-21 17:19:15.000000', 0, 0),
(7, 1, 10, '没错', '2021-09-21 22:43:36.000000', 0, 0),
(8, 13, 5, 'ftfgyt', '2021-09-22 13:08:37.000000', 0, 0),
(9, 14, 11, '哀伤的', '2021-10-23 22:31:09.000000', 0, 0);

-- --------------------------------------------------------

--
-- 表的结构 `section`
--

CREATE TABLE `section` (
  `sectionId` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `classifyId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `section`
--

INSERT INTO `section` (`sectionId`, `name`, `classifyId`) VALUES
(7, 'Java开发', 5),
(8, 'PHP开发', 5),
(11, 'C#开发', 5),
(12, '前端开发', 5),
(15, '最新通告', 6),
(16, '故障保修', 6),
(19, '新闻转载', 6),
(20, '灌水吐槽', 6),
(21, '饭卡丢失', 7),
(22, '贵重物品', 7),
(23, '关于学校的', 8),
(24, '关于宿舍的', 8),
(25, '关于考试的', 8),
(26, '关于老师的', 8);

-- --------------------------------------------------------

--
-- 表的结构 `users`
--

CREATE TABLE `users` (
  `userId` int(11) NOT NULL,
  `nickname` varchar(32) NOT NULL,
  `email` varchar(16) NOT NULL,
  `passwd` varchar(64) NOT NULL,
  `signature` varchar(32) DEFAULT 'Ta什么也没说',
  `picture` varchar(32) DEFAULT NULL,
  `regTime` datetime(6) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 转存表中的数据 `users`
--

INSERT INTO `users` (`userId`, `nickname`, `email`, `passwd`, `signature`, `picture`, `regTime`) VALUES
(5, '暴风吸入', 'admin@test.com', '827CCB0EEA8A706C4C34A16891F84E7B', '好喝到翘jiojio', NULL, '2021-09-20 20:13:49.000000'),
(6, '北方的狼', 'test1@test.com', '5A105E8B9D40E1329780D62EA2265D8A', '我不是狗', NULL, '2021-09-21 16:47:17.000000'),
(7, '游客test2@test.com', 'test2@test.com', 'AD0234829205B9033196BA818F7A872B', 'Ta什么也没说', NULL, '2021-09-21 16:47:41.000000'),
(8, '游客test3@test.com', 'test3@test.com', '827CCB0EEA8A706C4C34A16891F84E7B', 'Ta什么也没说', NULL, '2021-09-21 17:04:37.000000'),
(9, '778', 'test@123.com', '827CCB0EEA8A706C4C34A16891F84E7B', '好喝到翘jiojio', NULL, '2021-09-21 20:58:05.000000'),
(10, '新的名字', 'test111@qq.com', '827CCB0EEA8A706C4C34A16891F84E7B', '哈哈哈', NULL, '2021-09-21 22:40:54.000000'),
(11, '傻逼王琪', 'haha@haha.com', '827CCB0EEA8A706C4C34A16891F84E7B', '我住206', NULL, '2021-10-23 22:30:05.000000'),
(12, '游客admin@111.com', 'admin@111.com', '827CCB0EEA8A706C4C34A16891F84E7B', 'Ta什么也没说', NULL, '2021-10-31 16:48:20.000000');

--
-- 转储表的索引
--

--
-- 表的索引 `classify`
--
ALTER TABLE `classify`
  ADD PRIMARY KEY (`classifyId`);

--
-- 表的索引 `manager`
--
ALTER TABLE `manager`
  ADD PRIMARY KEY (`managerId`);

--
-- 表的索引 `posts`
--
ALTER TABLE `posts`
  ADD PRIMARY KEY (`postId`);

--
-- 表的索引 `reply`
--
ALTER TABLE `reply`
  ADD PRIMARY KEY (`replyId`);

--
-- 表的索引 `section`
--
ALTER TABLE `section`
  ADD PRIMARY KEY (`sectionId`);

--
-- 表的索引 `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userId`);

--
-- 在导出的表使用AUTO_INCREMENT
--

--
-- 使用表AUTO_INCREMENT `classify`
--
ALTER TABLE `classify`
  MODIFY `classifyId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- 使用表AUTO_INCREMENT `manager`
--
ALTER TABLE `manager`
  MODIFY `managerId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- 使用表AUTO_INCREMENT `posts`
--
ALTER TABLE `posts`
  MODIFY `postId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- 使用表AUTO_INCREMENT `reply`
--
ALTER TABLE `reply`
  MODIFY `replyId` int(16) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- 使用表AUTO_INCREMENT `section`
--
ALTER TABLE `section`
  MODIFY `sectionId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- 使用表AUTO_INCREMENT `users`
--
ALTER TABLE `users`
  MODIFY `userId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
