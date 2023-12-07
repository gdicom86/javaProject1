<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>등업 신청</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script> 
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/levelUp/register.css">
<!-- Sweet Alert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/levelUp/register.js"></script>
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<div>
		<h1 style="margin-top: 14rem; text-align: center;">등업 신청</h1>
	</div>
	<form style="padding: 20px;" action="/levelUp/register" method="post" id="registerForm">
		<table>
			<tbody>
				<tr>
					<th>아이디 <span data-tooltip="필수항목"><i
							class="fa-solid fa-circle-exclamation fa-2xs"
							style="color: #ff0000;"></i></span>
					</th>
					<td><input type="text" name="id" value="${ses.id }" readonly="readonly" required="required"></td>
				</tr>
				<tr>
					<th>핸드폰번호 <span data-tooltip="필수항목"><i
							class="fa-solid fa-circle-exclamation fa-2xs"
							style="color: #ff0000;"></i></span>
					</th>
					<td><input type="text" name="phone">
						<p id="phoneError" style="color: red; display: none;">핸드폰번호를 입력해주세요.</p>
					</td>
				</tr>
				<tr>
					<th>사업자 등록번호 <span data-tooltip="필수항목"><i
							class="fa-solid fa-circle-exclamation fa-2xs"
							style="color: #ff0000;"></i></span>
					</th>
					<td><input type="text" name="businessNumber">
						<p id="businessNumberError" style="color: red; display: none;">사업자 등록번호를 입력해주세요.</p>
					</td>
				</tr>
				<tr>
					<th>등업신청 내용</th>
					<td><textarea name="content" id="" cols="30" rows="10" placeholder="ex) 어떤부동산 소속공인중개사 김땡땡입니다.&#10;    매물 등록을 위해 등업 신청합니다."></textarea>
						<p id="contentError" style="color: red; display: none;">등업신청 내용을 입력해주세요.</p>
					</td>
				</tr>
			</tbody>
		</table>
		<div class="subtitle">개인정보의 수집 및 이용에 대한 안내</div>
		개인정보의 처리 <span data-tooltip="필수항목"><i class="fa-solid fa-circle-exclamation fa-2xs"
			style="color: #ff0000;"></i></span> <span id="privacy-policy"
			style="cursor: pointer;" class="detail">자세히보기</span>
		<!-- ***************************************************************************************************************************************************************************************************** -->
		<div id="policy-modal" class="modal">
			<span id="close-button-policy" class="modal-close">&times;</span>
			<div class="modal-content">
				<p>※ "개인정보"란 살아 있는 개인에 관한 정보로서 다음의 어느 하나에 해당하는 정보를 말합니다(「개인정보
					보호법」 제2조제1호). 1. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보 2. 해당
					정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보(이 경우 쉽게 결합할 수
					있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야
					함) 3. 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용·결합 없이는 특정 개인을 알아볼 수 없는 정보
					※ "가명처리"란 개인정보의 일부를 삭제하거나 일부 또는 전부를 대체하는 등의 방법으로 추가 정보가 없이는 특정 개인을
					알아볼 수 없도록 처리하는 것을 말합니다((「개인정보 보호법」 제2조제1호의2).</p>
			</div>
		</div>
		개인정보의 수집·이용 방법 <span data-tooltip="필수항목"><i class="fa-solid fa-circle-exclamation fa-2xs"
			style="color: #ff0000;"></i></span> <span id="privacy-policy1"
			style="cursor: pointer;" class="detail">자세히보기</span>

		<div id="policy-modal1" class="modal">
			<span id="close-button-policy1" class="modal-close">&times;</span>
			<div class="modal-content">
				<p>개인정보의 수집·이용 개인정보처리자
				※ "개인정보"란 살아 있는 개인에 관한 정보로서 다음의 어느 하나에 해당하는 정보를 말합니다(「개인정보
					보호법」 제2조제1호). 1. 성명, 주민등록번호 및 영상 등을 통하여 개인을 알아볼 수 있는 정보 2. 해당
					정보만으로는 특정 개인을 알아볼 수 없더라도 다른 정보와 쉽게 결합하여 알아볼 수 있는 정보(이 경우 쉽게 결합할 수
					있는지 여부는 다른 정보의 입수 가능성 등 개인을 알아보는 데 소요되는 시간, 비용, 기술 등을 합리적으로 고려하여야
					함) 3. 가명처리함으로써 원래의 상태로 복원하기 위한 추가 정보의 사용·결합 없이는 특정 개인을 알아볼 수 없는 정보
					※ "가명처리"란 개인정보의 일부를 삭제하거나 일부 또는 전부를 대체하는 등의 방법으로 추가 정보가 없이는 특정 개인을
					알아볼 수 없도록 처리하는 것을 말합니다((「개인정보 보호법」 제2조제1호의2).</p>
			</div>
		</div>
		<div>
			<input type="checkbox">상담진행을 위해 개인정보 수집 및 이용에 동의 합니다.
		</div>

		<button id="levelUpBtn" onclick="validateButton(event)" type="submit"  style="margin-bottom: 108px;">등업신청</button>
	</form>
	
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>