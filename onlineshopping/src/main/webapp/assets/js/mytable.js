//for admin part

$(function() {
	$('#mytable')
			.DataTable(
					{
						ajax : {
							url : '/onlineshopping/all/category',
							dataSrc : ''
						},
						columns : [
								{
									data : 'id'
								},
								{
									data : 'name'
								},
								{
									data : null,
									mRender : function(data, type, row) {
										return '<img src="/onlineshopping/resources/images/'
												+ row.imgURL
												+ '" height="50" width="50">';
									}
								},
								{
									mRender : function(data, type, row) {
										return "<a class='btn btn-primary' href='/onlineshopping/admin/show/category/"
												+ row.id
												+ "'>View Item</a> &nbsp;<a class='btn btn-primary' href='/onlineshopping/admin/delete/"
												+ row.id
												+ "/category'>Delete</a>";
				}
								}

						]
					});

});
