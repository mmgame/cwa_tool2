package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.domain.EntityDBAttr;
import com.cwa.tool.creater.database.domain.EntityIndexAttr;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

/**
 * @author mali
 * 
 */
public class XXXEntityDBCreateScriptPrepareExcel extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		List<EntityDBAttr> list = getEntityDBAttrList(s);

		// 获取索引
		List<EntityIndexAttr> indexList = getEntityIndexAttrList(s);

		int isSingleIndex = 0;
		for (EntityIndexAttr index : indexList) {
			if (index.getIsHasGroupIndex() != 1) {
				isSingleIndex = 1;
				break;
			}
		}

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		// class属性
		root.put("attrs", list);
		// 表名
		root.put("tableName", s.getSheet());

		root.put("indexAttrs", indexList);

		root.put("isSingleIndex", isSingleIndex);

		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "dbscript" + File.separator + "XXXEntityDBCreateScript.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "dbScript" + File.separator + "create";
		FileUtil.createDirectory(path);

		String fileName = structure == null ? "" : getEntityName(s);
		return new File(path + File.separator + StringUtil.upperFirstString(fileName) + ".sql");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
