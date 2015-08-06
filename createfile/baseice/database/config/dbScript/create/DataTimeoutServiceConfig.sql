CREATE TABLE `0_dataTimeoutService` (
	`gid` int(11) DEFAULT '0',
	`ftype` int(11) DEFAULT '0',
	`key` varchar(30) DEFAULT '',
	`version` int(11) DEFAULT '0',
	`available` int(11) DEFAULT '0',
	`initPriority` int(11) DEFAULT '0',
	`timeout` int(11) DEFAULT '0',
	`expression` varchar(30) DEFAULT '',

	PRIMARY KEY (`gid`,`ftype`,`key`),
	KEY `gid_ftype` (`gid`,`ftype`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
