package com.example.dealingapp.mvc.inner.group.group3;

import java.util.Calendar;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerListModel;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class Group3 extends AbstractInnerFrame {
	
	private JTextField name;
	private JTextField company;
	private JTextField address;
	private JSpinner spinner;
	private JSpinner dateEditor;
	private JSpinner numEditor;
	private JSpinner listEditor;
	
	public Group3(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(context.isDebug())
				.columns("$lcgap,fill:pref:grow,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap")
				.padding(Paddings.EMPTY);
	}

	@Override
	protected void binder() {

	}

	@Override
	protected void initGUI(FormBuilder builder) {
		name = ComponentFactory.XJTextField.create(10);
		company = ComponentFactory.XJTextField.create(10);
		address = ComponentFactory.XJTextField.create(50);
		SpinnerModel model = new SpinnerNumberModel(0,-100,100,1);
		spinner = ComponentFactory.XJSpinner.create(model, null);
		
		Calendar rightNow = Calendar.getInstance();
	    Date current = rightNow.getTime();
	    rightNow.set(Calendar.DAY_OF_MONTH, -5);
	    Date start = rightNow.getTime();
	    rightNow.set(Calendar.DAY_OF_MONTH, 100);
	    Date end = rightNow.getTime();

		SpinnerDateModel model2 = new SpinnerDateModel(current,start,end,Calendar.DAY_OF_MONTH);
		dateEditor = ComponentFactory.XJSpinner.createDateEditor(model2, null,"yyyy-MM-dd");
		
		SpinnerNumberModel model3 = new SpinnerNumberModel(0,-10000.00,10000.00,100);
		numEditor = ComponentFactory.XJSpinner.createNumberEditor(model3, null, "###,###,###.##");
		
		SpinnerListModel model4 = new SpinnerListModel(new Object[]{"111","222","333","444","555","666","77788"});
		listEditor = ComponentFactory.XJSpinner.createListEditor(model4, null);
		
		JPanel group = FormBuilder.create().debug(context.isDebug())
				.padding(Paddings.DLU21)
				.columns("$lcgap,right:pref,$lcgap,left:pref,$lcgap")
				.rows("$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap")
				.border(BorderFactory.createTitledBorder("GROUP3"))
				.add("Name").xy(2, 2)
				.add(name).xy(4, 2)
				.add("Company").xy(2, 4)
				.add(company).xy(4, 4)
				.add("Address").xy(2, 6)
				.add(address).xy(4, 6)
				.add("spread").xy(2, 8)
				.add(spinner).xy(4, 8)
				.add("date").xy(2, 10)
				.add(dateEditor).xy(4, 10)
				.add("number").xy(2, 12)
				.add(numEditor).xy(4, 12)
				.add("list").xy(2, 14)
				.add(listEditor).xy(4, 14)
				.build();

		builder.add(group).xy(2, 2);
	}
}
