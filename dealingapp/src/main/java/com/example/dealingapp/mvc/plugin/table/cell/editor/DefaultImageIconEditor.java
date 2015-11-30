package com.example.dealingapp.mvc.plugin.table.cell.editor;

import java.awt.Component;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JTable;
import javax.swing.table.TableCellEditor;

@SuppressWarnings("serial")
public class DefaultImageIconEditor  extends AbstractCellEditor implements TableCellEditor {

    public boolean isCellEditable(EventObject e) {
        return false;
    }
    
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object getCellEditorValue() {
		// TODO Auto-generated method stub
		return null;
	}

}
