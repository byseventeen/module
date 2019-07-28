package com.day09cartServlet;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.day09cartBase.Goods;


/**
 * Servlet implementation class getGoodsServlet
 */
@WebServlet("/goods/detail")
public class getGoodsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		//在GetGoodsServlet中获取商品ID，然后根据ID从ServletContext对象查询该ID的商品出来
		String goodsId= request.getParameter("goodsId");
		ServletContext sc =request.getServletContext();
		Object o=sc.getAttribute("goods");
		if(o!=null){
			List<Goods> goodsList=(List<Goods>) o;
			for (Goods goods : goodsList) {
				if(goods.getGoodsId()==Integer.parseInt(goodsId)){
					request.setAttribute("goods", goods);
					request.getRequestDispatcher("/WEB-INF/jsp/goods/detail.jsp").forward(request, response);
					// /WEB-INF/jsp/goods/detail.jsp
				}
			}
		}
	}


}
