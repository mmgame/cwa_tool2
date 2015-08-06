insert into `${tableNumber}_${tableName?lower_case}` 
(<#rt> 
<#list attrNames as attrName>
	<#lt>`${attrName}`<#if attrName_has_next>,</#if><#rt> 
</#list>
)
VALUES
<#list rows as row>
(<#rt> 
<#list row.attrValues as attrValue>
	<#if attrValue.isString==1>
		<#lt>'${attrValue.value}'<#if attrValue_has_next>,</#if><#rt>
	 <#else>
		<#lt>${attrValue.value}<#if attrValue_has_next>,</#if><#rt>
	</#if>
</#list>
<#lt>)<#if row_has_next>,</#if>
</#list>
