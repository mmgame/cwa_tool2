package com.cwa.tool.component.excel.db.structure.datalayer;

import java.util.ArrayList;
import java.util.List;

import com.cwa.tool.component.excel.db.structure.AbstractLayer;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.wrap.ISheet;

/**
 * 索引层
 * 
 * @author mausmars
 *
 */
public class IndexLayer extends AbstractLayer {
	private List<List<String>> indexs = new ArrayList<List<String>>();

	@Override
	public LayerTypeEnum getLayerType() {
		return LayerTypeEnum.Layer_Index;
	}

	@Override
	public void extract(ISheet xSheet) {
		// if (logger.isInfoEnabled()) {
		// logger.info("IndexLayer extract start!");
		// }
		int overRow = startRow + rowCount;
		for (int i = startRow; i < overRow; i++) {
			List<String> index = new ArrayList<String>();
			setData(xSheet, i, index);
			indexs.add(index);
		}

		// for (List<String> data : indexs) {
		// printData(data);
		// }
		// if (logger.isInfoEnabled()) {
		// logger.info("IndexLayer extract over!");
		// }
	}

	public List<List<String>> getIndexs() {
		return indexs;
	}

}
