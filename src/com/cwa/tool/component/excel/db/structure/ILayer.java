package com.cwa.tool.component.excel.db.structure;

import com.cwa.tool.component.excel.wrap.ISheet;

public interface ILayer {
	void extract(ISheet xSheet);

	/**
	 * 层类型
	 * 
	 * @return
	 */
	LayerTypeEnum getLayerType();

	/**
	 * 开始行
	 * 
	 * @return
	 */
	int getStartRow();

	/**
	 * 行数
	 * 
	 * @return
	 */
	int getRowCount();
}
