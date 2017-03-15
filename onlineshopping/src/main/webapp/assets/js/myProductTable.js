$(document).ready(function() {
		$('#myProductTable')
				.DataTable(
						{
							ajax : {
								url : '/onlineshopping/allproducts',
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
											return '<img src="/onlineshopping/resources/images/'
													+ row.prdimgURL
													+ '" height="50" width="50">';

										/*data : null,
										mRender : function(data, type, row) {
											return '<img src="/onlineshopping/resources/images/' 
							+ row.prdimgURL+ '.jpg" height="50" width="50">';*/
										}
									},
									{
										data : null,
										mRender : function(data, type, row) {
											return '<a class="btn btn-primary" href="/onlineshopping/products/showproduct/' 
							+ row.prdid+ '">View Item</a> &nbsp;<a class="btn btn-primary" href="/onlineshopping/cart/user/addtocart/' 
							+ row.prdid + '"><span class="glyphicon glyphicon-shopping-cart"></span>Add To Cart</a>';
										}
									} ]
						});
	});
