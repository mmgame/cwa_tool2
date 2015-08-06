package com.cwa.data.${flag}.spread;

import java.util.List;

import baseice.basedao.IKey;

import com.cwa.component.data.operate.pool.IOperatePool;
import com.cwa.component.data.operate.DaoOperateFactory;
import com.cwa.component.data.operate.IDaoOperate;
import com.cwa.component.data.operate.TypeDaoOperate.DaoOperateType;
import com.cwa.data.${flag}.I${className}Dao;
import com.cwa.data.${flag}.domain.${className};

public class ${className}Dao implements I${className}Dao {
	private I${className}Dao dao;

	protected IOperatePool operatePool;// 操作池
	protected DaoOperateFactory daoOperateFactory;// 数据操作工厂
	
	@Override
	public List<${className}> selectEntity(IKey key, Object attach) {
		//DefaultKey defaultKey = (DefaultKey) key;
		//if (defaultKey.functionName.equals("selectEntityByChannel")) {
		//	return dao.selectEntity(defaultKey);
		//}
		return null;
	}

<#list indexAttrs as indexAttr>
	@Override
	<#if indexAttr.isHasGroupIndex==0 >
	public ${className} selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach) {
		${className} entity =( ${className})dao.selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrPName}, <#rt>
		</#list>
		<#lt>attach);
		if(entity != null){
		   entity.obtainAfter();
		}
		return entity;
	}
	<#else>
	public List<${className}> selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach) {
		List<${className}> entitys = dao.selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrPName}, <#rt>
		</#list>
		<#lt>attach);
		for (${className} entity : entitys) {
	        entity.obtainAfter();
		}
		return entitys;
	}
	</#if>
	</#list>
	

	@Override
	public List<${className}> selectAllEntity(Object attach) {
	    List<${className}> entitys = dao.selectAllEntity(attach);
	    for (${className} entity : entitys) {
	        entity.obtainAfter();
		}
		return entitys;
	}
	
	@Override
	public void insertEntity(${className} entity, Object attach) {
	    entity.saveBefore();
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Insert, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void updateEntity(${className} entity, Object attach) {
	    entity.saveBefore();
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Update, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void removeEntity(${className} entity, Object attach) {
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.Remove, entity, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchInsertEntity(List<${className}> entitys, Object attach) {
	    for (${className} entity : entitys) {
	        entity.saveBefore();
		}
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.BatchInsert, entitys, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchUpdateEntity(List<${className}> entitys, Object attach) {
	    for (${className} entity : entitys) {
	        entity.saveBefore();
		}
		IDaoOperate daoOperate = daoOperateFactory.createDaoOperate(dao, DaoOperateType.BatchUpdate, entitys, "", null, attach);
		operatePool.execute(daoOperate);
	}

	@Override
	public void batchRemoveEntity(List<${className}> entitys, Object attach) {
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

	public void setDao(I${className}Dao dao) {
		this.dao = dao;
	}
	
	public void setOperatePool(IOperatePool operatePool) {
		this.operatePool = operatePool;
	}

	public void setDaoOperateFactory(DaoOperateFactory daoOperateFactory) {
		this.daoOperateFactory = daoOperateFactory;
	}
}
