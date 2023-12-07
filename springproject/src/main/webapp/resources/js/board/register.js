// Rotating Text
var words = document.getElementsByClassName('word');
var wordArray = [];
var currentWord = 0;

words[currentWord].style.opacity = 1;
for (var i = 0; i < words.length; i++) {
  splitLetters(words[i]);
}

function changeWord() {
  var cw = wordArray[currentWord];
  var nw = currentWord == words.length-1 ? wordArray[0] : wordArray[currentWord+1];
  for (var i = 0; i < cw.length; i++) {
    animateLetterOut(cw, i);
  }
  
  for (var i = 0; i < nw.length; i++) {
    nw[i].className = 'letter behind';
    nw[0].parentElement.style.opacity = 1;
    animateLetterIn(nw, i);
  }
  
  currentWord = (currentWord == wordArray.length-1) ? 0 : currentWord+1;
}

function animateLetterOut(cw, i) {
  setTimeout(function() {
    cw[i].className = 'letter out';
  }, i*80);
}

function animateLetterIn(nw, i) {
  setTimeout(function() {
    nw[i].className = 'letter in';
  }, 340+(i*80));
}

function splitLetters(word) {
  var content = word.innerHTML;
  word.innerHTML = '';
  var letters = [];
  for (var i = 0; i < content.length; i++) {
    var letter = document.createElement('span');
    letter.className = 'letter';
    letter.innerHTML = content.charAt(i);
    word.appendChild(letter);
    letters.push(letter);
  }
  
  wordArray.push(letters);
}

changeWord();
setInterval(changeWord, 4000);

// 행정구역 select
var categories = {
	'서울': ['강남구','강동구','강북구','강서구','관악구','광진구','구로구','금천구','노원구','도봉구','동대문구','동작구','마포구','서대문구','서초구','성동구','성북구','송파구','양천구','영등포구','용산구','은평구','종로구','중구','중랑구'],
    '부산': ['강서구','금정구','남구','동구','동래구','부산진구','북구','사상구','사하구','서구','수영구','연제구','영도구','중구','해운대구','기장군'],
    '대구': ['남구','달서구','동구','북구','서구','수성구','중구','달성군'],
    '인천': ['계양구','남구','남동구','동구','부평구','서구','연수구','중구','강화군','옹진군'],
    '광주': ['광산구','남구','동구','북구','서구'],
    '대전': ['대덕구','동구','서구','유성구','중구'],
    '울산': ['남구','동구','북구','중구','울주군'],
    '강원': ['강릉시','동해시','삼척시','속초시','원주시','춘천시','태백시','고성군','양구군','양양군','영월군','인제군','정선군','철원군','평창군','홍천군','화천군','횡성군'],
    '경기': ['고양시 덕양구','고양시 일산구','과천시','광명시','광주시','구리시','군포시','김포시','남양주시','동두천시','부천시 소사구','부천시 오정구','부천시 원미구','성남시 분당구','성남시 수정구','성남시 중원구','수원시 권선구','수원시 장안구','수원시 팔달구','시흥시','안산시 단원구','안산시 상록구','안성시','안양시 동안구','안양시 만안구','오산시','용인시','의왕시','의정부시','이천시','파주시','평택시','하남시','화성시','가평군','양주군','양평군','여주군','연천군','포천군'],
    '경남': ['거제시','김해시','마산시','밀양시','사천시','양산시','진주시','진해시','창원시','통영시','거창군','고성군','남해군','산청군','의령군','창녕군','하동군','함안군','함양군','합천군'],
    '경북': ['경산시','경주시','구미시','김천시','문경시','상주시','안동시','영주시','영천시','포항시 남구','포항시 북구','고령군','군위군','봉화군','성주군','영덕군','영양군','예천군','울릉군','울진군','의성군','청도군','청송군','칠곡군'],
    '전남': ['광양시','나주시','목포시','순천시','여수시','강진군','고흥군','곡성군','구례군','담양군','무안군','보성군','신안군','영광군','영암군','완도군','장성군','장흥군','진도군','함평군','해남군','화순군'],
    '전북': ['군산시','김제시','남원시','익산시','전주시 덕진구','전주시 완산구','정읍시','고창군','무주군','부안군','순창군','완주군','임실군','장수군','진안군'],
    '제주': ['서귀포시','제주시','남제주군','북제주군'],
    '충남': ['공주시','논산시','보령시','서산시','아산시','천안시','금산군','당진군','부여군','서천군','연기군','예산군','청양군','태안군','홍성군'],
    '충북': ['제천시','청주시 상당구','청주시 흥덕구','충주시','괴산군','단양군','보은군','영동군','옥천군','음성군','진천군','청원군']
};

function add1_change(selectedValue, searchType_add2) {
    var selectedCategory = categories[selectedValue] || [];
    populateOptions(searchType_add2, selectedCategory);
}

