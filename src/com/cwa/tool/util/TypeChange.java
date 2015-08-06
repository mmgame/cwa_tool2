package com.cwa.tool.util;

import java.util.HashMap;
import java.util.Map;

public class TypeChange {
	private Map<String, String> iceTypeMap = new HashMap<String, String>();

	private void initIceTypeMap() {
		iceTypeMap.put("String", "string");
		iceTypeMap.put("boolean", "bool");
	}
}
