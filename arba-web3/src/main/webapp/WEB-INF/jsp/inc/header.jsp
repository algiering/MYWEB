<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="header">
    <div class="btn_logo">로고</div>
    <c:choose>
    <c:when test="${login_check}">
        <div class="btn_logout">로그아웃</div>
        <div class="btn_myinfo">내정보</div>
        </c:when>
        <c:otherwise>
        <div class="btn_hlogin">로그인</div>
        <div class="btn_member">회원가입</div>
        </c:otherwise>
    </c:choose>
</div>