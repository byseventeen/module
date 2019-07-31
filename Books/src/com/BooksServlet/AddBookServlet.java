package com.BooksServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

		
		System.out.println("bookName"+bookName+"bookAuthor"+bookAuthor+price+amount);
	}

}
