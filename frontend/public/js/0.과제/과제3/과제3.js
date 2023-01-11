
console.log( 'js실행') //테스트

let contentArray = [];		// 방명록 내용이 들어갈 배열 (초기값 새팅) - 전역변수

function addcontent() {		// 버튼을 클릭했을 때
	console.log('클릭했다.');	// 잘 눌렸는 지 확인
	
	let content = document.querySelector(".contents").value ;// contents 라는 클래스의 값을 가져온다. (input 태그)
	
	contentArray.push(content);	// contentArray 아파트에 입주 

	let tableContent = "";	// 테이블에 뿌려줄 태그를 포함한 내용
	
	for (let i = 0; i < contentArray.length; i++) {
		tableContent = tableContent + "<tr><th>" + (i+1) + "</th><th>" + contentArray[i] + "</th></tr>";
	}
	
	document.querySelector("._table").innerHTML = tableContent;
}




 