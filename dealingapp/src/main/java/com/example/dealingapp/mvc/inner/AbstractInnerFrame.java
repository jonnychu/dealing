package com.example.dealingapp.mvc.inner;

import java.awt.BorderLayout;

import javax.swing.JPanel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.example.dealingapp.mvc.Context;
import com.example.dealingapp.mvc.login.Login;
import com.jgoodies.forms.builder.FormBuilder;

public abstract class AbstractInnerFrame extends JPanel{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractInnerFrame.class);
	
	protected Context context;
	
	protected abstract FormBuilder getLayoutBuilder();
	protected abstract void initGUI(FormBuilder builder);
	protected abstract void binder();
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AbstractInnerFrame(Context context){
		this.setLayout(new BorderLayout());
		this.context = context;
		FormBuilder builder = getLayoutBuilder();
		if(builder == null){
			this.LOGGER.error("can not find subclass builder");
			return;
		}
		initGUI(builder);
		add(builder.build());
	}
	
}
