package com.cwa.tool.creater.database.filecreater;

import java.util.LinkedList;
import java.util.List;

import com.cwa.tool.component.IContext;
import com.cwa.tool.component.IStructure;

public class DataBaseStructure implements IStructure {
	private IContext context;
	private List<IStructure> structureList = new LinkedList<IStructure>();

	public DataBaseStructure(IContext context) {
		this.context = context;
	}

	public void addStructures(List<IStructure> structures) {
		structureList.addAll(structures);
	}

	public IContext getContext() {
		return context;
	}

	public List<IStructure> getStructureList() {
		return structureList;
	}
}
