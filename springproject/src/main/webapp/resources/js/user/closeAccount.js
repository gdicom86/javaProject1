// 체크박스
function checkConsent() {
    var consentBtn = document.getElementById("consentBtn");
    var checkbox = document.getElementById("checkConsent");

    if (checkbox.checked) {
        consentBtn.removeAttribute("disabled");
    } else {
        consentBtn.setAttribute("disabled", "disabled");
    }
}

//
function closeAccountBtn() {
	$.ajax({
		type: "post",
		url: "/user/closeAccount",
		success: function(data) {
            if(data == "N") {
            	Swal.fire(
					'Error!',
        			'계정 해지는 로그인이 필요합니다.',
        			'error'
				).then(() => {
                        window.location.href = "/";
                    });		
            } else {
            	Swal.fire(
					'Success',
					data + '님 그동안 부동산 코리아를 이용해 주셔서 감사합니다.', 
					'success'
				).then(() => {
                        window.location.href = "/";
                    });
            }
        },
        error: function() {
        	alert("failed");
        }
		
	});
}