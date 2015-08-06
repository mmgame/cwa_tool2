CREATE TABLE `1_item` (
	`userId` bigint(20) DEFAULT '0',
	`itemId` int(11) DEFAULT '0',
	`count` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`,`itemId`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
