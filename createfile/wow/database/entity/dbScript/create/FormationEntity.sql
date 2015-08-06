CREATE TABLE `1_formation` (
	`userId` bigint(20) DEFAULT '0',
	`type` int(11) DEFAULT '0',
	`heros` varchar(200) DEFAULT '',
	`retinues` varchar(200) DEFAULT '',

	PRIMARY KEY (`userId`,`type`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
