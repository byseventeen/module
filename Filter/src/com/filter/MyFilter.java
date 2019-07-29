package com.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		// TODO Auto-generated method stub
		System.out.println("调用过滤器中。。。");
		//放行
		chain.doFilter(request, response);
		
	}
	
	//过滤器被销毁的时候自动执行
	@Override
	public void destroy() {
		System.out.println("执行MyFilter的destroy方法...");
	}





}
