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
<link rel="stylesheet" type="text/css" href="/css/index.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
<script type="text/javascript">
	var goBoard = function(board_id) {
		window.location.href = '/' + board_id + '/page=1';
	};

	var goArticle = function(board_id, page) {
		window.location.href = '/' + board_id + '/page=1' + '/article=' + page;
	};
</script>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<script type="text/javascript" src="/js/index.js"></script>
</head>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="mini_board">
            <div>
                <div board_id="noti" id="title" class="title_click">
                    공지사항
                    <div>+</div>
                </div>
                <table>
                    <tbody>
                        <c:forEach var="item" items="${noti_list}">
                            <tr>
                                <td board_id="${item.board_id}"
                                    article_no="${item.article_subno}"
                                    class="article_click">${item.article_title}</td>
                                <td>${item.user_id}</td>
                                <td><fmt:formatDate
                                        value="${item.article_regdate}"
                                        pattern="MM-dd" />​</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
            <div>
                <div board_id="free" id="title" class="title_click">
                    자유 게시판
                    <div>+</div>
                </div>
                <table>
                    <tbody>
                        <c:forEach var="item" items="${free_list}">
                            <tr>
                                <td board_id="${item.board_id}"
                                    article_no="${item.article_subno}"
                                    class="article_click">${item.article_title}</td>
                                <td>${item.user_id}</td>
                                <td><fmt:formatDate
                                        value="${item.article_regdate}"
                                        pattern="MM-dd" />​</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>