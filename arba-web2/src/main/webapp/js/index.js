$(document).ready(function() {
	$('.article_click').on('click', function(event) {
		var page = $(this).attr('article_no');
		var board_id = $(this).attr('board_id');
		goArticle(board_id, page);
	});
	
	$('.title_click').on('click', function(event) {
		var board_id = $(this).attr('board_id');
		goBoard(board_id);
	});
});