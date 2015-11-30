package com.example.dealingapp.mvc.inner.group.group2;

import java.util.ArrayList;
import java.util.List;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.mvc.plugin.ListGroupBuilderView;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

@SuppressWarnings("serial")
public class Group2 extends AbstractInnerFrame{
	
	private ListGroupBuilderView group;
	
	public Group2(Context context) {
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
		group = new ListGroupBuilderView("Your Group", "Display", "Hide", true, 120, 60, 20);
		
		builder.add(group).xy(2, 2);
		
		loadData();
	}

	protected void loadData() {
		List<String> l = new ArrayList<>();
		l.add("ShangHai");
		l.add("TaiWan");
		l.add("BeiJing");
		l.add("DaLian");
		l.add("TianJing");
		l.add("HuNan");
		l.add("GuiZhou");
		l.add("HaerBin");
		l.add("ShenYang");
		l.add("ChangChun");
		
		group.loadData(l, null);
	}
}
