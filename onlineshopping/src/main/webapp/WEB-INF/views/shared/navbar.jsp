<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
	<div class="container">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#bs-example-navbar-collapse-1">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="${contextRoot}/home">Online
				Shopping</a>
		</div>
		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li id="about"><a href="${contextRoot}/about">About</a></li>
				<li id="contact"><a href="${contextRoot}/contact">Contact</a></li>
				<li id="listProducts"><a
					href="${contextRoot}/show/all/products">View Products</a></li>

				<%-- <li id="listProducts"><a href="${contextRoot}/admin">Admin</a></li>
				<li id="listProducts"><a href="${contextRoot}/login">Login</a></li>--%>

				<security:authorize access="hasAuthority('Admin')">
					<li class="dropdown"><a class="dropdown-toggle"
						data-toggle="dropdown" href="#">ADMIN <span class="caret"></span></a>
						<ul class="dropdown-menu">
							<li><a href="${pageContext.request.contextPath}/admin">Category</a></li>
							<li><a
								href="${pageContext.request.contextPath}/admin/Products">Product</a></li>
						</ul></li>
				</security:authorize>
				<security:authorize access="isAuthenticated()">
					<li id="logout"><a href="${contextRoot}/logout">Logout</a></li>
				</security:authorize>

				<security:authorize access="isAnonymous()">
					<li id="userReg"><a href="${contextRoot}/register">Register</a></li>
					<li id="login"><a href="${contextRoot}/login">Login</a></li>
				</security:authorize>

				<security:authorize access="hasAuthority('customer')">
					<li id="login"><a href="${contextRoot}/customer/cart">View
							Cart</a></li>
				</security:authorize>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container -->
</nav>
