package com.cwa.tool.component.excel.wrap;

import java.io.IOException;
import java.io.InputStream;

public interface IWorkbook {
	void init(InputStream input) throws IOException;

	int getNumberOfSheets();

	ISheet getSheetAt(int index);
}
