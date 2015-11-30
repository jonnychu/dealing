package com.example.dealingapp.mvc.inner.group;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

@SuppressWarnings("serial")
public class DefaultInnerFrame extends AbstractInnerFrame {

	private JTextField name;
	private JTextField company;
	private JTextField address;
	
	public DefaultInnerFrame(Context context) {
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
		
		JPanel group = FormBuilder.create().debug(context.isDebug())
				.padding(Paddings.DLU21)
				.columns("$lcgap,right:pref,$lcgap,left:pref,$lcgap")
				.rows("$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap")
				.border(BorderFactory.createTitledBorder("GROUP Dafult"))
				.add("Name").xy(2, 2)
				.add(name).xy(4, 2)
				.add("Company").xy(2, 4)
				.add(company).xy(4, 4)
				.add("Address").xy(2, 6)
				.add(address).xy(4, 6).build();

		builder.add(group).xy(2, 2);
	}
}
