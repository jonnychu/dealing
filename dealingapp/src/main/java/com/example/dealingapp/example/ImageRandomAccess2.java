package com.example.dealingapp.example;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.UIManager;

public class ImageRandomAccess2 implements ActionListener {
	final static int NUM_IMAGES = 8;// 显示的图片总数
	final static int START_INDEX = 3;// 初始化的时候默认显示的图片
	ImageIcon[] images = new ImageIcon[NUM_IMAGES];// 初始化数组
	JPanel mainPanel, selectPanel, displayPanel;// 三个面板
	JLabel selectLabel = null;
	JComboBox combobox = null;// 控制显示有哪些图片，非随即滚动
	JButton controlBtn = null;
	JLabel imageIconLabel = null; // Constructor

	public ImageRandomAccess2() { // Create the phase selection and display
									// panels.
		selectPanel = new JPanel();
		displayPanel = new JPanel(); // Add various widgets to the sub panels.
		addWidgets(); // Create the main panel to contain the two sub panels.
		mainPanel = new JPanel();
		mainPanel.setLayout(new GridLayout(2, 1, 5, 5));
		mainPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5)); // Add
																			// the
																			// select
																			// and
																			// display
																			// panels
																			// to
																			// the
																			// main
																			// panel.
		mainPanel.add(selectPanel);
		mainPanel.add(displayPanel);
	}
	// Create and the widgets to select and display the images of peoples.

	private void addWidgets() { // Get the images and put them into an array of
								// ImageIcon.
		for (int i = 0; i < NUM_IMAGES; i++) {
			String imageName = "images/" + (i + 1) + ".jpg";
			System.out.println("getting image: " + imageName); //
			URL iconURL = ClassLoader.getSystemResource(imageName);
			ImageIcon icon = new ImageIcon(imageName);
			images[i] = icon;
		} // Create label for displaying images and put a border around // it.
		imageIconLabel = new JLabel();
		imageIconLabel.setHorizontalAlignment(JLabel.CENTER);
		imageIconLabel.setVerticalAlignment(JLabel.CENTER);
		imageIconLabel.setVerticalTextPosition(JLabel.CENTER);
		imageIconLabel.setHorizontalTextPosition(JLabel.CENTER);
		imageIconLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createLoweredBevelBorder(),
				BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		imageIconLabel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createEmptyBorder(0, 0, 10, 0),
				imageIconLabel.getBorder()));
		controlBtn = new JButton("无图片");
		selectLabel = new JLabel("选择图片");
		combobox = new JComboBox();
		for (int i = 0; i < NUM_IMAGES; i++) {
			combobox.addItem(i);
		}
		selectLabel.setLabelFor(combobox); // Display the first image.
		imageIconLabel.setIcon(images[START_INDEX]);
		imageIconLabel.setText(""); // Add border around the select panel.
		selectPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Select Phase"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Add border
																// around the
																// display
																// panel.
		displayPanel.setBorder(BorderFactory.createCompoundBorder(BorderFactory.createTitledBorder("Display Phase"),
				BorderFactory.createEmptyBorder(5, 5, 5, 5))); // Add control
																// button to
																// select panel
																// and image
																// label to //
																// displayPanel.
		selectPanel.add(selectLabel);
		selectPanel.add(combobox);
		selectPanel.add(controlBtn);
		displayPanel.add(imageIconLabel); // Listen to events from control
											// button. //
		controlBtn.addActionListener(this);
		combobox.addActionListener(this);
		controlBtn.addActionListener(this);
	}

	boolean run = false; // Implementation of ActionListener interface.

	public void actionPerformed(ActionEvent event) {
		if (event.getSource() == combobox) {
			int imageIndex = combobox.getSelectedIndex();
			imageIconLabel.setIcon(images[imageIndex]);
		}
		if (event.getSource() == controlBtn) {
			System.out.println("------------");
			imageIconLabel.setIcon(null); //
			imageIconLabel.setIcon(new ImageIcon());
		}
	} // main method

	public static void main(String[] args) { // create a new instance of
												// ImageRandomAccess
		ImageRandomAccess2 phases = new ImageRandomAccess2(); // Create a frame
																// and container
																// for the
																// panels.
		JFrame mainFrame = new JFrame("ImangeRandomAccess"); // Set the look and
																// feel.
		try {
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
		}
		mainFrame.setContentPane(phases.mainPanel); // Exit when the window is
													// closed.
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Show the
																	// converter.
		mainFrame.pack();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
	}
}