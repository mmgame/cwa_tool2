CREATE TABLE `1_testUser` (
	`userId` bigint(20) DEFAULT '0',
	`level` int(11) DEFAULT '0',
	`name` varchar(50) DEFAULT '',
	`exp` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
