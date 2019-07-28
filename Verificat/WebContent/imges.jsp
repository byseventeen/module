<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function changeImg() {
	    //使用javascript脚本来实现局部刷新
	    document.getElementById("code").src ="${pageContext.request.contextPath}/images?"+Math.random();
	}
</script>
</head>
<body>

		<!-- img中的src属性中，配置VerifyImage的请求 -->
		<img alt="验证码" id="code" src="${pageContext.request.contextPath }/images" onClick="changeImg()"/>

</body>
</html>