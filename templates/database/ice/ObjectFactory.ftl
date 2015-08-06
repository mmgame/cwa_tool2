package com.cwa.data;

import Ice.Object;
import Ice.ObjectFactory;

<#list classNames as className>
import ${projectName}.data.${flag}.${className?cap_first}General${flag?cap_first};
import com.cwa.data.${flag}.domain.${className?cap_first}${flag?cap_first};
</#list>

/**
 * 对象工厂适配，通过staticId转化对应的类
 * 
 * @author mausmars
 * 
 */
public class ${flag?cap_first}ObjectFactoryAdapter implements ObjectFactory {
	@Override
	public Object create(String type) {
	<#list classNames as className>
		if (type.equals(${className?cap_first}General${flag?cap_first}.ice_staticId())){
			return new ${className?cap_first}${flag?cap_first}();
		}
	</#list>
		return null;
	}

	@Override
	public void destroy() {
	}
}