function add2_change(selectedValue) {
    console.log('선택된 값 (searchType_add2):', selectedValue);
}

function populateOptions(selectElement, values) {
    selectElement.options.length = 0; // 기존 옵션 제거

    selectElement.options[0] = new Option('-선택-', '', '', true);

    for (var i = 0; i < values.length; i++) {
        selectElement.options[i + 1] = new Option(values[i], values[i]);
    }
}

// searchType_a, searchType_b JS(data-value(dataset.value)넣기, click style)
window.onload = function () {
    var typesA = document.querySelectorAll('.type_a');
    var typesB = document.querySelectorAll('.type_b');
    
    function handleTypeClick(types, inputId) {
        types.forEach(function (type) {
            type.addEventListener('click', function (e) {
                // remove type-clicked from all types
                types.forEach(function (t) {
                    t.firstElementChild.classList.remove('type-clicked');
                });

                // add type-clicked to the clicked type
                e.currentTarget.firstElementChild.classList.add('type-clicked');

                // update the hidden input with the data-value of the clicked type
                document.getElementById(inputId).value = e.currentTarget.dataset.value;
            });
        });
    }

    handleTypeClick(typesA, 'mySelection_a');
    handleTypeClick(typesB, 'mySelection_b');
}

// fileUpload
document.getElementById('thumbFileTrigger').addEventListener('click', () => {
    document.getElementById('thumbFile').click();
})

document.getElementById('detailFileTrigger').addEventListener('click', () => {
    document.getElementById('detailFile').click();
})

// 정규식 표현식을 사용하여 생성자 함수를 만들기
// 실행파일 막기 기능, 이미지파일 체크
// fileUpload시 형식제한 함수
const regExp = new RegExp("\.(exe|sh|bat|msi|dll|js|txt)$"); // 실행파일
const regExpImg = new RegExp("\.(jpg|jpeg|png|gif|bmp)$"); // 이미지파일
const maxSize = 1024*1024*20; // 20M 보다 큰지 확인

function fileSizeValidation(fileName, fileSize) {
    if (regExp.test(fileName) || fileSize > maxSize) {
        return 0;
    } else {
        return 1;
    }
}

function handleFileInputChange(e, fileZoneId) {
    const files = e.target.files;
    const fileZone = document.getElementById(fileZoneId);
    fileZone.innerHTML = '';

    let ul = '<ul style="list-style: none; margin: 8px 0; padding: 0;">';
    let isOk = 1;

    for (let file of files) {
        let validResult = fileSizeValidation(file.name, file.size);
        isOk *= validResult;

        ul += `<li>`;
        ul += `<div>${validResult ? '업로드가 가능한 파일입니다.' : '업로드가 불가능한 파일입니다.'}</div>`;
        ul += `${file.name}`;
        ul += `<span class="badge rounded-pill text-bg-${validResult ? 'success' : 'danger'}">${file.size}Bytes</span></li>`;
    }

    ul += `</ul>`;
    fileZone.innerHTML = ul;

    const regBtn = document.getElementById('regBtn');
    regBtn.disabled = isOk === 0;
}

document.querySelector('.file-upload-container').addEventListener('change', (e) => {
    if (e.target.id === 'thumbFile') {
        handleFileInputChange(e, 'thumbFileZone');
    } else if (e.target.id === 'detailFile') {
        handleFileInputChange(e, 'detailFileZone');
    }
});

// 폼 전송 방지
function validateButton(event) {
    var searchTypeA = document.querySelector('input[name="searchType_a"]');
    var searchTypeB = document.querySelector('input[name="searchType_b"]');
    var typeError = document.getElementById("typeError");

    var titleInput = document.querySelector('input[name="title"]');
    var titleError = document.getElementById("titleError");

    var searchTypeAdd1 = document.querySelector('select[name="searchType_add1"]');
    var searchTypeAdd2 = document.querySelector('select[name="searchType_add2"]');
    var arenaError = document.getElementById("arenaError");

    var contentTextarea = document.querySelector('textarea[name="content"]');
    var contentError = document.getElementById("contentError");

    var isFormValid = true;

    if (searchTypeA.value !== "" && searchTypeB.value !== "") {
        typeError.style.display = "none";
    } else {
        isFormValid = false;
        typeError.style.display = "block";
    }

    if (titleInput.value.trim() !== "") {
        titleError.style.display = "none";
    } else {
        isFormValid = false;
        titleError.style.display = "block";
    }

    if (searchTypeAdd1.value !== "-선택-" && searchTypeAdd2.value !== "-선택-") {
        arenaError.style.display = "none";
    } else {
        isFormValid = false;
        arenaError.style.display = "block";
    }

    if (contentTextarea.value.trim() !== "") {
        contentError.style.display = "none";
    } else {
        isFormValid = false;
        contentError.style.display = "block";
    }

    console.log(isFormValid);
    if (!isFormValid) {
        event.preventDefault();
    }
}

