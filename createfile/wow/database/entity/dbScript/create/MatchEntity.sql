CREATE TABLE `1_match` (
	`userId` bigint(20) DEFAULT '0',
	`matchType` int(11) DEFAULT '0',
	`match_keyid` int(11) DEFAULT '0',
	`battleKeyIds` varchar(200) DEFAULT '',
	`resetKeyIds` varchar(200) DEFAULT '',
	`resetTime` bigint(20) DEFAULT '0',

	PRIMARY KEY (`userId`,`matchType`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
