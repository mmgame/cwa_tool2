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
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.creater.database.AbstractDBTemplatePrepare;
import com.cwa.tool.creater.database.Constant;
import com.cwa.tool.creater.database.domain.DaoConfig;
import com.cwa.tool.creater.database.filecreater.DataBaseStructure;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.util.FileUtil;

/**
 * @author mali
 * 
 */
public class EntityDaoConfigPrepare extends AbstractDBTemplatePrepare {
	@Override
	public Map<String, Object> createMap(IStructure structure) {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		Map<String, Object> root = new HashMap<String, Object>();

		List<DaoConfig> list = new LinkedList<DaoConfig>();
		for (IStructure dbStructure : dbs.getStructureList()) {
			IDBTableStructure s = (IDBTableStructure) dbStructure;

			String name = getEntityName(s);
			DaoConfig daoConfig = new DaoConfig();
			daoConfig.setEntityName(name);
			daoConfig.setDaoClassName(daoConfig.getEntityName() + "Dao");
			daoConfig.setDaoGeneralClassName(daoConfig.getEntityName() + "GeneralDao");
			list.add(daoConfig);
		}
		root.put("flag", dbc.getFlag());
		root.put("projectName", dbc.getProjectName());
		root.put("tableNumber", dbc.getTableNumber());
		
		root.put("daoInfos", list);
		root.put("daoPath", Constant.getInstance().ENTITYDAOJAVAFILE.replace(File.separator, "."));
		root.put("daoSpreadGeneralPath", Constant.getInstance().ENTITYSPREADDAOJAVAFILE.replace(File.separator, "."));
		root.put("daoServicePath", Constant.getInstance().ENTITYDAOSERVICE_PATH.replace(File.separator, "."));
		return root;
	}

	@Override
	public String getFtlFilePath(IStructure structure) {
		return "spring" + File.separator + "entity_dao.ftl";
	}

	@Override
	public File getFile(IStructure structure) throws Exception {
		DataBaseStructure dbs = (DataBaseStructure) structure;
		IDataBaseContext dbc = (IDataBaseContext) dbs.getContext();

		String path = dbc.getCreateFilePath() + File.separator + "spring";
		FileUtil.createDirectory(path);
		return new File(path + File.separator + dbc.getFlag() + "_dao.xml");
	}

	@Override
	public void createEnd(IStructure structure) {

	}
}
