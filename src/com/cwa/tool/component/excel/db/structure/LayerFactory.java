package com.cwa.tool.component.excel.db.structure;

import com.cwa.tool.component.excel.db.structure.datalayer.ClassFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataBaseFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataDescLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.IndexLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.RuleLayer;

public class LayerFactory {
	public ILayer createLayer(int type, int startRow, int rowCount) {
		AbstractLayer layer = null;
		if (type == LayerTypeEnum.Layer_Desc.getLType()) {
			layer = new DataDescLayer();
		} else if (type == LayerTypeEnum.Layer_Database.getLType()) {
			layer = new DataBaseFieldLayer();
		} else if (type == LayerTypeEnum.Layer_Class.getLType()) {
			layer = new ClassFieldLayer();
		} else if (type == LayerTypeEnum.Layer_Rule.getLType()) {
			layer = new RuleLayer();
		} else if (type == LayerTypeEnum.Layer_Index.getLType()) {
			layer = new IndexLayer();
		} else if (type == LayerTypeEnum.Layer_Data.getLType()) {
			layer = new DataLayer();
		}
		layer.setStartRow(startRow);
		layer.setRowCount(rowCount);
		return layer;
	}
}
