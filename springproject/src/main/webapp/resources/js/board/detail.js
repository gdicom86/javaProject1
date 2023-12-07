function showConfirmationModal(bno) {
    Swal.fire({
        title: `삭제하시려면 확인을 눌러주세요.`,
        text: " 정말 삭제하시겠습니까?",
        icon: 'question',
        showCancelButton: true,
        confirmButtonColor: '#3085d6',
        cancelButtonColor: '#d33',
        confirmButtonText: '확인',
        cancelButtonText: '취소'
    }).then((result) => {
        if (result.isConfirmed) {
            // Send AJAX request to the server
            $.ajax({
                type: "POST",
                url: "/board/delete",
                data: { "bno": bno },
                success: function (data) {
                    if (data === "Y") {
                        Swal.fire(
                            'Success!',
                            '삭제가 완료되었습니다.',
                            'success'
                        ).then(() => {
                            window.location.href = "/board/myBoardManagement";
                        });
                    } else {
                        Swal.fire(
                            '삭제 실패!',
                            '삭제 중 문제가 발생했습니다.',
                            'error'
                        );
                    }
                },
                error: function (xhr, status, error) {
                    // Handle error response (if needed)
                    Swal.fire(
                        '오류 발생!',
                        '문제가 발생했습니다. 다시 시도해주세요.',
                        'error'
                    );
                    console.error(error);
                }
            });
        }
    });
}

// 썸네일 슬라이드 
// 자바스크립트를 사용하여 슬라이드 기능 추가
document.addEventListener("DOMContentLoaded", function() {
    const images = document.querySelectorAll('.thumbnailImage img');
    let currentImageIndex = 0;

    function showImage() {
        if (images.length > 1) {
            images[currentImageIndex].style.display = "none";
            currentImageIndex = (currentImageIndex + 1) % images.length;
            images[currentImageIndex].style.display = "block";
        }
    }

    setInterval(showImage, 3000); // 3초마다 이미지 변경
});
