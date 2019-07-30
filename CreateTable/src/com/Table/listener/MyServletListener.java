package com.Table.listener;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.CreateTable.base.Employee;
import com.chinasofti.stumgr.utils.DateUtil;
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
			String employeer = employee.getName();
			//获取实体类的所有属性信息，返回Field数组  
			Field[] field02 = employee.getDeclaredFields();
			//集合的Key代表属性名，Value代表属性类型
			 Map<String, String> map = new HashMap<String,String>();
			 
			for (Field field : field02) {
				//获取属性名字
				String propertyName= field.getName().toString();
				map.put("name", propertyName);
				//获取属性类型
				String propertyType=field.getType().toString();
				map.put("type", propertyType); 
				System.out.println(field.getType()); 
				
				// 获取数据库连接
				Connection conn = DriverManager.getConnection(
						"jdbc:mysql://localhost:3306/aa", 
						"root", 
						"root");
				// 创建PreparedStatement对象
				PreparedStatement pstmt = conn.prepareStatement("insert into employeer(stu_name, gender, birthdate"
						+ ", phone, hobby) values(?, ?, ?, ?, ?)");
				// 设置参数
				pstmt.setString(1, userName);
				pstmt.setBoolean(2, true);
				pstmt.setDate(3, DateUtil.getCurrentDate());
				pstmt.setString(4, phone);
				pstmt.setString(5, Arrays.toString(hobby));
				// 执行execute操作 
				pstmt.execute();
				// 关闭连接
				conn.close();
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
