package com.cwa.tool.creater.database;

import java.util.LinkedList;
import java.util.List;

import com.cwa.tool.component.excel.db.IDBTableStructure;
import com.cwa.tool.component.excel.db.structure.LayerTypeEnum;
import com.cwa.tool.component.excel.db.structure.datalayer.ClassFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataBaseFieldLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.DataDescLayer;
import com.cwa.tool.component.excel.db.structure.datalayer.IndexLayer;
import com.cwa.tool.creater.ITemplatePrepare;
import com.cwa.tool.creater.database.domain.EntityClassAttr;
import com.cwa.tool.creater.database.domain.EntityDBAttr;
import com.cwa.tool.creater.database.domain.EntityIbatisAttr;
import com.cwa.tool.creater.database.domain.EntityIndexAttr;
import com.cwa.tool.creater.database.filecreater.IDataBaseContext;
import com.cwa.tool.util.StringUtil;
import com.cwa.util.CollectionType;
import com.cwa.util.CollectionType.CollectionTypeEnum;

public abstract class AbstractDBTemplatePrepare implements ITemplatePrepare {
	protected List<EntityDBAttr> getEntityDBAttrList(IDBTableStructure s) {
		List<EntityDBAttr> list = new LinkedList<EntityDBAttr>();

		DataDescLayer dataDescLayer = (DataDescLayer) s.getLayer(LayerTypeEnum.Layer_Desc);
		DataBaseFieldLayer dataBaseFieldLayer = (DataBaseFieldLayer) s.getLayer(LayerTypeEnum.Layer_Database);

		for (int i = 0; i < s.getColumnNum(); i++) {
			String attrName = dataBaseFieldLayer.getFieldNames().get(i);
			String attrTpyte = dataBaseFieldLayer.getFieldTypes().get(i);
			String attrDesc = dataDescLayer.getDescs().get(i);

			EntityDBAttr attr = new EntityDBAttr();
			attr.setAttrDesc(attrDesc);
			attr.setAttrName(attrName);
			attr.setAttrType(attrTpyte);
			attr.setAttrLimit(getAttrLimit(attrName, attrTpyte));

			list.add(attr);
		}
		return list;
	}

	protected List<EntityClassAttr> getEntityClassAttrList(IDBTableStructure s) {
		List<EntityClassAttr> list = new LinkedList<EntityClassAttr>();

		DataDescLayer dataDescLayer = (DataDescLayer) s.getLayer(LayerTypeEnum.Layer_Desc);
		ClassFieldLayer classFieldLayer = (ClassFieldLayer) s.getLayer(LayerTypeEnum.Layer_Class);

		for (int i = 0; i < s.getColumnNum(); i++) {
			String attrName = classFieldLayer.getFieldNames().get(i);
			String attrType = classFieldLayer.getFieldTypes().get(i);
			String attrDesc = dataDescLayer.getDescs().get(i);

			CollectionType collectionType = classFieldLayer.getCollectionType(i);
			EntityClassAttr attr = new EntityClassAttr();
			attr.setAttrDesc(attrDesc);
			attr.setAttrName(attrName);
			attr.setAttrType(attrType);

			if (collectionType != null) {
				attr.setIsCollection(1);
				if (collectionType.getType() == CollectionTypeEnum.Map) {
					attr.setCollectionInitType("HashMap");
				} else if (collectionType.getType() == CollectionTypeEnum.List) {
					attr.setCollectionInitType("ArrayList");
				} else if (collectionType.getType() == CollectionTypeEnum.Set) {
					attr.setCollectionInitType("HashSet");
				}
				attr.setCollectionType(collectionType.getType().name());
				attr.setCollectionSuffix(collectionType.getSuffix());
			}
			list.add(attr);
		}
		return list;
	}

	// 数据库限制
	private String getAttrLimit(String attrName, String attrTpyte) {
		if (attrName.equals("id")) {
			return "NOT NULL";
		} else if (attrTpyte.contains("int")) {
			return "DEFAULT '0'";
		} else if (attrTpyte.contains("blob")) {
			return "";
		} else if (attrTpyte.contains("varchar")) {
			return "DEFAULT ''";
		}
		return "DEFAULT '0'";
	}

	protected int isHasList(List<EntityClassAttr> list) {
		int isHasList = 0;

		for (EntityClassAttr l : list) {
			if (l.getIsCollection() == 1) {
				isHasList = 1;
				break;
			}
		}
		return isHasList;
	}

