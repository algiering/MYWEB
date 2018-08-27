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
<link rel="stylesheet" type="text/css" href="/css/aftermember.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
</head>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/aftermember.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="after_member">
            <div id="form">
                <div id="blank"></div>
                <div id="title">회원가입이 완료되었습니다</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="btn_login" class="btn_login">로그인</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="blank"></div>
            </div>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>