package com.example.dealingapp.mvc.login;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.Random;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.res.ResourceManager;
import com.example.dealingapp.util.WinUtils;
import com.jgoodies.binding.binder.BeanBinder;
import com.jgoodies.binding.binder.Binders;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.factories.Paddings;

public class Login extends JDialog {

	private static final Logger LOGGER = LoggerFactory.getLogger(Login.class);
	
	private LoginModel model;
	private Context context;
    private JTextField username;
    private JPasswordField password;
    private JCheckBox remember;
    private JButton btnLogin;
    private JButton btnCancel;
    
	/**
	 * Create the dialog.
	 */
	public Login(Context context,LoginModel model) {
		this.context = context;
		this.model = model;
		initGUI();
	}
	
	private void initGUI(){
		//
		username = new JTextField(8);
		password = new JPasswordField(8);
		remember = new JCheckBox("rmb");
		btnLogin = new JButton("Login");
		btnCancel = new JButton("Cancel");
		PrgBar bar = new PrgBar(1,100);
		bar.setVisible(false);
		//
		btnLogin.setActionCommand("start");
		btnLogin.addActionListener(bar);
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.this.dispose();
			}
		});
		
		//
		initBindings();
		
		Icon icon = context.getResourceManager().getImageIcon(ResourceManager.ImageEnum.IMAGE_SPLASH);
		//
		JComponent panel = FormBuilder.create().debug(context.isDebug())
		.columns("$lcgap,right:min, $lcgap, left:pref:grow, $lcgap, right:min, $lcgap, left:pref:grow ,$lcgap, 50dlu,$lcgap, 45dlu,$lcgap, 45dlu,$lcgap")
		.rows("pref:grow, $lg, min,$lg, pref")
		.padding(Paddings.EMPTY)
		.add(icon)					.xywh(1, 1, 15, 2)
        .add("UserName:")			.xy (2,  3)
        .add(username)				.xy (4,  3)
        .add("Password:")			.xy (6,  3)
        .add(password)				.xy (8,  3)
        .add(remember)				.xy (10,  3)
        .add(btnLogin)				.xy (12,  3)
        .add(btnCancel)				.xy (14,  3)
        .add(bar)					.xyw(1, 5, 15)
		.build();
		
		//
		setContentPane(panel);
		setSize(650, 400);
		WinUtils.windowCentral(this);
		setResizable(true);
//		setUndecorated(true);
		setModal(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setVisible(true);
	}
	
	protected void initBindings() {
		BeanBinder binder = Binders.binderFor(this.model);
		binder.bindProperty(LoginModel.PROPERTY_USERNAME).to(this.username);
		binder.bindProperty(LoginModel.PROPERTY_PASSWORD).to(this.password);
		binder.bindProperty(LoginModel.PROPERTY_REMEMBER_PASSWORD).to(this.remember);
	}
	
	private class PrgBar extends JProgressBar implements ActionListener, PropertyChangeListener {

		private Task task;

		class Task extends SwingWorker<Void, Void> {
			/*
			 * Main task. Executed in background thread.
			 */
			@Override
			public Void doInBackground() {
				try {
					Random random = new Random();
					int progress = 0;
					// Initialize progress property.
					setProgress(getMinimum());
					// Sleep for at least one second to simulate "startup".

					Thread.sleep(1000 + random.nextInt(2000));

					while (progress < getMaximum()) {
						// Make random progress.
						progress += random.nextInt(10);
						setProgress(Math.min(progress, 100));
						// Sleep for up to one second.
						try {
							Thread.sleep(random.nextInt(1000));
						} catch (InterruptedException ignore) {
						}
					}
				} catch (InterruptedException ignore) {
					Login.this.model.setResult(-1);
				}
				return null;
			}

			/*
			 * Executed in event dispatch thread
			 */
			public void done() {
				Toolkit.getDefaultToolkit().beep();
				Login.this.model.setResult(0);
				Login.this.dispose();
			}
		}

		public PrgBar(int min,int max) {
			super(min,max);
			setOpaque(true);
			setValue(min);
			setStringPainted(true);
			setBorderPainted(true);
		}

		/**
		 * Invoked when the user presses the start button.
		 */
		public void actionPerformed(ActionEvent evt) {
			setIndeterminate(true);
			btnLogin.setEnabled(false);
			setVisible(true);
			//
			task = new Task();
			task.addPropertyChangeListener(this);
			task.execute();
		}

		/**
		 * Invoked when task's progress property changes.
		 */
		public void propertyChange(PropertyChangeEvent evt) {
			if ("progress" == evt.getPropertyName()) {
				int progress = (Integer) evt.getNewValue();
				setIndeterminate(false);
				setValue(progress);
			}
		}
	}
}
