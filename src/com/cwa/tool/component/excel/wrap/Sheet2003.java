package com.cwa.tool.component.excel.wrap;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;

public class Sheet2003 implements ISheet {
	private HSSFSheet sheet;

	public Sheet2003(HSSFSheet sheet) {
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
		HSSFRow row = sheet.getRow(rownum);
		if (row == null) {
			return null;
		}
		Row2003 row2003 = new Row2003(row);
		return row2003;
	}
}
