CREATE TABLE `1_matchStar` (
	`userId` bigint(20) DEFAULT '0',
	`matchType` int(11) DEFAULT '0',
	`chapterId` int(11) DEFAULT '0',
	`chapterStars` varchar(100) DEFAULT '',
	`chapterScores` varchar(100) DEFAULT '',

	PRIMARY KEY (`userId`,`matchType`,`chapterId`),
	KEY `userId_matchType` (`userId`,`matchType`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
