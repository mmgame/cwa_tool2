/**
 * 
 */
package com.cwa.tool.creater.database.prepare;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.filecreater.DataBaseStructure;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.util.FileUtil;

/**
 * @author mali
 * 
 */
public class SqlMapConfigPrepare extends AbstractDBTemplatePrepare {

	@Override
	public Map<String, Object> createMap(IStructure structure) {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "mybatis" + File.separator + dbc.getFlag() + File.separator + "entity";

		File ibatisFilePath = new File(path);

		Map<String, Object> root = new HashMap<String, Object>();

		List<String> list = new LinkedList<String>();
		File[] files = ibatisFilePath.listFiles();
		if (files == null) {
			return null;
		}
		for (File file : files) {
			if (file.getName().contains("-rule")) {
				continue;
			}
			// 模板里配置的路径
			String fileName = "mybatis/" + dbc.getFlag() + "/entity/" + file.getName();
			list.add(fileName);
		}
		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		root.put("filePaths", list);
		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "ibatis" + File.separator + "sqlmap-config.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "mybatis" + File.separator + dbc.getFlag();
		FileUtil.createDirectory(path);
		return new File(path + File.separator + "sqlmap-config.xml");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
