package com.example.dealingapp.mvc.inner.table.table2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import org.apache.commons.lang3.RandomUtils;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.mvc.plugin.table.GTable;
import com.example.dealingapp.mvc.plugin.table.GTableColumn;
import com.example.dealingapp.mvc.plugin.table.GTableHeaderColumnGroup;
import com.example.dealingapp.mvc.plugin.table.GTableRowSorter;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultDateEditor;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultImageIconEditor;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultJButtonEditor;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultJCheckBoxEditor;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultJComboBoxEditor;
import com.example.dealingapp.mvc.plugin.table.cell.editor.DefaultJSpinnerEditor;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultDateRender;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultImageIconRender;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultJButtonRender;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultJCheckBoxRenderer;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultJComboBoxRender;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultJSpinnerRender;
import com.example.dealingapp.mvc.plugin.table.cell.render.DefaultProgressCellRenderer;
import com.example.dealingapp.mvc.plugin.table.model.GTableColumnModel;
import com.example.dealingapp.mvc.plugin.table.model.GTableModel;
import com.example.dealingapp.mvc.plugin.table.test.row.MyRow;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;

public class Table2 extends AbstractInnerFrame {

	private JButton btnShowData;
	private JButton btnAdd;

	public Table2(Context context) {
		super(context);
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().columns("fill:pref:grow,50dlu").rows("fill:pref:grow");

	}

