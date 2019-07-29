package com.javaIpt.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class sessionServlet
 */
@WebServlet("/prevent")
public class sessionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String TokenProccessor = null;
	/**
	 * 用于生成Token(令牌)和跳转到form.jsp页面
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

        String name = request.getParameter("name");

        HttpSession session = request.getSession();
        Object token = session.getAttribute("token");
        String tokenValue = request.getParameter("token");

        System.out.println(token);
        System.out.println(tokenValue);
        System.out.println("name: " + name);

        if (token != null && token.equals(tokenValue)) {
            session.removeAttribute("token");
        } else {
            response.sendRedirect("/javascrIpt/denied.jsp");
            return;
        }

        response.sendRedirect("/javascrIpt/success.jsp");
	}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}


}
