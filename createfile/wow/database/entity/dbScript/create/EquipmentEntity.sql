CREATE TABLE `1_equipment` (
	`userId` bigint(20) DEFAULT '0',
	`heroId` int(11) DEFAULT '0',
	`positionId` int(11) DEFAULT '0',
	`equipmentLevel` int(11) DEFAULT '0',
	`equipmentQuality` int(11) DEFAULT '0',
	`plugs` varchar(60) DEFAULT '',

	PRIMARY KEY (`userId`,`heroId`,`positionId`),
	KEY `userId_heroId` (`userId`,`heroId`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
