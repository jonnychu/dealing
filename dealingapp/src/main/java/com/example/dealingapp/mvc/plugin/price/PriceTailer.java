/*
 * Created by JFormDesigner on Tue Nov 17 15:35:17 CST 2015
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
public class PriceTailer extends JPanel {
	public PriceTailer() {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY  //GEN-BEGIN:initComponents
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();

		//======== this ========
		setLayout(new FormLayout(
			"3*(fill:pref:grow(0.11)), 2*(fill:pref:grow(0.17)), 3*(fill:pref:grow(0.11))",
			"fill:pref:grow"));

		//---- label1 ----
		label1.setText("21:38:22");
		label1.setBorder(new MatteBorder(0, 1, 1, 0, Color.gray));
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		add(label1, CC.xywh(1, 1, 3, 1));

		//---- label2 ----
		label2.setText("0.8");
		label2.setBorder(new MatteBorder(0, 0, 1, 0, Color.gray));
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		add(label2, CC.xywh(4, 1, 2, 1));

		//---- label3 ----
		label3.setText("21:38:33");
		label3.setBorder(new MatteBorder(0, 0, 1, 1, Color.gray));
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label3, CC.xywh(6, 1, 3, 1));
		// JFormDesigner - End of component initialization  //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY  //GEN-BEGIN:variables
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	// JFormDesigner - End of variables declaration  //GEN-END:variables
}
