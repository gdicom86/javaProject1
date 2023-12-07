const nameValidCheck = /^[가-힣]+|[a-zA-Z]+$/;
const phoneValidCheck = /^[0-9]+$/;

// 이름 형식 확인 onblur
function confirmName() {
	var name = $('input[name="searchInputName"]').val();	
	if (nameValidCheck.test(name)) {
		$('.name_error').css("display", "none");
	} else {
		$('.name_error').css("display", "inline-block");
	}
}

// 번호 형식 확인 onblur
function confirmPhone() {
	var phone = $('input[name="searchInputPhone"]').val();
	if (phoneValidCheck.test(phone)) {
		$('.phone_error').css("display", "none");
	} else {
		$('.phone_error').css("display", "inline-block");
	}
}

// 아이디 찾기 sweetalert2
function searchIdAlert(event) {

	var name = $('input[name="searchInputName"]').val();	
	var phone = $('input[name="searchInputPhone"]').val();
	console.log("name: " + name);
	console.log("phone: " + phone);
	
	$.ajax({
		url: '/user/searchId',
		method: 'post',
		data: { "name": name, "phone": phone },
		success: function (data) {
			console.log("Data from the server: ", data);
			if (data.trim() == "") {				
				Swal.fire(
					'Error!',
        			'회원 정보를 확인해 주세요.',
        			'error'
				)			
			} else {
				Swal.fire(
					'Success',
					'아이디 찾기에 성공하였습니다. <br>고객님의 아이디는 ' + data + '입니다.', 
					'success'
				)
			}
		},
		error: function (xhr, status, error) {	
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

// Check White Space
function checkWS() {
	
	var name = $('input[name="searchInputName"]').val();	
	var phone = $('input[name="searchInputPhone"]').val();
	
	// 이름 공백 확인
	if(name == '') {
		$('.name_error').css("display", "inline-block");	
	}
	
	// 전화번호 공백 확인
	if(phone == '') {
		$('.phone_error').css("display", "inline-block");	
	}
	
}