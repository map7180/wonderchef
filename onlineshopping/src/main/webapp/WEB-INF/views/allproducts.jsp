<!--admin file for products uploading  -->
<script src="${js}/productdata.js"></script>
<div class="container">
	<div class="container col-md-offset-2 col-md-col-md-8">
		<form:form action="${contextRoot}/admin/save/Products" method="POST"
			modelAttribute="products" enctype="multipart/form-data"
			class="form-horizontal">
			<div class="form-group">
				<label class="col-md-2 control-label" for="prdid">Product ID</label>
				<div class="col-sm-10">
					<form:input type="text" path="prdid" id="prdid"
						class="form-control input-sm" value="${products.prdid}"></form:input>
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="prdname">Product
					Name</label>
				<div class="col-sm-6">
					<form:input type="text" path="prdname" id="prdname"
						class="form-control input-sm" value="${products.prdname}" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="prddisc">Description</label>
				<div class="col-sm-6">
					<form:input type="text" path="prddisc" id="prddisc"
						class="form-control input-sm" />
				</div>
			</div>
			<div class="form-group">
				<label class="col-md-2 control-label" for="prdprice">Price</label>
				<div class="col-sm-6">
					<form:input type="text" path="prdprice" id="prdprice"
						class="form-control input-sm" />
				</div>
			</div>

			<div class="form-group">
				<label class="col-md-2 control-label" for="prdimgURL">Upload
					Image</label>
				<div class="col-sm-6">
					<form:input type="file" path="file" id="prdimgURL"
						class="form-control input-sm" />

				</div>
			</div>
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">Submit</button>
				</div>
			</div>
		</form:form>
	</div>
</div>
<div class="row">
	<div class="col-md-offset-2 col-md-8">
		<table class="table table-bordered" id="myproduct">
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