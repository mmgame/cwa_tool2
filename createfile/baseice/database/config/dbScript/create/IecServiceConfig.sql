CREATE TABLE `0_iecService` (
	`gid` int(11) DEFAULT '0',
	`ftype` int(11) DEFAULT '0',
	`key` varchar(30) DEFAULT '',
	`version` int(11) DEFAULT '0',
	`available` int(11) DEFAULT '0',
	`initPriority` int(11) DEFAULT '0',
	`groupIds` varchar(100) DEFAULT '',
	`port` int(11) DEFAULT '0',
	`protocol` varchar(30) DEFAULT '',
	`adapterName` varchar(30) DEFAULT '',
	`packageNames` varchar(100) DEFAULT '',
	`interfcNames` varchar(100) DEFAULT '',

	PRIMARY KEY (`gid`,`ftype`,`key`),
	KEY `gid_ftype` (`gid`,`ftype`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
