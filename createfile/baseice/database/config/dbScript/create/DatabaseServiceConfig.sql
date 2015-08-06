CREATE TABLE `0_databaseService` (
	`gid` int(11) DEFAULT '0',
	`ftype` int(11) DEFAULT '0',
	`key` varchar(30) DEFAULT '',
	`version` int(11) DEFAULT '0',
	`available` int(11) DEFAULT '0',
	`initPriority` int(11) DEFAULT '0',
	`groupIds` varchar(100) DEFAULT '',
	`driverClass` varchar(100) DEFAULT '',
	`minPool` int(11) DEFAULT '0',
	`initialPool` int(11) DEFAULT '0',
	`maxPool` int(11) DEFAULT '0',
	`acquireIncrement` int(11) DEFAULT '0',
	`maxStatements` int(11) DEFAULT '0',
	`maxStatementsPerConnection` int(11) DEFAULT '0',
	`maxIdleTime` int(11) DEFAULT '0',
	`checkoutTimeout` int(11) DEFAULT '0',

	PRIMARY KEY (`gid`,`ftype`,`key`),
	KEY `gid_ftype` (`gid`,`ftype`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
