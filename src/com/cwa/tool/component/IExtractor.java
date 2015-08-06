/**
 * 
 */
package com.cwa.tool.component;

import java.util.List;

/**
 * @author mali
 * 
 */
public interface IExtractor {
	List<IStructure> extract(String filePath);
}
