<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- form表单提交到对应的servlet里面 -->
	<form action="/Books/add" method="post">
		<table border="1" cellspacing="0">
			<tr>
				<td>书名：</td>
				<td>
					<input name="bookName"/> 
				</td>
			</tr>
			<tr>
				<td>作者：</td>
				<td>
					<input name="bookAuthor"/>
				</td>
			</tr>
			<tr>
				<td>价格：</td>
				<td>
					<input name="price"/>
				</td>
			</tr>
			<tr>
				<td>数量：</td>
				<td>
					<input name="amount"/>
				</td>
			</tr>						
			<tr>
				<td colspan=2 align="center">
					<input type="submit" value="提交"/>
				</td>
			</tr>
		</table>
	</form>

</body>
</html>