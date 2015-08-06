/**
 * 
 */
package com.cwa.tool.creater.database.domain;

import java.util.LinkedList;
import java.util.List;

/**
 * @author mali
 * 
 */
public class EntityValueAttr {
	private List<EntityValue> attrValues;

	public EntityValueAttr() {
		attrValues = new LinkedList<EntityValue>();
	}

	public void addValue(EntityValue value) {
		attrValues.add(value);
	}

	public List<EntityValue> getAttrValues() {
		return attrValues;
	}
}
