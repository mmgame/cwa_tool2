CREATE TABLE `0_databaseInfo` (
	`gid` int(11) DEFAULT '0',
	`dbid` int(11) DEFAULT '0',
	`ip` varchar(255) DEFAULT '',
	`port` int(11) DEFAULT '0',
	`dbName` varchar(255) DEFAULT '',
	`user` varchar(255) DEFAULT '',
	`password` varchar(255) DEFAULT '',
	`regionMap` varchar(255) DEFAULT '',
	`mybatis` varchar(255) DEFAULT '',

	PRIMARY KEY (`gid`,`dbid`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
