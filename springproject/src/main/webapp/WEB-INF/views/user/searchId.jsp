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
<script defer type="text/javascript" src="/resources/js/user/searchId.js" ></script> 
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<div class="searchDiv">
		<p>아이디 찾기</p>
		<div id="searchIdContainer">
			<img alt="realtor icon" src="/resources/image/usherIcon.png" style="margin-top: 1rem">
			<p>아이디가 기억나지 않으세요?</p>
			<p>아래 인증 방법을 통해 아이디를 확인 하실 수 있습니다.</p>
		</div>
		<div id="certificationDiv">
			<p>인증방식</p>
			<p>회원가입시 기입하셨던 이름과 전화번호를 입력해 주세요. </p>
			<div id="certificationForm">			
				<input type="text" id="name_input" name="searchInputName" maxlength="12" placeholder="이름을 입력해 주세요." onblur="confirmName()"> <br>
				<span class="name_error">*이름을 다시 확인해 주세요.</span> <br>
				<input type="text" id="phone_input" name="searchInputPhone" maxlength="12" placeholder="'-'를 제외한 전화번호를 입력해 주세요." onblur="confirmPhone()"> <br>
				<span class="phone_error">*전화번호를 다시 확인해 주세요.</span> <br>
				<button type="submit" id="searchBtn" onclick="checkWS(); searchIdAlert();">아이디 찾기</button>			
			</div>
		</div>
	</div>
	
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>