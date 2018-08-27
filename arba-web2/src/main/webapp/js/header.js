$(document).ready(function() {
	$('.btn_member').on('click', function(event) {
		window.location.href = "/membership"
	});
	$('.btn_hlogin').on('click', function(event) {
		window.location.href = "/login"
	});
	$('.btn_logout').on('click', function(event) {
		window.location.href = "/logout"
	});
	$('.btn_logo').on('click', function(event) {
		window.location.href = "/"
	});
});