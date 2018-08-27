$(document).ready(function() {
	$('.btn_list').on('click', function(event) {
		var board_id = $(this).attr('board_id');
		goBoard(board_id);
	});

	$('.btn_cancel').on('click', function(event) {
		history.back();
	});

	$('.btn_update').on('click', function(event) {
		var input_title = $('.input_title').val()
		input_title = input_title.replace(/\n/gi, '<br>');
		var input_content = $('.input_content').val();
		input_content = input_content.replace(/\n/gi, '<br>');

		var i = document.createElement('input');
		i.setAttribute('type', 'hidden');
		i.setAttribute('name', 'article_subno');
		i.setAttribute('value', article_subno);
		$('form').append(i);

		$('.input_title').val(input_title);
		$('.input_content').val(input_content);

		$('form').submit();
	});

	$('.file_delete').on('click', function(event) {

		if (confirm("파일을 삭제 합니까?")) {
			var file_no = $(this).attr('file_no');
			var data = {
				'file_no' : file_no
			}

			$.ajax({
				url : '/filedelete',
				data : JSON.stringify(data) // 사용하는 경우에는 JSON.stringify( {
				// 'data1':'test1', 'data2':'test2'
				// } )
				,
				type : 'post' // get, post
				,
				timeout : 30000 // 30초
				,
				dataType : 'html' // text, html, xml, json, jsonp, script
				,
				headers : {
					'Accept' : 'application/json',
					'Content-Type' : 'application/json'
				},
				beforeSend : function() {
					// 통신이 시작되기 전에 이 함수를 타게 된다.
				}
			}).done(function(data, textStatus, xhr) {
				// 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
				$('div[file_no=' + file_no + ']').parent().remove();

			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		} else {
			return false;
		}
	});
});