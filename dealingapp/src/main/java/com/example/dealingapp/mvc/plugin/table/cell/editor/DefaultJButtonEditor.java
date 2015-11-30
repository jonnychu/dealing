package com.example.dealingapp.mvc.plugin.table.cell.editor;

import java.awt.Component;
import java.awt.event.ActionListener;

import javax.swing.AbstractCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

@SuppressWarnings("serial")
public class DefaultJButtonEditor extends AbstractCellEditor implements TableCellEditor {

	private JButton jButton;
	private String label;
	private transient ActionListener listener;

	public DefaultJButtonEditor() {
		this(null);
	}
	
	public DefaultJButtonEditor(ActionListener listener){
		jButton = new JButton();
		addActionListener(listener);
	}

	@Override
	public Object getCellEditorValue() {
		return label;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		label = (value == null) ? "" : value.toString();
		jButton.setText(label);
		return jButton;
	}
	
	public void addActionListener(ActionListener listener){
		this.listener = listener;
		if (jButton.getActionListeners() == null || jButton.getActionListeners().length == 0) {
			jButton.addActionListener(this.listener);
		}
	}
}
