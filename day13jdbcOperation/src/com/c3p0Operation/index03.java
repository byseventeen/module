package com.c3p0Operation;

import java.beans.PropertyVetoException;
import java.security.spec.DSAGenParameterSpec;
import java.sql.Connection;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class index03 {
	public static void main(String[] args) throws PropertyVetoException, SQLException {
		ComboPooledDataSource ds=new ComboPooledDataSource();
		/*// 配置数据库信息 
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/test");
		ds.setUser("root");
		ds.setPassword("root");
		// 配置连接池参数
		ds.setInitialPoolSize(3);
		ds.setMaxPoolSize(5);
		ds.setMinPoolSize(3);
		ds.setAcquireIncrement(1);
		ds.setCheckoutTimeout(5000);*/
		
		//Connection conn=ds.getConnection();
		//理解为jdbc connection的代理来的，创建了一个connection然后继承他并且实现getconnection方法
		for (int i = 0; i < 5; i++) {
			Connection conn=ds.getConnection();
			System.out.println(conn);
			
			if (i==3) {
				//把当前连接释放到连接池中
				conn.close();
			}
		}
		ds.getConnection();
	}

}
