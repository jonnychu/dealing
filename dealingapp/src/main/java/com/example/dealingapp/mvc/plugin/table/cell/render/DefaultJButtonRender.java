package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Component;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class DefaultJButtonRender extends JButton implements TableCellRenderer {
	
	public DefaultJButtonRender(){
		super();
		setOpaque(true);
		setHorizontalAlignment(SwingConstants.CENTER);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		//
		if (isSelected) {
			setForeground(table.getSelectionForeground());
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(table.getForeground());
			setBackground(UIManager.getColor("Button.background"));
		}
		
		setText(value == null? "" : value.toString());
		return this;
	}
}
