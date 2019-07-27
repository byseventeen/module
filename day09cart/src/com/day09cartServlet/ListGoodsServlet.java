package com.day09cartServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day09cartBase.Goods;




/**
 * Servlet implementation class ListGoodsServlet
 */
@WebServlet("/goods/list")
public class ListGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	/**
	 *get方法
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Goods> goodsList=new ArrayList<Goods>();
		//初始化商品
		goodsList.add(new Goods(110, "小米电视机", "小米电视机", 2699)); 
		goodsList.add(new Goods(111, "小米mix3", "小米mix3", 3999));
		goodsList.add(new Goods(112, "小米手环", "小米手环", 199));
		goodsList.add(new Goods(113, "小米耳机", "小米耳机", 99));
		
		//将商品保存到一个对象当中   ServletContext域对象
		ServletContext sc =request.getServletContext();
		sc.setAttribute("goods", goodsList);
		
		//请求转发
		request.getRequestDispatcher("/WEB-INF/jsp/goods/list.jsp").forward(request, response);
		
	}


}
