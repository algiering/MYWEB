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
<link rel="stylesheet" type="text/css" href="/css/article.css">
<link rel="stylesheet" type="text/css" href="/css/board.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
<script type="text/javascript">

	var paging = function(page) {
		window.location.href = '/${board_id}/page=' + page + window.location.search;
	};

	var goArticle = function(page, article_no) {
		window.location.href = '/${board_id}/' + 'page=' + page + '/article=' + article_no + window.location.search;
	};

	var download = function(file_no) {
		// post 로 요청. ajax / form
		var f = document.createElement('form');
		f.setAttribute('method', 'post');
		f.setAttribute('action', '/download');
		f.setAttribute('enctype', 'application/x-www-form-urlencoded');

		var i = document.createElement('input');
		i.setAttribute('type', 'hidden');
		i.setAttribute('name', 'file_no');
		i.setAttribute('value', file_no);
		f.appendChild(i);

		document.body.appendChild(f);

		f.submit();
	}
	
	var login_check = ${login_check};

	var update = function(article_subno) {
		// post 로 요청. ajax / form
		var f = document.createElement('form');
		f.setAttribute('method', 'post');
		f.setAttribute('action', '/' + '${board_id}' + '/' + 'update');
		f.setAttribute('enctype', 'application/x-www-form-urlencoded');

		var i = document.createElement('input');
		i.setAttribute('type', 'hidden');
		i.setAttribute('name', 'article_subno');
		i.setAttribute('value', article_subno);
		f.appendChild(i);
		
	    var j = document.createElement('input');
	        j.setAttribute('type', 'hidden');
	        j.setAttribute('name', 'page');
	        j.setAttribute('value', ${page});
	        f.appendChild(j);

		document.body.appendChild(f);

		f.submit();
	}

	var deletea = function(article_subno) {
		// post 로 요청. ajax / form
		var f = document.createElement('form');
		f.setAttribute('method', 'post');
		f.setAttribute('action', '/' + '${board_id}' + '/' + 'delete');
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
<script type="text/javascript" src="/js/article.js"></script>
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
        <div id="article">
            <div id="article_header">
                <div>
                    <div>
                        <div>제 목</div>
                        <div>${article.article_title}</div>
                    </div>
                    <div>
                        <div>작성자</div>
                        <div>${article.user_id}</div>
                        | 
                        <div>조회</div>
                        <div>${article.article_hit}</div>
                        | 
                        <div>댓글</div>
                        <div class="top_comment_count">${comment_count}</div>
                    </div>
                    <c:forEach var="item" items="${file_list}">
                        <div>
                            <div>파 일</div>
                            <div id="file_name">
                                <a
                                    href="javascript:download(${item.file_no})">${item.file_name}</a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <div>
                    <div>
                        <fmt:formatDate
                            value="${article.article_regdate}"
                            pattern="yyyy-MM-dd HH:mm:ss" />
                    </div>
                </div>
            </div>
            <hr>
            <div id="article_body">${article.article_content}</div>
            <div id="vote">
                <c:choose>
                    <c:when test="${goodvote_check==true}">
                        <div id="good" class="good_clicked"
                            article_no="${article_no}">
                    </c:when>
                    <c:otherwise>
                        <div id="good" class="good_unclicked"
                            article_no="${article_no}">
                    </c:otherwise>
                </c:choose>
                추천
                <div class="good_count">
                    <c:choose>
                        <c:when
                            test="${goodvote_count==null or goodvote_count==0}">
                                0
                            </c:when>
                        <c:otherwise>
                                ${goodvote_count}
                            </c:otherwise>
                    </c:choose>
                </div>
            </div>
            <c:choose>
                <c:when test="${badvote_check==true}">
                    <div id="bad" class="bad_clicked"
                        article_no="${article_no}">
                </c:when>
                <c:otherwise>
                    <div id="bad" class="bad_unclicked"
                        article_no="${article_no}">
                </c:otherwise>
            </c:choose>
            비추천
            <div class="bad_count">
                <c:choose>
                    <c:when
                        test="${badvote_count==null or badvote_count==0}">
                                0
                            </c:when>
                    <c:otherwise>
                                ${badvote_count}
                            </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>
    <hr>
    <div id="btn_container">
        <div class="btn_list">전체목록</div>
        <div>베스트</div>
        <c:if test="${login_check}">
            <div board_id="${board_id}" class="btn_write">글쓰기</div>
        </c:if>
        <c:if test="${my_article_check}">
            <div article_subno="${article.article_subno}"
                class="btn_update">글수정</div>
            <div article_subno="${article.article_subno}"
                class="btn_delete">글삭제</div>
        </c:if>
    </div>
    <div id="comment_container">
        <div id="title">
            <div id="title">전체 댓글 수</div>
            <div id="content" class="bottom_comment_count">${comment_count}</div>
        </div>
        <c:forEach var="comment" items="${comment_list}">
            <div id="content" comment_no="${comment.comment_no}">
                <div id="writer">${comment.user_id}</div>
                <div id="content">${comment.comment_content}</div>
                <div id="regdate">
                    <fmt:formatDate value="${comment.comment_regdate}"
                       timeZone="KST" pattern="yyyy-MM-dd HH:mm:ss" />
                </div>
                <c:if test="${user_id eq comment.user_id}">
                    <div id="btn_comment_delete"
                        class="btn_comment_delete">삭제</div>
                    <div id="btn_comment_edit" class="btn_comment_edit">수정</div>
                </c:if>
            </div>
            <hr id="comment_line">
        </c:forEach>
        <c:if test="${login_check}">
            <div id="input_form">
                <textarea id="input_comment" class="comment_content"></textarea>
                <div id="btn_write" class="btn_comment"
                    article_no="${article.article_no}">등록</div>
            </div>
        </c:if>
    </div>
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
                        <c:choose>
                            <c:when
                                test="${item.article_no eq article.article_no}">
                                <tr style="background: #99b2ff;">
                            </c:when>
                            <c:otherwise>
                                <tr>
                            </c:otherwise>
                        </c:choose>
                        <td>${item.article_subno}</td>
                        <td class="article_click" page="${page}"
                            article_no="${item.article_subno}">${item.article_title}
                            <c:if test="${item.comment_count gt 0}">[${item.comment_count}]</c:if>
                        </td>
                        <td>${item.user_id}</td>
                        <td>${item.article_hit}</td>
                        <td><fmt:formatDate
                                value="${item.article_regdate}"
                                pattern="yyyy-MM-dd" />​</td>
                        <td><c:choose>
                                <c:when
                                    test="${item.vote_count==null or item.vote_count==0}">
                                0
                                </c:when>
                                <c:otherwise>
                                ${item.vote_count}
                                </c:otherwise>
                            </c:choose></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <hr>
        </div>
        <div id="article">
            <div id="btn_container">
                <div class="btn_list">전체목록</div>
                <div>베스트</div>
                <c:if test="${login_check}">
                    <div board_id="${board_id}" class="btn_write">글쓰기</div>
                </c:if>
                <c:if test="${my_article_check}">
                    <div article_subno="${article.article_subno}"
                        class="btn_update">글수정</div>
                    <div article_subno="${article.article_subno}"
                        class="btn_delete">글삭제</div>
                </c:if>
            </div>
        </div>
        <table id="paging_table">
            <tbody>
                <tr>
                    <c:if test="${curPage ne totalFirstPage}">
                        <td class="firstPage" page="${totalFirstPage}">&lt&lt</td>
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
        <form action="/${board_id}/page=1" method="get"
            enctype="application/x-www-form-urlencoded"
            accept-charset="utf-8">
            <div id="search_container">
                <select name="searchType">
                    <option value="title">제목</option>
                    <option value="content">본문</option>
                    <option value="titlecontent">제목+본문</option>
                    <option value="writer">작성자</option>
                </select> <input type="text" name=searchValue> <input
                    type="submit" class="searchSubmit" value="검색">
            </div>
        </form>
    </div>
    </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>