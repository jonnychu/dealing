package com.example.dealingapp;

import javax.swing.SwingUtilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.MainFrame;
import com.example.dealingapp.mvc.login.Login;
import com.example.dealingapp.mvc.login.LoginModel;
import com.example.dealingapp.util.WinUtils;

/**
 * @author jonny
 */
public class Dealing {

	private static final Logger LOGGER = LoggerFactory.getLogger(Dealing.class);
	public static Context context;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	/**
	 * 
	 */
	public void launch() {
		WinUtils.setLAF();

		// 1
		SwingUtilities.invokeLater(new Runnable() {

			@Override
			public void run() {
				//
				MainFrame mainFrame = new MainFrame(context);
				//
				LoginModel model = new LoginModel();
				Login login = new Login(context, model);
				//
				if (model.getResult() == 0) {
					mainFrame.setVisible(true);
				} else {
					mainFrame.dispose();
				}
			}
		});
	}
}
