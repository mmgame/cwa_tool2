CREATE TABLE `${tableNumber}_${tableName}` (
<#list attrs as attr>
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
