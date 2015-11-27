package com.example.dealingapp.mvc.tree;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;

import com.jgoodies.looks.Options;

public class MenuTree {

	private JTree tree;
	
	public MenuTree() {
		//
		this.tree = new JTree(getRootData());
		this.tree.putClientProperty(Options.TREE_LINE_STYLE_KEY,Options.TREE_LINE_STYLE_NONE_VALUE);
//		this.tree.setCellRenderer(new TreeCellRenderer());
		this.tree.setOpaque(false);
		this.tree.setRootVisible(false);
		this.tree.setShowsRootHandles(true);
	}
	
	private DefaultMutableTreeNode getRootData(){
		DefaultMutableTreeNode root = new DefaultMutableTreeNode();
		
		DefaultMutableTreeNode d1_1 = new DefaultMutableTreeNode("Deep1_1");
		DefaultMutableTreeNode d1_2 = new DefaultMutableTreeNode("Deep1_2");
		DefaultMutableTreeNode d1_3 = new DefaultMutableTreeNode("Deep1_3");
		
		DefaultMutableTreeNode d2_1 = new DefaultMutableTreeNode("Deep2_1");
		DefaultMutableTreeNode d2_2 = new DefaultMutableTreeNode("Deep2_2");
		DefaultMutableTreeNode d2_3 = new DefaultMutableTreeNode("Deep2_3");
		
		d1_1.add(d2_1);
		d1_2.add(d2_2);
		d1_3.add(d2_3);
		root.add(d1_1);
		root.add(d1_2);
		root.add(d1_3);
		
		return root;
	}
	
	private static final class TreeCellRenderer extends DefaultTreeCellRenderer {

		private static final Color NON_SELECTION_BACKGROUND = Color.WHITE;

		public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
				boolean leaf, int row, boolean focus) {
			super.getTreeCellRendererComponent(tree, value, this.selected, expanded, false, row, focus);

			DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
			setForeground(sel ? getTextSelectionColor() : Color.WHITE);

			setBackgroundNonSelectionColor(NON_SELECTION_BACKGROUND);
			this.selected = sel;

			return this;
		}
	}

	public JTree getTree() {
		return tree;
	}

	public void setTree(JTree tree) {
		this.tree = tree;
	}
}
