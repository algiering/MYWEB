$(document).ready(function() {
	$('.btn_list').on('click', function(event) {
		var board_id = $(this).attr('board_id');
		goBoard(board_id);
	});

	$('.btn_cancel').on('click', function(event) {
		history.back();
	});

	$('.btn_write').on('click', function(event) {

		var input_title = $('.input_title').val()
		input_title = input_title.replace(/\n/gi, '<br>');
		var input_content = $('.input_content').val();
		input_content = input_content.replace(/\n/gi, '<br>');

		$('.input_title').val(input_title);
		$('.input_content').val(input_content);

		$('form').submit();
	});
});