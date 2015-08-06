package com.cwa.tool.component.excel.wrap;

public interface IRow {
	short getLastCellNum();

	ICell getCell(int cellnum);
}
