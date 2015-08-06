package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

public class XXXEntityDBDropScriptPrepareExcel extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		// 表名
		root.put("tableName", s.getSheet());

		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "dbscript" + File.separator + "XXXEntityDBDropScript.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "dbScript" + File.separator + "drop";
		FileUtil.createDirectory(path);

		String fileName = structure == null ? "" : getEntityName(s);
		return new File(path + File.separator + StringUtil.upperFirstString(fileName) + ".sql");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
