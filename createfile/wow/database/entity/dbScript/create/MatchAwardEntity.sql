CREATE TABLE `1_matchAward` (
	`userId` bigint(20) DEFAULT '0',
	`chapterId` int(11) DEFAULT '0',
	`awardStates` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`,`chapterId`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
