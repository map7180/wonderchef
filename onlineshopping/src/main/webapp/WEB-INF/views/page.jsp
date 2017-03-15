<!--It's a master page  -->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<spring:url value="/resources/css" var="css" />
<spring:url value="/resources/js" var="js" />
<spring:url value="/resources/images" var="images" />

<c:set var="contextRoot" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html lang="en">
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Online Shopping - ${title}</title>


<script>
	window.menu = '${title}';
</script>
<!--All Links  -->
<script src="${js}/jquery.js"></script>
<link href="${css}/bootstrap.css" rel="stylesheet"></link>
<link href="${css}/bootstrap-theme.css" rel="stylesheet"></link>
<link href="${css}/dataTables.bootstrap.css" rel="stylesheet">
<link href="${css}/style.css" rel="stylesheet" type="text/css"></link>
<link href="${css}/myapp.css" rel="stylesheet" type="text/css"></link>
<script src="${js}/productdata.js"></script>
</head>

<body background="${images}/bg1.jpg">
	<div class="wrapper">
		<!-- Navigation -->
		<%@include file="./shared/navbar.jsp"%>

		<!-- Page Content -->
		<div class="content">
			<!-- Loading the Home page content -->
			<c:if test="${userClickHome==true}">
				<%@include file="home.jsp"%>
			</c:if>
			<!-- Load only when user clicks about -->
			<c:if test="${userClickAbout==true}">
				<%@include file="about.jsp"%>
			</c:if>
			<!-- Load only when user clicks Contact -->
			<c:if test="${userClickContact==true}">
				<%@include file="contact.jsp"%>
			</c:if>
			<c:if test="${userClickLogin==true}">
				<%@include file="login.jsp"%>
			</c:if>

			<%-- 			<c:if test="${userClickRegister==true}">
				<%@include file="userReg.jsp"%>
			</c:if>
 --%>
			<%-- <c:if test="${userClickMemberLogin==true}">
				<%@include file="memberlogin.jsp"%>
			</c:if> --%>

			<c:if test="${userClickProducts==true}">
				<%@include file="allproducts.jsp"%>
			</c:if>

			<%-- 	<c:if test="${userClickViewCart==true}">
				<%@include file="viewCart.jsp"%>

			</c:if>
 --%>


			<c:if test="${userClickAdmin==true}">
				<%@include file="admin.jsp"%>
			</c:if>
			<c:if
				test="${userClickAllProducts==true or userClickCategoryProducts==true}">
				<%@include file="listProducts.jsp"%>
			</c:if>
		</div>

		<!-- Footer -->
		<%@include file="./shared/fotter.jsp"%>

		<!-- jQuery -->
		

		<!-- Bootstrap Core JavaScript -->
		<script src="${js}/bootstrap.min.js"></script>
		<script src="${js}/jquery.dataTables.js"></script>
		<script src="${js}/dataTables.bootstrap.js"></script>
		<script src="${js}/mytable.js"></script>
		<!-- Self coded JavaScript -->
		<script src="${js}/myapp.js"></script>

	</div>
</body>

</html>
