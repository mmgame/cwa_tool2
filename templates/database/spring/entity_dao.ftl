<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">


    <bean id="singleThreadEngine" class="java.util.concurrent.Executors" factory-method="newSingleThreadExecutor" />
	<!-- 引擎初始化 -->
	<!-- 1、立即执行 -->
	<!-- <bean id="asyncOperatePool" class="com.cwa.component.data.operate.pool.AsyncImmediatelyOperatePool"> -->
	<!-- <property name="executor" ref="singleThreadEngine" /> -->
	<!-- </bean> -->
	<!--2、次数执行 -->
	<!-- <bean id="asyncOperatePool" class="com.cwa.data.operate.pool.AsyncCountOperatePool"> -->
	<!-- <property name="executor" ref="singleThreadEngine" /> -->
	<!-- <property name="expectCount" value="3" /> -->
	<!-- </bean> -->
	<!--3、定时执行 -->
	<bean id="asyncOperatePool" class="com.cwa.component.data.operate.pool.AsyncTimingOperaterPool">
		<constructor-arg index="0" value="asyncOperatePool" />
		<property name="executor" ref="singleThreadEngine" />
	</bean>
	<!--4、同步执行 -->
    <bean id="syncOperatePool" class="com.cwa.component.data.operate.pool.SyncOperatePool" />
	
	<bean id="daoOperateFactory" class="com.cwa.component.data.operate.DaoOperateFactory" />

    <!-- GeneralDao -->
	<#list daoInfos as daoInfo>
	<bean id="${daoInfo.daoGeneralClassName?uncap_first}" class="com.cwa.data.${flag}.general.${daoInfo.daoGeneralClassName?cap_first}" />
	</#list>


    <!-- Dao -->
	<#list daoInfos as daoInfo>
	<bean id="${daoInfo.daoClassName?uncap_first}" class="com.cwa.data.${flag}.spread.${daoInfo.daoClassName?cap_first}" >
		<property name="dao" ref="${daoInfo.daoGeneralClassName?uncap_first}" />
		<property name="operatePool" ref="syncOperatePool" />
		<property name="daoOperateFactory" ref="daoOperateFactory" />
	</bean>	
	</#list>
	
    <!-- daoservice -->	
	
	<bean id="${flag}DaoMap" class="java.util.HashMap">
		<constructor-arg>
			<map>
			<#list daoInfos as daoInfo>
				<entry key="${daoInfo.entityName?cap_first}" value-ref="${daoInfo.daoClassName?uncap_first}" />
			</#list>
			</map>
		</constructor-arg>
	</bean>
</beans>