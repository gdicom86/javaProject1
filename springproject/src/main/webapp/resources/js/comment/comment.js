document.addEventListener("DOMContentLoaded", function () {
  document.getElementById("cmtPostBtn").addEventListener("click", () => {
    const cmtText = document.getElementById("cmtText").value;
    const rateValue = parseFloat(getSelectedRate()) / 2.0;
    console.log(cmtText);
    if (cmtText == "" || cmtText == null) {
      alert("댓글을 입력해주세요.");
      document.getElementById("cmtText").focus();
      return false;
    } else if (rateValue <= 0) {
      alert("0.5점 이상의 평점을 선택해주세요.");
      return false;
    } else {
      let cmtData = {
        bno: bnoVal,
        writer: document.getElementById("cmtWriter").innerText,
        content: cmtText,
        rate: rateValue,
      };
      console.log(cmtData);
      postCommentToServer(cmtData).then((result) => {
        if (result > 0) {
          alert("댓글 등록 성공");
          document.getElementById("cmtText").value = "";
          getCommentList(cmtData.bno);
          resetRateRadio();
        } else {
          alert("댓글 등록에 실패했습니다. 다시 시도해주세요.");
        }
      });
    }
  });
});

// 라디오 버튼에서 선택된 rate 값을 가져오는 함수
function getSelectedRate() {
  const ratingElements = document.getElementsByName("rating");
  for (let i = 0; i < ratingElements.length; i++) {
    if (ratingElements[i].checked) {
      return ratingElements[i].value;
    }
  }
  // 선택된 rate가 없는 경우의 기본 값
  return 0;
}

// rate radio를 0으로 초기화하는 함수
function resetRateRadio() {
  const ratingElements = document.getElementsByName("rating");
  for (let i = 0; i < ratingElements.length; i++) {
    ratingElements[i].checked = false;
  }
}

async function postCommentToServer(cmtData) {
  try {
    const url = "/comment/post";
    const config = {
      method: "post",
      headers: {
        "content-type": "application/json; charset-utf-8",
      },
      body: JSON.stringify(cmtData),
    };
    const response = await fetch(url, config);
    const result = await response.text();
    return parseInt(result);
  } catch (error) {
    console.log(error);
    throw error; // 에러를 호출자에게 전파
  }
}

// Comment 출력
async function spreadCommentFromServer(bno) {
  console.log(bno);
  try {
    const response = await fetch("/comment/" + bno);
    const data = await response.json();
    return data;
  } catch (error) {
    console.log(error);
    return []; // 에러 발생 시 빈 배열을 반환하도록 수정
  }
}

function getCommentList(bno) {
  console.log("getCommentList 호출됨. bno: " + bno);
  spreadCommentFromServer(bno)
    .then((result) => {
      console.log(result);
      const ul = document.getElementById("cmtListArea");
      if (result.length > 0) {
        ul.innerHTML = "";
        for (let cvo of result) {
          const rating = cvo.rate;
          const ratingElement = getRatingElement(rating);

          const isAuthor = sesId === cvo.writer || apiSesEmail === cvo.writer;

          let li = `<li data-cno="${cvo.cno}">`;
          li += `<div>${cvo.writer}</div>`;

          if (isAuthor) {
            li += `<input type="text" id="cmtTextMod" value="${cvo.content}">`;
          } else {
            li += `<input type="text" id="cmtTextMod" value="${cvo.content}" disabled>`;
          }

          li += `<div>${cvo.mod_date}</div>`;
          li += `<div>${rating}</div>`;
          li += `<div>${ratingElement}</div>`;

          if (isAuthor) {
            li += `<button type="button" class="modBtn">%</button>`;
            li += `<button type="button" class="delBtn">X</button>`;
          }

          li += `</li>`;
          ul.innerHTML += li;
        }
      } else {
        let li = `<li>Comment not Exist</li>`;
        ul.innerHTML += li;
      }
    })
    .catch((error) => {
      console.log(error);
    });
}

function getRatingElement(rating) {
  let ratingText = "";
  const fullStars = Math.floor(rating); // 평가의 정수 부분 (별 개수)
  const hasHalfStar = rating % 1 !== 0; // 0.5 단위인 경우 반 개의 별이 추가됨

  // 별 개수에 따라 full star를 추가
  for (let i = 0; i < fullStars; i++) {
    ratingText += '<i class="fa-solid fa-star"></i>';
  }

  // 0.5단위인 경우 half star를 추가
  if (hasHalfStar) {
    ratingText += '<i class="fa-solid fa-star-half-stroke"></i>';
  }

  // 나머지 별을 빈 별로 채움
  const remainingStars = 5 - fullStars - (hasHalfStar ? 1 : 0);
  for (let i = 0; i < remainingStars; i++) {
    ratingText += '<i class="fa-regular fa-star"></i>';
  }

  return ratingText;
}

// Comment 수정
document.addEventListener("click", (e) => {
  console.log(e.target);
  if (e.target.classList.contains("modBtn")) {
    console.log("수정버튼 클릭");
    let li = e.target.closest("li");
    let cnoVal = li.dataset.cno;
    let textContent = li.querySelector("#cmtTextMod").value;
    console.log("cno: " + cnoVal);
    console.log("textContent: " + textContent);

    let cmtData = {
      cno: cnoVal,
      content: textContent,
    };
    console.log(cmtData);
    // 서버 연결 부분
    editCommentToServer(cmtData).then((result) => {
      if (result > 0) {
        alert("댓글 수정 성공");
      }
      getCommentList(bnoVal);
    });
  } else if (e.target.classList.contains("delBtn")) {
    console.log("삭제버튼 클릭");
    let li = e.target.closest("li");
    let cnoVal = li.dataset.cno;
    console.log(cnoVal);

    // SweetAlert로 확인 메시지 표시
    Swal.fire({
      title: "댓글 삭제",
      text: "정말로 이 댓글을 삭제하시겠습니까?",
      icon: "warning",
      showCancelButton: true,
      confirmButtonText: "예, 삭제합니다",
      cancelButtonText: "취소",
    }).then((result) => {
      if (result.isConfirmed) {
        // 사용자가 확인을 눌렀을 때만 삭제 로직 실행
        removeCommentToServer(cnoVal).then((result) => {
          if (result > 0) {
            alert("댓글 삭제 성공");
          }
          getCommentList(bnoVal);
        });
      }
    });
  }
});

// 수정 서버 연결 부분
async function editCommentToServer(cmtData) {
  try {
    const url = "/comment/" + cmtData.cno;
    const config = {
      method: "put",
      headers: {
        "content-type": "application/json; charset=utf-8",
      },
      body: JSON.stringify(cmtData),
    };
    const response = await fetch(url, config);
    const result = await response.text();
    return parseInt(result);
  } catch (error) {
    log.info(error);
  }
}

// 삭제 서버 연결 부분
async function removeCommentToServer(cno) {
  try {
    const url = "/comment/" + cno;
    const config = {
      method: "delete",
    };
    const response = await fetch(url, config);
    const result = await response.text();
    return parseInt(result);
  } catch (error) {
    log.info(error);
  }
}
