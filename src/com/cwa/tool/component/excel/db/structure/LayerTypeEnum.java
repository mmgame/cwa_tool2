package com.cwa.tool.component.excel.db.structure;

public enum LayerTypeEnum {
	Layer_Desc(0, 1), // 描述层
	Layer_Database(1, 2), // 数据库字段层
	Layer_Class(2, 3), // 类字段层
	Layer_Rule(3, 2), // 规则层
	Layer_Index(4, -1), // 索引层
	Layer_Data(5, -1), // 数据层
	;

	int ltype;// 类型
	int count;// 所占行数

	LayerTypeEnum(int ltype, int count) {
		this.ltype = ltype;
		this.count = count;
	}

	public int getCount() {
		return this.count;
	}

	public int getLType() {
		return this.ltype;
	}
}
