/**
 * 
 */
package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.Constant;
import com.cwa.tool.creater.database.domain.EntityDBAttr;
import com.cwa.tool.creater.database.domain.EntityIbatisAttr;
import com.cwa.tool.creater.database.domain.EntityIndexAttr;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.FileUtil;

/**
 * @author mali
 * 
 */
public class XXXEntitityIbatisPrepareExcel extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		List<EntityIbatisAttr> list = getEntityIbatisAttr(s);

		// 获取索引
		List<EntityIndexAttr> indexList = getEntityIndexAttrList(s);
		int isSingleIndex = 0;
		for (EntityIndexAttr index : indexList) {
			if (index.getIsHasGroupIndex() != 1) {
				isSingleIndex = 1;
				break;
			}
		}
		List<EntityDBAttr> entityDBAttrList = getEntityDBAttrList(s);

		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		// class属性
		root.put("attrs", list);

		root.put("eattrs", entityDBAttrList);

		// 表名
		root.put("tableName", s.getSheet());
		// 类名
		root.put("className", getEntityName(s));
		// 全类名
		String fullClassName = Constant.getInstance().ENTITYJAVAFILE + File.separator + StringUtil.upperFirstString(getEntityName(s));
		root.put("fullClassName", fullClassName.replace(File.separator, "."));

		root.put("indexAttrs", indexList);

		root.put("isSingleIndex", isSingleIndex);
		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "ibatis" + File.separator + "XXXIbatisConfig.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		IDBTableStructure s = (IDBTableStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) s.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "mybatis" + File.separator + dbc.getFlag() + File.separator + "entity";
		FileUtil.createDirectory(path);

		String fileName = structure == null ? "" : getEntityName(s);
		return new File(path + File.separator + fileName + ".xml");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
