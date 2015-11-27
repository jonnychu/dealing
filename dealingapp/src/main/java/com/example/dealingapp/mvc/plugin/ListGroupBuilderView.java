package com.example.dealingapp.mvc.plugin;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.DefaultListSelectionModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dealingapp.mvc.login.Login;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.ButtonStackBuilder;
import com.jgoodies.forms.builder.FormBuilder;

public class ListGroupBuilderView extends JPanel {

	private static final Logger LOGGER = LoggerFactory.getLogger(ListGroupBuilderView.class);
	
	private final static String LCG = "$lcgap";
	private final static String COMMA = ",";
	private final static String LEFTLIST_NAME = "leftlist";
	private final static String RIGHTLIST_NAME = "rightlist";
	
	private String groupTitle, leftListTitle, rightListTitle;

	private JList leftList, rightList;
	private DefaultListModel<Object> leftListModel, rightListModel;
	private DefaultListSelectionModel leftListSelModel , rightListSelModel;
	
	private JButton btnMoveUp, btnMoveDown;
	private JButton btnMoveLeft, btnMoveRight, btnMoveLeftAll, btnMoveRigthAll;
	
	private boolean hasFirstColumnint;
	private int listWidth, buttonWidth, buttonHeight;

	public ListGroupBuilderView(String groupTitle, String leftListTitle, String rightListTitle,
			boolean hasFirstColumnint, int listWidth, int buttonWidth, int buttonHeight) {
		this.groupTitle = groupTitle;
		this.leftListTitle = leftListTitle;
		this.rightListTitle = rightListTitle;
		this.hasFirstColumnint = hasFirstColumnint;
		this.listWidth = listWidth;
		this.buttonWidth = buttonWidth;
		this.buttonHeight = buttonHeight;
		
		BtnHandler handler = new BtnHandler();
		btnMoveUp = ComponentFactory.XJButton.create("↑", "moveup", handler);
		btnMoveDown = ComponentFactory.XJButton.create("↓", "movedown", handler);
		btnMoveLeft = ComponentFactory.XJButton.create("<", "moveleft", handler);
		btnMoveRight = ComponentFactory.XJButton.create(">", "moveright", handler);
		btnMoveLeftAll = ComponentFactory.XJButton.create("<<", "moveleftall", handler);
		btnMoveRigthAll = ComponentFactory.XJButton.create(">>", "moverightall", handler);
		//TODO
//		JPanel btnStack = ButtonStackBuilder.create().addButton(btnMoveUp,btnMoveDown).build();

		JListHandler listHandler = new JListHandler();
		leftList = ComponentFactory.XJList.create(LEFTLIST_NAME,this.leftListModel = new DefaultListModel<Object>(),
				this.leftListSelModel = new DefaultListSelectionModel(), null, listHandler);
		rightList = ComponentFactory.XJList.create(RIGHTLIST_NAME,this.rightListModel = new DefaultListModel<Object>(),
				this.rightListSelModel = new DefaultListSelectionModel(), null, listHandler);

		this.add(initFormBuilder().build());
	}

	public FormBuilder initFormBuilder() {
		return FormBuilder.create()//.debug(true)
				.columns(columnsBuilder(hasFirstColumnint, listWidth, buttonWidth))
				.rows(rowsBuilder(buttonHeight))
				.border(groupTitle == null ? BorderFactory.createLineBorder(Color.WHITE)
						: BorderFactory.createTitledBorder(groupTitle))
				.add(btnMoveUp).xy(2, 11)
				.add(btnMoveDown).xy(2, 13)
				.add(leftListTitle).xy(4, 3)
				.add(leftList).xywh(4, 4, 1, 16)
				.add(btnMoveLeft).xy(6, 9)
				.add(btnMoveLeftAll).xy(6, 11)
				.add(btnMoveRight).xy(6, 13)
				.add(btnMoveRigthAll).xy(6, 15)
				.add(rightListTitle).xy(8, 3)
				.add(rightList).xywh(8, 4, 1, 16);
	}

	public String columnsBuilder(boolean hasFirstColumnint, int listWidth, int buttonWidth) {
		StringBuffer defaultColumns = new StringBuffer();
		defaultColumns.append(LCG).append(COMMA); 										// 1 column
		if (hasFirstColumnint) {
			defaultColumns.append("").append(buttonWidth).append("dlu").append(COMMA); 	// 2 column
		} else {
			defaultColumns.append("0dlu").append(COMMA); 								// 2 column
		}
		defaultColumns.append(LCG).append(COMMA); 										// 3 column
		defaultColumns.append("").append(listWidth).append("dlu").append(COMMA); 		// 4 column
		defaultColumns.append(LCG).append(COMMA); 										// 5 column
		defaultColumns.append("").append(buttonWidth).append("dlu").append(COMMA); 		// 6 column
		defaultColumns.append(LCG).append(COMMA); 										// 7 column
		defaultColumns.append("").append(listWidth).append("dlu").append(COMMA); 		// 8 column
		defaultColumns.append(LCG);
		return defaultColumns.toString();
	}

