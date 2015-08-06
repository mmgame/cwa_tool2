package com.cwa.tool.creater.database;

import java.io.File;

import com.cwa.util.FileUtil;

public class Constant {
	private String separator = File.separator;

	public static Constant instance;

	public void init() {
		instance = this;
	}

	public static Constant getInstance() {
		return instance;
	}

	public Constant(String gameName, String createFilePath) {
		ENTITYJAVAFILE = "com" + separator + "cwa" + separator + gameName + separator + "db" + separator + "entity" + separator + "domain";
		ENTITYGENERALJAVAFILE = ENTITYJAVAFILE + separator + "general";
		ENTITYDAOJAVAFILE = "com" + separator + "cwa" + separator + gameName + separator + "db" + separator + "entity" + separator + "dao";
		SERVER_ENTITYJAVE_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + "server" + separator + ENTITYJAVAFILE;
		SERVER_ENTITYGENERALJAVE_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + "server" + separator + ENTITYJAVAFILE + separator + "general";
		SERVER_ENTITYJAVEDAO_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + "server" + separator + ENTITYDAOJAVAFILE;

		ENTITYGENERALDAOJAVAFILE = ENTITYDAOJAVAFILE + separator + "general";
		ENTITYSPREADDAOJAVAFILE = ENTITYDAOJAVAFILE + separator + "spread";
		SERVER_ENTITYJAVEGENERALDAO_PATH = SERVER_ENTITYJAVEDAO_PATH + separator + "general";
		SERVER_ENTITYJAVESPREADDAO_PATH = SERVER_ENTITYJAVEDAO_PATH + separator + "spread";

		CACHEENTITYGENERALDAOJAVAFILE = ENTITYDAOJAVAFILE + separator + "cache";
		SERVER_CACHEENTITYJAVEGENERALDAO_PATH = SERVER_ENTITYJAVEDAO_PATH + separator + "cache";
		// ------------------------------------------------------------
		DBSCRIPT_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + "dbScript";

		DBSCRIPT_DROP_PATH = DBSCRIPT_PATH + separator + "drop";
		DBSCRIPT_CREATE_PATH = DBSCRIPT_PATH + separator + "create";
		DBSCRIPT_INSERT_PATH = DBSCRIPT_PATH + separator + "insert";
		// ------------------------------------------------------------
		CONFIG_RELATIVE_PATH = "config" + separator + "mybatis";
		IBATISFILE_ELATIVE_PATH_PATH = CONFIG_RELATIVE_PATH + separator  + "entity";
		MYBATISFILE_ELATIVE_PATH_PATH = "mybatis"+ separator  + "entity";
		CONFIG_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + CONFIG_RELATIVE_PATH;

		IBATISFILE_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + IBATISFILE_ELATIVE_PATH_PATH;

		ROUTING_PATH = "config" + separator + "routing";
		CREATE_ROUTING_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + ROUTING_PATH;
		// ------------------------------------------------------------
		ENTITYDAOSERVICE_PATH = "com" + separator + "cwa" + separator + gameName + separator + "service";

		CREATE_ENTITYDAOSERVICE_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator +"ice" + separator + "entity"+ separator+"service";

		// ------------------------------------------------------------
		SPRINGCONFIG_RELATIVE_PATH = "config" + separator + "db";
		CREATE_SPRINGCONFIG_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + SPRINGCONFIG_RELATIVE_PATH;
		// -------------------------------------------------------------
		SERVER_ICE_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + "ice";
		SERVER_ICE_Entity_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + "ice" + separator + "entity"+ separator+"domain";
		SERVER_ICE_Entity_GENERALDAO_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + "ice" + separator + "entity"+ separator+"general";
		SERVER_ICE_Entity_DAO_PATH = FileUtil.getCurrentParentPath()+separator+ createFilePath + separator + "ice" + separator + "entity"+ separator+"dao";
		SERVER_ICE_Entity_INTERFACE_PATH =FileUtil.getCurrentParentPath()+separator+  createFilePath + separator + "ice" + separator + "entity"+ separator+"imp";
	}

	// ------------------------------------------------------------
	public String ENTITYJAVAFILE;
	public String ENTITYGENERALJAVAFILE;
	public String ENTITYDAOJAVAFILE;
	public String SERVER_ENTITYJAVE_PATH;
	public String SERVER_ENTITYGENERALJAVE_PATH;
	public String SERVER_ENTITYJAVEDAO_PATH;

	public String ENTITYGENERALDAOJAVAFILE;
	public String ENTITYSPREADDAOJAVAFILE;
	public String SERVER_ENTITYJAVEGENERALDAO_PATH;
	public String SERVER_ENTITYJAVESPREADDAO_PATH;

	public String CACHEENTITYGENERALDAOJAVAFILE;
	public String SERVER_CACHEENTITYJAVEGENERALDAO_PATH;
	// ------------------------------------------------------------
	public String DBSCRIPT_PATH;
	public String DBSCRIPT_DROP_PATH;
	public String DBSCRIPT_CREATE_PATH;
	public String DBSCRIPT_INSERT_PATH;
	// ------------------------------------------------------------
	public String CONFIG_RELATIVE_PATH;
	public String IBATISFILE_ELATIVE_PATH_PATH;
	public String MYBATISFILE_ELATIVE_PATH_PATH;
	
	public String CONFIG_PATH;
	public String IBATISFILE_PATH;
	public String ROUTING_PATH;
	public String CREATE_ROUTING_PATH;
	// ------------------------------------------------------------
	public String ENTITYDAOSERVICE_PATH;
	public String CREATE_ENTITYDAOSERVICE_PATH;
	// ------------------------------------------------------------
	public String SPRINGCONFIG_RELATIVE_PATH;
	public String CREATE_SPRINGCONFIG_PATH;
	// -------------------------------------------------------------
	public String SERVER_ICE_PATH;
	public String SERVER_ICE_Entity_PATH;
	public String SERVER_ICE_Entity_GENERALDAO_PATH;
	public String SERVER_ICE_Entity_DAO_PATH;
	public String SERVER_ICE_Entity_INTERFACE_PATH;
}
