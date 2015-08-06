package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.domain.EntityClassAttr;
import com.cwa.tool.creater.database.domain.EntityIceAttr;
import com.cwa.tool.creater.database.filecreater.DataBaseStructure;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

public class IceEntityPrepareExcel extends AbstractDBTemplatePrepare {

	@Override
	public Map<String, Object> createMap(IStructure structure) {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		List<EntityIceAttr> entityIceAttrList = new ArrayList<EntityIceAttr>();
		for (IStructure dbStructure : dbs.getStructureList()) {
			IDBTableStructure s = (IDBTableStructure) dbStructure;

			List<EntityClassAttr> list = getEntityClassAttrList(s);
			String className = StringUtil.upperFirstString(getGeneralEntityName(s));
			int isHasList = isHasList(list);
			EntityIceAttr entityIceAttr = new EntityIceAttr(className, isHasList, list);
			entityIceAttrList.add(entityIceAttr);
		}

		Map<String, Object> root = new HashMap<String, Object>();

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		root.put("entityIceAttrList", entityIceAttrList);

		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "ice" + File.separator + "iceEntity.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "ice";
		FileUtil.createDirectory(path);
		return new File(path + File.separator + dbc.getProjectName() + "_" + dbc.getFlag() + ".ice");
	}

	@Override
	public void createEnd(IStructure structure) {

	}

}
