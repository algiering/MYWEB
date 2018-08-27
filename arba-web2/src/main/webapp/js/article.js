$(document).ready(function() {
	$('.btn_list').on('click', function(event) {
		var page = 1;
		paging(page);
	});

	$('.btn_write').on('click', function(event) {
		var board_id = $(this).attr('board_id');
		window.location.href = '/' + board_id + '/' + 'write';
	});

	$('.btn_update').on('click', function(event) {
		var article_subno = $(this).attr('article_subno');
		update(article_subno);
	});

	$('.btn_delete').on('click', function(event) {
		var article_subno = $(this).attr('article_subno');
		deletea(article_subno);
	});

	$(document).on("click", ".good_unclicked", function(event) {
		if (login_check) {
			var article_no = $(this).attr('article_no');
			var vote_goodbad = 1;
			var data = {
				'article_no' : article_no,
				'vote_goodbad' : vote_goodbad
			};

			$.ajax({
				url : '/vote',
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
				$('.good_unclicked').attr('class', 'good_clicked');
				var c = $('.good_count').text().trim();
				c = Number(c) + 1;
				$('.good_count').text(c)

			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		} else {
			alert("추천하려면 로그인 해야 합니다")
		}
	});

	$(document).on("click", ".good_clicked", function(event) {
		if (login_check) {
			var article_no = $(this).attr('article_no');
			var vote_goodbad = 1;
			var data = {
				'article_no' : article_no,
				'vote_goodbad' : vote_goodbad
			};

			$.ajax({
				url : '/unvote',
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
				$('.good_clicked').attr('class', 'good_unclicked');
				var c = $('.good_count').text().trim();
				c = Number(c) - 1;
				$('.good_count').text(c)

			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});

		} else {
			alert("추천하려면 로그인 해야 합니다")
		}
	});

	$(document).on("click", ".bad_clicked", function(event) {
		if (login_check) {
			var article_no = $(this).attr('article_no');
			var vote_goodbad = 1;
			var data = {
				'article_no' : article_no,
				'vote_goodbad' : vote_goodbad
			};

			$.ajax({
				url : '/unvote',
				data : JSON.stringify(data) // 사용하는 경우에는 JSON.stringify( {
				// 'data1':'test1', 'data2':'test2' } )
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
				$('.bad_clicked').attr('class', 'bad_unclicked');
				var c = $('.bad_count').text().trim();
				c = Number(c) - 1;
				$('.bad_count').text(c)

			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		} else {
			alert("비추천하려면 로그인 해야 합니다")
		}
	});

	$(document).on("click", ".bad_unclicked", function(event) {
		if (login_check) {
			var article_no = $(this).attr('article_no');
			var vote_goodbad = 1;
			var data = {
				'article_no' : article_no,
				'vote_goodbad' : vote_goodbad
			};

			$.ajax({
				url : '/unvote',
				data : JSON.stringify(data) // 사용하는 경우에는 JSON.stringify( {
				// 'data1':'test1', 'data2':'test2' } )
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
				$('.bad_unclicked').attr('class', 'bad_clicked');
				var c = $('.bad_count').text().trim();
				c = Number(c) + 1;
				$('.bad_count').text(c)

			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		} else {
			alert("비추천하려면 로그인 해야 합니다")
		}
	});
	
	$('.btn_comment').click(function(event) {
		
		var comment_content = $('.comment_content').val();
		var article_no = $(this).attr('article_no');
		
        comment_content = comment_content.replace(/\n/gi, '<br>');
		
		var comment = { 'comment_content': comment_content,
                'article_no': article_no, }
        
        $.ajax({
            url : '/comment_write'
            , data: JSON.stringify( comment )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'html'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            	$('#comment_container').children().last().prev().after(data);
            	$('.comment_content').val('');
            	
            	var tcount = $('.top_comment_count').text().trim();
            	var bcount = $('.bottom_comment_count').text().trim();
            	
            	tcount = Number(tcount)+1;
            	bcount = Number(bcount)+1;
            	
            	$('.top_comment_count').text(tcount);
            	$('.bottom_comment_count').text(bcount);
            	
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
	});
	
    $(document).on("click",".btn_comment_edit",function(){
    	
    	var comment_no = $(this).parents().attr('comment_no');
    	
    	var edit_form = '<div id="edit_form" style="display: inline-flex; width: 94%;">'
    	+ '<div style="width: 86%; height: 50px;">'
    	+ '<textarea class="edit_val" style="width: 100%; height: 50px;">'
    	+ '</textarea></div><div class="btn_edit_comment" style="display: inline-flex;justify-content: center;'
    	+ 'align-items: center;padding-bottom: 3px; width: 80px;height: 40px;'
    	+ 'border: #617de2 1px solid; border-radius: 4px; background-color: #93bcff;'
    	+ 'font-weight: bold;color: white; margin-left: 10px;"'
    	+ 'comment_no="' + comment_no + '">수정</div></div>';
    	var cur_data = $('div[comment_no="'+ comment_no +'"]').children('div[id="content"]').html();
    	cur_data = cur_data.replace(/<br>/gi, "\n");
    	$(this).after(edit_form);
    	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').children().children('textarea').val(cur_data);
    	$(this).attr('class', 'btn_comment_edit_clicked');
    });
    
    $(document).on("click",".btn_comment_edit_clicked",function(){
    	var comment_no = $(this).parents().attr('comment_no');
    	$(this).attr('class', 'btn_comment_edit');
    	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').remove();
    });
    
    $(document).on("click",".btn_comment_delete",function(){
        var comment_no = $(this).parents().attr('comment_no');
        if (confirm('삭제 하시겠습니까?')) {
        $.ajax({
            url : '/comment_delete'
            , data: JSON.stringify( comment_no )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if (data == 1) { 
            	$('div[comment_no="'+ comment_no +'"]').next().remove();
            	$('div[comment_no="'+ comment_no +'"]').remove();
            	
            	var tcount = $('.top_comment_count').text();
                var bcount = $('.bottom_comment_count').text();
                
                tcount = Number(tcount)-1;
                bcount = Number(bcount)-1;

                $('.top_comment_count').text(tcount);
                $('.bottom_comment_count').text(bcount);
            }
            else {
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
        } else {
        	return false;
        }
    });
    
    $(document).on("click",".btn_edit_comment",function(){
    	
    	var comment_no = $(this).attr('comment_no');
    	var comment_content = $('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').children().children('textarea').val();
    	
    	comment_content = comment_content.replace(/\n/gi, '<br>');
    	
    	var comment = {
    			'comment_content': comment_content,
    			'comment_no': comment_no
    	};
    	
    	$('div[comment_no="'+ comment_no +'"]').children('div[class="btn_comment_edit_clicked"]').attr('class', 'btn_comment_edit');

    	$.ajax({
            url : '/comment_edit'
            , data: JSON.stringify( comment )        // 사용하는 경우에는 JSON.stringify( { 'data1':'test1', 'data2':'test2' } )
            , type: 'post'       // get, post
            , timeout: 30000    // 30초
            , dataType: 'json'  // text, html, xml, json, jsonp, script
            , headers: {  'Accept': 'application/json', 'Content-Type': 'application/json' }
            , beforeSend : function() {
                // 통신이 시작되기 전에 이 함수를 타게 된다.
            }
        }).done( function(data, textStatus, xhr ){
            // 통신이 성공적으로 이루어졌을 때 이 함수를 타게 된다.
            if (data == 1) { 
            	$('div[comment_no="'+ comment_no +'"]').children('div[id="edit_form"]').remove();
            	$('div[comment_no="'+ comment_no +'"]').children('div [id="content"]').html(comment_content);
            }
            else {
                alert('정상적인 경로로 접속해주세요');
            }
        }).fail( function(xhr, textStatus, error ) {
            // 통신이 실패했을 때 이 함수를 타게 된다.
            alert('정상적인 경로로 접속해주세요');
        }).always( function(data, textStatus, xhr ) {
            // 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
        });
    });
	
});