package com.day09cartServlet;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day09cartBase.Goods;

/**
 * Servlet implementation class ShowServlet
 */
@WebServlet("/cart/list")
public class ShowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 展示购物车
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//解决中文乱码
		response.setContentType("text/html;charset=utf-8");
		HttpSession session=request.getSession();
		Object o=session.getAttribute("myCart");

		Map<Goods, Integer> myCart = null;
		if (o!=null) {
			myCart = (Map<Goods, Integer>) o;
			//遍历map集合
			for (Map.Entry<Goods, Integer> entry : myCart.entrySet()) {
				Goods goods=entry.getKey();
				int total=entry.getValue();
				
				response.getWriter().write("商品名称:"+goods.getGoodsName()+"</br>");
				response.getWriter().write("单价:"+goods.getPrice()+"</br>");
				response.getWriter().write("数量:"+total+"</br>");
				response.getWriter().write("</hr>");
			}
		}
		response.getWriter().write("<a href='"+request.getContextPath()+"/goods/list'>继续浏览商品</a>");
	}
}
