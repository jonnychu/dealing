package com.example.dealingapp.mvc.plugin.table.cell.editor;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;

public class DefaultJComboBoxEditor extends DefaultCellEditor {

	public DefaultJComboBoxEditor(JComboBox comboBox) {
		super(comboBox);
		comboBox.setEditable(true);
	}

}
