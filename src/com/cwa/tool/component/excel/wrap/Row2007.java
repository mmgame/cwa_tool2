package com.cwa.tool.component.excel.wrap;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;

public class Row2007 implements IRow {
	private XSSFRow row;

	public Row2007(XSSFRow row) {
		this.row = row;
	}

	@Override
	public short getLastCellNum() {
		return row.getLastCellNum();
	}

	@Override
	public ICell getCell(int cellnum) {
		XSSFCell cell = row.getCell(cellnum);
		if (cell == null) {
			return null;
		}
		Cell2007 cell2007 = new Cell2007(cell);
		return cell2007;
	}
}
