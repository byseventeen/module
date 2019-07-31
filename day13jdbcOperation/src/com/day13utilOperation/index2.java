package com.day13utilOperation;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class index2 {
	//创建一遍之后就不需要再重复创建
	static QueryRunner qr =new QueryRunner(new ComboPooledDataSource());
	public static void main(String[] args) throws SQLException {
		//getTotalOfEmployee();
		addEmployee();
		//queryEmployeeById(110);
		//queryEmployees();
		//updateEmployee();
		//deleteEmployee();
		
	}
	
	//统计表里面的总记录数
	public static void getTotalOfEmployee() throws SQLException{
		String sql="select count(*) from employee";
		Object o=qr.query(sql, new ScalarHandler());
		System.out.println("结果总数："+o);
	}
	
	//查询所有
	public static void queryEmployee() throws SQLException {
		String sql="select * from employee";
		Object o=qr.query(sql, new BeanListHandler(Employee.class));
		if (o!=null) {
			List<Employee> emplist=(List<Employee>) o;
			for (Employee employee : emplist) {
				System.out.println(employee);
			}
		}
	}
	
	//根据id查询
	public static void queryEmployeeById(int id) throws SQLException {
		String sql="select * from employee where id=?";
		Object o=qr.query(sql, new BeanHandler(Employee.class), new Object[]{110});
		if (o!=null) {
				Employee emp=(Employee) o;
				System.out.println(emp);			
		}
	}
	
	private static void deleteEmployee() throws SQLException {
		/*
		 * 调用方法
		 * 	update()：执行添加、删除、修改操作
		 *  query()：执行查询操作
		 */
		String sql = "delete from employee where id = ?";
		qr.update(sql, 220);
	}
	
	private static void updateEmployee() throws SQLException {
		/*
		 * 调用方法
		 * 	update()：执行添加、删除、修改操作
		 *  query()：执行查询操作
		 */
		String sql = "update employee set name = ? where id = ?";
		qr.update(sql, new Object[]{"micky", 221});
	}

	private static void addEmployee() throws SQLException {
		/*
		 * 调用方法
		 * 	update()：执行添加、删除、修改操作
		 *  query()：执行查询操作
		 */
		String sql = "insert into employee(id, name, dept, job) values(?, ?, ?, ?)";
		qr.update(sql, new Object[]{220, "lucy", "行政部", "行政主管"});
	}
}