	@Override
	protected void initGUI(FormBuilder builder) {

		// GTable table = createTable();

		//
		List<GTableColumn> rows = new ArrayList<>();
		GTableColumn col1 = new GTableColumn("", "col1", "num", "setRowNum", "getRowNum", Integer.class, 40,
				true, MyRow.class);
		GTableColumn col2 = new GTableColumn("", "col2", "money", "setMoney", "getMoney", BigDecimal.class,
				120, false, MyRow.class);
		GTableColumn col3 = new GTableColumn("", "col3", "mark", "setjComboBox", "getjComboBox",
				String.class, 120, false, MyRow.class);
		GTableColumn col4 = new GTableColumn("", "col4", "mark-2", "setCheckBox", "getCheckBox",
				Boolean.class, 40, false, MyRow.class);
		GTableColumn col5 = new GTableColumn("", "col5", "mark-3", "setjButton", "getjButton", String.class,
				80, false, MyRow.class);
		GTableColumn col6 = new GTableColumn("", "col6", "mark-4", "setSpinner", "getSpinner",
				Integer.class, 60, false, MyRow.class);
		GTableColumn col7 = new GTableColumn("", "col7", "updatetime", "setUpdateTime", "getUpdateTime",
				Date.class, 120, false, MyRow.class);
		GTableColumn col8 = new GTableColumn("", "col7", "status", "setImage", "getImage", Integer.class,
				60, false, MyRow.class);
		GTableColumn col9 = new GTableColumn("", "col7", "progress", "setProgress", "getProgress",
				Integer.class, 200, false, MyRow.class);

		rows.add(col1);
		rows.add(col2);
		rows.add(col3);
		rows.add(col4);
		rows.add(col5);
		rows.add(col6);
		rows.add(col7);
		rows.add(col8);
		rows.add(col9);

		// text col
		// col1.setCellRenderer(new
		// DefaultJTextFieldRender(SwingConstants.CENTER));
		// col1.setCellEditor(new DefaultJTextFieldEditor(new JTextField()));
		// //text col
		// col2.setCellRenderer(new
		// DefaultJTextFieldRender(SwingConstants.CENTER));
		// col2.setCellEditor(new DefaultJTextFieldEditor(new JTextField()));
		// combo box col
		String[] values = new String[] { "111", "222", "333" };
		col3.setCellRenderer(new DefaultJComboBoxRender(values));
		col3.setCellEditor(new DefaultJComboBoxEditor(new JComboBox<>(values)));
		// check box col
		col4.setCellRenderer(new DefaultJCheckBoxRenderer());
		col4.setCellEditor(new DefaultJCheckBoxEditor(new JCheckBox()));
		// button col
		col5.setCellRenderer(new DefaultJButtonRender());
		col5.setCellEditor(new DefaultJButtonEditor(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Test");

			}
		}));
		// spinner col
		col6.setCellRenderer(new DefaultJSpinnerRender());
		col6.setCellEditor(new DefaultJSpinnerEditor());
		//
		col7.setCellRenderer(new DefaultDateRender("yyyy/MM/dd HH:mm:ss"));
		col7.setCellEditor(new DefaultDateEditor(new JTextField(),"yyyy/MM/dd HH:mm:ss"));
		//
		col8.setCellRenderer(new DefaultImageIconRender());
		col8.setCellEditor(new DefaultImageIconEditor());
		//
		col9.setCellRenderer(new DefaultProgressCellRenderer(0, 100));
		//
		GTableHeaderColumnGroup group1 = new GTableHeaderColumnGroup("New GroupA");
		GTableHeaderColumnGroup group2 = new GTableHeaderColumnGroup("New GroupA_1");
		GTableHeaderColumnGroup group3 = new GTableHeaderColumnGroup("New GroupA_2");
		group1.add(group2);
		group1.add(group3);
		group2.add(col2);
		group2.add(col3);
		group3.add(col4);
		group3.add(col5);
		group3.add(col6);
		group3.add(col7);
		group3.add(col8);
		List root = new ArrayList<>();
		root.add(group1);

		GTable table = new GTable();
		GTableColumnModel colModelFix = new GTableColumnModel(rows);
		GTableModel tableModel = new GTableModel(colModelFix);
		table.setModel(tableModel);
		table.setColumnModel(colModelFix);
		table.setTableHeaderGroup(root, 3);
		//
	    GTableRowSorter<GTableModel> sorter = new GTableRowSorter<>(tableModel);
	    sorter.setComparators(colModelFix);
	    table.setRowSorter(sorter);

		btnAdd = ComponentFactory.XJButton.create("Mock data", "mock data", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						List rows = new ArrayList();
						MyRow row = new MyRow();
						row.setMark("what are u nong sha lei");
						row.setMoney(new BigDecimal("0.0000"));
						row.setRowNum(new Integer(1));
						row.setjButton("OK");
						row.setCheckBox(false);
						row.setSpinner(new Integer(19));
						row.setUpdateTime(new Date());
						row.setImage(RandomUtils.nextInt(1, 3));
						row.setProgress(RandomUtils.nextInt(1, 100));
						rows.add(row);

						((GTableModel) table.getModel()).addRows(rows);
					}
				});
			}
		});
		btnShowData = ComponentFactory.XJButton.create("Show Data", "show data", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						List allRows = ((GTableModel) table.getModel()).getRows();
						StringBuffer message = new StringBuffer();
						for (Iterator iterator = allRows.iterator(); iterator.hasNext();) {
							MyRow myRow = (MyRow) iterator.next();
							String s = "row num :" + myRow.getRowNum() + ", money:" + myRow.getMoney().toString()
									+ ", combo:" + myRow.getjComboBox() + ", check:" + myRow.getCheckBox()
									+ ", spinner:" + myRow.getSpinner() + ", updatetime:" + myRow.getUpdateTime()
									+ ", status:" + myRow.getImage() + ", progress:" + myRow.getProgress();
							message.append(s).append("\r\n");
						}
						JOptionPane.showMessageDialog(null, message.toString());
					}
				});
			}
		});

		JPanel btnPanel = FormBuilder.create().columns("fill:pref:grow")
				.rows("fill:pref:grow,fill:pref:grow,fill:pref:grow").add(btnAdd).xy(1, 1).add(btnShowData).xy(1, 2)
				.build();

		builder.add(table).xy(1, 1).add(btnPanel).xy(2, 1, "fill,top").build();
	}

	@Override
	protected void binder() {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; i++) {
			System.out.println(RandomUtils.nextInt(0, 3));
		}
	}
}
