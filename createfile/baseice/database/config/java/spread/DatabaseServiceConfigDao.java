package com.cwa.data.config.spread;

import java.util.List;

import baseice.basedao.IKey;

import com.cwa.component.data.operate.pool.IOperatePool;
import com.cwa.component.data.operate.DaoOperateFactory;
import com.cwa.component.data.operate.IDaoOperate;
import com.cwa.component.data.operate.TypeDaoOperate.DaoOperateType;
import com.cwa.data.config.IDatabaseServiceConfigDao;
import com.cwa.data.config.domain.DatabaseServiceConfig;

public class DatabaseServiceConfigDao implements IDatabaseServiceConfigDao {
	private IDatabaseServiceConfigDao dao;

	protected IOperatePool operatePool;// 操作池
	protected DaoOperateFactory daoOperateFactory;// 数据操作工厂
	
	@Override
	public List<DatabaseServiceConfig> selectEntity(IKey key, Object attach) {
		//DefaultKey defaultKey = (DefaultKey) key;
		//if (defaultKey.functionName.equals("selectEntityByChannel")) {
		//	return dao.selectEntity(defaultKey);
		//}
		return null;
	}

	@Override
	public DatabaseServiceConfig selectEntityByGidAndFtypeAndKey(int gid,int ftype,String key,Object attach) {
		DatabaseServiceConfig entity =( DatabaseServiceConfig)dao.selectEntityByGidAndFtypeAndKey(gid, ftype, key, attach);
		if(entity != null){
		   entity.obtainAfter();
		}
		return entity;
	}
	@Override
	public List<DatabaseServiceConfig> selectEntityByGidAndFtype(int gid,int ftype,Object attach) {
		List<DatabaseServiceConfig> entitys = dao.selectEntityByGidAndFtype(gid, ftype, attach);
		for (DatabaseServiceConfig entity : entitys) {
	        entity.obtainAfter();
		}
		return entitys;
	}
	@Override
	public List<DatabaseServiceConfig> selectEntityByGid(int gid,Object attach) {
		List<DatabaseServiceConfig> entitys = dao.selectEntityByGid(gid, attach);
		for (DatabaseServiceConfig entity : entitys) {
	        entity.obtainAfter();
		}
		return entitys;
	}
	

	@Override
	public List<DatabaseServiceConfig> selectAllEntity(Object attach) {
	    List<DatabaseServiceConfig> entitys = dao.selectAllEntity(attach);
	    for (DatabaseServiceConfig entity : entitys) {
	        entity.obtainAfter();
		}
		return entitys;
	}
	
	@Override
	public void insertEntity(DatabaseServiceConfig entity, Object attach) {
	    entity.saveBefore();
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Insert, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void updateEntity(DatabaseServiceConfig entity, Object attach) {
	    entity.saveBefore();
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Update, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void removeEntity(DatabaseServiceConfig entity, Object attach) {
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Remove, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchInsertEntity(List<DatabaseServiceConfig> entitys, Object attach) {
	    for (DatabaseServiceConfig entity : entitys) {
	        entity.saveBefore();
		}
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.BatchInsert, entitys, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchUpdateEntity(List<DatabaseServiceConfig> entitys, Object attach) {
	    for (DatabaseServiceConfig entity : entitys) {
	        entity.saveBefore();
		}
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.BatchUpdate, entitys, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchRemoveEntity(List<DatabaseServiceConfig> entitys, Object attach) {
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.BatchRemove, entitys, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void createTable(Object attach) {
		dao.createTable(attach);
	}

	@Override
	public List<String> selectAllTableName(Object attach) {
		return dao.selectAllTableName(attach);
	}
	// ------------------------------

	public void setDao(IDatabaseServiceConfigDao dao) {
		this.dao = dao;
	}
	
	public void setOperatePool(IOperatePool operatePool) {
		this.operatePool = operatePool;
	}

	public void setDaoOperateFactory(DaoOperateFactory daoOperateFactory) {
		this.daoOperateFactory = daoOperateFactory;
	}
}
