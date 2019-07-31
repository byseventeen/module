package com.Table.listener;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	
			//获取类对象，通过Class对象分别获取类名和属性信息
			Class employee;
			try {
				employee = Class.forName(path);
				String employeer = employee.getSimpleName();
				//获取实体类的所有属性信息，返回Field数组  
				Field[] field02 = employee.getDeclaredFields();
				//集合的Key代表属性名，Value代表属性类型
				 Map<String, Class> map = new HashMap<String,Class>();

				for (Field field : field02) {
					String propertyName= field.getName().toString();
					Class propertyType=field.getType();
					map.put(propertyName, propertyType); 
				}						
				createTable(employeer, map);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}     

	}
	
	public void createTable(String employeer,  Map<String, Class> map) throws SQLException{
		//通过JDBC创建表，表的名字就是类的名字（小写），表字段的名字就是属性名字（小写），字段类型可以根据属性类型进行动态指定。
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test", 
				"root", 
				"root");
		StringBuilder sql=new StringBuilder();			 
		
		sql.append("create table ");
		sql.append(" ");
		sql.append(employeer.toLowerCase());
		sql.append("(");
		for (Map.Entry<String, Class> entry:  map.entrySet()) {
			String name=entry.getKey();
			Class type=entry.getValue();
			sql.append(name);
			sql.append(" ");
			if (type==Integer.class) {
				sql.append("int,");
			}
			if (type==String.class) {
				sql.append("varchar(255),");
			}		
		}
		// 删除最后字段的逗号
		sql.deleteCharAt(sql.length() - 1);
		sql.append(")");
		// 创建Statement对象
		PreparedStatement pstmt = conn.prepareStatement(sql.toString());
		// 执行sql
		pstmt.execute();		
		pstmt.close();
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sec) {	
		System.out.println("ServletContext对象被销毁了..");
	}

}
