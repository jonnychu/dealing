package com.example.dealingapp.mvc.plugin.table.model;

import java.util.HashMap;
import java.util.List;

import javax.swing.table.DefaultTableColumnModel;

import com.example.dealingapp.mvc.plugin.table.GTableColumn;
import com.example.dealingapp.mvc.plugin.table.GTableColumn.ColumnProperty;

public class GTableColumnModel extends DefaultTableColumnModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<GTableColumn> columnFixs;
	private final HashMap<Integer, GTableColumn> columnMap = new HashMap<Integer, GTableColumn>();
	
	public GTableColumnModel(List<GTableColumn> columnFixs){
		this.columnFixs = columnFixs;
		createColumnModel(this.columnFixs);
	}

	private void createColumnModel(List<GTableColumn> columnFixs){
		int modexIndex = 0;
		for (GTableColumn column : columnFixs) {
			ColumnProperty colProperty = column.getColumnProperty();
			column.setModelIndex(modexIndex);
			column.setHeaderValue(colProperty.getColumnName());
			column.setIdentifier(colProperty.getColumnId());
			column.setPreferredWidth(colProperty.getColWidth());
			column.setMinWidth(0);
			addColumn(column);
			columnMap.put(modexIndex, column);
			modexIndex++;
		}
	}
}
