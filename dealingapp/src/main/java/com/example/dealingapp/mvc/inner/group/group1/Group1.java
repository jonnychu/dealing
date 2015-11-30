package com.example.dealingapp.mvc.inner.group.group1;

import java.awt.Dimension;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXTaskPane;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;
import com.jidesoft.popup.JidePopup;
import com.jidesoft.spinner.DateSpinner;
import com.jidesoft.spinner.PointSpinner;
import com.jidesoft.swing.Calculator;
import com.jidesoft.swing.MarqueePane;

public class Group1 extends AbstractInnerFrame{
	
	private JTextField name;
	private JTextField company;
	private JTextField address;
	
	public Group1(Context context) {
		super(context);
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(context.isDebug())
				.columns("$lcgap,fill:pref:grow,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap,fill:pref,$lcgap,fill:pref,$lcgap")
				.padding(Paddings.EMPTY);
	}

	@Override
	protected void binder() {

	}

	protected void initGUI(FormBuilder builder) {
		name = ComponentFactory.XJTextField.create(10);
		company = ComponentFactory.XJTextField.create(10);
		address = ComponentFactory.XJTextField.create(50);
		
		JPanel group = FormBuilder.create().debug(context.isDebug())
				.padding(Paddings.DLU21)
				.columns("$lcgap,right:pref,$lcgap,left:pref,$lcgap")
				.rows("$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap")
				.border(BorderFactory.createTitledBorder("GROUP1"))
				.add("Name").xy(2, 2)
				.add(name).xy(4, 2)
				.add("Company").xy(2, 4)
				.add(company).xy(4, 4)
				.add("Address").xy(2, 6)
				.add(address).xy(4, 6).build();

		MarqueePane horizonMarqueeLeft = new MarqueePane(new JLabel("This is a test marquee pane , It's JIDE Open Source. This is show long message....")); 
        horizonMarqueeLeft.setPreferredSize(new Dimension(250, 40));
        horizonMarqueeLeft.setScrollDirection(MarqueePane.SCROLL_DIRECTION_RIGHT);
        
        DateSpinner dateSpinner = new DateSpinner("yyyy/MM/dd",new Date());
        PointSpinner pointSpinner = new PointSpinner();
        Calculator cal = new Calculator();
        
		JPanel group2 = FormBuilder.create().debug(context.isDebug())
				.padding(Paddings.DLU21)
				.columns("$lcgap,right:pref,$lcgap")
				.rows("$lcgap,center:pref,$lcgap,center:pref,$lcgap,center:pref,$lcgap")
				.border(BorderFactory.createTitledBorder("GROUP2"))
				.add(horizonMarqueeLeft).xy(2, 2)
				.add(dateSpinner).xy(2, 4)
				.add(cal).xy(2, 6)
				.build();
		
		JXTaskPane taskPane = new JXTaskPane("hello");
		taskPane.add(new JTextArea("Hello taskpane.......................................................\r\n Hohoho!!!"));
		
		JPanel group3 = FormBuilder.create().debug(context.isDebug())
				.padding(Paddings.DLU21)
				.columns("$lcgap,fill:pref,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap,fill:pref,$lcgap,fill:pref,$lcgap")
				.border(BorderFactory.createTitledBorder("GROUP3"))
				.add(taskPane).xy(2, 2)
				.build();
		
		builder.add(group).xy(2, 2).add(group2).xy(2, 4).add(group3).xy(2, 6);
	}
}
