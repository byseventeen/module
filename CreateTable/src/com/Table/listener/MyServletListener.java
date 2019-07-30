package com.Table.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyServletListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sec) {
		System.out.println("ServletContext对象被创建了..");
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {
		System.out.println("ServletContext对象被销毁了..");

	}

}
