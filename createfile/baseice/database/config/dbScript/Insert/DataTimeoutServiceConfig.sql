insert into `0_datatimeoutservice` 
(`gid`,`ftype`,`key`,`version`,`available`,`initPriority`,`timeout`,`expression`)
VALUES
(0,0,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(0,8,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(1,1,'NetDataTimeout',1,1,90,120000,'0/20 * * * * ?'),
(1,1,'DataTimeout',1,1,90,900000,'0/20 * * * * ?'),
(1,2,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(1,3,'DataTimeout',1,1,90,120000,'0/20 * * * * ?'),
(1,9,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(1,7,'DataTimeout',1,1,90,900000,'0/20 * * * * ?'),
(1,7,'NetDataTimeout',1,1,90,120000,'0/20 * * * * ?'),
(2,1,'NetDataTimeout',1,1,90,120000,'0/20 * * * * ?'),
(2,1,'DataTimeout',1,1,90,900000,'0/20 * * * * ?'),
(2,2,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(2,3,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(2,9,'DataTimeout',1,0,90,900000,'0/20 * * * * ?'),
(2,7,'DataTimeout',1,1,90,900000,'0/20 * * * * ?'),
(2,7,'NetDataTimeout',1,1,90,120000,'0/20 * * * * ?')
