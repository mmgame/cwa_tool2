package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;

/**
 * 数据描述层
 * 
 * @author mausmars
 *
 */
public class DataDescLayer extends AbstractLayer {
	private List<String> descs = new ArrayList<String>();// 字段描述信息

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Desc;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("DataDescLayer extract start!");
		// }
		setData(xSheet, startRow, descs);

		// printData(descs);
		// if (logger.isInfoEnabled()) {
		// logger.info("DataDescLayer extract over!");
		// }
	}

	public List<String> getDescs() {
		return descs;
	}

}
