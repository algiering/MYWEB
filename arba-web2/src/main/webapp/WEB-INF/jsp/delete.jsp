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
<style type="text/css"></style>
<link rel="stylesheet" type="text/css" href="/css/delete.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
</head>
<script type="text/javascript">
	var delete_rest = function(article_subno) {
		// post 로 요청. ajax / form
		var f = document.createElement('form');
		f.setAttribute('method', 'post');
		f.setAttribute('action', '/' + '${board_id}' + '/' + 'delete_rest');
		f.setAttribute('enctype', 'application/x-www-form-urlencoded');

		var i = document.createElement('input');
		i.setAttribute('type', 'hidden');
		i.setAttribute('name', 'article_subno');
		i.setAttribute('value', article_subno);
		f.appendChild(i);

		document.body.appendChild(f);

		f.submit();
	}
</script>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/delete.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="delete_form">
            <div id="form">
                <div id="blank"></div>
                <div id="title">삭제 하시겠습니까?</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="btn_cancel" class="btn_cancel">취소</div>
                <div id="btn_delete" class="btn_delete"
                    article_subno="${article_subno}">삭제</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="blank"></div>
            </div>
            <div id="btn_container">
                <div>메인화면</div>
                <div class="btn_cancel">취소</div>
            </div>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>