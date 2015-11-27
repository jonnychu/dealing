package com.example.dealingapp.mvc.plugin.table;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JViewport;
import javax.swing.event.ListSelectionEvent;

import com.example.dealingapp.mvc.plugin.table.GTableColumn.ColumnProperty;
import com.example.dealingapp.mvc.plugin.table.model.GTableColumnModel;
import com.example.dealingapp.mvc.plugin.table.model.GTableModel;

public class GTableFixColumnManager extends JScrollPane{

	private List<GTableHeaderColumnGroup> colGroup;
	private List<GTableColumn> column;
	private GTable fixedTable;
	private GTable table;
	
	public GTableFixColumnManager(List<GTableColumn> column,List<GTableHeaderColumnGroup> colGroup,int deep){
		this.colGroup = colGroup;
		this.column = column;
		fixedTable = createFixTable(deep);
		table = createTable(deep);
		//
		fixedTable.setEnabled(false);
		table.setEnabled(false);
		//
		JViewport viewport = new JViewport();
		viewport.setView(fixedTable);
		viewport.setPreferredSize(fixedTable.getPreferredSize());
		setViewportView(table);
		setRowHeaderView(viewport);
		setCorner(JScrollPane.UPPER_LEFT_CORNER, fixedTable.getTableHeader());
	}
	
	private GTable createTable(int deep){
		GTable gTable = new GTable(){
			public void valueChanged(ListSelectionEvent e) {
				super.valueChanged(e);
				checkSelection(false);
			}
		};
		List<GTableColumn> r = new ArrayList<>();
		for (GTableColumn gTableColumn : column) {
			ColumnProperty cp = gTableColumn.getColumnProperty();
			if(!cp.isFixed()){
				r.add(gTableColumn);
			}
		}
		GTableColumnModel colModelFix = new GTableColumnModel(r);
		GTableModel tableModel = new GTableModel(colModelFix);
		gTable.setModel(tableModel);
		gTable.setColumnModel(colModelFix);
		gTable.setTableHeaderGroup(colGroup, deep);
		
		return gTable;
	}
	
	private GTable createFixTable(int deep){
		GTable gTable = new GTable(){
			public void valueChanged(ListSelectionEvent e) {
				super.valueChanged(e);
				checkSelection(true);
			}
		};
		List<GTableColumn> r = new ArrayList<>();
		for (GTableColumn gTableColumn : column) {
			ColumnProperty cp = gTableColumn.getColumnProperty();
			if(cp.isFixed()){
				r.add(gTableColumn);
			}
		}
		GTableColumnModel colModelFix = new GTableColumnModel(r);
		GTableModel tableModel = new GTableModel(colModelFix);
		gTable.setModel(tableModel);
		gTable.setColumnModel(colModelFix);
		gTable.setTableHeaderGroup(colGroup, deep);
		
		return gTable;
	}
	
	private void checkSelection(boolean isFixedTable) {
		int fixedSelectedIndex = fixedTable.getSelectedRow();
		int selectedIndex = table.getSelectedRow();
		if (fixedSelectedIndex != selectedIndex) {
			if (isFixedTable) {
				table.setRowSelectionInterval(fixedSelectedIndex, fixedSelectedIndex);
			} else {
				fixedTable.setRowSelectionInterval(selectedIndex, selectedIndex);
			}
		}
	}

	public GTable getTable() {
		return table;
	}
	
	public GTable getFixedTable() {
		return fixedTable;
	}
	
	public void addRows(List<?> rows){
		((GTableModel) getFixedTable().getModel()).addRows(rows);
		((GTableModel) getTable().getModel()).addRows(rows);
	}
	
}
