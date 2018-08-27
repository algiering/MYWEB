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
<link rel="stylesheet" type="text/css" href="/css/board.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
<script type="text/javascript">
	var paging = function(page) {
		window.location.href = '/${board_id}/page=' + page + window.location.search;
	};
	
    var goList = function(page) {
        window.location.href = '/${board_id}/page=' + page;
    };

    var goArticle = function(page, article_no) {
        window.location.href = '/${board_id}/' + 'page=' + page + '/article=' + article_no + window.location.search;
    };
</script>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/board.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
</head>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="board_title">
            <div>${board_name}</div>
            <div>게시판</div>
        </div>
        <div id="board">
            <div id="content">
                <hr>
                <table id="article_table">
                    <tbody>
                        <tr>
                            <th>글번호</th>
                            <th>제목</th>
                            <th>작성자</th>
                            <th>조회수</th>
                            <th>작성일</th>
                            <th>추천수</th>
                        </tr>
                        <c:forEach var="item" items="${article_list}">
                            <tr>
                                <td>${item.article_subno}</td>
                                <td class="article_click" page="${page}"
                                    article_no="${item.article_subno}">${item.article_title} <c:if test="${item.comment_count gt 0}">[${item.comment_count}]</c:if></td>
                                <td>${item.user_id}</td>
                                <td>${item.article_hit}</td>
                                <td><fmt:formatDate
                                        value="${item.article_regdate}"
                                        pattern="yyyy-MM-dd" />​</td>
                                <td>
                                <c:choose>
                                <c:when test="${item.vote_count==null or item.vote_count==0}">
                                0
                                </c:when>
                                <c:otherwise>
                                ${item.vote_count}
                                </c:otherwise>
                                </c:choose>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
                <hr>
            </div>
            <div id="btn_container">
                <div class="btnList">전체목록</div>
                <div id="btn_best">베스트</div>
                <c:if test="${login_check}">
                <div board_id="${board_id}" class="btnWrite">글쓰기</div>
                </c:if>
            </div>
            <table id="paging_table">
                <tbody>
                    <tr>
                        <c:if test="${curPage ne totalFirstPage}">
                            <td class="firstPage"
                                page="${totalFirstPage}">&lt&lt</td>
                        </c:if>
                        <c:if test="${prevLink > 0 }">
                            <td class="prevPage" page="${prevLink}">&lt</td>
                        </c:if>
                        <c:forEach var="i" items="${pageLinks}"
                            varStatus="stat">
                            <c:choose>
                                <c:when test="${curPage == i}">
                                    <td id="curPage" class="pageNum">${i}</td>
                                </c:when>
                                <c:otherwise>
                                    <td class="pageNum">${i}</td>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        <c:if test="${nextLink > 0 }">
                            <td class="nextPage" page="${nextLink}">&gt</td>
                        </c:if>
                        <c:if
                            test="${curPage ne totalLastPage and totalLastPage ne 0}">
                            <td class="lastPage" page="${totalLastPage}">&gt&gt</td>
                        </c:if>
                    </tr>
                </tbody>
            </table>
            <form action="/${board_id}/page=1" method="get" enctype="application/x-www-form-urlencoded" accept-charset="utf-8">
            <div id="search_container">
                <select name="searchType">
                    <option value="title">제목</option>
                    <option value="content">본문</option>
                    <option value="titlecontent">제목+본문</option>
                    <option value="writer">작성자</option>
                </select>
                 <input type="text" name=searchValue>
                 <input type="submit" class="searchSubmit" value="검색">
            </div>
            </form>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>