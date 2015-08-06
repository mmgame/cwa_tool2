package com.cwa.data.${flag};

import java.util.List;

import com.cwa.component.data.IEntityDao;
import com.cwa.data.${flag}.domain.${className};

public interface I${className}Dao extends IEntityDao<${className}> {
	
	<#list indexAttrs as indexAttr>
	<#if indexAttr.isHasGroupIndex==0 >
	public ${className} selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach);
	<#else>
	public List<${className}> selectEntityBy${indexAttr.name}(<#rt>
		<#list indexAttr.attrs as attr>
		<#lt>${attr.attrTpye} ${attr.attrPName},<#rt>
		</#list>
		<#lt>Object attach) ;
	</#if>
	</#list>
}
