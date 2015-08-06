CREATE TABLE `0_minaService` (
	`gid` int(11) DEFAULT '0',
	`ftype` int(11) DEFAULT '0',
	`key` varchar(30) DEFAULT '',
	`version` int(11) DEFAULT '0',
	`available` int(11) DEFAULT '0',
	`initPriority` int(11) DEFAULT '0',
	`listening` int(11) DEFAULT '0',
	`heartbeatId` int(11) DEFAULT '0',
	`forwardEvent` int(11) DEFAULT '0',
	`ideltimeout` int(11) DEFAULT '0',
	`heartbeatrate` int(11) DEFAULT '0',
	`messagemaxpackage` int(11) DEFAULT '0',
	`connectTimeout` int(11) DEFAULT '0',
	`minpool` int(11) DEFAULT '0',
	`maxpool` int(11) DEFAULT '0',
	`allowedInterval` int(11) DEFAULT '0',

	PRIMARY KEY (`gid`,`ftype`,`key`),
	KEY `gid_ftype` (`gid`,`ftype`),
	KEY `gid` (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
