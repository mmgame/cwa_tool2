/**
 * 
 */
package com.cwa.tool.creater.database.domain;

/**
 * @author mali
 * 
 */
public class EntityDBAttr {
	// 属性名
	private String attrName;
	// 属性类型
	private String attrType;
	// 属相描述
	private String attrDesc;

	private String attrLimit;

	public String getAttrName() {
		return attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public String getAttrDesc() {
		return attrDesc;
	}

	public String getAttrLimit() {
		return attrLimit;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public void setAttrLimit(String attrLimit) {
		this.attrLimit = attrLimit;
	}
}
