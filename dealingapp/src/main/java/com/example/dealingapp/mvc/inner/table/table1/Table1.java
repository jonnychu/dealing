package com.example.dealingapp.mvc.inner.table.table1;

import javax.swing.JTable;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class Table1 extends AbstractInnerFrame {

	private JTable table;
	private DefaultTableModel tModel;
	private DefaultTableColumnModel tColModel;

	public Table1(Context context) {
		super(context);
	}

	private static final long serialVersionUID = 1L;

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(context.isDebug()).columns("$lcgap,fill:pref:grow,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap").padding(Paddings.EMPTY);
	}

	@Override
	protected void initGUI(FormBuilder builder) {
		String[] header = new String[] { "name", "age", "sex", "color", "school" };
		this.table = ComponentFactory.XJTable.create(tModel = new DefaultTableModel(),
				tColModel = new DefaultTableColumnModel(), null);
		this.tModel.setDataVector(null, header);
		builder.add(table).xy(2, 2).build();
	}

	@Override
	protected void binder() {
		// TODO Auto-generated method stub

	}

}
