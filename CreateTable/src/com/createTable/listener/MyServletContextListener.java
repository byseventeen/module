package com.createTable.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.createTable.entity.Employee;

public class MyServletContextListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent arg0) {
		// 监听器加载的时候执行的方法
		
		//获取Employee类的Class对象
		  Class employee = Employee.class;
		  employee.getDeclaredFields();

	}
	
	public void contextDestroyed(ServletContextEvent arg0) {
		// TODO Auto-generated method stub

	}



}
