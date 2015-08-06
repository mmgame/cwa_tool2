/**
 * 
 */
package com.cwa.tool.component.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 执行sql
 * 
 * @author mali
 * 
 */
public class DBOperate {
	private static final Logger logger = LoggerFactory.getLogger(DBOperate.class);

	private String jdbcDriver;
	private String jdbcUrl;
	private String jdbcUser;
	private String jdbcPassword;

	private Connection conn;

	public void connect() throws SQLException, ClassNotFoundException {
		Class.forName(jdbcDriver);// 加载驱动
		conn = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);
	}

	public void closeConnect() throws SQLException {
		conn.close();
	}

	public void executeSql(List<String> scripts) throws SQLException {
		for (String script : scripts) {
			conn.setAutoCommit(false);
			Statement st = conn.createStatement();// 创建能够发送命令的对象

			logger.info(script);
			st.addBatch(script);
			// st.execute(script);
			st.executeBatch();
			conn.commit();
			st.close();
		}
	}

	public void executeSql(String script) throws SQLException {
		conn.setAutoCommit(false);
		Statement st = conn.createStatement();// 创建能够发送命令的对象

		st.addBatch(script);
		// st.execute(script);
		st.executeBatch();
		conn.commit();
		st.close();
	}

	// ----------------------------------------------
	public void setJdbcDriver(String jdbcDriver) {
		this.jdbcDriver = jdbcDriver;
	}

	public void setJdbcUrl(String jdbcUrl) {
		this.jdbcUrl = jdbcUrl;
	}

	public void setJdbcUser(String jdbcUser) {
		this.jdbcUser = jdbcUser;
	}

	public void setJdbcPassword(String jdbcPassword) {
		this.jdbcPassword = jdbcPassword;
	}
}
