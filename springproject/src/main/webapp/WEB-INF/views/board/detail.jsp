<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세보기</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<link rel="stylesheet" href="/resources/css/board/detail.css">
<!-- Jquery -->
<script src="https://code.jquery.com/jquery-3.4.1.js"></script> 
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/board/detail.js" ></script>
<script type="text/javascript" src="/resources/js/comment/comment.js"></script>
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
<!-- SweetAlert2 -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
</head>
<body id="detailBody">
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<h1 style="margin-top: 14rem;">상세보기</h1>
	<c:set value="${ bdto.combinedList }" var="fvoList"></c:set>
	<c:set value="${ bdto.bvo }" var="bvo"></c:set>
	
	<section id="mainSection">
		<!-- 썸네일 사진 가져오기 -->
		<div class="thumbnailImage">
			<c:forEach items="${ fvoList }" var="file">
				<c:if test="${ file.fileCategoryNum == 1 }">
					<img alt="thumbnailImage" src="/upload/${fn:replace(file.save_dir, '\\','/') }/${file.uuid}_${file.file_name}">
				</c:if>
			</c:forEach>
		</div>
		<!-- 정보 가져오기 -->
		<div class="boardOption">
			<span>매물정보</span>
			<span>매물번호: ${ bvo.bno }</span>
			<span>매물유형: ${ bvo.searchType_a }</span>
			<span>거래유형: ${ bvo.searchType_b }</span>
			<span>주소: ${ bvo.searchType_add1 } ${ bvo.searchType_add2 }</span>
			<span>가격: ${ bvo.title }</span>
			<span>등록인: ${ bvo.writer }</span>
			<span>등록일자: ${ bvo.reg_date }</span>
		</div>
	</section>
	
	<!-- 콘텐트 가져오기 -->
	<div class="content">
		<span>상세 내용</span>
		<div>${ bvo.content }</div>
	</div>
	
	<!-- 상세사진 가져오기 -->
	<div class="detailImage">
		<c:forEach items="${ fvoList }" var="file">
			<c:if test="${ file.fileCategoryNum == 0 }">
				<img alt="thumbnailImage" src="/upload/${fn:replace(file.save_dir, '\\','/') }/${file.uuid}_${file.file_name}">
			</c:if>
		</c:forEach>
	</div>
	
	<!-- 코멘트 작성 라인 -->
	<div id="reviewWrite">
		<!-- api -->
		<c:if test="${ apiSes != null }">
			<span id="cmtWriter">${ email }</span>
		</c:if>
		<!-- ses -->
		<c:if test="${ ses != null }">
			<span id="cmtWriter">${ ses.id }</span>
		</c:if>	
		<fieldset class="rate">
        	<input type="radio" id="rating10" name="rating" value="10"><label for="rating10" title="5점"></label>
            <input type="radio" id="rating9" name="rating" value="9"><label class="half" for="rating9" title="4.5점"></label>
            <input type="radio" id="rating8" name="rating" value="8"><label for="rating8" title="4점"></label>
            <input type="radio" id="rating7" name="rating" value="7"><label class="half" for="rating7" title="3.5점"></label>
            <input type="radio" id="rating6" name="rating" value="6"><label for="rating6" title="3점"></label>
            <input type="radio" id="rating5" name="rating" value="5"><label class="half" for="rating5" title="2.5점"></label>
            <input type="radio" id="rating4" name="rating" value="4"><label for="rating4" title="2점"></label>
            <input type="radio" id="rating3" name="rating" value="3"><label class="half" for="rating3" title="1.5점"></label>
            <input type="radio" id="rating2" name="rating" value="2"><label for="rating2" title="1점"></label>
            <input type="radio" id="rating1" name="rating" value="1"><label class="half" for="rating1" title="0.5점"></label>
        </fieldset>
		<input type="text" id="cmtText" class="textArea" onclick="checkSignIn()">
		<button type="button" id="cmtPostBtn">등록</button>
	</div>
	
	<!-- 코멘트 표시 라인 -->	
	<div id="reviewList">
		<ul id="cmtListArea">
		</ul>
	</div>
	
	<!-- 수정, 삭제 메뉴 -->
	<c:if test="${ ses.id != null  && ses.id == bvo.writer}">
		<div id="btnDiv">
			<a href="/board/modify?bno=${ bvo.bno }"><button type="button">게시물 수정</button></a>	
			<button type="button" onclick="showConfirmationModal(${ bvo.bno })">게시물 삭제</button>		
		</div>
	</c:if>	
	<!-- 댓글 로그인 확인 -->
	<script type="text/javascript">
		const bnoVal = `<c:out value="${ bvo.bno }"/>`;
		const apiSesName = `<c:out value="${ name }"/>`;
		const sesId = `<c:out value="${ ses.id }"/>`;
		const apiSesEmail = `<c:out value="${ email }"/>`;
		
		function checkSignIn() {
	        console.log("bnoVal: " + bnoVal);
	        console.log("apiSesName: " + apiSesName);
	        console.log("sesId: " + sesId);

	        if (${apiSes != null} || ${ses != null}) {
	            console.log("사용자가 로그인되어 있습니다. 작업을 계속합니다.");
	        } else {
	       		Swal.fire(
     				'ERROR',
                    '로그인이 필요합니다.',
                    'error'
                ).then(() => {
             		// 로그인 페이지로 리디렉션
                    window.location.href = "/user/signIn";
                    return false; // 리디렉션 이후 함수 종료
               	});
	        }
	    }
	</script>
	<script type="text/javascript">
		getCommentList(bnoVal);
	</script>
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>