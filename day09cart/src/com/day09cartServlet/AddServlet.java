package com.day09cartServlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.day09cartBase.Goods;


/**
 * Servlet implementation class AddServlet
 */
@WebServlet("/cart/add")
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * 添加进入购物车
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//获取表单数据
		String goodsId=request.getParameter("goodsId");
		String amount=request.getParameter("amount");
		
		// 从session中获取当前用户的购物车商品
		HttpSession session = request.getSession();
		// Key代表购买的商品，Value代表购买数量
		Object o = session.getAttribute("myCart");
		Map<Goods, Integer> myCart = null;
		if (o!=null) {
			myCart = (Map<Goods, Integer>) o;
			// 记录map集合中是否存在指定goodsId的商品
			boolean hasGoods = false;
			for (Map.Entry<Goods, Integer> entry : myCart.entrySet()) {
				Goods goods=entry.getKey();
				int total=entry.getValue();
				if(goods.getGoodsId()==Integer.parseInt(goodsId)){
					total+=Integer.parseInt(amount);
					hasGoods=true;				
				}
			}
			if (hasGoods==false) {
				Goods goods=getGoods(request,Integer.parseInt(goodsId));
				myCart.put(goods, Integer.parseInt(amount));
			}
		}
		else {
			myCart=new HashMap<Goods, Integer>();
			Goods goods=getGoods(request,Integer.parseInt(goodsId));
			myCart.put(goods, Integer.parseInt(amount));
		}
		//处理中文乱码
		response.setContentType ("text/html; charset=utf-8");
		//把map添加到session对象的myCart属性中
		session.setAttribute("myCart",myCart);
		response.getWriter().write("商品加入购物车成功！");
		response.getWriter().write("<a href=''>请继续浏览商品</a>");
		response.getWriter().write("<a href=''>浏览购物车</a>");
	}
	 
	
	
	//根据商品id查询商品
	private Goods getGoods(HttpServletRequest request,int goodsId) {
		ServletContext sc=request.getServletContext();
		Object o=sc.getAttribute("goods"); 
		if(o!=null){
			List<Goods> goodList=(List<Goods>) o;
			//遍历集合
			for (Goods goods : goodList) {
				if (goods.getGoodsId()==goodsId) {
					return goods;
				}
			}
		}
		return null;
	}
}
