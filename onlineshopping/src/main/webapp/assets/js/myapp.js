$(function() {
	switch (menu) {

	case 'About Us':
		$('#bout').addClass('active');
		break;

	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	case 'Login':
		$('#Login').addClass('active');
		break;
		
	case 'Register':
		$('#Register').addClass('active');
		break;
	case 'Memeber Login':
		$('#memberlogin').addClass('active');
		break;
		
	case 'Admin':
		$('#admin').addClass('active');
		break;

	
	default:
		$('#listProducts').addClass('active');
	$('#a_'+menu).addClass('active');
	break;

	/*
	 * listProducts case 'About Us': $('#bout').addClass('active'); break;
	 */

	}

});
