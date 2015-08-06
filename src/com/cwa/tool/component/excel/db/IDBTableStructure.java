package com.cwa.tool.component.excel.db;

import com.cwa.tool.component.IContext;
import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.structure.ILayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;

/**
 * 数据库表数据结构
 * 
 * @author mausmars
 *
 */
public interface IDBTableStructure extends IStructure {
	void setContext(IContext context);

	/**
	 * 获取表名
	 * 
	 * @return
	 */
	String getSheet();

	/**
	 * 列数
	 * 
	 * @return
	 */
	int getColumnNum();

	/**
	 * 获取层数据
	 * 
	 * @param layerTypeEnum
	 * @return
	 */
	ILayer getLayer(LayerTypeEnum layerType);

}
