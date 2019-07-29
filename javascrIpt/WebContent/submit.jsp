<%@ page import="java.util.Date" %><%--
  Created by IntelliJ IDEA.
  User: MC_jjk
  Date: 2019/7/27
  Time: 13:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    String tokenValue = new Date().getTime() + "";
    session.setAttribute("token", tokenValue);
%>

<form action="/javascrIpt/prevent" method="post">

    <input type="hidden" name="token"  value="<%=tokenValue %>"/>
    姓名: <input type="text" name="name" />
    密码: <input type="password" name="name" />
    <input type="submit" value="提交" />
</form>
</body>
</html>
