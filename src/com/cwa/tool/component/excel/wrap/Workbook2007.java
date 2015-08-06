package com.cwa.tool.component.excel.wrap;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Workbook2007 implements IWorkbook {
	private XSSFWorkbook xwb;

	@Override
	public void init(InputStream input) throws IOException {
		xwb = new XSSFWorkbook(input);
	}

	@Override
	public int getNumberOfSheets() {
		return xwb.getNumberOfSheets();
	}

	@Override
	public ISheet getSheetAt(int index) {
		XSSFSheet sheet = xwb.getSheetAt(index);
		if (sheet == null) {
			return null;
		}
		Sheet2007 sheet2007 = new Sheet2007(sheet);
		return sheet2007;
	}
}
