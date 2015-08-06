package com.cwa.tool.creater.database.domain;

public class DaoConfig {
	private String daoClassName;
	private String daoGeneralClassName;
	private String entityName;

	public String getDaoClassName() {
		return daoClassName;
	}

	public void setDaoClassName(String daoClassName) {
		this.daoClassName = daoClassName;
	}

	public String getDaoGeneralClassName() {
		return daoGeneralClassName;
	}

	public void setDaoGeneralClassName(String daoGeneralClassName) {
		this.daoGeneralClassName = daoGeneralClassName;
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

}
