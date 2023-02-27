-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Feb 27, 2023 at 09:30 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 7.4.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `emanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `blue_print_marks_details`
--

CREATE TABLE `blue_print_marks_details` (
  `id` int(11) NOT NULL,
  `fib_obj` double DEFAULT NULL,
  `fib_sub` double DEFAULT NULL,
  `la` double DEFAULT NULL,
  `mcq` double DEFAULT NULL,
  `sa` double DEFAULT NULL,
  `tf` double DEFAULT NULL,
  `vsa` double DEFAULT NULL,
  `totalmarks` double DEFAULT NULL,
  `blueprint_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blue_print_marks_details`
--

INSERT INTO `blue_print_marks_details` (`id`, `fib_obj`, `fib_sub`, `la`, `mcq`, `sa`, `tf`, `vsa`, `totalmarks`, `blueprint_id`) VALUES
(50, 1, 0, 0, 1, 0, 1, 0, 3, 54),
(51, 1, 0, 0, 1, 0, 1, 0, 3, 55),
(52, 1, 0, 0, 1, 0, 1, 0, 3, 56),
(53, 1, 0, 0, 1, 0, 1, 0, 3, 57);

-- --------------------------------------------------------

--
-- Table structure for table `blue_print_tb`
--

CREATE TABLE `blue_print_tb` (
  `id` int(11) NOT NULL,
  `created_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `createdontimestamp` bigint(20) DEFAULT NULL,
  `location` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `master_course_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `option` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `status` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `subject` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `term` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `updated_by` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL,
  `updatedontimestamp` bigint(20) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8 COLLATE utf8_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `blue_print_tb`
--

INSERT INTO `blue_print_tb` (`id`, `created_by`, `createdontimestamp`, `location`, `master_course_name`, `option`, `status`, `subject`, `term`, `updated_by`, `updatedontimestamp`, `title`) VALUES
(54, 'DEV', 1675090077546, '9TS', 'Master Course 1', 'Objective', 'DRAFT', 'Subject 1', 'Term 1', 'DEV', 1675090077546, 'New blueprint with optimized code '),
(55, 'DEV', 1675096653439, '9TS', 'Master Course 1', 'Objective', 'DRAFT', 'Subject 1', 'Term 1', 'DEV', 1675096653439, 'Blueprint data'),
(56, 'DEV', 1675096917784, '9TS', 'Master Course 1', 'Objective', 'DRAFT', 'Subject 1', 'Term 1', 'DEV', 1675096917784, 'New blueprint 2'),
(57, 'DEV', 1675668473763, '9TS', 'Master Course 1', 'Objective', 'DRAFT', 'Subject 1', 'Term 1', 'DEV', 1675668473763, 'My first blueprint');

-- --------------------------------------------------------

--
-- Table structure for table `mcq_questions`
--

CREATE TABLE `mcq_questions` (
  `seq_id` int(11) NOT NULL,
  `option_1` varchar(255) DEFAULT NULL,
  `option_2` varchar(255) DEFAULT NULL,
  `option_3` varchar(255) DEFAULT NULL,
  `option_4` varchar(255) DEFAULT NULL,
  `question_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mcq_questions`
--

INSERT INTO `mcq_questions` (`seq_id`, `option_1`, `option_2`, `option_3`, `option_4`, `question_id`) VALUES
(13, 'sdfsfdasdf', 'asdfasd dasfd new correct answer updated answer for freezing', 'updating the option 3 again', 'updated option 4 new updates are here', 29),
(19, '', '', '', '', 33);

-- --------------------------------------------------------

--
-- Table structure for table `new_sequence`
--

CREATE TABLE `new_sequence` (
  `next_not_cached_value` bigint(21) NOT NULL,
  `minimum_value` bigint(21) NOT NULL,
  `maximum_value` bigint(21) NOT NULL,
  `start_value` bigint(21) NOT NULL COMMENT 'start value when sequences is created or value if RESTART is used',
  `increment` bigint(21) NOT NULL COMMENT 'increment value',
  `cache_size` bigint(21) UNSIGNED NOT NULL,
  `cycle_option` tinyint(1) UNSIGNED NOT NULL COMMENT '0 if no cycles are allowed, 1 if the sequence should begin a new cycle when maximum_value is passed',
  `cycle_count` bigint(21) NOT NULL COMMENT 'How many cycles have been done'
) ENGINE=InnoDB;

--
-- Dumping data for table `new_sequence`
--

INSERT INTO `new_sequence` (`next_not_cached_value`, `minimum_value`, `maximum_value`, `start_value`, `increment`, `cache_size`, `cycle_option`, `cycle_count`) VALUES
(1, 1, 9223372036854775806, 1, 1, 1000, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `question`
--

CREATE TABLE `question` (
  `seq_id` int(11) NOT NULL,
  `answer` varchar(255) DEFAULT NULL,
  `category` varchar(255) DEFAULT NULL,
  `option` varchar(255) DEFAULT NULL,
  `question_desc` varchar(255) DEFAULT NULL,
  `questionid` int(11) DEFAULT NULL,
  `subcategory` varchar(255) DEFAULT NULL,
  `suboption` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `question`
--

INSERT INTO `question` (`seq_id`, `answer`, `category`, `option`, `question_desc`, `questionid`, `subcategory`, `suboption`) VALUES
(29, 'option1', 'COMP', 'OBJ', 'New Updation is available here 123 updated  new updates and patches', 1, 'MK', 'MCQ'),
(30, 'Answer changed', 'FACT', 'OBJ', 'Question updated again demo updated again', 2, 'SK', 'FIB'),
(31, 'false', 'COMP', 'OBJ', 'Adding true false question updated', 3, 'CK', 'TF'),
(32, 'Sanjeev Kumar', 'COMP', 'OBJ', 'What is your full name?', 4, 'MK', 'FIB'),
(33, '', '', 'OBJ', '', 5, '', 'MCQ');

-- --------------------------------------------------------

--
-- Table structure for table `roles`
--

CREATE TABLE `roles` (
  `roleid` int(11) NOT NULL,
  `rolename` varchar(255) DEFAULT NULL,
  `timecreated` bigint(20) DEFAULT NULL,
  `timeupdated` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `roles`
--

INSERT INTO `roles` (`roleid`, `rolename`, `timecreated`, `timeupdated`) VALUES
(1, 'ADMIN', 1672569859304, 1672569859304),
(2, 'UEB', 20230211224549, 20230211224549),
(3, 'CO', 20230211224549, 20230211224549);

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `userid` int(11) NOT NULL,
  `location` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `timecreated` bigint(20) DEFAULT NULL,
  `timeupdated` bigint(20) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`userid`, `location`, `password`, `status`, `timecreated`, `timeupdated`, `username`, `user_id`) VALUES
(3, '9TS', 'sanjeev@123', 'Active', 1672509803483, 1672509803483, 'Sanjeev Kumar', NULL),
(4, '9TS', 'Anam@!23', 'Active', 1672510311101, 1672510311101, 'Anam', 1000),
(6, '9TS', 'Test@123', 'Active', 1672569859304, 1672569859304, 'test1', 1001),
(7, 'DUMMY_TEST', 'Test@123', 'Active', 1672740945761, 1672740945761, 'Dummy User', 1002),
(8, '10TS', 'Test@123', 'Active', 1673260469874, 1673260469874, 'Sachin  Sharma', 1003);

-- --------------------------------------------------------

--
-- Table structure for table `users_roles`
--

CREATE TABLE `users_roles` (
  `user_userid` int(11) NOT NULL,
  `roles_roleid` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `user_roles`
--

CREATE TABLE `user_roles` (
  `roleid` int(11) NOT NULL,
  `userid` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user_roles`
