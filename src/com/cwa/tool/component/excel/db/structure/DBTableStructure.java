package com.cwa.tool.component.excel.db.structure;

import java.util.HashMap;
import java.util.Map;

import com.cwa.tool.component.IContext;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.component.excel.wrap.IRow;
import com.cwa.tool.component.excel.wrap.ISheet;
import com.cwa.tool.util.StringUtil;

/**
 * 表信息
 * 
 * @author mausmars
 *
 */
public class DBTableStructure implements IDBTableStructure {
	private String sheet;// 标签名
	private int startColumn;// 开始列
	private int overColumn;// 结束列

	private LayerFactory layerFactory = new LayerFactory();
	private Map<Integer, ILayer> layerMap = new HashMap<Integer, ILayer>();// 表层

	private IContext context;

	public void init(IRow row) {
		sheet = row.getCell(0).getStringCellValue();
		startColumn = StringUtil.getColumn(row.getCell(1).getStringCellValue());
		overColumn = StringUtil.getColumn(row.getCell(2).getStringCellValue());

		int startRow = (int) row.getCell(3).getNumericCellValue() - 1;
		int dataStartRow = (int) row.getCell(4).getNumericCellValue() - 1;
		int endRow = (int) row.getCell(5).getNumericCellValue() - 1;

		for (LayerTypeEnum layerType : LayerTypeEnum.values()) {
			int rowCount = layerType.getCount();
			if (rowCount == -1) {
				if (layerType == LayerTypeEnum.Layer_Index) {
					rowCount = dataStartRow - startRow;
				} else if (layerType == LayerTypeEnum.Layer_Data) {
					rowCount = endRow - startRow + 1;
				}
			}
			ILayer layer = layerFactory.createLayer(layerType.getLType(), startRow, rowCount);
			layerMap.put(layer.getLayerType().getLType(), layer);
			startRow += rowCount;// 增加行数
		}
	}

	public void layerExtract(ISheet xSheet) {
		for (ILayer layer : layerMap.values()) {
			layer.extract(xSheet);
		}
	}

	@Override
	public ILayer getLayer(LayerTypeEnum layerTypeEnum) {
		return layerMap.get(layerTypeEnum.getLType());
	}

	@Override
	public String getSheet() {
		return sheet;
	}

	@Override
	public int getColumnNum() {
		return overColumn - startColumn + 1;
	}

	public int getStartColumn() {
		return startColumn;
	}

	public int getOverColumn() {
		return overColumn;
	}

	@Override
	public IContext getContext() {
		return context;
	}

	@Override
	public void setContext(IContext context) {
		this.context = context;
	}
}