package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet("/login")
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 获取参数
		String userName=request.getParameter("userName");
		String userPass=request.getParameter("userPass");
		
		//如果验证成功，把当前用户信息保存在Session中，然后重定向到IndexServlet
		if ("admin".equals(userName) && "123".equals(userPass)) {
			//记录用户的登录状态
			request.getSession().setAttribute("loginUser", userName);
			response.sendRedirect(request.getContextPath() + "/admin");
		} else {
			request.setAttribute("msg", "用户名或密码不正确！");
			request.getRequestDispatcher("/form.jsp").forward(request, response);

		}
		
	}

}
