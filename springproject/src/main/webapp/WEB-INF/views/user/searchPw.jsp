<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/user/searchId.css">
<script src="https://code.jquery.com/jquery-3.4.1.js"></script> 
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<script defer type="text/javascript" src="/resources/js/user/searchPw.js" ></script> 
<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<div class="searchDiv">
		<p>비밀번호 찾기</p>
		<div id="searchIdContainer">
			<img alt="realtor icon" src="/resources/image/usherIcon.png" style="margin-top: 1rem">
			<p>비밀번호가 기억나지 않으세요?</p>
			<p>아래 인증 방법을 통해 비밀번호를 확인 하실 수 있습니다.</p>
		</div>
		<div id="certificationDiv">
			<p>인증방식</p>
			<p>아이디와 인증하셨던 이메일을 입력해 주세요. </p>
			<div id="certificationForm">			
				<input type="text" id="name_input" name="searchInputId" maxlength="12" placeholder="아이디를 입력해 주세요." onblur="confirmId()"> <br>
				<span class="id_error">*아이디를 다시 확인해 주세요.</span> <br>
				<input type="text" id="phone_input" name="searchInputEmail" placeholder="ex) email@gmail.com " onblur="confirmEmail()"> <br>
				<span class="email_error">*이메일을 다시 확인해 주세요.</span> <br>
				<button type="submit" id="searchBtn" onclick="checkWS(); sendEmail();">비밀번호 찾기</button>			
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>