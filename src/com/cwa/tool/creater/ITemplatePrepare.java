/**
 * 
 */
package com.cwa.tool.creater;

import java.io.File;
import java.util.Map;

import com.cwa.tool.component.IStructure;

/**
 * 创建参数
 * 
 * @author mali
 */
public interface ITemplatePrepare {
	// 创建参数
	Map<String, Object> createMap(IStructure structure);

	// 模板文件路径
	String getFtlFilePath(IStructure structure);

	// 文件
	File getFile(IStructure structure) throws Exception;

	void createEnd(IStructure structure);
}
