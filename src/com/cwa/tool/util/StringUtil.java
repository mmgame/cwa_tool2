package com.cwa.tool.util;

public class StringUtil {
	/**
	 * 字符串首字符大写
	 * 
	 * @param str
	 * @return
	 */
	public static String upperFirstString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		return str.substring(0, 1).toUpperCase() + str.substring(1);
	}

	public static String lowerFirstString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		return str.substring(0, 1).toLowerCase() + str.substring(1);
	}
	
	public static String lowerAllString(String str) {
		if (str == null || str.equals("")) {
			return str;
		}
		return str.toLowerCase();
	}
	/**
	 * 替换Rev为Send，替换Send为Rev
	 * 
	 * @param str
	 */
	public static String repeatMessageName(String name) {
		if (name.contains("Rev")) {
			return name.replace("Rev", "Send");
		} else if (name.contains("Send")) {
			return name.replace("Send", "Rev");
		}
		return name;
	}

	public static int getColumn(String column) {
		int num = 0;
		for (int i = 0; i < column.length(); i++) {
			num += (column.charAt(i) - 'A' + 1) * Math.pow(26, column.length() - i - 1);
		}
		num--;
		return num;
	}
}
