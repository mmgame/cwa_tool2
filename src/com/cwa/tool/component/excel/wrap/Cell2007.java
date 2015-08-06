package com.cwa.tool.component.excel.wrap;

import org.apache.poi.xssf.usermodel.XSSFCell;

public class Cell2007 implements ICell {
	private XSSFCell cell;

	public Cell2007(XSSFCell cell) {
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
