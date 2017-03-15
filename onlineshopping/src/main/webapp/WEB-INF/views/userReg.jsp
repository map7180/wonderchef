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
			<form:form method="POST" modelAttribute="user"
				class="form-horizontal">
				<!-- 	<div class="form-group">
					<label class="col-md-2 control-label" for="id">ID</label>
					<div class="col-sm-10">
						<form:input type="text" path="id" id="id" class="form-control input-sm"></form:input>
						<div class="has-error">
							<form:errors path="id" class="help-inline" />
						</div>
					</div>
				</div>
			 -->
				<div class="form-group">
					<label class="col-md-2 control-label" for="name">Name</label>
					<div class="col-sm-10">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="emid">Email ID</label>
					<div class="col-sm-10">
						<form:input type="text" path="emid" id="emid"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="username">User
						Name</label>
					<div class="col-sm-10">
						<form:input type="text" path="username" id="username"
							class="form-control input-sm"></form:input>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="id">Customer</label>
					<div class="col-sm-10">
					
						<form:radiobutton path="role" id="role" value='customer' class="form-control input-sm"></form:radiobutton>
						<label class="col-md-2 control-label" for="id">Customer</label>
					
					<div class="col-sm-10">
					
						<form:radiobutton path="role" id="role" value='supplier' class="form-control input-sm"></form:radiobutton>
						<label class="col-md-2 control-label" for="id">Supplier</label>
					
					</div>

						<div class="form-group">
							<label class="col-md-2 control-label" for="pwd">Password</label>
							<div class="col-sm-10">
								<form:input type="text" path="pwd" id="pwd"
									class="form-control input-sm"></form:input>
							</div>
						</div>
					<br/>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-default"
									name="_eventId_submit">Next</button>
							</div>
						</div>
						<!-- 					<div class="form-group">
								<div class="col-sm-offset-2 col-sm-10">
									<button type="submit" class="btn btn-default"
										name="_eventId_edit">Edit</button>
								</div>
							</div>
		 -->
			</form:form>
		</div>
</body>
</html>