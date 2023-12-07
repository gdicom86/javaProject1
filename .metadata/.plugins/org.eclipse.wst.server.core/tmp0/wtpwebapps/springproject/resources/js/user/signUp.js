let isFormValid = true; // 폼 유효성 검사 결과
let code = "";
const idValidCheck = /^[a-zA-Z0-9]{4,12}$|^[a-zA-Z]{4,12}$/;
const pwValidCheck = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$ %^&*-]).{8,16}$/;
const nameValidCheck = /^[가-힣]+|[a-zA-Z]+$/;
const emailValidCheck = /^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/;

// 비동기 아이디 중복 검사
function checkId() {
    var id = $('#id_input').val();
    $.ajax({
        url: '/user/idCheck',
        type: 'post',
        data: { "id": id },
        success: function (data) {
        	// 조건 추가
        	if (idValidCheck.test(id)) {
        		if (data == "N") {
        			$('.id_ok').css("display", "inline-block");
                	$('.id_already').css("display", "none");  
                	$('.id_error').css("display", "none");                	
                	isFormValid = true;
        		} else {
        			$('.id_already').css("display", "inline-block");
	                $('.id_ok').css("display", "none");
	                $('.id_error').css("display", "none");
	                isFormValid = false;
        		}
        	} else {
        		$('.id_error').css("display", "inline-block");
               	$('.id_already').css("display", "none");
                $('.id_ok').css("display", "none");
                isFormValid = false;
        	}    	
        },
        error: function (error) {
            console.log("에러 발생: " + error.responseText);
        }
    });
}

// 비밀번호 유효성 검사
function checkPw() {
	var pw = $('#pw_input').val();
	
	if(pwValidCheck.test(pw)) {
		$('.pw_ok').css("display", "inline-block");
		$('.pw_error').css("display", "none");
		isFormValid = true;
	} else {
		$('.pw_error').css("display", "inline-block");
		$('.pw_ok').css("display", "none");
		isFormValid = false;
	}
}

// 비밀번호 확인
function confirmPw() {
	var pw = $('#pw_input').val();
	var pwConfirm = $('#pw_confirm').val();
	if(pw === pwConfirm) {
		$('.pw_confirm_ok').css("display", "inline-block");
		$('.pw_confirm_error').css("display", "none");
		isFormValid = true;
	} else {
		$('.pw_confirm_error').css("display", "inline-block");
		$('.pw_confirm_ok').css("display", "none");
		isFormValid = false;
	}
}

// 이름 형식 확인
function confirmName() {
	var name = $('#name_input').val();
	if (nameValidCheck.test(name)) {
		$('.name_error').css("display", "none");
		isFormValid = true;
	} else {
		$('.name_error').css("display", "inline-block");
		isFormValid = false;
	}
}

// 주소 검색
function exePost() {
	 new daum.Postcode({
         oncomplete: function(data) {
            // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

            // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
            // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
            var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
            var extraRoadAddr = ''; // 도로명 조합형 주소 변수

            // 법정동명이 있을 경우 추가한다. (법정리는 제외)
            // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
            if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                extraRoadAddr += data.bname;
            }
            // 건물명이 있고, 공동주택일 경우 추가한다.
            if(data.buildingName !== '' && data.apartment === 'Y'){
               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
            }
            // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
            if(extraRoadAddr !== ''){
                extraRoadAddr = ' (' + extraRoadAddr + ')';
            }
            // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
            if(fullRoadAddr !== ''){
                fullRoadAddr += extraRoadAddr;
            }

            // 우편번호와 주소 정보를 해당 필드에 넣는다.
            console.log(data.zonecode);
            console.log(fullRoadAddr);
            
          
            $("[name=address_postcode]").val(data.zonecode);
            $("[name=address_primary]").val(fullRoadAddr);
            
         	$("[name=address_detail]").focus();
            
        }
     }).open();
}

// 전화번호 길이제한
function maxLengthCheck(object){
	if (object.value.length > object.maxLength) {
		object.value = object.value.slice(0, object.maxLength);
    }
}

