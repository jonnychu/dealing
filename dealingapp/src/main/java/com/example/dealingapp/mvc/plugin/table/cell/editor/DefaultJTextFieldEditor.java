package com.example.dealingapp.mvc.plugin.table.cell.editor;

import javax.swing.DefaultCellEditor;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class DefaultJTextFieldEditor extends DefaultCellEditor {

	public DefaultJTextFieldEditor(JTextField textField) {
		super(textField);
		textField.setHorizontalAlignment(SwingConstants.CENTER);
	}
}