--

INSERT INTO `user_roles` (`roleid`, `userid`) VALUES
(1, 6),
(2, 6),
(3, 6);

-- --------------------------------------------------------

--
-- Table structure for table `workflow_assignment`
--

CREATE TABLE `workflow_assignment` (
  `assignmentid` int(11) NOT NULL,
  `createdby` bigint(20) DEFAULT NULL,
  `role` varchar(255) DEFAULT NULL,
  `timecreated` bigint(20) DEFAULT NULL,
  `timeupdated` bigint(20) DEFAULT NULL,
  `updatedby` bigint(20) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `process_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workflow_assignment`
--

INSERT INTO `workflow_assignment` (`assignmentid`, `createdby`, `role`, `timecreated`, `timeupdated`, `updatedby`, `userid`, `process_id`) VALUES
(2, 1001, 'CO', 1676146424532, 1676146424532, 0, 1001, 2);

-- --------------------------------------------------------

--
-- Table structure for table `workflow_process`
--

CREATE TABLE `workflow_process` (
  `processid` int(11) NOT NULL,
  `app` varchar(255) DEFAULT NULL,
  `ownerid` bigint(20) DEFAULT NULL,
  `timecreated` bigint(20) DEFAULT NULL,
  `timeupdated` bigint(20) DEFAULT NULL,
  `updatedby` bigint(20) DEFAULT NULL,
  `memo` varchar(255) DEFAULT NULL,
  `pending_with` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `workflow_process`
--

INSERT INTO `workflow_process` (`processid`, `app`, `ownerid`, `timecreated`, `timeupdated`, `updatedby`, `memo`, `pending_with`) VALUES
(2, 'BP', 1001, 0, 0, 1001, 'This it to test weather route wf is working or not', NULL),
(3, 'BP', 54, 0, 0, 1001, 'Sending For approval', 'OIC UEB'),
(4, 'BP', 55, 0, 0, 1001, 'fjalsdfj', 'CI'),
(5, 'BP', 56, 0, 0, 1001, 'Sending to CI', 'OIC UEB');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `blue_print_marks_details`
--
ALTER TABLE `blue_print_marks_details`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_63hxnfhy0w7l5p92xoh566c6k` (`blueprint_id`);

--
-- Indexes for table `blue_print_tb`
--
ALTER TABLE `blue_print_tb`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `mcq_questions`
--
ALTER TABLE `mcq_questions`
  ADD PRIMARY KEY (`seq_id`),
  ADD KEY `FKn1rr43ymm4rtx6tdtry5flv2o` (`question_id`);

--
-- Indexes for table `question`
--
ALTER TABLE `question`
  ADD PRIMARY KEY (`seq_id`);

--
-- Indexes for table `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`roleid`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`userid`);

--
-- Indexes for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD KEY `FK8wvn2euuxv9igsp8jh5ehu1mt` (`roles_roleid`),
  ADD KEY `FKa447bcrqmmjlpn3gnn89gstbl` (`user_userid`);

--
-- Indexes for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD KEY `FK6qgn9xtttlujey5sa2j7qow4d` (`userid`),
  ADD KEY `FKmet9tvqxk3rk51yhrcje7dwd5` (`roleid`);

--
-- Indexes for table `workflow_assignment`
--
ALTER TABLE `workflow_assignment`
  ADD PRIMARY KEY (`assignmentid`),
  ADD KEY `FK23yqknvuak21ng3ujbc165nuq` (`process_id`);

--
-- Indexes for table `workflow_process`
--
ALTER TABLE `workflow_process`
  ADD PRIMARY KEY (`processid`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `blue_print_marks_details`
--
ALTER TABLE `blue_print_marks_details`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT for table `blue_print_tb`
--
ALTER TABLE `blue_print_tb`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=58;

--
-- AUTO_INCREMENT for table `mcq_questions`
--
ALTER TABLE `mcq_questions`
  MODIFY `seq_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `question`
--
ALTER TABLE `question`
  MODIFY `seq_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=34;

--
-- AUTO_INCREMENT for table `roles`
--
ALTER TABLE `roles`
  MODIFY `roleid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `userid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `workflow_assignment`
--
ALTER TABLE `workflow_assignment`
  MODIFY `assignmentid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `workflow_process`
--
ALTER TABLE `workflow_process`
  MODIFY `processid` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `blue_print_marks_details`
--
ALTER TABLE `blue_print_marks_details`
  ADD CONSTRAINT `FKs7p7tf5kymf1r34gyaukya3pw` FOREIGN KEY (`blueprint_id`) REFERENCES `blue_print_tb` (`id`);

--
-- Constraints for table `mcq_questions`
--
ALTER TABLE `mcq_questions`
  ADD CONSTRAINT `FKn1rr43ymm4rtx6tdtry5flv2o` FOREIGN KEY (`question_id`) REFERENCES `question` (`seq_id`);

--
-- Constraints for table `users_roles`
--
ALTER TABLE `users_roles`
  ADD CONSTRAINT `FK8wvn2euuxv9igsp8jh5ehu1mt` FOREIGN KEY (`roles_roleid`) REFERENCES `roles` (`roleid`),
  ADD CONSTRAINT `FKa447bcrqmmjlpn3gnn89gstbl` FOREIGN KEY (`user_userid`) REFERENCES `users` (`userid`);

--
-- Constraints for table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK6qgn9xtttlujey5sa2j7qow4d` FOREIGN KEY (`userid`) REFERENCES `users` (`userid`),
  ADD CONSTRAINT `FKmet9tvqxk3rk51yhrcje7dwd5` FOREIGN KEY (`roleid`) REFERENCES `roles` (`roleid`);

--
-- Constraints for table `workflow_assignment`
--
ALTER TABLE `workflow_assignment`
  ADD CONSTRAINT `FK23yqknvuak21ng3ujbc165nuq` FOREIGN KEY (`process_id`) REFERENCES `workflow_process` (`processid`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
