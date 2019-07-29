<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>	
	<%
		String msg = (String)request.getAttribute("msg");
		System.out.println(msg);
	%>
	<form action="${pageContext.request.contextPath}/login"  method="post">
		<%
		while(request.getAttribute("msg")!=null){
			response.getWriter().write(request.getAttribute("msg").toString());
		}
		%>
		<br>

		用户名：<input type="text" name="userName"><br/>
		密码：<input type="password" name="userPass"/><br/>
		<input type="submit" value="登录"/><br/>
	</form>

</body>
</html>