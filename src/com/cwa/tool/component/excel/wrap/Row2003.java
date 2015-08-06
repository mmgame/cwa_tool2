package com.cwa.tool.component.excel.wrap;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;

public class Row2003 implements IRow {
	private HSSFRow row;

	public Row2003(HSSFRow row) {
		this.row = row;
	}

	@Override
	public short getLastCellNum() {
		return row.getLastCellNum();
	}

	@Override
	public ICell getCell(int cellnum) {
		HSSFCell cell = row.getCell(cellnum);
		if (cell == null) {
			return null;
		}
		Cell2003 cell2003 = new Cell2003(cell);
		return cell2003;
	}
}
