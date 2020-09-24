
//도움말 버튼 보이기(전구 아이콘)
var titleHeader = document.getElementsByClassName("mainHeader")[0].firstElementChild;
var btnHint = "<i class='far fa-lightbulb' style='font-size: .74em;margin-left:10px;cursor: pointer;' onclick='toggleHint();' title='약간의 도움말'></i>";
titleHeader.innerHTML += " - 선생님꺼 ";
titleHeader.innerHTML += btnHint;

var toggleFlag = false;

function toggleHint() {

	var scriptBubble = document.getElementsByClassName("script");
	for (var i=0; i<scriptBubble.length; i++) {
		if (toggleFlag)
			scriptBubble[i].style.display = "none";
		else 
			scriptBubble[i].style.display = "block";
	}
	toggleFlag = !toggleFlag;
}





//문제 요구사항에 스피커 아이콘 붙이기
// var question = document.getElementsByClassName("mainHeader")[0].children[1];
// var loud = "<i class='far fa-hand-point-right' style='margin-right: 5px;'></i>";
// question.innerHTML = loud + question.innerHTML;




//보조 항목 마지막에 프로그래밍 코드 분할 + 표시하기 > document.images|img.src|onmouseover|onmouseout

var code = document.getElementsByClassName("mainHeader")[0].lastElementChild;
code.innerHTML = "<i class='fas fa-keyboard'></i> " + code.innerHTML;
// var codes = code.innerHTML.split("|");
// for (var i=0; i<codes.length; i++) {
// 	code.innerHTML += "<code>" + codes[i] + "</code> ";
// }
