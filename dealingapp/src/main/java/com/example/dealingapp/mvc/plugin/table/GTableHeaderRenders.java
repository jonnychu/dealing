package com.example.dealingapp.mvc.plugin.table;

import java.awt.Component;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

public class GTableHeaderRenders {
	
	private static Border border = UIManager.getBorder("TableHeader.cellBorder");
	
	public static class DefaultGTableHeaderColumnRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			JTableHeader header = table.getTableHeader();
			if (header != null) {
				setForeground(header.getForeground());
				setBackground(header.getBackground());
				setFont(header.getFont());
			}
			setHorizontalAlignment(JLabel.CENTER);
			setText((value == null) ? "" : value.toString());
			setBorder(border);
			return this;
		}
	}
	
	public static class DefaultGTableHeaderRender extends DefaultTableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
				boolean hasFocus, int row, int column) {
			JLabel header = new JLabel();
			header.setForeground(table.getTableHeader().getForeground());
			header.setBackground(table.getTableHeader().getBackground());
			header.setFont(table.getTableHeader().getFont());
			header.setHorizontalAlignment(JLabel.CENTER);
			header.setText(value.toString());
			header.setBorder(border);
			return header;
		}
	}
}
