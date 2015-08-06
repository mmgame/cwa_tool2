package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;

/**
 * 数据库字段类型层
 * 
 * @author mausmars
 *
 */
public class DataBaseFieldLayer extends AbstractLayer {
	private List<String> fieldNames = new ArrayList<String>();// 字段名
	private List<String> fieldTypes = new ArrayList<String>();// 字段类型

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Database;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("DataBaseFieldLayer extract start!");
		// }
		setData(xSheet, startRow, fieldNames);
		setData(xSheet, startRow + 1, fieldTypes);

		// printData(fieldNames);
		// printData(fieldTypes);
		// if (logger.isInfoEnabled()) {
		// logger.info("DataBaseFieldLayer extract over!");
		// }
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public List<String> getFieldTypes() {
		return fieldTypes;
	}

}
