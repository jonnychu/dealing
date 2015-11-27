/*
 * Created by JFormDesigner on Tue Nov 17 15:19:29 CST 2015
 */

package com.example.dealingapp.mvc.plugin.price;

import java.awt.Font;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import com.example.dealingapp.Dealing;
import com.example.dealingapp.res.ResourceManager;
import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;

/**
 * @author jonny
 */
public class Price extends JPanel {

	public Price() {
		initComponents();
	}

	public Price(boolean leftLine) {
		initComponents();
	}

	private void initComponents() {
		// JFormDesigner - Component initialization - DO NOT MODIFY
		// //GEN-BEGIN:initComponents
		label5 = new JLabel();
		label1 = new JLabel();
		label2 = new JLabel();
		label3 = new JLabel();
		label4 = new JLabel();

		//======== this ========
		setLayout(new FormLayout(
			"pref:grow(0.2), pref:grow(0.5), pref:grow(0.3)",
			"2*(fill:pref:grow(0.5))"));

		//---- label5 ----
		label5.setBorder(null);
		add(label5, CC.xy(1, 1));

		//---- label1 ----
		label1.setText("102.");
		label1.setBorder(null);
		label1.setHorizontalAlignment(SwingConstants.RIGHT);
		add(label1, CC.xy(1, 2));

		//---- label2 ----
		label2.setText("21");
		label2.setBorder(null);
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setFont(new Font("\u5b8b\u4f53", Font.PLAIN, 40));
		add(label2, CC.xywh(2, 1, 1, 2));

		//---- label3 ----
		label3.setText("1");
		label3.setBorder(null);
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		add(label3, CC.xy(3, 1));

		//---- label4 ----
		label4.setText("");
		label4.setBorder(null);
		label4.setHorizontalAlignment(SwingConstants.CENTER);
		add(label4, CC.xy(3, 2));
		// //GEN-END:initComponents
	}

	// JFormDesigner - Variables declaration - DO NOT MODIFY
	// //GEN-BEGIN:variables
	private JLabel label5;
	private JLabel label1;
	private JLabel label2;
	private JLabel label3;
	private JLabel label4;
	// JFormDesigner - End of variables declaration //GEN-END:variables

	public void subcribe(CountDownLatch cdl){
		
		ResourceManager rm = new ResourceManager();
		Icon up = rm.getImageIcon(ResourceManager.ImageEnum.ARROW_UP);
		Icon down = rm.getImageIcon(ResourceManager.ImageEnum.ARROW_DOWN);
		Icon empty = new ImageIcon();
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			
			boolean myflag = false;
			@Override
			public void run() {
				try {cdl.await();} catch (InterruptedException e) {}
				int i=0;
				Random r1 = new Random();
				int rr1 = r1.nextInt(100);
				int rr2 = r1.nextInt(40);
				int rr3 = r1.nextInt(10);
				
				while(++i < 1000){
					SwingUtilities.invokeLater(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							label1.setText(String.valueOf(Math.abs(rr1)));//label1.revalidate();
							label2.setText(String.valueOf(Math.abs(rr2)));//label2.revalidate();
							label3.setText(String.valueOf(Math.abs(rr3)));//label3.revalidate();
							if(myflag){
								label4.setIcon(up);
							}else{
								label4.setIcon(down);
							}
							myflag = !myflag;
						}
					});
				}
			}
		}, 1000,1000);
	}
}
