$(document).ready(function() {
	$('.pageNum').on('click', function(event) {
		var page = $(this).text();
		paging(page);
	});
	
	$('.firstPage').on('click', function(event) {
		var page = $(this).attr('page');
		paging(page);
	});
	
	$('.prevPage').on('click', function(event) {
		var page = $(this).attr('page');
		paging(page);
	});
	
	$('.nextPage').on('click', function(event) {
		var page = $(this).attr('page');
		paging(page);
	});
	
	$('.lastPage').on('click', function(event) {
		var page = $(this).attr('page');
		paging(page);
	});
	
	$('.btnList').on('click', function(event) {
		goList(1);
	});
	
	$('.article_click').on('click', function(event) {
		var article_no = $(this).attr('article_no');
		var page = $(this).attr('page');
		goArticle(page, article_no);
	});
	
	$('.btnWrite').on('click', function(event) {
		var board_id = $(this).attr('board_id');
		window.location.href = '/' + board_id + '/' + 'write';
	});
	
});