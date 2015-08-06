package com.cwa.tool.creater.database.domain;

import java.util.List;

public class EntityIceAttr {
	private String className;
	private int isHasList;
	private List<EntityClassAttr> entityClassAttrs;

	public EntityIceAttr(String className, int isHasList, List<EntityClassAttr> entityClassAttrs) {
		this.className = className;
		this.isHasList = isHasList;
		this.entityClassAttrs = entityClassAttrs;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getIsHasList() {
		return isHasList;
	}

	public void setIsHasList(int isHasList) {
		this.isHasList = isHasList;
	}

	public List<EntityClassAttr> getEntityClassAttrs() {
		return entityClassAttrs;
	}

	public void setEntityClassAttrs(List<EntityClassAttr> entityClassAttrs) {
		this.entityClassAttrs = entityClassAttrs;
	}
}
