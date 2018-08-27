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
<link rel="stylesheet" type="text/css" href="/css/membership.css">
<link rel="stylesheet" type="text/css" href="/css/header.css">
<link rel="stylesheet" type="text/css" href="/css/footer.css">
</head>
<script type="text/javascript" src="/js/jquery-3.2.1.js"></script>
<script type="text/javascript" src="/js/membership.js"></script>
<script type="text/javascript" src="/js/header.js"></script>
<script type="text/javascript">
	var error_char = '비밀번호에 영문자가 포함되어야 합니다';
	var error_digit = '비밀번호에 숫자가 포함되어야 합니다';
	var error_unique = '비밀번호에 특수문자가 포함되어야 합니다';
	var error_password_length = '비밀번호가 8자리 이상이어야 합니다';

	var error_not_correct_pw = '비밀번호가 서로 맞지 않습니다';
	var error_id_length = '아이디는 8자 이상이어야 합니다'

	var id_checked = 0;

	//password pattern check
	var checkPasswordPattern = function(str) {

		var pattern1 = /[0-9]/; // 숫자
		var pattern2 = /[a-zA-Z]/; // 문자
		var pattern3 = /[~!@#$%^&*()_+|<>?:{}]/; // 특수문자

		if (!pattern2.test(str)) {
			return error_char;
		} else if (!pattern1.test(str)) {
			return error_digit;
		} else if (!pattern3.test(str)) {
			return error_unique;
		} else if (str.length < 8) {
			return error_password_length;
		} else {
			return '';
		}
	}

	$(document).ready(function() {
		$('#id_check').on('click', function(event) {
			var user_id = $('#id').val();
			var data = {
				'user_id' : user_id,
			};
			
			if (user_id.length < 8) {
				alert(error_id_length);
				return false;
			}

			$.ajax({
				url : '/id_check',
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
				if (data == 0) {
                    alert('사용가능한 아이디 입니다');
					id_checked = 1;
				} else {
					alert('중복된 아이디가 있습니다');
					id_checked = 0;
				}
			}).fail(function(xhr, textStatus, error) {
				// 통신이 실패했을 때 이 함수를 타게 된다.
				alert('정상적인 경로로 접속해주세요');
				id_checked = 0;
			}).always(function(data, textStatus, xhr) {
				// 통신이 실패했어도 성공했어도 이 함수를 타게 된다.
			});
		});

		$('.btn_membership').on('click', function(event) {
			var id = $('#id').val();

			var pw1 = $('#pw1').val();
			var pw2 = $('#pw2').val();

			if (id.length < 8) {
				alert(error_id_length);
				return false;
			}

			if (pw1 == pw2) {
				if ('' == checkPasswordPattern(pw2)) {
					if (id_checked == 0) {
						alert('아이디 중복 체크를 해주세요');
						return false;
					} else {
						$('form').submit();
					}
				} else {
					alert(checkPasswordPattern(pw2));
					return false();
				}

			} else {
				alert(error_not_correct_pw);
				return false;
			}
		});
	});
</script>
<body>
    <%@ include file="./inc/header.jsp"%>
    <div id="container">
        <div id="membership_form">
            <div id="form">
                <div id="blank"></div>
                <div id="title">회원가입</div>
                <div id="blank"></div>
                <form action="/membership_rest" method="post">
                    <div>
                        <div id="col0">아이디</div>
                        <div id="col1">
                            <input id="id" class="two" type="text"
                                name="user_id"> <input
                                type="button" value="중복확인" class="two"
                                id="id_check">
                        </div>
                    </div>
                    <div>
                        <div id="col0">비밀번호</div>
                        <div id="col1">
                            <input id="pw1" class="one" type="password"
                                name="">
                        </div>
                    </div>
                    <div>
                        <div id="col0">비밀번호 확인</div>
                        <div id="col1">
                            <input id="pw2" class="one" type="password"
                                name="user_passwd">
                        </div>
                    </div>
                    <div>
                        <div id="col0">이메일</div>
                        <div id="col1">
                            <input class="two" type="text"
                                name="user_email1"> @ <input
                                type="text" name="user_email2">
                        </div>
                    </div>
                    <div>
                        <div id="col0">폰번호</div>
                        <div id="col1">
                            <input class="one" type="text"
                                name="user_phone">
                        </div>
                    </div>
                </form>
                <div id="blank"></div>
                <div id="blank"></div>
                <div id="blank"></div>
            </div>
            <div id="btn_container">
                <div>메인화면</div>
                <div class="btn_membership">회원가입</div>
                <div>취소</div>
            </div>
        </div>
    </div>
    <%@ include file="./inc/footer.jsp"%>
</body>
</html>