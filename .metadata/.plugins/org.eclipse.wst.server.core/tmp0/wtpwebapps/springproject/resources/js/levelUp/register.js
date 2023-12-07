// 개인정보 수집 정보 모달 창
document.addEventListener('DOMContentLoaded', function() {
   	var policyModal = document.getElementById("policy-modal");
	var policyButton = document.getElementById("privacy-policy");
	var closeButton = document.getElementById("close-button-policy");
	
	var policyModal1 = document.getElementById("policy-modal1");
	var policyButton1 = document.getElementById("privacy-policy1");
	var closeButton1 = document.getElementById("close-button-policy1");
	
	policyButton.addEventListener('click', function() {
	    policyModal.style.display = "block";
	});
	
	closeButton.addEventListener('click', function() {
	    policyModal.style.display = "none";
	});
	
	policyButton1.addEventListener('click', function() {
	    policyModal1.style.display = "block";
	});
	
	closeButton1.addEventListener('click', function() {
	    policyModal1.style.display = "none";
	});
	
	window.addEventListener('click', function(event) {
	    if (event.target === policyModal) {
	        policyModal.style.display = "none";
	    }
	    if (event.target === policyModal1) {
	        policyModal1.style.display = "none";
	    }
	});
});


// 폼 전송 방지
function validateButton(event) {
    var phone = document.querySelector('input[name="phone"]');
    var phoneError = document.getElementById("phoneError");
    
    var businessNumber = document.querySelector('input[name="businessNumber"]');
    var businessNumberError = document.getElementById("businessNumberError");

    var contentTextarea = document.querySelector('textarea[name="content"]');
    var contentError = document.getElementById("contentError");

	var checkbox = document.querySelector('input[type="checkbox"]');
	
    var isFormValid = true;

    if (phone.value.trim() !== "") {
        phoneError.style.display = "none";
    } else {
        isFormValid = false;
        phoneError.style.display = "block";
    }

    if (businessNumber.value.trim() !== "") {
        businessNumberError.style.display = "none";
    } else {
        isFormValid = false;
        businessNumberError.style.display = "block";
    }

    if (contentTextarea.value.trim() !== "") {
        contentError.style.display = "none";
    } else {
        isFormValid = false;
        contentError.style.display = "block";
    }
    
    // 개인정보 수집 체크박스     
    if (!checkbox.checked) {
    	isFormValid = false;
        alert("개인정보 수집에 동의해야 합니다.");
	}
	
    console.log(isFormValid);
    if (!isFormValid) {
        event.preventDefault();
    }
}