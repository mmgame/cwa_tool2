#define ${projectName?upper_case}_${flag?upper_case}

#ifndef BASE_DAO
#include "common_basedao.ice" 
#endif

#ifndef COMMON_BASETYPE
#include "common_basetype.ice" 
#endif

//实体类
module ${projectName}{
module data{
module ${flag}{
	 
<#list entityIceAttrList as entityIceAttr>  
	class ${entityIceAttr.className} extends baseice::basedao::IEntity {
		<#list entityIceAttr.entityClassAttrs as attr>  
			${attr.attrType?uncap_first} ${attr.attrName};            //${attr.attrDesc}
		</#list>
	 };
</#list> 
};
};
};