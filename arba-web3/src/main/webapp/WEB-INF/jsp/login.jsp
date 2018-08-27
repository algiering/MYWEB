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
<link rel="stylesheet" type="text/css" href="/css/login.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
</head>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/login.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="login_form">
            <div id="form">
                <div id="blank"></div>
                <div id="title">로그인</div>
                <div id="blank"></div>
                <form action="/login_rest" method="post">
                    <div>
                        <div id="col0">아이디</div>
                        <div id="col1">
                            <input class="one" type="text"
                                name="user_id">
                        </div>
                    </div>
                    <div>
                        <div id="col0">비밀번호</div>
                        <div id="col1">
                            <input class="one" type="password"
                                name="user_passwd">
                        </div>
                    </div>
                </form>
                <div id="blank"></div>
                <div id="btn_login" class="btn_login">로그인</div>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="blank"></div>
            </div>
            <div id="btn_container">
                <div>메인화면</div>
                <div>취소</div>
            </div>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>