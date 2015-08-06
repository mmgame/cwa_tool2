/**
 * 
 */
package com.cwa.tool.creater.database.domain;

/**
 * 类属性
 * 
 * @author mausmars
 *
 */
public class EntityClassAttr {
	private String attrName;// 属性名
	private String attrType;// 属性类型
	private String attrDesc;// 属相描述

	private int isCollection = 0;// 是否是集合类型
	private String collectionType; // 集合类型List
	private String collectionInitType;// 集合初始化类型如"ArrayList" 或"HashSet"
	private String collectionSuffix;// 后缀<XXX>

	public String getAttrName() {
		return attrName;
	}

	public void setAttrName(String attrName) {
		this.attrName = attrName;
	}

	public String getAttrType() {
		return attrType;
	}

	public void setAttrType(String attrType) {
		this.attrType = attrType;
	}

	public String getAttrDesc() {
		return attrDesc;
	}

	public void setAttrDesc(String attrDesc) {
		this.attrDesc = attrDesc;
	}

	public int getIsCollection() {
		return isCollection;
	}

	public void setIsCollection(int isCollection) {
		this.isCollection = isCollection;
	}

	public String getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(String collectionType) {
		this.collectionType = collectionType;
	}

	public String getCollectionInitType() {
		return collectionInitType;
	}

	public void setCollectionInitType(String collectionInitType) {
		this.collectionInitType = collectionInitType;
	}

	public String getCollectionSuffix() {
		return collectionSuffix;
	}

	public void setCollectionSuffix(String collectionSuffix) {
		this.collectionSuffix = collectionSuffix;
	}
}
