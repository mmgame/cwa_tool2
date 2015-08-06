package com.cwa.tool.component.excel.wrap;

import java.io.IOException;
import java.io.InputStream;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class Workbook2003 implements IWorkbook {
	private HSSFWorkbook xwb;

	@Override
	public void init(InputStream input) throws IOException {
		xwb = new HSSFWorkbook(input);
	}

	@Override
	public int getNumberOfSheets() {
		return xwb.getNumberOfSheets();
	}

	@Override
	public ISheet getSheetAt(int index) {
		HSSFSheet sheet = xwb.getSheetAt(index);
		if (sheet == null) {
			return null;
		}
		Sheet2003 sheet2003 = new Sheet2003(sheet);
		return sheet2003;
	}
}
