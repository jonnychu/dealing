/*
 * Created by JFormDesigner on Tue Nov 17 15:03:59 CST 2015
 */

package com.example.dealingapp.mvc.plugin.price;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import com.jgoodies.forms.factories.*;
import com.jgoodies.forms.layout.*;

/**
 * @author jonny
 */
@SuppressWarnings("serial")
public class PriceHeader extends JPanel {
	public PriceHeader() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();

		//======== this ========
		setLayout(new FormLayout(
			"2*(pref:grow(0.5))",
			"2*(fill:pref:grow(0.5))"));

		//---- label1 ----
		label1.setText("Base Rate");
		label1.setHorizontalTextPosition(SwingConstants.CENTER);
		label1.setBorder(new MatteBorder(1, 1, 1, 1, Color.gray));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label1, CC.xywh(1, 1, 2, 1, CC.FILL, CC.FILL));

		//---- label2 ----
		label2.setText("BID");
		label2.setBorder(new MatteBorder(0, 1, 1, 1, Color.gray));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label2, CC.xy(1, 2));

		//---- label3 ----
		label3.setText("ASK");
		label3.setBorder(new MatteBorder(0, 0, 1, 1, Color.gray));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label3, CC.xy(2, 2));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