	protected List<EntityIbatisAttr> getEntityIbatisAttr(IDBTableStructure s) {
		List<EntityIbatisAttr> list = new LinkedList<EntityIbatisAttr>();

		ClassFieldLayer classFieldLayer = (ClassFieldLayer) s.getLayer(LayerTypeEnum.Layer_Class);
		DataBaseFieldLayer dataBaseFieldLayer = (DataBaseFieldLayer) s.getLayer(LayerTypeEnum.Layer_Database);

		for (int i = 0; i < s.getColumnNum(); i++) {
			String attrPName = classFieldLayer.getFieldNames().get(i);
			String attrDBName = dataBaseFieldLayer.getFieldNames().get(i);

			EntityIbatisAttr attr = new EntityIbatisAttr();
			attr.setAttrPName(attrPName);
			attr.setAttrDBName(attrDBName);
			list.add(attr);
		}
		return list;
	}

	/**
	 * 获取所有索引
	 * 
	 * @param excelStructure
	 * @return
	 */
	protected List<EntityIndexAttr> getEntityIndexAttrList(IDBTableStructure s) {
		IndexLayer indexLayer = (IndexLayer) s.getLayer(LayerTypeEnum.Layer_Index);
		// 获取索引
		List<EntityIndexAttr> indexList = new LinkedList<EntityIndexAttr>();
		List<List<String>> indexDataList = indexLayer.getIndexs();
		for (List<String> indexData : indexDataList) {
			EntityIndexAttr indexAttr = getEntityIndexAttr(s, indexData);
			indexList.add(indexAttr);
		}
		return indexList;
	}

	/**
	 * 获取一行索引
	 * 
	 * @param excelStructure
	 * @return
	 */
	protected EntityIndexAttr getEntityIndexAttr(IDBTableStructure s) {
		IndexLayer indexLayer = (IndexLayer) s.getLayer(LayerTypeEnum.Layer_Index);
		// 获取第一行
		List<String> indexData = indexLayer.getIndexs().get(0);
		EntityIndexAttr indexAttr = getEntityIndexAttr(s, indexData);
		return indexAttr;
	}

	protected EntityIndexAttr getEntityIndexAttr(IDBTableStructure s, List<String> indexData) {
		EntityIndexAttr indexAttr = new EntityIndexAttr();
		int length = Math.min(indexData.size(), s.getColumnNum());

		for (int i = 0; i < length; i++) {
			String indexValue = indexData.get(i);
			if (indexValue == null || indexValue.equals("") || indexValue.equals("0")) {
				continue;
			}

			int indexV = Integer.parseInt(indexValue);
			if (indexV == 3 || indexV / 2 == 3) {
				indexAttr.setIsHasGroupIndex(1);
			}
			EntityIbatisAttr entityIbatisAttr = getEntityIbatisAttr(s, i, indexValue);
			indexAttr.addAttr(entityIbatisAttr);

			if (indexV % 2 == 0) {
				indexAttr.setIsHasOwnerIndex(1);
				indexAttr.setOwnerIndexName(entityIbatisAttr.getAttrPName());
				indexAttr.setOwnerIndexType(entityIbatisAttr.getAttrTpye());
			}
		}
		return indexAttr;
	}

	protected EntityIbatisAttr getEntityIbatisAttr(IDBTableStructure s, int index, String indexType) {
		ClassFieldLayer classFieldLayer = (ClassFieldLayer) s.getLayer(LayerTypeEnum.Layer_Class);
		DataBaseFieldLayer dataBaseFieldLayer = (DataBaseFieldLayer) s.getLayer(LayerTypeEnum.Layer_Database);

		String attrPName = classFieldLayer.getFieldNames().get(index);
		String attrDBName = dataBaseFieldLayer.getFieldNames().get(index);
		String attrTpyte = classFieldLayer.getFieldTypes().get(index);

		EntityIbatisAttr attr = new EntityIbatisAttr();
		attr.setAttrPName(attrPName);
		attr.setAttrDBName(attrDBName);
		attr.setAttrTpye(attrTpyte);
		// attr.setIndexType(indexType);
		return attr;
	}

	protected String getEntityName(IDBTableStructure structure) {
		IDataBaseContext c = (IDataBaseContext) structure.getContext();
		return structure.getSheet() + StringUtil.upperFirstString(c.getFlag());
	}

	protected String getGeneralEntityName(IDBTableStructure structure) {
		IDataBaseContext c = (IDataBaseContext) structure.getContext();
		return structure.getSheet() + "General" + StringUtil.upperFirstString(c.getFlag());
	}

	protected String getEntityDaoName(IDBTableStructure structure) {
		IDataBaseContext c = (IDataBaseContext) structure.getContext();
		return structure.getSheet() + StringUtil.upperFirstString(c.getFlag()) + "Dao";
	}

	protected String getEntityGeneralDaoName(IDBTableStructure structure) {
		IDataBaseContext c = (IDataBaseContext) structure.getContext();
		return structure.getSheet() + StringUtil.upperFirstString(c.getFlag()) + "GeneralDao";
	}

	protected String getTableName(IDBTableStructure structure) {
		IDataBaseContext c = (IDataBaseContext) structure.getContext();
		return c.getFlag() + "_" + structure.getSheet();
	}

}
