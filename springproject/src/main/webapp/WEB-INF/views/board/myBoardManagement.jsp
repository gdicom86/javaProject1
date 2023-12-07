<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내글관리</title>
<!-- font awesome -->
<script src="https://kit.fontawesome.com/e927512ef5.js" crossorigin="anonymous"></script>
<!-- CSS import -->
<link rel="stylesheet" href="/resources/css/board/myBoardManagement.css">
<link rel="stylesheet" href="/resources/css/navigation.css">
<link rel="stylesheet" href="/resources/css/footer.css">
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/board/myBoardManagement.js" ></script>
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<h1 style="margin-top: 14rem; text-align: center;">내글관리</h1>
	<c:choose>
		<c:when test="${ empty myBdtoList }">
			<p id="emptyPara">등록된 게시물이 없습니다.</p>
		</c:when>
		<c:otherwise>
			<div id="dtoListDiv">
			<c:forEach items="${ myBdtoList }" var="dto">		
				<div class="dtoDiv">
					<a href="/board/detail?bno=${ dto.bvo.bno }">
						<span class="info-1">등록인: ${ ses.name }</span> <span class="info-2">${ dto.bvo.searchType_a }</span>
						<span class="img-wrapper">
	                        <span class="img-container">
	                            <c:forEach items="${ dto.combinedList }" var="fvo">
	                                <c:if test="${fvo.fileCategoryNum == 1}">
       									<img alt="image" src="/upload/${fn:replace(fvo.save_dir, '\\','/')}/${fvo.uuid}_${fvo.file_name}">
   									</c:if>
	                            </c:forEach>
	                        </span>
	                    </span>     	
	                    <span class="info-3">${ dto.bvo.searchType_b }</span> <span class="info-4">${ dto.bvo.title }</span>
	                    <span class="info-5">${ dto.bvo.searchType_add1 } ${ dto.bvo.searchType_add2 }</span>						
						<span class="info-6">${ dto.bvo.content }</span>
						<span class="info-7">등록일자: ${ dto.bvo.reg_date }</span>
						<span class="info-8">조회수: ${ dto.bvo.read_count }</span>
					</a>
				</div>
			</c:forEach>
			</div>
		</c:otherwise>
	</c:choose>
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>