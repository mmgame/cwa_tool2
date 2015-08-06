package com.cwa.tool.creater.database.filecreater;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

import com.cwa.tool.component.IStructure;
import com.cwa.tool.component.database.DBOperate;
import com.cwa.tool.component.database.DatabaseHandler;
import com.cwa.tool.component.excel.db.DBExcelExtractor;
import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.component.excel.wrap.Workbook2003;
import com.cwa.tool.component.excel.wrap.Workbook2007;
import com.cwa.tool.creater.AbstractFileCreater;
import com.cwa.tool.creater.ITemplatePrepare;
import com.cwa.tool.creater.database.prepare.ClassObjectFactoryPrepareExcel;
import com.cwa.tool.creater.database.prepare.EntityDaoConfigPrepare;
import com.cwa.tool.creater.database.prepare.IceConfigObjectFactoryPrepareExcel;
import com.cwa.tool.creater.database.prepare.IceEntityPrepareExcel;
import com.cwa.tool.creater.database.prepare.SqlMapConfigPrepare;
import com.cwa.tool.creater.database.prepare.XXXEntitityIbatisPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXEntityDBCreateScriptPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXEntityDBDropScriptPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXEntityDBInsertScriptPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXEntityWrapPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXIceEntityDaoPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXIceEntityGeneralDaoPrepareExcel;
import com.cwa.tool.creater.database.prepare.XXXIceEntityInterfacePrepareExcel;
import com.cwa.util.FileUtil;

/**
 * 数据库相关文件创建
 * 
 * @author mausmars
 *
 */
public class DataBaseFileCreater extends AbstractFileCreater implements IDataBaseContext {
	private String flag;// 标示,Entity,Prototype,Config
	private String projectName;// 项目名
	private String tableNumber;// 表num
	private String dbScriptPath;// sql脚本文件路径

	private String catalogue;
	private int catalogueStartRow;

	private DBOperate dbOperate = new DBOperate();

	private List<ITemplatePrepare> wholeTemplatePrepareList;// 整体
	private List<ITemplatePrepare> singleTemplatePrepareList;// 单个

	public DataBaseFileCreater() {
		init();
	}

	private void init() {
		wholeTemplatePrepareList = new LinkedList<ITemplatePrepare>();
		wholeTemplatePrepareList.add(new EntityDaoConfigPrepare());
		wholeTemplatePrepareList.add(new IceEntityPrepareExcel());
		wholeTemplatePrepareList.add(new SqlMapConfigPrepare());
		wholeTemplatePrepareList.add(new ClassObjectFactoryPrepareExcel());
		wholeTemplatePrepareList.add(new IceConfigObjectFactoryPrepareExcel());
		
		singleTemplatePrepareList = new LinkedList<ITemplatePrepare>();
		singleTemplatePrepareList.add(new XXXEntitityIbatisPrepareExcel());
		singleTemplatePrepareList.add(new XXXEntityDBCreateScriptPrepareExcel());
		singleTemplatePrepareList.add(new XXXEntityDBDropScriptPrepareExcel());
		singleTemplatePrepareList.add(new XXXEntityDBInsertScriptPrepareExcel());
		singleTemplatePrepareList.add(new XXXEntityWrapPrepareExcel());
		singleTemplatePrepareList.add(new XXXIceEntityDaoPrepareExcel());
		singleTemplatePrepareList.add(new XXXIceEntityGeneralDaoPrepareExcel());
		singleTemplatePrepareList.add(new XXXIceEntityInterfacePrepareExcel());
	}

	@Override
	public void createFile() {
		logger.info("DataBaseFile create start!");
		dbScriptPath = createFilePath + File.separator + "dbScript";

		removeOldFile();
		createDBFile();
		operationDB();
	}

	private void removeOldFile() {
		logger.info("start delete old file!");
		// 删除文件
		FileUtil.removeAllFileFromDirectory(createFilePath);
		logger.info("end delete old file!");
	}

	private void createDBFile() {
		DataBaseStructure bataBaseStructure = new DataBaseStructure(this);
		// 全部表数据
		File file = new File(resourcePath);
		if (!file.isDirectory()) {
			return;
		}
		String[] fileNames = file.list();
		for (String fileName : fileNames) {
			String[] filenameStrs = fileName.split("\\.");
			if (filenameStrs.length <= 0) {
				continue;
			}
			String postfix = filenameStrs[filenameStrs.length - 1];
			DBExcelExtractor dbExcelExtractor = new DBExcelExtractor();
			dbExcelExtractor.setCatalogue(catalogue);
			dbExcelExtractor.setCatalogueStartRow(catalogueStartRow);
			if (postfix.equals("xlsx")) {
				dbExcelExtractor.setXwb(new Workbook2007());
			} else if (postfix.equals("xls")) {
				dbExcelExtractor.setXwb(new Workbook2003());
			} else {
				continue;
			}
			// 加入每个配置文件解析出的数据
			bataBaseStructure.addStructures(dbExcelExtractor.extract(resourcePath + FileUtil.separator + fileName));
		}
		try {
			for (ITemplatePrepare singleTemplatePrepare : singleTemplatePrepareList) {
				for (IStructure s : bataBaseStructure.getStructureList()) {
					IDBTableStructure dbs = (IDBTableStructure) s;
					dbs.setContext(this);
					createFile(singleTemplatePrepare, s);
				}
			}
			for (ITemplatePrepare wholeTemplatePrepare : wholeTemplatePrepareList) {
				createFile(wholeTemplatePrepare, bataBaseStructure);
			}
		} catch (Exception e) {
			logger.error("", e);
			return;
		}
	}

	private void operationDB() {
		DatabaseHandler databaseHandler = new DatabaseHandler();
		databaseHandler.setdBOperate(dbOperate);
		databaseHandler.setDbScriptPath(dbScriptPath);
		databaseHandler.startHandler();
	}

	@Override
	public String getFlag() {
		return flag;
	}

	@Override
	public String getProjectName() {
		return projectName;
	}

	public String getTemplatesPath() {
		return templatesPath;
	}

	public String getResourcePath() {
		return resourcePath;
	}

	public String getCreateFilePath() {
		return createFilePath;
	}

	public String getDbScriptPath() {
		return dbScriptPath;
	}

	// ---------------------------------
	public void setJdbcDriver(String jdbcDriver) {
		dbOperate.setJdbcDriver(jdbcDriver);
	}

	public void setJdbcUser(String jdbcUser) {
		dbOperate.setJdbcUser(jdbcUser);
	}

	public void setJdbcPassword(String jdbcPassword) {
		dbOperate.setJdbcPassword(jdbcPassword);
	}

	public void setJdbcUrl(String jdbcUrl) {
		dbOperate.setJdbcUrl(jdbcUrl);
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public void setCatalogueStartRow(int catalogueStartRow) {
		this.catalogueStartRow = catalogueStartRow;
	}

	public void setFlag(String flag) {
		this.flag = flag;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getTableNumber() {
		return tableNumber;
	}

	public void setTableNumber(String tableNumber) {
		this.tableNumber = tableNumber;
	}
}
