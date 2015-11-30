package com.example.dealingapp.mvc.plugin.table.cell.render;

import java.awt.Component;

import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;

import com.example.dealingapp.res.ResourceManager;

@SuppressWarnings("serial")
public class DefaultImageIconRender extends DefaultTableCellRenderer{

	public DefaultImageIconRender(){
		super();
		setHorizontalAlignment(SwingConstants.CENTER);
		setVerticalAlignment(SwingConstants.CENTER);;
	}
	
	@Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
		Integer v = ((Integer)value);
		if(v == null){
			setIcon(new ImageIcon());
		}else if(v.intValue() == 1){
			setIcon(ResourceManager.getImageIcon("img/green.png"));
		}else if(v.intValue() == 2){
			setIcon(ResourceManager.getImageIcon("img/red.png"));
		}
		
    	return super.getTableCellRendererComponent(table, "", isSelected, hasFocus, row, column);
    }
}
