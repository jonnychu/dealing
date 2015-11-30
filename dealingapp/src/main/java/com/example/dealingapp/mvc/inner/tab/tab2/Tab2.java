package com.example.dealingapp.mvc.inner.tab.tab2;

import javax.swing.JTextArea;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jidesoft.swing.JideTabbedPane;

@SuppressWarnings("serial")
public class Tab2 extends AbstractInnerFrame {

	public Tab2(Context context) {
		super(context);
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(context.isDebug()).columns("$lcgap,fill:pref:grow,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap").padding(Paddings.EMPTY);
	}

	@Override
	protected void initGUI(FormBuilder builder) {
		JideTabbedPane tabpane = new JideTabbedPane();
		tabpane.addTab("JIDETab", new JTextArea(50, 100));
		builder.add(tabpane).xy(2, 2).build();
	}

	@Override
	protected void binder() {
		
	}

}
