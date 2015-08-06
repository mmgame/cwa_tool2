package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;

/**
 * 规则层
 * 
 * @author mausmars
 *
 */
public class RuleLayer extends AbstractLayer {
	// 字段使用规则(0都使用 1 服务使用 2客户端使用)
	private List<String> fieldNames = new ArrayList<String>();
	// 是否国际化
	private List<String> internationals = new ArrayList<String>();

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Rule;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("RuleLayer extract start!");
		// }
		setData(xSheet, startRow, fieldNames);
		setData(xSheet, startRow + 1, internationals);

		// printData(fieldNames);
		// printData(internationals);

		// if (logger.isInfoEnabled()) {
		// logger.info("RuleLayer extract over!");
		// }
	}

	public List<String> getFieldNames() {
		return fieldNames;
	}

	public List<String> getInternationals() {
		return internationals;
	}

}
