package day13jdbcOperation;

import java.awt.image.RescaleOp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.naming.spi.DirStateFactory.Result;

public class index01 {
	static{
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		//int[] Ids={3,4};
		//indexDelete(Ids);
		//index2Delete(6);
		//update(1, "micky");
		//indexQuery();
		indexAdd();
 	}
	
	private static void  indexDelete(int[] stuIds) {
		//批量删除
		try(
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test",
					"root",
					"root"
					);
			PreparedStatement pstmt=conn.prepareStatement(
					" delete from student where stu_id=?");
				) {
					for (int id : stuIds) {
						pstmt.setInt(1, id);
						pstmt.addBatch();
					}
					pstmt.executeBatch();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void  index2Delete(int stuIds) {
		//删除
		try(
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test",
					"root",
					"root"
					);
			PreparedStatement pstmt=conn.prepareStatement(
					" delete from student where stu_id=?");
				) {

					pstmt.setInt(1, stuIds);				
					pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void  update(int stuIds, String name) {
		//修改
		try(
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test",
					"root",
					"root"
					);
			PreparedStatement pstmt=conn.prepareStatement(
					" update student set stu_name=? where stu_id=?");
				) {

					pstmt.setInt(2, stuIds);
					pstmt.setString(1, name);
					pstmt.execute();			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void  indexQuery() {
		//修改
		try(
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test",
					"root",
					"root"
					);
			PreparedStatement pstmt=conn.prepareStatement(
					" select * from student");
				//执行查询
				ResultSet rs=pstmt.executeQuery();
				) {

					while (rs.next()) {
						int stuId = rs.getInt("stu_id");
						String stuName = rs.getString("stu_name");
						boolean gender = rs.getBoolean("gender");
						Date birthdate = rs.getDate("birthdate");
						String phone = rs.getString("phone");
						String hobby = rs.getString("hobby");
						System.out.println(stuId + ", " + stuName + ", "
							+ gender + "," + birthdate + "," + phone + "," + hobby);						
					}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static void  indexAdd() {
		//修改
		try(
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/test",
					"root",
					"root"
					);
			PreparedStatement pstmt=conn.prepareStatement(
					" insert into student(stu_name, gender, birthdate, phone, hobby) values(?, ?, ?, ?, ?)");
				) {
					// 设置sql的参数
					pstmt.setString(1, "su");
					pstmt.setBoolean(2, true);
					pstmt.setDate(3, new java.sql.Date(new java.util.Date().getTime()));
					pstmt.setString(4, "3333");
					pstmt.setString(5, "吃,喝");	
					
					pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
}
