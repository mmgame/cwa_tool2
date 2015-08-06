CREATE TABLE `1_userattr` (
	`userId` bigint(20) DEFAULT '0',
	`attrType` int(11) DEFAULT '0',
	`attrValue` bigint(20) DEFAULT '0',

	PRIMARY KEY (`userId`,`attrType`),
	KEY `userId` (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
