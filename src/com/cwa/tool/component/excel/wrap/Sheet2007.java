package com.cwa.tool.component.excel.wrap;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;

public class Sheet2007 implements ISheet {
	private XSSFSheet sheet;

	public Sheet2007(XSSFSheet sheet) {
		this.sheet = sheet;
	}

	@Override
	public String getSheetName() {
		return sheet.getSheetName();
	}

	@Override
	public int getLastRowNum() {
		return sheet.getLastRowNum();
	}

	@Override
	public IRow getRow(int rownum) {
		XSSFRow row = sheet.getRow(rownum);
		if (row == null) {
			return null;
		}
		Row2007 row2007 = new Row2007(row);
		return row2007;
	}

}
