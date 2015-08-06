/**
 * 
 */
package com.cwa.tool.component.database;

import java.io.File;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cwa.util.FileUtil;

/**
 * @author mali
 * 
 */
public class DatabaseHandler {
	private static final Logger logger = LoggerFactory.getLogger(DatabaseHandler.class);

	private DBOperate dBOperate;

	private String dbScriptPath;

	public void startHandler() {
		// 数据库表创建，插入数据到数据库
		List<String> dropScriptList = FileUtil.readFileContentFromDirectory(dbScriptPath + File.separator + "drop", "sql");
		List<String> createScriptList = FileUtil.readFileContentFromDirectory(dbScriptPath + File.separator + "create", "sql");
		List<String> insertScriptList = FileUtil.readFileContentFromDirectory(dbScriptPath + File.separator + "insert", "sql");
		String str = null;
		try {
			dBOperate.connect();
			dBOperate.executeSql(dropScriptList);
			dBOperate.executeSql(createScriptList);
			for (String insertScript : insertScriptList) {
				logger.info(insertScript);
				str = insertScript;
				dBOperate.executeSql(insertScript);
			}
		} catch (Exception e) {
			logger.error("DatabaseHandler error!  " + str, e);
		} finally {
			try {
				dBOperate.closeConnect();
			} catch (SQLException e) {
			}
		}
	}

	public void setdBOperate(DBOperate dBOperate) {
		this.dBOperate = dBOperate;
	}

	public void setDbScriptPath(String dbScriptPath) {
		this.dbScriptPath = dbScriptPath;
	}
}
