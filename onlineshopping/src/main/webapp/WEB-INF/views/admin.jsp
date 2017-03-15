<!--admin file to upload category  -->
<div class="container">
		<div class="container col-md-offset-2 col-md-col-md-8 ">
			<form:form action="${contextRoot}/admin/save/category" method="POST"
				modelAttribute="category" class="form-horizontal" enctype="multipart/form-data">
				<div class="form-group">
					<label class="col-md-2 control-label" for="id">Category
						ID</label>
					<div class="col-sm-10">
						<form:input type="text" path="id" id="id"
							class="form-control input-sm"></form:input>
						<div class="has-error">
							<form:errors path="id" class="help-inline" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="name">Category
						Name</label>
					<div class="col-sm-10">
						<form:input type="text" path="name" id="name"
							class="form-control input-sm"></form:input>
						<div class="has-error">
							<form:errors path="name" class="help-inline" />
						</div>
					</div>
				</div>
				<div class="form-group">
					<label class="col-md-2 control-label" for="imgURL">Upload
						Image</label>
					<div class="col-sm-10">
						<form:input type="file" path="file" id="file"
							class="form-control input-sm" />
						<div class="has-error">
						</div>
					</div>
				</div>
				<div class="form-group">
					<div class="col-sm-offset-2 col-sm-10">
						<button type="submit" class="btn btn-default">Submit</button>
					</div>
				</div>
			</form:form>
		</div>

 		<div class="row">
			<div class="container col-md-col-md-8 col-md-offset-2 ">
				<table id="mytable" class="table table-bordered">
					<thead>
						<tr>
							<th>id</th>
							<th>Name</th>
							<th>Image</th>
							<th>Buttons</th>
						</tr>
					</thead>
				</table>
			</div>
		</div>	