<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 수정</title>
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
<link rel="stylesheet" href="/resources/css/board/register.css">
<link rel="stylesheet" href="/resources/css/board/modify.css">
<!-- JS import -->
<script defer type="text/javascript" src="/resources/js/board/modify.js" ></script>
<script defer type="text/javascript" src="/resources/js/navigation.js"></script>
</head>
<body>
	<!-- navigation -->
	<jsp:include page="../layouts/navigation.jsp"></jsp:include>
	<c:set value="${ bdto.bvo }" var="bvo"></c:set>
	<c:set value="${ bdto.combinedList }" var="fvoList"></c:set>
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
	<main>
		<form action="/board/modify" method="post" enctype="multipart/form-data">
			<input type="hidden" name="bno" value="${bvo.bno}" />
			<!-- Type A -->
			<input type="hidden" name="searchType_a" id="mySelection_a">
			<div id="searchType_aDiv">
				<ul>
					<li class="type_a" data-value="아파트">
						<div>
							<i class="fa-solid fa-building"></i>
							<div class="type_a-name">아파트</div>
						</div>
					</li>
					<li class="type_a" data-value="원룸">
						<div>
							<i class="fa-solid fa-house-user"></i>
							<div class="type_a-name">원룸</div>
						</div>
					</li>
					<li class="type_a" data-value="빌라">
						<div>
							<i class="fa-solid fa-hotel"></i>
							<div class="type_a-name">빌라</div>
						</div>
					</li>
					<li class="type_a" data-value="단독/다가구">
						<div>
							<i class="fa-solid fa-people-roof"></i>
							<div class="type_a-name">단독/다가구</div>
						</div>
					</li>
					<li class="type_a" data-value="상가">
						<div>
							<i class="fa-solid fa-store"></i>
							<div class="type_a-name">상가</div>
						</div>
					</li>				
				</ul>
			</div>
			<!-- Type B -->
			<input type="hidden" name="searchType_b" id="mySelection_b">
			<div id="searchType_bDiv">
				<ul>
					<li class="type_b" data-value="매매">
						<div>
							<i class="fa-regular fa-credit-card"></i>
							
							<div class="type_b-name">매매</div>
						</div>
					</li>
					<li class="type_b" data-value="전세">
						<div>
							<i class="fa-solid fa-handshake"></i>
							<div class="type_b-name">전세</div>
						</div>
					</li>
					<li class="type_b" data-value="월세">
						<div>
							<i class="fa-solid fa-sack-dollar"></i>
							<div class="type_b-name">월세</div>
						</div>
					</li>
					<li class="type_b" data-value="단기">
						<div>
							<i class="fa-solid fa-coins"></i>
							<div class="type_b-name">단기</div>
						</div>
					</li>		
				</ul>
			</div>
			<p id="typeError" class="error" style="color: red; display: none;">해당하는 카테고리를 눌러주세요.</p>
			<div class="mb-3">
  				<label for="title" class="form-label">Title</label>
  				<input type="text" class="form-control" name="title" id="title" value="${ bvo.title }">
			</div>
			<p id="titleError" class="error" style="color: red; display: none;">제목을 입력해주세요.</p>
			<div class="mb-3">
			  	<label for="writer" class="form-label">Writer</label>
			  	<input type="text" class="form-control" name="writer" id="writer" value="${ bvo.writer }" readonly="readonly">
			</div>
			<span id="areaSpan">Area</span>
			<div id="areaDiv" style="margin-top: 8px; margin-bottom: 16px;">
				<div style="margin-right: 4px;">
					<select name="searchType_add1" onChange="add1_change(this.value,searchType_add2)" class="form-select" aria-label="Default select example">
						<option>-선택-</option>
						<option value='서울'>서울</option>
						<option value='부산'>부산</option>
				  		<option value='대구'>대구</option>
						<option value='인천'>인천</option>
						<option value='광주'>광주</option>
						<option value='대전'>대전</option>
						<option value='울산'>울산</option>
						<option value='강원'>강원</option>
						<option value='경기'>경기</option>
						<option value='경남'>경남</option>
						<option value='경북'>경북</option>
						<option value='전남' >전남</option>
						<option value='전북'>전북</option>
						<option value='제주'>제주</option>
						<option value='충남'>충남</option>
						<option value='충북'>충북</option>
					</select>
				</div>
				<div>
					<select name="searchType_add2" onChange="add2_change(this.value)" class="form-select" aria-label="Default select example">
				  		<option>-선택-</option>
					</select>
				</div>
				<p id="arenaError" class="error" style="color: red; display: none;">* 해당 지역을 선택해주세요.</p>			
			</div>
			<div class="mb-3">
			  	<label for="content" class="form-label">Content</label>
			  	<textarea class="form-control" name="content" id="content" rows="3">${ bvo.content }</textarea>
			</div>
			<p id="contentError" class="error" style="color: red; display: none;">* 상세 정보를 입력해주세요.</p>
			<!-- file upload -->
			<div class="file-upload-container">
				<div id="thumbFileDiv">
					<input type="file" id="thumbFile" name="thumbFiles" style="display: none" required>
					<button type="button" id="thumbFileTrigger">썸네일 업로드</button>
					<div id="oldThumbFileZone">
						<c:forEach items="${ fvoList }" var="fvo">
                        	<c:if test="${fvo.fileCategoryNum == 1}">
								<img alt="image" src="/upload/${fn:replace(fvo.save_dir, '\\','/')}/${fvo.uuid}_${fvo.file_name}">
								<button type="button" class="file-x" data-uuid="${fvo.uuid }">&times;</button>
							</c:if>
                         </c:forEach>
					</div>
					<div id="thumbFileZone">
						
					</div>				
				</div>
				
				<div id="detailFileDiv">
					<input type="file" id="detailFile" name="detailFiles" style="display: none" required multiple>
					<button type="button" id="detailFileTrigger">상세사진 업로드</button>
					<div id="oldDetailFileZone">
						<c:forEach items="${ fvoList }" var="fvo">
                        	<c:if test="${fvo.fileCategoryNum == 0}">
								<img alt="image" src="/upload/${fn:replace(fvo.save_dir, '\\','/')}/${fvo.uuid}_${fvo.file_name}">
								<button type="button" class="file-x" data-uuid="${fvo.uuid }">&times;</button>
							</c:if>
                         </c:forEach>
					</div>
					<div id="detailFileZone">
						
					</div>
				</div>				
			</div>
			<button type="submit" onclick="validateButton(event)" class="btn-hover color-1">등록</button>
		</form>
	</main>
	<!-- footer -->
	<jsp:include page="../layouts/footer.jsp"></jsp:include>