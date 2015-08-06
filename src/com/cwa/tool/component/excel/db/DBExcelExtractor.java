/**
 * 
 */
package com.cwa.tool.component.excel.db;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cwa.tool.component.IExtractor;
import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.structure.DBTableStructure;
import com.cwa.tool.component.excel.wrap.IRow;
import com.cwa.tool.component.excel.wrap.ISheet;
import com.cwa.tool.component.excel.wrap.IWorkbook;

/**
 * @author mali
 * 
 */
public class DBExcelExtractor implements IExtractor {
	private final Logger logger = LoggerFactory.getLogger(IExtractor.class);

	// 目录名
	private String catalogue;
	// 目录开始行
	private int catalogueStartRow;

	private IWorkbook xwb;

	// 这里可能会消耗很多内存。这样做可以减小耦合。
	@Override
	public List<IStructure> extract(String filePath) {
		List<IStructure> structureList = new LinkedList<IStructure>();
		ISheet xSheet = null;
		try {
			FileInputStream input = new FileInputStream(filePath);
			xwb.init(input);

			Map<String, DBTableStructure> sheetMap = new HashMap<String, DBTableStructure>();
			for (int numSheet = 0; numSheet < xwb.getNumberOfSheets(); numSheet++) {
				xSheet = xwb.getSheetAt(numSheet);
				if (xSheet == null) {
					continue;
				}

				// 过滤掉不处理的表
				if (xSheet.getSheetName().equals(catalogue)) {
					catalogue(xSheet, sheetMap);
					continue;
				}

				DBTableStructure tableStructure = sheetMap.get(xSheet.getSheetName());
				if (tableStructure == null) {
					continue;
				}
				tableStructure.layerExtract(xSheet);
				structureList.add(tableStructure);
			}
		} catch (Exception e) {
			logger.error("extract excelSheet is error! sheetName=" + xSheet.getSheetName() + " fileName=" + filePath, e);
		}
		return structureList;
	}

	private void catalogue(ISheet xSheet, Map<String, DBTableStructure> sheetMap) {
		int lastRowNum = xSheet.getLastRowNum();
		for (int i = catalogueStartRow - 1; i <= lastRowNum; i++) {
			IRow row = xSheet.getRow(i);

			DBTableStructure tableStructure = new DBTableStructure();
			tableStructure.init(row);
			sheetMap.put(tableStructure.getSheet(), tableStructure);
		}
	}

	// ----------------------------------
	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public void setCatalogueStartRow(int catalogueStartRow) {
		this.catalogueStartRow = catalogueStartRow;
	}

	public void setXwb(IWorkbook xwb) {
		this.xwb = xwb;
	}
}
