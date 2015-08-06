package com.cwa.tool.creater.database.filecreater;

import com.cwa.tool.component.IContext;

public interface IDataBaseContext extends IContext {
	String getFlag();

	String getProjectName();

	String getCreateFilePath();

	String getTableNumber();
}
