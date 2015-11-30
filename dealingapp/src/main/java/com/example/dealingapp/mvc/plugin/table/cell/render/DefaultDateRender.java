package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Component;
import java.text.SimpleDateFormat;

import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

@SuppressWarnings("serial")
public class DefaultDateRender extends DefaultTableCellRenderer {

	private SimpleDateFormat formatter;

	public DefaultDateRender(String pattern) {
		super();
		formatter = new SimpleDateFormat(pattern);
		setHorizontalAlignment(SwingConstants.RIGHT);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		if (value != null) {
			setText(formatter.format(value));
		} else {
			setText("");
		}

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
