package com.example.dealingapp.mvc.plugin.table.sorter;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.table.JTableHeader;

import com.example.dealingapp.mvc.plugin.table.model.GTableModel;

public class HeaderListener extends MouseAdapter {
	
	private JTableHeader header;
	private SortButtonRenderer renderer;

	public HeaderListener(JTableHeader header, SortButtonRenderer renderer) {
		this.header = header;
		this.renderer = renderer;
	}

	public void mousePressed(MouseEvent e) {
		int col = header.columnAtPoint(e.getPoint());
		int sortCol = header.getTable().convertColumnIndexToModel(col);
		renderer.setPressedColumn(col);
		renderer.setSelectedColumn(col);
		header.repaint();

		if (header.getTable().isEditing()) {
			header.getTable().getCellEditor().stopCellEditing();
		}

		boolean isAscent;
		if (SortButtonRenderer.DOWN == renderer.getState(col)) {
			isAscent = true;
		} else {
			isAscent = false;
		}
//		((GTableModel) header.getTable().getModel()).sortByColumn(sortCol, isAscent);
	}

	public void mouseReleased(MouseEvent e) {
//		int col = header.columnAtPoint(e.getPoint());
		renderer.setPressedColumn(-1); // clear
		header.repaint();
	}
}
