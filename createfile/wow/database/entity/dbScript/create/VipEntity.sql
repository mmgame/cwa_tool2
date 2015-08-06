CREATE TABLE `1_vip` (
	`userId` bigint(20) DEFAULT '0',
	`vipLevel` int(11) DEFAULT '0',
	`vipExp` int(11) DEFAULT '0',
	`rewardState` int(11) DEFAULT '0',

	PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
