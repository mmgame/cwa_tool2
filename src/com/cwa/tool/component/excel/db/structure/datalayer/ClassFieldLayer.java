package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;
import com.cwa.util.CollectionType;

/**
 * 类字段类型层
 * 
 * @author mausmars
 *
 */
public class ClassFieldLayer extends AbstractLayer {
	private List<String> fieldNames = new ArrayList<String>();// 字段名
	private List<String> fieldTypes = new ArrayList<String>();// 字段类型
	private List<String> collectionTypes = new ArrayList<String>();// 集合类型

	private List<CollectionType> collectionTypeList = new ArrayList<CollectionType>();// 集合类型

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Class;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("ClassFieldLayer extract start!");
		// }
		setData(xSheet, startRow, fieldNames);
		setData(xSheet, startRow + 1, fieldTypes);
		setData(xSheet, startRow + 2, collectionTypes);
		// printData(fieldNames);
		// printData(fieldTypes);
		// printData(collectionTypes);

		for (String ct : collectionTypes) {
			if (ct == null || ct.isEmpty() || ct.equals("null")) {
				collectionTypeList.add(null);
			} else {
				collectionTypeList.add(CollectionType.getCollectionType(ct));
			}
		}
		// if (logger.isInfoEnabled()) {
		// logger.info("ClassFieldLayer extract over!");
		// }
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public List<String> getFieldTypes() {
		return fieldTypes;
	}

	public CollectionType getCollectionType(int index) {
		if (index > collectionTypeList.size() - 1) {
			return null;
		}
		return collectionTypeList.get(index);
	}

	public List<String> getCollectionTypes() {
		return collectionTypes;
	}
}
