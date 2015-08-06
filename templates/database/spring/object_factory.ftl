<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<!-- ice对象工厂，这里可以继承ObjectFactoryAdapter自己实现工厂 -->
	<bean id="${flag}ObjectFactory" class="com.cwa.data.${flag?cap_first}ObjectFactoryAdapter" />
	
	<bean id="objectFactoryMap" class="java.util.HashMap">
		<constructor-arg>
			<map>
				<#list classNames as className>
				<entry key="::${projectName}::data::${flag}::${className?cap_first}General${flag?cap_first}" value-ref="${flag}ObjectFactory" /> 
				</#list>
			</map>
		</constructor-arg>
	</bean>
</beans>
	