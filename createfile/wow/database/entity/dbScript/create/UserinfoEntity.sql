CREATE TABLE `1_userinfo` (
	`userId` bigint(20) DEFAULT '0',
	`name` varchar(32) DEFAULT '',
	`level` int(11) DEFAULT '0',
	`experience` int(11) DEFAULT '0',
	`icon` int(11) DEFAULT '0',
	`modifyNameCount` int(11) DEFAULT '0',
	`power` int(11) DEFAULT '0',
	`buyCount` int(11) DEFAULT '0',
	`resetTime` bigint(20) DEFAULT '0',
	`eventState` varchar(255) DEFAULT '',
	`functionState` varchar(255) DEFAULT '',

	PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
