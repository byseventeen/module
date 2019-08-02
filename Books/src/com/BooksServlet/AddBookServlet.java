package com.BooksServlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DbUtil.Dbutil;




/**
 * Servlet implementation class AddBookServlet
 */
@WebServlet("/add")
public class AddBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//获取表单参数
		// 处理中文乱码问题
		request.setCharacterEncoding("utf-8");
		//获取表单中的参数
		String bookName =request.getParameter("bookName");
		String bookAuthor = request.getParameter("bookAuthor");
		String price = request.getParameter("price");
		String amount = request.getParameter("amount");

		
		//System.out.println("bookName"+bookName+"bookAuthor"+bookAuthor+price+amount);
		try {
			Dbutil.AddStudent(bookName, bookAuthor, price, amount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//处理响应中文乱码
		response.setContentType("text/html;charset=utf-8");
		//向客户端输出结果
		response.getWriter().write("录入书本成功！ <a href=''>【查看所有书本信息】</a>");
	}

}
