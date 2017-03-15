<!-- display all products data...outside admin  -->
<div class="container">
	<div class="row">
		<!-- to display side bar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>
		</div>
 <!-- to display actual products -->
		<div class="col-md-9">
			<!--  Adding breadcrum component-->
			<script src="${js}/myProductTable.js"></script>
			<div class="row">
				<div class="col-lg-12">
					<c:if test="${userClickAllProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">All Products</li>
						</ol>
					</c:if>
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li>
							<li class="active">Category</li>
							<li class="active">${category.name}</li>
						</ol>
					</c:if>
					<!-- include data table on this page -->
					<form:form action="${contextRoot}/admin/all/products"
						method="POST" modelAttribute="category" class="form-horizontal">
						<div class="row">
							<div class="container col-md-col-md-8 col-md-offset-2 ">
								<table id="myProductTable" class="table table-bordered">
									<thead>
										<tr>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
											<th></th>
										</tr>
									</thead>
								</table>
							</div>
						</div>
					</form:form>
					<!-- over of data table -->
				</div>
			</div>
		</div>
	</div>
</div>
