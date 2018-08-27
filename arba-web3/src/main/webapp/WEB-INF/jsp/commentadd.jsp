<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<div id="content" comment_no="${commentadd.comment_no}">
    <div id="writer">${commentadd.user_id}</div>
    <div id="content">${commentadd.comment_content}</div>
    <div id="regdate">
        <fmt:formatDate value="${commentadd.comment_regdate}"
            pattern="yyyy-MM-dd HH:mm:ss" />
    </div>
    <c:if test="${user_id eq comment.user_id}">
        <div id="btn_comment_delete" class="btn_comment_delete">삭제</div>
        <div id="btn_comment_edit" class="btn_comment_edit">수정</div>
    </c:if>
</div>
<hr id="comment_line">