	public String rowsBuilder(int buttonHeight) {
		StringBuffer defaultRows = new StringBuffer();
		defaultRows.append("20dlu").append(COMMA);
		defaultRows.append(LCG).append(COMMA);
		defaultRows.append("9 * (fill:").append(buttonHeight).append("dlu,$lcg)");

		return defaultRows.toString();
	}

	public void loadData(List l, List r) {
		if (l != null && l.size() > 0) {
			for (Object object : l) {
				this.leftListModel.addElement(object);
			}
		}else{
			this.btnMoveDown.setEnabled(false);
			this.btnMoveUp.setEnabled(false);
		}
		if (r != null) {
			for (Object object : r) {
				this.leftListModel.addElement(object);
			}
		}
	}
	
	private void moveUpAndDown(String actionCommand){
		if(this.leftListModel.isEmpty()) return;
		if(this.leftListSelModel.isSelectionEmpty()) this.leftList.setSelectedIndex(0);
		if(actionCommand.equals("moveup")){
			int maxSelectionIndex = this.leftListModel.size();
			int leadSelectionIndex = this.leftListSelModel.getLeadSelectionIndex();
			this.leftList.setSelectedIndex(--leadSelectionIndex >= maxSelectionIndex ? maxSelectionIndex:leadSelectionIndex);
			this.leftList.revalidate();
		}
		else{
			int maxSelectionIndex = this.leftListModel.size();
			int leadSelectionIndex = this.leftListSelModel.getLeadSelectionIndex();
			this.leftList.setSelectedIndex(++leadSelectionIndex >= maxSelectionIndex ? maxSelectionIndex:leadSelectionIndex);
		}
	}
	
	private void moveLeft(String actionCommand){
		if(this.rightListModel.isEmpty()) return;
		if(this.rightListSelModel.isSelectionEmpty()) return;
		
		List selValues = this.rightList.getSelectedValuesList();
		for (Object obj : selValues) {
			boolean isRemove = this.rightListModel.removeElement(obj);
			if(isRemove) this.leftListModel.addElement(obj);
			else LOGGER.error("can not find value:"+obj+" in rightlistmodel");
		}
	}
	
	private void moveRight(String actionCommand){
		if(this.leftListModel.isEmpty()) return;
		if(this.leftListSelModel.isSelectionEmpty()) return;
		
		List selValues = this.leftList.getSelectedValuesList();
		for (Object obj : selValues) {
			boolean isRemove = this.leftListModel.removeElement(obj);
			if(isRemove) this.rightListModel.addElement(obj);
			else LOGGER.error("can not find value:"+obj+" in leftlistmodel");
		}
	}
	private class BtnHandler implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			switch (e.getActionCommand()) {
			case "moveup":
			case "movedown":
				moveUpAndDown(e.getActionCommand());
				break;
			case "moveleft":
			case "moveleftall":
				moveLeft(e.getActionCommand());
				break;
			case "moveright":
			case "moverightall":
				moveRight(e.getActionCommand());
				break;
			default:
				break;
			}
		}
		
	}
	
	private class JListHandler extends MouseAdapter {

		@Override
		public void mouseClicked(MouseEvent mouseEvent) {
			JList list = (JList) mouseEvent.getSource();
			if (mouseEvent.getClickCount() == 2) {
				int index = list.locationToIndex(mouseEvent.getPoint());
				if (index >= 0) {
					Object obj = list.getModel().getElementAt(index);
					if(list.getName()!=null && list.getName().equals(LEFTLIST_NAME)){
						leftListModel.remove(index);
						rightListModel.addElement(obj);
					}else if(list.getName()!=null && list.getName().equals(RIGHTLIST_NAME)){
						rightListModel.remove(index);
						leftListModel.addElement(obj);
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		ListGroupBuilderView view = new ListGroupBuilderView("group1", "left", "right",false,60,30,20);
		List l = new ArrayList();
		l.add("1111");
		l.add("1112");
		l.add("1113");
		l.add("1114");
		l.add("1115");
		l.add("1116");
		l.add("1117");
		l.add("1118");
		l.add("1119");
		l.add("11110");
		view.loadData(l, null);
		
		JDialog dialog = new JDialog();
		dialog.setContentPane(view);
		dialog.setSize(700, 500);
		dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		dialog.setVisible(true);
	}
}
