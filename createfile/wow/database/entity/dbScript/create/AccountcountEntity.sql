CREATE TABLE `1_accountcount` (
	`aid` int(11) DEFAULT '0',
	`address` varchar(20) DEFAULT '',
	`count` bigint(20) DEFAULT '0',
	`version` bigint(20) DEFAULT '0',

	PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
