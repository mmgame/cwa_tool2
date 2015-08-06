package com.cwa.data.${flag}.general;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import baseice.basedao.IKey;

import org.apache.ibatis.session.SqlSession;

import com.cwa.data.${flag}.I${className}Dao;
import com.cwa.data.${flag}.domain.${className};

public class ${className}GeneralDao implements I${className}Dao {
	protected static String namespace = ${className}.class.getCanonicalName();

	public ${className}GeneralDao() {
	}

	@Override
	public List<${className}> selectEntity(IKey key, Object attach) {
		//DefaultKey defaultKey = (DefaultKey) key;
		//if (defaultKey.functionName.equals("selectEntityByUserId")) {
		//}
		return null;
	}

	<#list indexAttrs as indexAttr>
	@SuppressWarnings("unchecked")
	@Override
	<#if indexAttr.isHasGroupIndex==0 >
	public ${className} selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		<#list indexAttr.attrs as attr>
		paras.put("${attr.attrPName}", ${attr.attrPName});
		</#list>
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		List<${className}> list = sqlSessionTemplate.selectList(namespace + ".selectBy${indexAttr.name}", paras);
		return list.isEmpty()?null : list.get(0);
	}
	<#else>
	public List<${className}> selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		<#list indexAttr.attrs as attr>
		paras.put("${attr.attrPName}", ${attr.attrPName});
		</#list>
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		return sqlSessionTemplate.selectList(namespace + ".selectBy${indexAttr.name}", paras);
	}
	</#if>
	</#list>
	
	@SuppressWarnings("unchecked")
	@Override
	public List<${className}> selectAllEntity(Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		return sqlSessionTemplate.selectList(namespace + ".selectAllEntity", paras);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void insertEntity(${className} entity, Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity", entity);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.insert(namespace + ".insert", paras);
	}
	
    @SuppressWarnings("unchecked")
	@Override
	public void updateEntity(${className} entity, Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity", entity);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.update(namespace + ".update", paras);
	}

    @SuppressWarnings("unchecked")
	@Override
	public void removeEntity(${className} entity, Object attach)  {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity", entity);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.update(namespace + ".remove", paras);
	}

    @SuppressWarnings("unchecked")
	@Override
	public void batchInsertEntity(List<${className}> entitys, Object attach)  {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity_list", entitys);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.insert(namespace + ".batchInsert", paras);
	}
    
    @SuppressWarnings("unchecked")
	@Override
	public void batchUpdateEntity(List<${className}> entitys, Object attach)  {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity_list", entitys);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.update(namespace + ".batchUpdate", paras);
	}

    @SuppressWarnings("unchecked")
	@Override
	public void batchRemoveEntity(List<${className}> entitys, Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		paras.put("entity_list", entitys);
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.update(namespace + ".batchRemove", paras);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public void createTable(Object attach) {
		Map<String, Object> paras = (Map<String, Object>) attach;
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		sqlSessionTemplate.insert(namespace + ".createTable", paras);
	}

	@Override
	public List<String> selectAllTableName(Object attach) {
		Map<String, Object> paras = new HashMap<String, Object>();
		
		SqlSession sqlSessionTemplate = (SqlSession) paras.get("sql_session");
		return sqlSessionTemplate.selectList(namespace + ".selectAllTableName", paras);
	}
}
