package com.cwa.data.${flag}.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

import ${projectName}.data.${flag}.${generalClassName};

import com.cwa.component.data.ISpreadEntity;
import com.cwa.util.prototype.JsonUtil;

public class ${className} extends ${generalClassName} implements ISpreadEntity {
	private static final long serialVersionUID = 1L;
	
<#list attrs as attr>  	
	<#if attr.isCollection == 1 >		
	private ${attr.collectionType}${attr.collectionSuffix} ${attr.attrName}${attr.collectionType} = new ${attr.collectionInitType}${attr.collectionSuffix}();
	</#if>
</#list>

	@Override
	public void obtainAfter() {
<#list attrs as attr>  
		<#if attr.isCollection == 1 >				
	    ${attr.attrName}${attr.collectionType} = JsonUtil.transferJsonTOJavaBean(this.${attr.attrName}, ${attr.collectionType}.class);
		</#if>
</#list>
	}

	@Override
	public void saveBefore() {
<#list attrs as attr>  
		<#if attr.isCollection == 1 >
		this.${attr.attrName} = JsonUtil.gsonObj2String(${attr.attrName}${attr.collectionType});
		</#if>
</#list>
	}

	@Override
	public void saveAfter() {
	}

<#list attrs as attr>  	
	<#if attr.isCollection == 1 >		
	public ${attr.collectionType}${attr.collectionSuffix} get${attr.attrName?cap_first}${attr.collectionType}(){
		return ${attr.attrName}${attr.collectionType};
	}
	</#if>
</#list>

<#list attrs as attr>  	
	<#if attr.isCollection == 1 >		
	public void set${attr.attrName?cap_first}${attr.collectionType}(${attr.collectionType}${attr.collectionSuffix} ${attr.attrName}${attr.collectionType}){
		this.${attr.attrName}${attr.collectionType} = ${attr.attrName}${attr.collectionType};
	}
	</#if>
</#list>
	public ${className} cloneEntity() {
		${className} entity = new ${className}();
		<#list attrs as attr>
		entity.${attr.attrName} = this.${attr.attrName};
		</#list>
		return entity;
	}
}
