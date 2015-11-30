package com.example.dealingapp.mvc.plugin.table.cell.render;import java.awt.Component;import javax.swing.JCheckBox;import javax.swing.JTable;import javax.swing.SwingConstants;import javax.swing.table.TableCellRenderer;@SuppressWarnings("serial")public class DefaultJCheckBoxRenderer extends JCheckBox implements TableCellRenderer {	public DefaultJCheckBoxRenderer() {		super();		setOpaque(true);		setHorizontalAlignment(SwingConstants.CENTER);	}	@Override	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,			int row, int column) {		Boolean booleanValue = (Boolean)value;		setSelected(booleanValue == null ? false : booleanValue.booleanValue());		//		if (isSelected) {			setForeground(table.getSelectionForeground());			setBackground(table.getSelectionBackground());		} else {			setForeground(table.getForeground());			setBackground(table.getBackground());		}        		return this;	}}