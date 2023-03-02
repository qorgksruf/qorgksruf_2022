alert('js파일열림')
//js 함수
//function 함수명 (매개변수){실행코드 }

function 예제1(){

	let data = document.querySelector('.inputdata').value;
	console.log(data);
	
	
}
	//documemt :미리 만들어진 DOM 객체	
	//1.queryselector (식별자):tag 1개 -> 변수/객체에 저장
		//documemt.queryselector('.class')
		//documemt.queryselector('#id')
		//documemt.queryselector(.'tagname[name="namename"]')
	//2.queryselectorAll(식별자) : tag 여러개 -? 배열/리스크 에 저장
	
	//queryselector().속성명
		//1.queryselector().value : input ,select ,textarta [div x table x]
		//queryselector().innerHTML: div,span ,td 등