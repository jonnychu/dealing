package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Component;

import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

public class DefaultJSpinnerRender extends JSpinner implements TableCellRenderer  {

	public DefaultJSpinnerRender(){
		super();
		setOpaque(true);
		setValue(0);
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {

		setValue(value == null ? 0 : value);

		//
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(table.getBackground());
		}
		return this;
	}

	
}
