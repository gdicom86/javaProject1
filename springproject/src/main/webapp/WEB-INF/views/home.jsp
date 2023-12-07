<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>부동산 코리아</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css" />
<link rel="stylesheet" href="/resources/css/footer.css" />
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
<link rel="stylesheet" href="/resources/css/chatbot/chatbot.css" />
<link rel="stylesheet" href="/resources/css/home.css" />
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<script defer type="text/javascript" src="/resources/js/chatbot/chatbot.js"></script>
<script defer type="text/javascript" src="/resources/js/board/register.js" ></script>
<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
<!-- jquery import -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="./layouts/navigation.jsp"></jsp:include>
	
	<!-- Welcome 화면 -->
	<div class="text">
	  <p>Budongsan Korea is</p>&nbsp;&nbsp;
	  <p>
	    <span class="word wisteria">smart.</span>
	    <span class="word belize">beautiful.</span>
	    <span class="word pomegranate">awesome.</span>
	    <span class="word green">simple.</span>
	    <span class="word midnight">coool.</span>
	  </p>
	</div>

	<!-- main -->
	<main>
		<!-- 영상 or CF광고 -->
		<div class="video-box">
			<video src="/resources/video/skyscraper.mp4" muted autoplay loop>
				<source src="/resources/video/skyscraper.mp4" type="video/mp4">
			</video>
		</div>
		

		<!-- 플로팅 메뉴 or 퀵메뉴 -->
		<div class="floating">
			<button id="info-button">
				<i class="fa-solid fa-question" style="color: white"></i>
			</button>
			<div id="info-modal" class="modal">
				<div id="modal-header"
					style="display: flex; justify-content: center; align-items: center">
					<img class="robot-icon2" alt="robot-icon"
						src="/resources/image/icon_robot.png" /> <span>챗봇
						서비스</span> <span id="close-button">&times;</span>
				</div>
				<div id="wrap">
					<!-- 응답 메시지 출력  -->
					<div id="chatBox"></div>

					<!-- 질문 메시지 입력 폼 -->
					<form id="chatForm"
						style="display: flex; border: none; width: 100%">
						<input type="text" id="message" name="message" size="30"
							placeholder="질문을 입력하세요" /> <input type="submit"
							value="전송" />
					</form>
				</div>
			</div>
		</div>
	</main>

	<!-- footer -->
	<script type="text/javascript">
		// 회원 가입
		const msg_signUp = `<c:out value="${msg_signUp}"/>`;
		if (msg_signUp == 1) {
			Swal.fire("Success", "회원 가입을 축하드립니다.", "success");
		}
		// 정보 수정
		const msg_editAccount = `<c:out value="${msg_editAccount}"/>`;
		if (msg_editAccount == 1) {
			Swal.fire("Success", "성공적으로 회원님의 정보가 수정되었습니다.", "success");
		}
		// 로그인
		const loginSuccess = `<c:out value="${loginSuccess}"/>`;
		if (loginSuccess == 1) {
			Swal.fire("환영합니다!", "${name}님 ${email}으로 로그인 하셨습니다.", "success");
		}
		// 게시글 등록 권한
		const notRegister = `<c:out value="${notRegister}"/>`;
		console.log(notRegister);
		if (notRegister == 1) {
			Swal.fire("Error", "게시글 등록 권한이 없습니다.", "error");
		}
	</script>
	<jsp:include page="./layouts/footer.jsp"></jsp:include>
</body>
</html>
