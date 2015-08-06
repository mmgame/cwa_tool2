CREATE TABLE `1_usereconomy` (
	`userId` bigint(20) DEFAULT '0',
	`moneyType` int(3) DEFAULT '0',
	`moneyCount` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`,`moneyType`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
