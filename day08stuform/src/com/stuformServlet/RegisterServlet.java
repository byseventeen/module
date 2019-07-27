package com.stuformServlet;


import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DBUti.jdbcUti;

import sun.awt.RepaintArea;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * post请求处理
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// 处理中文乱码问题
		req.setCharacterEncoding("utf-8");
		//获取表单中的参数
		String userName =req.getParameter("userName");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String birthdate = req.getParameter("birthdate");
		String phone = req.getParameter("phone");
		String[] hobby = req.getParameterValues("hobby");
		
		//System.out.println("name"+userName+"gender"+gender+birthday+phone+hobby);
		//保存数据进servlet
		try {
			jdbcUti.AddStudent(userName, gender, age, birthdate, phone, hobby);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//处理响应中文乱码
		res.setContentType("text/html;charset=utf-8");
		//向客户端输出结果
		res.getWriter().write("录入学生成功！ <a href='/day08stuform/listStudentServlet'>【查看所有学生信息】</a>");
	}

}
