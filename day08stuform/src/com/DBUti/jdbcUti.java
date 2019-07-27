package com.DBUti;

import java.sql.Array;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;



import java.util.*;

import com.mysql.jdbc.PreparedStatement;
import com.stuformBase.Student;
import com.sun.corba.se.spi.orbutil.fsm.Guard.Result;

/*static {
	try {
		// 加载数据库驱动
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
}*/


public class jdbcUti {
	//加载数据库驱动
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//添加学生
	public static void AddStudent(String userName, String gender,
			String age, String birthdate, String phone, String[] hobby) throws SQLException {
		//获取数据库连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8",
				"root",
				"root"
				);
		//设置PrepareStatment对象
		 java.sql.PreparedStatement pstmt =conn.prepareStatement("insert into student(stu_name, gender, birthdate"
				+ ", phone, hobby) values(?, ?, ?, ?, ?) ");
		//设置参数
		 pstmt.setString(1, userName);
		 pstmt.setBoolean(2, true);
		 pstmt.setDate(3, DateUti.getCurrentDate());
		 pstmt.setString(4, phone);
		 pstmt.setString(5, Arrays.toString(hobby));
		//执行excute操作
		 pstmt.execute();
		//关闭连接
		 conn.close();
	}
	
	//查询所有学生
	//该方法返回一个student的string集合
	public static List<Student> selectStudent() throws SQLException{
		//获取数据库连接
		Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost/test?useUnicode=true&characterEncoding=UTF-8",
				"root",
				"root"
				);
		//设置PrepareStatment对象  
		 java.sql.PreparedStatement pstmt =conn.prepareStatement("select * from student ");
		 //执行查找 得到结果对象
		 ResultSet rs = pstmt.executeQuery();
		// 创建List集合保存所有Student对象到students中
		 List<Student> students =new ArrayList<com.stuformBase.Student>();
		 
		 
		 //遍历结果集
			while (rs.next()) { 
				int stuId = rs.getInt("stu_id");
				String stuName = rs.getString("stu_name");
				boolean gender = rs.getBoolean("gender");
				Date birthdate = rs.getDate("birthdate");
				String phone = rs.getString("phone");
				String hobby = rs.getString("hobby");
				// 把学生的信息封装到一个Student对象中
				Student student = new Student(stuId, stuName, gender, birthdate, phone, hobby);
				// 把student对象添加到List集合中
				students.add(student);
			}

			// 关闭资源
			rs.close();
			pstmt.close();
			conn.close();
		return students;
	}
}
