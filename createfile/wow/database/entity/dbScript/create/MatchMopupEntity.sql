CREATE TABLE `1_matchMopup` (
	`userId` bigint(20) DEFAULT '0',
	`mopupCount` int(11) DEFAULT '0',
	`resetTime` bigint(20) DEFAULT '0',

	PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
