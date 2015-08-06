CREATE TABLE `0_nettyService` (
	`gid` int(11) DEFAULT '0',
	`ftype` int(11) DEFAULT '0',
	`key` varchar(30) DEFAULT '',
	`version` int(11) DEFAULT '0',
	`available` int(11) DEFAULT '0',
	`initPriority` int(11) DEFAULT '0',
	`listening` int(11) DEFAULT '0',
	`readerIdleTime` int(11) DEFAULT '0',
	`writerIdleTime` int(11) DEFAULT '0',
	`allIdleTime` int(11) DEFAULT '0',
	`subReactorThreadNum` int(11) DEFAULT '0',
	`handlerThreadNum` int(11) DEFAULT '0',

	PRIMARY KEY (`gid`,`ftype`,`key`),
	KEY `gid_ftype` (`gid`,`ftype`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
