package com.cwa.tool.component.excel.wrap;

public interface ISheet {
	String getSheetName();

	IRow getRow(int rownum);

	int getLastRowNum();
}
