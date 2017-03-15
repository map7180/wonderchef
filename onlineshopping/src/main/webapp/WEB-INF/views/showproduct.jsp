<div class="container">
	<table class="table tale-bordered">
		<td class="col-sm-6 col-md-6"><img
			src="/omashoppingfront/resources/images/${product.prdid}.jpg" /> <%-- ${imgs}/${product.prdid} +".jpg" --%>
		</td>
		<td class="col-sm-6 col-md-6">
			<table>
				<tr height="100px">
					<td width="50%"><B>Product Name:</B></td>
					<td allign="center">${products.prdname}</td>
				</tr>
				<tr height="100px">
					<td><b>Product Description</b></td>
					<td allign="center">${products.prddisc}</td>
				</tr>
				<tr height="100px">
					<td><b>Quantity</b></td>
					<td>${products.prdsize}</td>
				</tr>
				<tr>
					<td allign="center"><button class="btn btn-success"
							href="${contextRoot}/customer/cart/addtocart/${products.prdid}">Add
							To Cart</button></td>
				</tr>
			</table>
		</td>

	</table>

</div>




<%-- <!--will display product when user will click on view product button  -->
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<spring:url var="css" value="/resources/css" />
<spring:url var="js" value="/resources/js" />
<spring:url var="images" value="/resources/images" />

<title>Insert title here</title>
<%@include file="./shared/header.jsp"%>
</head>
<body>
	<%@include file="./shared/navbar.jsp"%>
	<div class="container">
		<div class="row productimg">
 --%>
<div class="col-md-offset-1 col-md-5">
	<center>
		<img src="${images}/${prd.prdimgURL}" /> .${prdname}
	</center>
</div>
<%-- 		<div class="col-md-5 ">
				<ul>
					<li><h3>Product Name:</h3>${prd.prdname}</li>

					<li><h3>Description:</h3>${prd.description}</li>
				</ul>
			</div>
		</div>
	</div>
	
</body>
</html>
 --%>