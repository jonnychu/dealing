package com.example.dealingapp.mvc.inner.tab.tab1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.mvc.plugin.price.PricePanel;
import com.example.dealingapp.util.ComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class Tab1 extends AbstractInnerFrame {

	private JTabbedPane tabbedPane;
	private JButton btnStart;
	
	public Tab1(Context context) {
		super(context);
	}

	@Override
	protected FormBuilder getLayoutBuilder() {
		return FormBuilder.create().debug(context.isDebug()).columns("$lcgap,fill:pref:grow,$lcgap")
				.rows("$lcgap,fill:pref,$lcgap").padding(Paddings.EMPTY);
	}

	@Override
	protected void initGUI(FormBuilder builder) {
		//
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		//
		List<PricePanel> allPrice = new LinkedList<>();
		int col = 5;
		int row = 6;
		FormBuilder price = FormBuilder.create().columns(col+"*(pref:grow(0.2))").rows(row+"*(pref:grow(0.1))");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				PricePanel pp = new PricePanel();
				allPrice.add(pp);
				price.add(pp).xy(i+1, j+1);
			}
		}
		
		btnStart = ComponentFactory.XJButton.create("Start", "start", new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				CountDownLatch cdl = new CountDownLatch(col*row);
				for (PricePanel pricePanel : allPrice) {
					pricePanel.getPrice1().subcribe(cdl);
					cdl.countDown();
					pricePanel.getPrice2().subcribe(cdl);
					cdl.countDown();
				}
			}
		});
		
		JPanel tabbedPanel = FormBuilder.create()
				.columns("fill:pref:grow,60dlu")
				.rows("20dlu,20dlu,fill:pref:grow")
				.add(price.build()).xywh(1, 1, 1, 3).add(btnStart).xy(2, 1).build();
		
		tabbedPane.addTab("price", tabbedPanel);
		tabbedPane.addTab("trade", new JLabel("A"));
		
		builder.add(tabbedPane).xy(2, 2).build();
	}

	@Override
	protected void binder() {
		
	}

}
