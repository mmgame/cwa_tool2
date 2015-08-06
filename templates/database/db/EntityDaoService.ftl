package com.cwa.data.${flag}.service;

<#list daos as dao>
import com.cwa.data.${flag}.I${dao?cap_first}Dao;
</#list>

public class EntityDaoService {


	<#list daos as dao>
	private I${dao?cap_first}Dao ${dao?uncap_first}Dao;
	</#list>

	<#list daos as dao>
	public I${dao?cap_first}Dao get${dao?cap_first}Dao() {
	     return ${dao?uncap_first}Dao;
	}
	
	</#list>
	
	//-----------------------------------------------------
	<#list daos as dao>
	public void set${dao?cap_first}Dao(I${dao?cap_first}Dao ${dao?uncap_first}Dao) {
		 this.${dao?uncap_first}Dao = ${dao?uncap_first}Dao;
	}
	
	</#list>
}