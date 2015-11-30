/*
 * Created by JFormDesigner on Tue Nov 17 15:29:34 CST 2015
 */

package com.example.dealingapp.mvc.plugin.price;

import java.awt.Color;
import java.awt.ScrollPane;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.MatteBorder;

import com.example.dealingapp.util.WinUtils;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author jonny
 */
@SuppressWarnings("serial")
public class PricePanel extends JPanel {
	public PricePanel() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		priceHeader1 = new PriceHeader();
		price1 = new Price();
		price1.setBorder(new MatteBorder(0, 1, 1, 1, Color.gray));
		price2 = new Price();
		price2.setBorder(new MatteBorder(0, 0, 1, 1, Color.gray));
		priceTailer1 = new PriceTailer();

		//======== this ========
		setLayout(new FormLayout(
			"2*(60:grow(0.5))",
			"2*(fill:pref:grow(0.3)), fill:pref:grow(0.4)"));
		add(priceHeader1, CC.xywh(1, 1, 2, 1));
		add(price1, CC.xy(1, 2));
		add(price2, CC.xy(2, 2));
		add(priceTailer1, CC.xywh(1, 3, 2, 1));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private PriceHeader priceHeader1;
	private Price price1;
	private Price price2;
	private PriceTailer priceTailer1;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
	
	
	public static void main(String[] args) {
		WinUtils.setLAF();
		JFrame f = new JFrame("");
		
		List<PricePanel> allPrice = new LinkedList<>();
		int col = 5;
		int row = 6;
		FormBuilder builder = FormBuilder.create().columns(col+"*(pref:grow(0.2))").rows(row+"*(pref:grow(0.1))");
		for (int i = 0; i < col; i++) {
			for (int j = 0; j < row; j++) {
				PricePanel pp = new PricePanel();
				allPrice.add(pp);
				builder.add(pp).xy(i+1, j+1);
			}
		}
		JPanel group = builder.build();
		ScrollPane root = new ScrollPane();
		root.add(group);
		f.add(root);
		f.setExtendedState(JFrame.MAXIMIZED_BOTH);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.pack();
		f.setVisible(true);
		
		CountDownLatch cdl = new CountDownLatch(col*row);
		for (PricePanel pricePanel : allPrice) {
			pricePanel.getPrice1().subcribe(cdl);
			cdl.countDown();
			pricePanel.getPrice2().subcribe(cdl);
			cdl.countDown();
		}
	}

	public Price getPrice1() {
		return price1;
	}

	public void setPrice1(Price price1) {
		this.price1 = price1;
	}

	public Price getPrice2() {
		return price2;
	}

	public void setPrice2(Price price2) {
		this.price2 = price2;
	}

	public PriceTailer getPriceTailer1() {
		return priceTailer1;
	}

	public void setPriceTailer1(PriceTailer priceTailer1) {
		this.priceTailer1 = priceTailer1;
	}
}
