/**
 * 
 */
package com.cwa.tool.creater.database.domain;

/**
 * @author mali
 * 
 */
public class EntityIbatisAttr {
	// 属性名
	private String attrPName;
	// 数据库字段
	private String attrDBName;

	private String attrTpye;

	public String getAttrPName() {
		return attrPName;
	}

	public void setAttrPName(String attrPName) {
		this.attrPName = attrPName;
	}

	public String getAttrDBName() {
		return attrDBName;
	}

	public void setAttrDBName(String attrDBName) {
		this.attrDBName = attrDBName;
	}

	public String getAttrTpye() {
		return attrTpye;
	}

	public void setAttrTpye(String attrTpye) {
		this.attrTpye = attrTpye;
	}
}
