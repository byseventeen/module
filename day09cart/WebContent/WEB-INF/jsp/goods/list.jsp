<%@ page language="java" contentType="text/html; charset=UTF-8"  import="java.util.*, com.day09cartBase.Goods"
    pageEncoding="UTF-8"%>

<% 
	//
	String contextPath =request.getServletContext().getContextPath();
	//application相当于ServletContext对象
	List<Goods> goodsList=(List<Goods>)application.getAttribute("goods");
	%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="600" cellspacing="0">
		<tr>
			<td>商品名称</td>
			<td>查看</td>
		</tr>
	
		<% for (Goods goods : goodsList) { %>
		<tr>
			<td><%=goods.getGoodsName()%></td>
			<td><a href="<%=contextPath%>/goods/detail?goodsId=<%=goods.getGoodsId()%>">查看</a></td>
		</tr>
		<% } %>
		<tr>
			<td colspan="2">
				<a herf="">查看购物内容</a>
				<!-- /cart/list -->
			</td>
		</tr>
	</table>

</body>
</html>