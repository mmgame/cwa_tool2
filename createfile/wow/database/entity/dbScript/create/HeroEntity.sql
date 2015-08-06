CREATE TABLE `1_hero` (
	`userId` bigint(20) DEFAULT '0',
	`heroId` int(11) DEFAULT '0',
	`level` int(11) DEFAULT '0',
	`experience` int(11) DEFAULT '0',
	`starLevel` int(11) DEFAULT '0',
	`quality` int(11) DEFAULT '0',
	`patienceTrain` varchar(60) DEFAULT '',
	`trainState` int(11) DEFAULT '0',
	`waitPatienceTrain` varchar(60) DEFAULT '',
	`trainType` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`,`heroId`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
