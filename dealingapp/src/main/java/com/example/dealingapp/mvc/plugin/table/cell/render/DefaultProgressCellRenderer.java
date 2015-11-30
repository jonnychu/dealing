package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JProgressBar;
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

@SuppressWarnings("serial")
public class DefaultProgressCellRenderer extends JProgressBar implements TableCellRenderer {

	public DefaultProgressCellRenderer(int min, int max) {
		super(JProgressBar.HORIZONTAL, min, max);
		setBorderPainted(false);
		setStringPainted(true);
		setOpaque(true);
	}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		Integer v = ((Integer) value) == null ? 0 : ((Integer) value);
		if (isSelected) {
			setForeground(Color.RED);
			setBackground(table.getSelectionBackground());
		} else {
			setForeground(Color.RED);
			setBackground(table.getBackground());
		}

		setString(v.toString());
		setValue(v);
		setToolTipText(v.toString());
		return this;
	}
}
