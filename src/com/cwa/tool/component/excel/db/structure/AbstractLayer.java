package com.cwa.tool.component.excel.db.structure;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cwa.tool.component.excel.wrap.ICell;
import com.cwa.tool.component.excel.wrap.IRow;
import com.cwa.tool.component.excel.wrap.ISheet;

public abstract class AbstractLayer implements ILayer {
	protected final Logger logger = LoggerFactory.getLogger(ILayer.class);

	protected int startRow;
	protected int rowCount;

	public int getStartRow() {
		return startRow;
	}

	public int getRowCount() {
		return rowCount;
	}

	protected void printData(List<String> datas) {
		StringBuilder sb = new StringBuilder();
		for (String data : datas) {
			sb.append(data);
			sb.append(",");
		}
		if (logger.isInfoEnabled()) {
			logger.info(sb.toString());
		}
	}

	protected void setData(ISheet xSheet, int index, List<String> list) {
		IRow xRow = xSheet.getRow(index);
		if (xRow == null) {
			return;
		}
		for (int j = 0; j <= xRow.getLastCellNum(); j++) {
			ICell xCell = xRow.getCell(j);

			if (xCell == null) {
				list.add("");
				continue;
			}
			if (xCell.getCellType() == ICell.CELL_TYPE_BOOLEAN) {
				list.add(xCell.getBooleanCellValue() + "");
			} else if (xCell.getCellType() == ICell.CELL_TYPE_NUMERIC) {
				list.add((int) xCell.getNumericCellValue() + "");
			} else {
				list.add(xCell.getStringCellValue());
			}
		}
	}

	public void setStartRow(int startRow) {
		this.startRow = startRow;
	}

	public void setRowCount(int rowCount) {
		this.rowCount = rowCount;
	}
}
