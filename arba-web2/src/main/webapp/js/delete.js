$(document).ready(function() {
	$('.btn_delete').on('click', function(event) {
		var article_subno = $(this).attr('article_subno');
		delete_rest(article_subno);
	});
	
	$('.btn_cancel').click(function(event) {
		history.back();
	})
});