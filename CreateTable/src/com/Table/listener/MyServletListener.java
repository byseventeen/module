package com.Table.listener;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.CreateTable.base.Employee;
import com.sun.java.util.*;

public class MyServletListener implements ServletContextListener {
	static {
		try {
			// 加载数据库驱动
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void contextInitialized(ServletContextEvent sec) {

		System.out.println("ServletContext对象被创建了..");
		String path = "com.CreateTable.base.Employee";
		try {
			//获取类对象
			Class employee = Class.forName(path);
			//通过Class对象分别获取类名和属性信息     获取完整类名
			String strName01 = employee.getName();
			//获取实体类的所有属性信息，返回Field数组  
			Field[] field02 = employee.getDeclaredFields();
			//集合的Key代表属性名，Value代表属性类型
			 Map<String, String> map = new HashMap<String,String>();
			 
			for (Field field : field02) {
				//获取属性名字
				map.put("name", field.getName());
				//获取属性类型
				map.put("type", field.getType().toString()); 
				System.out.println(field.getType()); 
			}
			//通过JDBC创建表，表的名字就是类的名字（小写），表字段的名字就是属性名字（小写），字段类型可以根据属性类型进行动态指定。
			  
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sec) {	
		System.out.println("ServletContext对象被销毁了..");
	}

}
