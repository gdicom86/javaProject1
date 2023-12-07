<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${pageTitle }</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/user/signUp.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<script defer type="text/javascript" src="/resources/js/user/signUp.js" ></script> 
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<div id="signUpContainer">
		<h2>회원정보수정</h2>
		<form action="/user/editAccount" method="post">
			<div id="signUpInput">
				<p style="color: rgb(0,102,51); font-weight: bold;">Welcome!</p>
				<p style="color: rgb(190,190,205); font-weight: bold;">부동산 코리아에 오신 것을 환영합니다.</p>
				<div class="hrDiv">
					<hr>
				</div>			
				<input type="text" id="id_input" name="id" placeholder="${ses.id }" value="${ses.id }" readonly="readonly"> <br>		
				<input type="password" id="pw_input" name="pw" placeholder="비밀번호를 입력해 주세요. ( 8자리 이상 영문 대소문자, 숫자, 특수문자가 각 1개 이상 )" maxlength="18" oninput="delayedCheckPw()"> <br>
				<span class="pw_ok">사용 가능한 패스워드입니다.</span>
				<span class="pw_error">최소 8자리 이상 영문 대소문자, 숫자, 특수문자가 각 1개 이상 필요합니다.</span>
				<input type="password" id="pw_confirm" name="pw_confirm" placeholder="비밀번호를 재입력해 주세요." onblur="confirmPw()"> <br>
				<span class="pw_confirm_ok">일치하는 비밀번호입니다.</span>
				<span class="pw_confirm_error">비밀번호를 다시 확인해 주세요.</span>
				<input type="text" id="name_input" name="name" placeholder="${ses.name }" value="${ses.name }" onblur="confirmName()" readonly="readonly"> <br>
				<span class="name_error">형식에 맞는 이름을 입력해 주세요.</span>
				<div id="addressDiv">
					<div class="horizontal">			
	   					<input type="text" name="address_postcode" readonly="readonly" placeholder="우편번호">
	   					<input type="button" value="주소검색" onclick="exePost()">	
	   					<span class="address_error">&nbsp;&nbsp; * 주소를 입력해 주세요.</span>
	   				</div>	
					<div class="vertical">
					    <input type="text" id="address_primary" name="address_primary" readonly="readonly" placeholder="기본주소">
					    <input type="text" name="address_detail" placeholder="나머지 주소(선택 사항)">
  					</div>
				</div>
				<div id="phoneDiv">
					<input type="hidden" name="phone" placeholder="전화번호">
					<select id="phoneNum1">
						<option value="010">010</option>
						<option value="011">011</option>
						<option value="016">016</option>
						<option value="017">017</option>
						<option value="018">018</option>
						<option value="019">019</option>
					</select>
					- <input type="number" id="phoneNum2" maxlength="4" oninput="maxLengthCheck(this)">
		    		- <input type="number" id="phoneNum3" maxlength="4" oninput="maxLengthCheck(this)"> 
				</div>
				<span class="phone_error">전화번호를 입력해 주세요.</span>
				<div id="emailDiv">
					<div id="emailSendDiv">
						<input type="text" name="email" id="email" placeholder="${ses.email }" value="${ses.email }" readonly="readonly">
						<input type="button" id="emailButton" value="인증코드 발송" onclick="sendEmail()">
					</div>
					<span class="email_error">이메일을 입력해 주세요.</span>
					<div id="emailRecieveDiv">
						<input type="text" id="code_input" placeholder="인증번호 입력" disabled="disabled"> <br>
						<span class="code_ok">인증되었습니다.</span>
						<span class="code_error">인증번호를 다시 입력해주세요.</span>
					</div>
				</div>	
				<input type="hidden" name="customerType" value="2"> <br>
				<button type="submit" onclick="validateButton(event)" id="regBtn">정보수정</button>
			</div>
		</form>		
	</div>
	<!-- footer -->	
	<jsp:include page="../layouts/footer.jsp"></jsp:include>