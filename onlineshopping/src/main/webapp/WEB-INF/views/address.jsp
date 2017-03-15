<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="container col-md-offset-2 col-md-col-md-8 ">
			<form:form method="POST" modelAttribute="address"
				class="form-horizontal">

				<div class="form-group">
					<label class="col-md-2 control-label" for="address1">Shipping
						Address</label>
					<div class="col-sm-10">
						<form:input type="text" path="address1" id="address1"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="address2">Billing
						Address</label>
					<div class="col-sm-10">
						<form:input type="text" path="address2" id="address2"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="city">City</label>
					<div class="col-sm-10">
						<form:input type="text" path="city" id="city"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<%-- <div class="form-group">
					<label class="col-md-2 control-label" for="state">State</label>
					<div class="col-sm-10">
						<form:input type="text" path="state" id="state"
							class="form-control input-sm"></form:input>
					</div>
				</div> --%>
				<div class="form-group">
					<label class="col-md-2 control-label" for="code">Pin Code</label>
					<div class="col-sm-10">
						<form:input type="text" path="code" id="code"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<br />
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default"
							name="_eventId_submit">Submit</button>
					</div>
				</div>
				<!-- 				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default" name="_eventId_edit">Edit</button>
					</div>
				</div>
 -->
			</form:form>
		</div>
</body>
</html>