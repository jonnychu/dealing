package com.example.dealingapp.mvc.plugin.table.cell.editor;

import java.awt.Component;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.table.TableCellEditor;

public class DefaultJSpinnerEditor extends AbstractCellEditor implements TableCellEditor {

	private final int clickCountToStart=1;
	private JSpinner jSpinner;
	private SpinnerModel model;
	
	public DefaultJSpinnerEditor(){
		jSpinner = new JSpinner(model = new SpinnerNumberModel());
	}
	
    @Override
	public Object getCellEditorValue() {
		return model.getValue();
	}
    
	@Override
	public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
		jSpinner.setValue(value == null ? 0 : value);
		try {
			jSpinner.commitEdit();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return jSpinner;
	}
	
	public boolean isCellEditable(EventObject anEvent) {
        if (anEvent instanceof MouseEvent) {
            return ((MouseEvent)anEvent).getClickCount() >= clickCountToStart;
        }
        return true;
    }

}
