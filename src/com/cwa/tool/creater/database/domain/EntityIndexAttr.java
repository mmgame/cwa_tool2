package com.cwa.tool.creater.database.domain;

import java.util.LinkedList;
import java.util.List;

import com.cwa.tool.util.StringUtil;

public class EntityIndexAttr {
	private String name;
	private List<EntityIbatisAttr> attrs;
	private int isHasGroupIndex;
	private int isHasOwnerIndex;
	private String ownerIndexName;
	private String ownerIndexType;
	
	public EntityIndexAttr() {
		attrs = new LinkedList<EntityIbatisAttr>();
	}

	public List<EntityIbatisAttr> getAttrs() {
		return attrs;
	}

	public String getName() {
		return name;
	}

	public int getIsHasGroupIndex() {
		return isHasGroupIndex;
	}

	public void setIsHasGroupIndex(int isHasGroupIndex) {
		this.isHasGroupIndex = isHasGroupIndex;
	}

	public void addAttr(EntityIbatisAttr attr) {
		this.attrs.add(attr);
		if (name == null) {
			name = StringUtil.upperFirstString(attr.getAttrPName());
		} else {
			name += "And" + StringUtil.upperFirstString(attr.getAttrPName());
		}
	}

	public void setIsHasOwnerIndex(int isHasOwnerIndex) {
		this.isHasOwnerIndex = isHasOwnerIndex;
	}

	public void setOwnerIndexName(String ownerIndexName) {
		this.ownerIndexName = ownerIndexName;
	}

	public int getIsHasOwnerIndex() {
		return isHasOwnerIndex;
	}

	public String getOwnerIndexName() {
		return ownerIndexName;
	}

	public String getOwnerIndexType() {
		return ownerIndexType;
	}

	public void setOwnerIndexType(String ownerIndexType) {
		this.ownerIndexType = ownerIndexType;
	}
}
