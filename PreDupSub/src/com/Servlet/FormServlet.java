package com.Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FormServlet
 */
@WebServlet("/Form")
public class FormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String name=request.getParameter("name");
		HttpSession session =request.getSession();
		Object token=session.getAttribute("token");
		String tokenvalue=request.getParameter("token");
		
	       System.out.println(token);
	        System.out.println(tokenvalue);
	        System.out.println("name: " + name);
	      
	     if (token!=null&&token.equals(tokenvalue)) {
			session.removeAttribute("token");
		}
	     else {
			response.sendRedirect("/PreDupSub/false.jsp");
			return;
		}
	     response.sendRedirect("/PreDupSub/ok.jsp");		
	}

}
