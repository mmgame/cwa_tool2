package com.cwa.tool.component.excel.wrap;

import org.apache.poi.hssf.usermodel.HSSFCell;

public class Cell2003 implements ICell {
	private HSSFCell cell;

	public Cell2003(HSSFCell cell) {
		this.cell = cell;
	}

	@Override
	public int getCellType() {
		return cell.getCellType();
	}

	@Override
	public boolean getBooleanCellValue() {
		return cell.getBooleanCellValue();
	}

	@Override
	public double getNumericCellValue() {
		return cell.getNumericCellValue();
	}

	@Override
	public String getStringCellValue() {
		return cell.getStringCellValue();
	}
}
