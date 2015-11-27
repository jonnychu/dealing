package com.example.dealingapp.mvc;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import com.example.dealingapp.res.ResourceManager;

public class Context implements ApplicationContextAware{
	
	private boolean debug;
	private ApplicationContext appContext;
	private ResourceManager resourceManager;
	//operator
	//company
	
	public Context() {
		this(false);
	}
	
	public Context(boolean debug) {
		this(new ResourceManager(), debug);
	}

	public Context(ResourceManager resManager,boolean debug) {
		this.resourceManager = resManager;
		this.debug = debug;
	}
	

	public boolean isDebug() {
		return debug;
	}

	public void setDebug(boolean debug) {
		this.debug = debug;
	}

	public ResourceManager getResourceManager() {
		return resourceManager;
	}

	public void setResourceManager(ResourceManager resourceManager) {
		this.resourceManager = resourceManager;
	}

	public ApplicationContext getAppContext() {
		return appContext;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appContext = applicationContext;
	}
}
