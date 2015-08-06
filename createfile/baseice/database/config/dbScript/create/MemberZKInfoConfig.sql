CREATE TABLE `0_memberZKInfo` (
	`gid` int(11) DEFAULT '0',
	`hosts` varchar(100) DEFAULT '',
	`sessionTimeout` int(11) DEFAULT '0',
	`rootPath` varchar(30) DEFAULT '',

	PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
