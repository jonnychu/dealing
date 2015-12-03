package com.example.dealingapp.util;

import java.awt.event.ActionListener;
import java.awt.event.FocusListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerModel;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

public class ComponentFactory {

	public static class XJButton {

		public static JButton create(String text) {
			return create(text,null,null,null);
		}
		
		public static JButton create(String text, String actionCommand, ActionListener listener) {
			return create(text,null,actionCommand,listener);
		}
		
		public static JButton create(String text, Icon icon, String actionCommand, ActionListener listener) {
			JButton item = new JButton(text == null ? "" : text);
			if(icon != null) item.setIcon(icon);
			if (actionCommand != null)
				item.setActionCommand(actionCommand);
			if (listener != null)
				item.addActionListener(listener);
			return item;
		}
	}
	
	public static class XJTable {

		public static JTable create(TableModel tModel,TableColumnModel tColModel,ListSelectionModel lSelModel) {
			JTable item = new JTable();
			if (tModel != null)
				item.setModel(tModel);
			if (tColModel != null)
				item.setColumnModel(tColModel);
			if (lSelModel != null)
				item.setSelectionModel(lSelModel);
			return item;
		}
	}
	
	public static class XJMenu {

		public static JMenu create(String text, String actionCommand, ActionListener listener) {
			JMenu item = new JMenu(text == null ? "" : text);
			if (actionCommand != null)
				item.setActionCommand(actionCommand);
			if (listener != null)
				item.addActionListener(listener);
			return item;
		}
	}
	
	public static class XJMenuItem {

		public static JMenuItem create(String text, String actionCommand, ActionListener listener) {
			JMenuItem item = new JMenuItem(text == null ? "" : text);
			if (actionCommand != null)
				item.setActionCommand(actionCommand);
			if (listener != null)
				item.addActionListener(listener);
			return item;
		}
	}

	public static class XJList {

		public static JList<?> create() {
			return create(null,null,null,null,null);
		}
		
		public static JList<?> create(String name,ListModel model,ListSelectionModel selModel,ListSelectionListener selListener,MouseListener mListener) {
			JList item = new JList();
			if(model != null) item.setModel(model);
			if(selModel != null) item.setSelectionModel(selModel);
			if(selListener != null) item.addListSelectionListener(selListener);
			if(mListener != null) item.addMouseListener(mListener);
			if(name != null) item.setName(name);
			return item;
		}
	}
	
	public static class XJSpinner {

		public static JSpinner create(SpinnerModel model,ChangeListener cListener) {
			JSpinner item = new JSpinner();
			if(model != null) item.setModel(model);
			if(cListener != null) item.addChangeListener(cListener);
			return item;
		}
		
		public static JSpinner createNumberEditor(SpinnerModel model,ChangeListener cListener,String decimalFormatPattern) {
			JSpinner item = new JSpinner();
			if(model != null) item.setModel(model);
			if(cListener != null) item.addChangeListener(cListener);
			JSpinner.NumberEditor nEditor = new JSpinner.NumberEditor(item,decimalFormatPattern);
			item.setEditor(nEditor);
			return item;
		}
		
		public static JSpinner createDateEditor(SpinnerModel model,ChangeListener cListener,String dateFormatPattern) {
			JSpinner item = new JSpinner();
			if(model != null) item.setModel(model);
			if(cListener != null) item.addChangeListener(cListener);
			JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(item, dateFormatPattern);
			item.setEditor(dateEditor);
			return item;
		}
		
		public static JSpinner createListEditor(SpinnerModel model,ChangeListener cListener) {
			JSpinner item = new JSpinner();
			if(model != null) item.setModel(model);
			if(cListener != null) item.addChangeListener(cListener);
			JSpinner.ListEditor dateEditor = new JSpinner.ListEditor(item);
			item.setEditor(dateEditor);
			return item;
		}
	}
	
	public static class XJTextField {

		public static JTextField create(String text) {
			return create(text, 0, null, true, true, null, null, null);
		}
		
		public static JTextField create(int columns) {
			return create(null, columns, null, true, true, null, null, null);
		}

		public static JTextField create(String text, int columns) {
			return create(text, columns, null, true, true, null, null, null);
		}

		public static JTextField create(String text, int columns, boolean isEditable, boolean isEnable) {
			return create(text, columns, null, isEditable, isEnable, null, null, null);
		}

		public static JTextField create(String text, int columns, String actionCommand, boolean isEditable,
				boolean isEnable, KeyListener keyListener, ActionListener actListener, FocusListener focListener) {
			JTextField item = new JTextField();
			if (text != null)
				item.setText(text);
			item.setColumns(columns);
			item.setEditable(isEditable);
			item.setEnabled(isEnable);
			if (actionCommand != null)
				item.setActionCommand(actionCommand);
			if (keyListener != null)
				item.addKeyListener(keyListener);
			if (actListener != null)
				item.addActionListener(actListener);
			if (focListener != null)
				item.addFocusListener(focListener);
			return item;
		}
	}
}
