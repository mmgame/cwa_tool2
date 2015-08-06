CREATE TABLE `1_matchShop` (
	`userId` bigint(20) DEFAULT '0',
	`shopType` int(11) DEFAULT '0',
	`shopId` int(11) DEFAULT '0',
	`resetTime` bigint(20) DEFAULT '0',
	`goodsIndex` varchar(200) DEFAULT '',
	`refreshCount` int(11) DEFAULT '0',
	`creatTime` bigint(20) DEFAULT '0',

	PRIMARY KEY (`userId`,`shopType`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
