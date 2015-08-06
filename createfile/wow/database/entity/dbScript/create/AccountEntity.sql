CREATE TABLE `1_account` (
	`accountId` bigint(20) DEFAULT '0',
	`account` varchar(50) DEFAULT '',
	`channel` int(11) DEFAULT '0',
	`password` varchar(50) DEFAULT '',
	`createTime` bigint(20) DEFAULT '0',
	`rids` varchar(255) DEFAULT '',

	PRIMARY KEY (`accountId`),
	KEY `account_channel` (`account`,`channel`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
