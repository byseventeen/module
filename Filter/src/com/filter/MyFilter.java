package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/* 过滤器*/
public class MyFilter implements Filter {
	
	//在创建过滤器的时候自动调用的
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("执行MyFilter的init方法...");

	}
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req=(HttpServletRequest) request;
		HttpServletResponse resp=(HttpServletResponse) response;
		
		String requestURL=req.getRequestURI();
		if (requestURL.endsWith("form.jsp")||requestURL.endsWith("login")) {
			chain.doFilter(request, response);
		}
		else {
			Object o=req.getSession().getAttribute("loginUser");
			if (o!=null) {
				chain.doFilter(request, response);
			}
			else {
				resp.sendRedirect(req.getContextPath()+"/form.jsp");
			}
		}
		
	}
	
	//过滤器被销毁的时候自动执行
	@Override
	public void destroy() {
		System.out.println("执行MyFilter的destroy方法...");
	}





}
