package com.example.dealingapp.mvc.menu;

import java.awt.Insets;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.example.dealingapp.mvc.MainFrame;
import com.example.dealingapp.util.ComponentFactory;

@SuppressWarnings("serial")
public class MainMenuBar extends JMenuBar {

	public MainMenuBar(MainFrame handler) {

		// table menu
		JMenu mTable = ComponentFactory.XJMenu.create("Table", null, null);
		JMenuItem miTable1 = ComponentFactory.XJMenuItem.create("Tabel 1", "com.example.dealingapp.mvc.inner.table.table1.Table1", handler);
		JMenuItem miTable2 = ComponentFactory.XJMenuItem.create("Tabel 2", "com.example.dealingapp.mvc.inner.table.table2.Table2", handler);
		JMenuItem miTable3 = ComponentFactory.XJMenuItem.create("Tabel 3", "com.example.dealingapp.mvc.inner.table.table3.Table3", handler);
		mTable.add(miTable1);
		mTable.add(miTable2);
		mTable.add(miTable3);

		// group
		JMenu mGroup = ComponentFactory.XJMenu.create("Group", null, null);
		JMenuItem miGroup1 = ComponentFactory.XJMenuItem.create("Group 1", "com.example.dealingapp.mvc.inner.group.group1.Group1", handler);
		JMenuItem miGroup2 = ComponentFactory.XJMenuItem.create("Group 2", "com.example.dealingapp.mvc.inner.group.group2.Group2", handler);
		JMenuItem miGroup3 = ComponentFactory.XJMenuItem.create("Group 3", "com.example.dealingapp.mvc.inner.group.group3.Group3", handler);
		mGroup.add(miGroup1);
		mGroup.add(miGroup2);
		mGroup.add(miGroup3);

		// Tab
		JMenu mTab = ComponentFactory.XJMenu.create("Tab", null, null);
		JMenuItem miTab1 = ComponentFactory.XJMenuItem.create("Tab 1", "com.example.dealingapp.mvc.inner.tab.tab1.Tab1", handler);
		JMenuItem miTab2 = ComponentFactory.XJMenuItem.create("Tab 2", "com.example.dealingapp.mvc.inner.tab.tab2.Tab2", handler);
		JMenuItem miTab3 = ComponentFactory.XJMenuItem.create("Tab 3", "com.example.dealingapp.mvc.inner.tab.tab3.Tab3", handler);
		mTab.add(miTab1);
		mTab.addSeparator();
		mTab.add(miTab2);
		mTab.add(miTab3);
		
		// Chart
		JMenu mChart = ComponentFactory.XJMenu.create("Chart", null, null);
		JMenuItem miChart = ComponentFactory.XJMenuItem.create("Chart 1", "com.example.dealingapp.mvc.inner.chart.chart1.Chart1", handler);
		mChart.add(miChart);

		//
		add(mGroup);
		add(mTab);
		add(mTable);
		add(mChart);

		setMargin(new Insets(10, 10, 10, 10));
	}
}
