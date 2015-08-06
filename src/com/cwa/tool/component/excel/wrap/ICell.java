package com.cwa.tool.component.excel.wrap;

public interface ICell {
	public final static int CELL_TYPE_BOOLEAN = 4;
	public final static int CELL_TYPE_NUMERIC = 0;

	int getCellType();

	boolean getBooleanCellValue();

	double getNumericCellValue();

	String getStringCellValue();

}
