<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%-- <%@include file="page.jsp"%> --%>
</head>
<body>

	<%-- <p>welcome</p>
	${user.name}
 --%>
	<div class="content">
		<h2>Welcome , you have successfully registered .</h2>
		<h2>USERNAME: ${user.name}</h2>
		<a href="${contextRoot}/login"><span
			class="glyphicon glyphicon-user"></span> Login</a>
		
	</div>

</body>
</html>