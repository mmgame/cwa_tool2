CREATE TABLE `1_matchConceal` (
	`userId` bigint(20) DEFAULT '0',
	`concealId` int(11) DEFAULT '0',
	`resetTime` bigint(20) DEFAULT '0',

	PRIMARY KEY (`userId`,`concealId`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
