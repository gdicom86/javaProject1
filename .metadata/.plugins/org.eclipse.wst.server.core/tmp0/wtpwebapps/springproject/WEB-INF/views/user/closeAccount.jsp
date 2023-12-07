<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/user/closeAccount.css">
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/user/closeAccount.js"></script>
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script> 
<!-- fontawesome -->
<script src="https://kit.fontawesome.com/55381cd0ef.js" crossorigin="anonymous"></script>
<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<div id="mainDiv">
		<div id="consentInfo">
			<div>
				<i class="fa-solid fa-triangle-exclamation"></i> <span>계정 해지는 영구적인 조치입니다.</span> <br>
				<span>계정 해지는 영구적인 조치입니다. 해지 후에는 더 이상 계정을 이용할 수 없으며 복원할 수 없습니다.</span>
			</div>
		</div>
		<div id="consentDiv">
			<input type="checkbox" id="checkConsent" name="checkConsent" onclick="checkConsent()"><span>예. 부동산 코리아 계정을 영구적으로 해지하고 싶습니다.</span>
		</div>		
		<button type="submit" id="consentBtn" disabled="disabled" onclick="closeAccountBtn()">계정 해지</button>		
	</div>
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>