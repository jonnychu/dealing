package com.example.dealingapp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DealingStartup {
	
	private static final String[] configs = new String[] {"classpath:startup-dealing-app.xml"};
	
	public static void main(String[] args) {
		ApplicationContext appContext = new ClassPathXmlApplicationContext(configs);
	}
}
