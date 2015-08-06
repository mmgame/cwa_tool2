package com.cwa.data.entity.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.HashMap;
import java.util.Map;

import wow.data.entity.EquipmentGeneralEntity;

import com.cwa.component.data.ISpreadEntity;
import com.cwa.util.prototype.JsonUtil;

public class EquipmentEntity extends EquipmentGeneralEntity implements ISpreadEntity {
	private static final long serialVersionUID = 1L;
	

	@Override
	public void obtainAfter() {
	}

	@Override
	public void saveBefore() {
	}

	@Override
	public void saveAfter() {
	}


	public EquipmentEntity cloneEntity() {
		EquipmentEntity entity = new EquipmentEntity();
		entity.userId = this.userId;
		entity.heroId = this.heroId;
		entity.positionId = this.positionId;
		entity.equipmentLevel = this.equipmentLevel;
		entity.equipmentQuality = this.equipmentQuality;
		entity.plugs = this.plugs;
		return entity;
	}
}
