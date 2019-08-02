package com.DbUtil;

import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class Dbutil {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void AddStudent(String bookName, String bookAuthor,
			String price, String amount) throws SQLException {
		 QueryRunner qr =new QueryRunner(new ComboPooledDataSource());
		 
		String sql = "insert into books(bookName, author, price, amount) values(?, ?, ?, ?)";
		qr.update(sql, new Object[]{bookName, bookAuthor, price, amount});	
		
	}

}
