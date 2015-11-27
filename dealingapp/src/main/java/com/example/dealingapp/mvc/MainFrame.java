package com.example.dealingapp.mvc;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Constructor;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import com.example.dealingapp.mvc.inner.AbstractInnerFrame;
import com.example.dealingapp.mvc.inner.group.DefaultInnerFrame;
import com.example.dealingapp.mvc.menu.MainMenuBar;
import com.example.dealingapp.mvc.tree.MenuTree;
import com.example.dealingapp.util.WinUtils;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class MainFrame extends JFrame implements ActionListener {

	private MenuTree tree;
	private MainMenuBar mmBar;
	private JSplitPane splitPane;
	private Context context;

	public MainFrame(Context context) {
		this.context = context;
		//
		splitPane = buildSplitPane();
		//
		JPanel mainpanel = FormBuilder.create().debug(context.isDebug()).columns("pref:grow")
				.rows("pref,1dlu,fill:0:grow,1dlu,pref").add(buildMenuBar()).xy(1, 1).add(splitPane).xy(1, 3).add("bar")
				.xy(1, 5).build();
		//
		setLayout(new BorderLayout());
		setContentPane(mainpanel);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	private JSplitPane buildSplitPane() {
		JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, true, buildTreePanel(), buildInnerPanel());
		splitPane.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		splitPane.setOneTouchExpandable (true);
		return splitPane;
	}

	private JComponent buildMenuBar() {
		mmBar = new MainMenuBar(this);
		return mmBar;
	}

	private JComponent buildTreePanel() {
		tree = new MenuTree();
		return FormBuilder.create().debug(context.isDebug()).columns("fill:[50,pref]:grow")
				.rows("1dlu,fill:pref:grow,1dlu").padding(Paddings.EMPTY).addScrolled(tree.getTree()).xy(1, 2).build();
	}

	private JComponent buildInnerPanel() {
		return new DefaultInnerFrame(context);
	}

	public static void main(String[] args) {
		WinUtils.setLAF();
		new MainFrame(new Context(false)).setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Class cls = Class.forName(e.getActionCommand());
					Class[] paramTypes = { Context.class };
					Object[] params = { context };
					Constructor con = cls.getConstructor(paramTypes);
					AbstractInnerFrame aif = (AbstractInnerFrame)con.newInstance(params);
					splitPane.remove(splitPane.getRightComponent());
					splitPane.setRightComponent(aif);;
					splitPane.revalidate();
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		
	}
}
