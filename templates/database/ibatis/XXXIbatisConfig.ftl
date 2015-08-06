<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd" >

<mapper namespace="com.cwa.data.${flag}.domain.${className?cap_first}">
	<resultMap id="${className}" type="com.cwa.data.${flag}.domain.${className?cap_first}">
	<#list attrs as attr>
		<result column="${attr.attrDBName}" property="${attr.attrPName}" />
	</#list>
	</resultMap>
	
	<#list indexAttrs as indexAttr>
	<select id="selectBy${indexAttr.name}" resultMap="${className}">
		select * from `${r'${table_number}'}_${tableName}` where (<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>`${attr.attrDBName}`=#${r'{'}${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
		</#list>
		<#lt>)
	</select>
	</#list>
	
	<select id="selectAllEntity" resultMap="${className}">
		select * from `${r'${table_number}'}_${tableName}`
	</select>
	
	<insert id="insert" parameterType="java.util.Map">
		insert into `${r'${table_number}'}_${tableName}` (<#rt>
		<#list attrs as attr>
		<#lt>`${attr.attrDBName}`<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt>) values (<#rt>
		<#list attrs as attr>
		<#lt>#${r'{'}entity.${attr.attrPName}${r'}'}<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt>)
	</insert>
	
	<update id="update" parameterType="java.util.Map">
		update `${r'${table_number}'}_${tableName}` set <#rt>
		<#list attrs as attr>
		<#lt>`${attr.attrDBName}`=#${r'{'}entity.${attr.attrPName}${r'}'}<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt> where <#rt>
		<#list indexAttrs as indexAttr>
		<#lt>(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>`${attr.attrDBName}`=#${r'{'}entity.${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
		</#list>
		<#lt>)
		<#break>
		</#list>
	</update>
	
	<delete id="remove" parameterType="java.util.Map">
		delete from `${r'${table_number}'}_${tableName}` where <#rt>	
		<#list indexAttrs as indexAttr>
		<#lt>(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>`${attr.attrDBName}`=#${r'{'}entity.${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
		</#list>
		<#lt>)
		<#break>
		</#list>
	</delete>
	
	<insert id="batchInsert" parameterType="java.util.Map">
		insert into `${r'${table_number}'}_${tableName}` (<#rt>
		<#list attrs as attr>
		<#lt>`${attr.attrDBName}`<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt>) values 
		<foreach collection="entity_list" item="item" index="index" separator=",">
		(<#rt>
		<#list attrs as attr>
		<#lt>#${r'{'}item.${attr.attrPName}${r'}'}<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt>)
		</foreach> 
	</insert> 
	
	<delete id= "batchRemove" parameterType="java.util.Map">
		delete from `${r'${table_number}'}_${tableName}` where
       <foreach collection="entity_list" item= "item" index ="index" separator="or">
       <#list indexAttrs as indexAttr>
       (<#rt>
	   <#list indexAttr.attrs as attr>
	   <#lt>`${attr.attrDBName}`=#${r'{'}item.${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
	   </#list>
	   <#lt>)
	   <#break>
	   </#list>
       </foreach>
    </delete>
    
	<select id="selectAllTableName" parameterType="java.util.Map">
		select TABLE_NAME from information_schema.tables where TABLE_SCHEMA = ${"#"}{db_number} and TABLE_NAME like '${tableName}\_%'
	</select>
	
	<update id="createTable" parameterType="java.util.Map">
		CREATE TABLE `${r'${table_number}'}_${tableName}` (
		<#list eattrs as attr>
			`${attr.attrName}` ${attr.attrType} ${attr.attrLimit},
		</#list>
		<#if isSingleIndex == 0>
		<#list indexAttrs as indexAttr>
		KEY <#rt>
		<#list indexAttr.attrs as attr>
		<#if attr_index == 0>
		<#lt>`<#rt>
		</#if>
		<#lt>${attr.attrPName}<#if attr_has_next>_</#if><#rt>
		</#list>
		<#lt>` (<#rt>
		<#list indexAttr.attrs as attr>
  		<#lt>`${attr.attrDBName}`<#if attr_has_next>,</#if><#rt>
  		</#list>
  		<#lt>)<#if indexAttr_has_next>,</#if>
  		</#list>
		<#else>
		<#list indexAttrs as indexAttr>
		<#if indexAttr_index == 0>
		PRIMARY KEY (<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>`${attr.attrDBName}`<#if attr_has_next>,</#if><#rt>
		</#list>
		<#lt>)<#if indexAttr_has_next>,</#if>
		<#else>
		KEY <#rt>
		<#list indexAttr.attrs as attr>
		<#if attr_index == 0>
		<#lt>`<#rt>
		</#if>
		<#lt>${attr.attrPName}<#if attr_has_next>_</#if><#rt>
		</#list>
		<#lt>` (<#rt>
		<#list indexAttr.attrs as attr>
  		<#lt>`${attr.attrDBName}`<#if attr_has_next>,</#if><#rt>
  		</#list>
  		<#lt>)<#if indexAttr_has_next>,</#if>
		</#if>  
  		</#list>
		</#if> 
		) ENGINE=InnoDB DEFAULT CHARSET=utf8;
	</update>
	
	<update id="batchUpdate" parameterType="java.util.Map">
		 update `${r'${table_number}'}_${tableName}` set 
		 <#list attrs as attr>
		 `${attr.attrDBName}`=case 
		 <foreach collection="entity_list" item="item" index="index">
           when <#rt>
           <#list indexAttrs as indexAttr>
	       <#lt>(<#rt>
		   <#list indexAttr.attrs as attr>
		   <#lt>`${attr.attrDBName}`=#${r'{'}item.${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
		   </#list>
		   <#lt>)<#rt>
		   <#break>
		   </#list>
           <#lt> then #${r'{'}item.${attr.attrPName}${r'}'} 
       	</foreach>
        end<#if attr_has_next>,</#if>
		 </#list>
		where
       	<foreach collection="entity_list" item="item" index="index" separator="or">
       	<#list indexAttrs as indexAttr>
        (<#rt>
	    <#list indexAttr.attrs as attr>
	    <#lt>`${attr.attrDBName}`=#${r'{'}item.${attr.attrPName}${r'}'}<#if attr_has_next> and <#rt></#if><#rt>
	    </#list>
	    <#lt>)
	    <#break>
	    </#list>
       	</foreach>
	</update>
</mapper>