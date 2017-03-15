//admin part file for products detail

$(function() {
	$('#myproduct')
			.DataTable(
					{
						ajax : {
							url : '/onlineshopping/admin/displayproducts',
							dataSrc : ''
						},
						columns : [
								{
									data : 'prdid'
								},
								{
									data : 'prdname'
								},
								{
									data : 'prddisc'
								},
								{
									data : 'prdsize'
								},
								{
									data : 'prdprice'
								},
								{
									data : 'prdimgURL',
									mRender : function(data, type, row) {
										return "<img src='/onlineshopping/resources/images/"+ row.prdimgURL+"' height='50' width='50'>";
												
									}
								},
								{
									data : "",
									mRender : function(data, type, row) {
										return '<a class="btn btn-primary" href="/onlineshopping/admin/showproduct/'
												+ row.id+ '">Update Item</a> &nbsp;<a class="btn btn-primary" href="/onlineshopping/admin/delete/'
												+ row.id+ '">Delete</a>';
									}
								} ]
					});

});