// 이메일 보내기
function sendEmail() {
	if (!emailValidCheck.test($("#email").val())) {
		alert("이메일 형식에 맞추어 작성하세요.");
	} else {
		let email = $("#email").val();  //입력한 이메일
		$("#emailButton").val("전송중...");
		$.ajax({
			// controller에 보낼 주소
			url: "/user/mailSender",
			type: "get",
			data: {'email':email},
			success: function(rnum) {
				Swal.fire(
					'Success',
					'기입하신 이메일에 성공적으로 전송하였습니다.', 
					'success'
				)
				$("#emailButton").val("인증코드 발송");
				$("#code_input").attr("disabled", false); //입력칸 활성화
				code = rnum;				
			},
			error: function () {
				$("#emailButton").val("인증코드 발송");
				Swal.fire(
					'Error!',
        			'전송에 실패하였습니다. 이메일을 확인해 주세요.',
        			'error'
				)		
			}
		});		
	}
	
}

// 메일 인증 확인 (#code_input에서 blur 될 때 실행)
$("#code_input").blur(function() {
	// console.log("code: " + code);
	let code_input = $("#code_input").val();
	// console.log("code_input: " + code_input);
	if(code == $("#code_input").val()) { //인증번호 같다면
		$('.code_ok').css("display", "inline-block");
		$('.code_error').css("display", "none");
		isFormValid = true;
	}else {
		$('.code_error').css("display", "inline-block");
		$('.code_ok').css("display", "none");
		isFormValid = false;
	}
});

// 공백 검사 & 폼 전송 방지
function validateButton(event) { 
	let emptyCheck = true;
	
	let id_input = $('#id_input').val();
	// console.log("id_input: " + id_input);
	
	let pw_input = $('#pw_input').val();
	// console.log("pw_input: " + pw_input);
	
	let pw_confirm = $('#pw_confirm').val();
	// console.log("pw_confirm: " + pw_confirm);
	
	let name_input = $('#name_input').val();
	// console.log("name_input: " + name_input);
	
	let address_input = $("[name=address_postcode]").val();
	// console.log("address_input: " + address_input);
	
	let email_input = $("#email").val();
	// console.log("email_input: " + email_input);
	
	let code_input = $("#code_input").val();
	// console.log("code_input: " + code_input);
	
	// 아이디 공백
	if (id_input == '') {
		$('.id_error').css("display", "inline-block");
       	$('.id_already').css("display", "none");
        $('.id_ok').css("display", "none");
		emptyCheck = false;
	}
	// 비밀번호 공백
	if (pw_input == '') {
		$('.pw_error').css("display", "inline-block");
		$('.pw_ok').css("display", "none");
		emptyCheck = false;
	}
	// 비밀번호 확인 공백
	if (pw_confirm == '' || pw_confirm != pw_input) {
		$('.pw_confirm_error').css("display", "inline-block");
		$('.pw_confirm_ok').css("display", "none");
		emptyCheck = false;
	}
	
	// 이름 공백
	if (name_input == '') {
		$('.name_error').css("display", "inline-block");
		emptyCheck = false;
	}
	
	// 주소 공백 ( 정규식 표현 검사가 따로 없어, 공백아닌 경우도 검사 )
	if (address_input == '') {
		$('.address_error').css("display", "inline-block");
		emptyCheck = false;
	} else {
		$('.address_error').css("display", "none");		
	}
	
	// 전화번호 공백 ( 정규식 표현 검사가 따로 없어, 공백아닌 경우도 검사 )
	var num = $("#phoneNum1").val() + $("#phoneNum2").val() + $("#phoneNum3").val();
	var secondNum = $("#phoneNum2").val();
	var thirdNum = $("#phoneNum3").val();
	$("[name=phone]").val(num);	
	// console.log("num: 010" + secondNum + thirdNum);
	if(secondNum == '' || thirdNum == '') {
		$('.phone_error').css("display", "inline-block");
		emptyCheck = false;
	} else {
		$('.phone_error').css("display", "none");
	}
	
	// 이메일 공백
	if (email_input == '') {
		$('.email_error').css("display", "inline-block");
		emptyCheck = false;
	} else {
		$('.email_error').css("display", "none");
	}
	
	// 이메일인증 공백
	if (code_input == '') {
		$('.code_error').css("display", "inline-block");
		$('.code_ok').css("display", "none");
		emptyCheck = false;
	}
	
	console.log("isFormValid: " + isFormValid);
	console.log("emptyCheck: " + emptyCheck);
    if (!isFormValid || !emptyCheck) {
        event.preventDefault(); 
    }
}

let delayTimer;

function delayedCheckId() {
    clearTimeout(delayTimer);
    delayTimer = setTimeout(checkId, 500); // 500ms 지연 후에 checkId() 함수 호출
}

function delayedCheckPw() {
    clearTimeout(delayTimer);
    delayTimer = setTimeout(checkPw, 500); 
}