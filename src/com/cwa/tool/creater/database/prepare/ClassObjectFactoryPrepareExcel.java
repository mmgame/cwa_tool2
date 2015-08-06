package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.filecreater.DataBaseStructure;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

public class ClassObjectFactoryPrepareExcel extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		List<String> classNames = new LinkedList<String>();
		for (IStructure dbStructure : dbs.getStructureList()) {
			IDBTableStructure s = (IDBTableStructure) dbStructure;
			classNames.add(s.getSheet());
		}

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());

		root.put("classNames", classNames);

		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "ice" + File.separator + "ObjectFactory.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "ice";
		FileUtil.createDirectory(path);
		return new File(path + File.separator + StringUtil.upperFirstString(dbc.getFlag()) + "ObjectFactoryAdapter.java");
	}

	@Override
	public void createEnd(IStructure structure) {

	}

}
