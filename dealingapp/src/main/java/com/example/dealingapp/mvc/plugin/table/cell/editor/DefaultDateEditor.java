package com.example.dealingapp.mvc.plugin.table.cell.editor;

import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.DefaultCellEditor;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DefaultDateEditor extends DefaultCellEditor {

	private static final String DEFAULT_PATTERN = "yyyy/MM/dd HH:mm:ss";
	private SimpleDateFormat formatter;
	private JTextField jTextField;

	public DefaultDateEditor(JTextField textField) {
		super(textField);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		formatter = new SimpleDateFormat(DEFAULT_PATTERN);
	}

	public DefaultDateEditor(JTextField textField, String pattern) {
		super(textField);
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		formatter = new SimpleDateFormat(pattern);
	}

	@Override
	public Object getCellEditorValue() {
		try {
			return formatter.parse(jTextField.getText());
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		if (value != null) {
			jTextField.setText(formatter.format(value));
		} else {
			jTextField.setText("");
		}
		return jTextField;
	}
}
