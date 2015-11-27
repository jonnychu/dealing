package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Component;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DefaultJComboBoxRender extends JComboBox<String> implements TableCellRenderer {
	
	public DefaultJComboBoxRender(String[] values) {
		super(values);
		setOpaque(true);
		setEditable(true);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		
		setSelectedItem(value);
		//
//		if (isSelected) {
//			setForeground(table.getSelectionForeground());
//			setBackground(table.getSelectionBackground());
//		} else {
//			setForeground(table.getForeground());
//			setBackground(table.getBackground());
//		}
		return this;
	}
}
