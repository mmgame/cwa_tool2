/**
 * 
 */
package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.db.structure.datalayer.ClassFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataBaseFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataLayer;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.domain.EntityValue;
import com.cwa.tool.creater.database.domain.EntityValueAttr;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

/**
 * 数据库脚本：插入
 * 
 * @author mali
 * 
 */
public class XXXEntityDBInsertScriptPrepareExcel extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		DataLayer dataLayer = (DataLayer) s.getLayer(LayerTypeEnum.Layer_Data);
		List<List<String>> datasList = dataLayer.getDatas();
		if (datasList.isEmpty()) {
			return root;
		} else {
			boolean isEmpty = true;
			for (List<String> datas : datasList) {
				if (!datas.isEmpty()) {
					isEmpty = false;
					break;
				}
			}
			if (isEmpty) {
				return root;
			}
		}

		List<String> list = new LinkedList<String>();
		for (int i = 0; i < s.getColumnNum(); i++) {
			DataBaseFieldLayer dataBaseFieldLayer = (DataBaseFieldLayer) s.getLayer(LayerTypeEnum.Layer_Database);
			String attrName = dataBaseFieldLayer.getFieldNames().get(i);
			// String attrTpyte =
			// excelStructure.getHead(StructureTypeExcel.DBAT_TRIBUTETYPES).get(i);
			// String attrDesc =
			// excelStructure.getHead(StructureTypeExcel.DESCS).get(i);
			list.add(attrName);
		}

		List<EntityValueAttr> entityValueAttrList = new ArrayList<EntityValueAttr>(datasList.size());
		for (List<String> datas : datasList) {
			EntityValueAttr entityValueAttr = new EntityValueAttr();
			for (int i = 0; i < s.getColumnNum(); i++) {
				ClassFieldLayer classFieldLayer = (ClassFieldLayer) s.getLayer(LayerTypeEnum.Layer_Class);
				String attrTpyte = classFieldLayer.getFieldTypes().get(i);
				EntityValue value = new EntityValue();
				value.setValue(datas.get(i));
				if (attrTpyte.contains("String") || attrTpyte.contains("List")) {
					value.setIsString(1);
				}
				entityValueAttr.addValue(value);
			}
			entityValueAttrList.add(entityValueAttr);
		}

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		// class属性
		root.put("attrNames", list);
		// 表名
		root.put("tableName", s.getSheet());
		// 数据
		root.put("rows", entityValueAttrList);
		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "dbscript" + File.separator + "XXXEntityDBInsertScript.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "dbScript" + File.separator + "Insert";
		FileUtil.createDirectory(path);

		String fileName = structure == null ? "" : getEntityName(s);
		return new File(path + File.separator + StringUtil.upperFirstString(fileName) + ".sql");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
