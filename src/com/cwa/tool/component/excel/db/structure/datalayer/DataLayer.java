package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;

public class DataLayer extends AbstractLayer {
	private List<List<String>> datas = new ArrayList<List<String>>();

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Data;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("DataLayer extract start!");
		// }
		int overRow = startRow + rowCount;
		for (int i = startRow; i < overRow; i++) {
			List<String> data = new ArrayList<String>();
			setData(xSheet, i, data);
			datas.add(data);
		}

		// for (List<String> data : datas) {
		// printData(data);
		// }
		// if (logger.isInfoEnabled()) {
		// logger.info("DataLayer extract over!");
		// }
	}

	public List<List<String>> getDatas() {
		return datas;
	}
}
