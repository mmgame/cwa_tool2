insert into `0_iecservice` 
(`gid`,`ftype`,`key`,`version`,`available`,`initPriority`,`groupIds`,`port`,`protocol`,`adapterName`,`packageNames`,`interfcNames`)
VALUES
(0,0,'IceServer',1,1,100,'[0]',30001,'tcp','service','["baseice.event.","serverice.config."]','["IEventListener","IConfigService"]'),
(0,8,'IceServer',1,1,100,'[0]',30801,'tcp','service','["baseice.event.","serverice.proto."]','["IEventListener","IProtoService"]'),
(1,1,'IceServer',1,1,100,'[1]',30101,'tcp','service','["baseice.event."]','["IEventListener"]'),
(1,2,'IceServer',1,1,100,'[1]',30201,'tcp','service','["baseice.event.","serverice.foyer."]','["IEventListener","IFoyerService"]'),
(1,3,'IceServer',1,1,100,'[1]',30301,'tcp','service','["baseice.event.","serverice.account."]','["IEventListener","IAccountService"]'),
(1,9,'IceServer',1,1,100,'[1]',30901,'tcp','service','["baseice.event.","serverice.room."]','["IEventListener","IRoomService"]'),
(1,7,'IceServer',1,1,100,'[1]',30701,'tcp','service','["baseice.event.","serverice.battle."]','["IEventListener","IBattleService"]'),
(2,1,'IceServer',1,1,100,'[2]',30101,'tcp','service','["baseice.event."]','["IEventListener"]'),
(2,2,'IceServer',1,1,100,'[2]',30201,'tcp','service','["baseice.event.","serverice.foyer."]','["IEventListener","IFoyerService"]'),
(2,3,'IceServer',1,1,100,'[2]',30301,'tcp','service','["baseice.event.","serverice.account."]','["IEventListener","IAccountService"]'),
(2,9,'IceServer',1,1,100,'[2]',30901,'tcp','service','["baseice.event.","serverice.room."]','["IEventListener","IRoomService"]'),
(2,7,'IceServer',1,1,100,'[2]',30701,'tcp','service','["baseice.event.","serverice.battle."]','["IEventListener","IBattleService"]')
