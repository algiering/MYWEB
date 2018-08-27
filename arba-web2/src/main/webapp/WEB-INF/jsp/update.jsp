<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="utf-8">
<title></title>
<style type="text/css">
</style>
<link rel="stylesheet" type="text/css" href="/css/update.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
<script type="text/javascript">
	var goBoard = function(board_id) {
		window.location.href = '/' + board_id + '/page=1';
	};
	var article_subno = ${article.article_subno};
	var board_id = '${board_id}';
</script>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/update.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<script type="text/javascript">

    $(document).ready(function() {
        $('.add_input').on('click', function(event) {
            var file_input_form = '<div style="width: 10%; text-align: center; display: inline-block;"></div>'
                                + '<div style="margin-left: 4px; width: 80%; display: inline-block;" id="file">'
                                + '<input type="file" name="file">'
                                + '</div>'
            $('.update_form').children().eq(2).append(file_input_form);
        });
    });
</script>
</head>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="board_title">
            <div>${board_name}</div>
            <div>게시판</div>
        </div>
        <form action="/${board_id}/update_rest" method="post" enctype="multipart/form-data" accept-charset="utf-8">
            <div id="update_form" class="update_form">
                <div id="title">
                    <div>제 목</div>
                    <div>
                        <input type="text" name="title" class="input_title" value="${article.article_title}">
                    </div>
                </div>
                <div id="file_list">
                    <c:forEach var="item" items="${file_list}">
                    <div><div>파 일 </div><div>${item.file_name}</div><div class="file_delete" file_no="${item.file_no}">×</div></div>
                    </c:forEach>
                </div>
                <div id="file">
                    <div>파일 업로드</div>
                    <div>
                        <input type="file" name="file">
                    </div>
                </div>
                <div id="add_input" class="add_input">파일추가</div>
                <hr>
                <div id="content">
                    <div>
                        <textarea name="content" class="input_content">${article.article_content}</textarea>
                    </div>
                </div>
                <input type="text" name="page" value="${page}" style="display: none;">
                <div id="btn_container">
                    <div board_id="${board_id}" class="btn_list">전체목록</div>
                    <div class="btn_update">글수정</div>
                    <div class="btn_cancel">취소</div>
                </div>
            </div>
            <input name="article_no" value="${article_no}" style="display: none;">
        </form>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>