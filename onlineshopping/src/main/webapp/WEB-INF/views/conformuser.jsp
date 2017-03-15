<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="content">
		<fieldset>
			<legend>Confirm Details</legend>
			<!-- for triggering webflow events using links,
					 the eventId to be triggered is given in "href" attribute as:
				 -->
			<a href="">Home</a><br /> <br /> UserName: ${user.name} <br /> <br />
			Email Id:${user.emid} <br /> <br /> Role :${user.role} <br /> <br />

			<!-- for triggering webflow events using form submission,
					 the eventId to be triggered is given in "name" attribute as:
					-->

			<a href="${flowExecutionUrl}&_eventId_edit">Edit</a>
			 <a href="${flowExecutionUrl}&_eventId_conform">Conform Details</a>
				
				
			<!-- <input name="_eventId_edit" type="submit" value="Edit" /> -->
			<!-- <input name="_eventId_conform" type="submit" value="Conform Details" /> -->
		
			<br />

		</fieldset>
	</div>











</body>
</html>