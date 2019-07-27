package com.stuformServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUti.jdbcUti;
import com.stuformBase.Student;

/**
 * Servlet implementation class listStudentServlet
 */
@WebServlet("/listStudentServlet")
public class listStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * get处理
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		try {
			//获得保存数组的list
		   List<Student> students=jdbcUti.selectStudent();
		   //遍历结果集
		   for (Student student : students) {
			response.getWriter().write(student.toString()+ "<br/>");
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



}
