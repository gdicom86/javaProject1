const idValidCheck = /^[a-zA-Z0-9]{4,12}$|^[a-zA-Z]{4,12}$/;
const emailValidCheck = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

// 아이디 형식 확인 onblur
function confirmId() {
	var id = $('input[name="searchInputId"]').val();
	if (idValidCheck.test(id)) {
		$('.id_error').css("display", "none");
	} else {
		$('.id_error').css("display", "inline-block");
	}
}

// 이메일 형식 확인 onblur
function confirmEmail() {
	var email = $('input[name="searchInputEmail"]').val();
	if (emailValidCheck.test(email)) {
		$('.email_error').css("display", "none");
	} else {
		$('.email_error').css("display", "inline-block");
	}
}

// Check White Space
function checkWS() {
	
	var id = $('input[name="searchInputId"]').val();	
	var email = $('input[name="searchInputEmail"]').val();
	
	// 이름 공백 확인
	if(id == '') {
		$('.id_error').css("display", "inline-block");	
	}
	
	// 전화번호 공백 확인
	if(email == '') {
		$('.email_error').css("display", "inline-block");	
	}
	
}

// 이메일 보내기
function sendEmail() {
	var id = $('input[name="searchInputId"]').val();
	var email = $('input[name="searchInputEmail"]').val();
	$("#searchBtn").text('전송중...');	
	$.ajax({
		url: "/user/searchPw",
		type: "post",
		data: { 'id': id, 'email': email },
		success: function(data) {			
			console.log("Data from the server: ", data);
			if (data == "N") {
				Swal.fire(
					'Error!',
        			'회원 정보를 확인해 주세요.',
        			'error'
				)
			} else {
				Swal.fire(
					'Success',
					'고객님의 이메일에 임시 비밀번호가 발급되었습니다.', 
					'success'
				)
			}
			$("#searchBtn").text('비밀번호 찾기');
		},
		error: function (xhr, status, error) {	
			$("#searchBtn").text('비밀번호 찾기');
			// Handle error response (if needed)
			// 혹시 모를 중복 발생시
            Swal.fire(
                '오류 발생!',
                '아이디를 찾는 동안 문제가 발생했습니다. 다시 시도해주세요.',
                'error'
            );	
			console.error(error);
		}
	});
}