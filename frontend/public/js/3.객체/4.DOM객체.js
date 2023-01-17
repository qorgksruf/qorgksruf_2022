/*

	객체
	1.미리 만들어진 객체
		1.console.log객체
			console.log()
		2.Math클래스
			Math.random( )	
		3. document객체: DOM객체
			document.querySelector( )	


	2.사용자 적의 객체
	

 */
//1.DOM 객체 : HTML을 동적으로 만들어지는 객체화
let h1 = `<h1>${'안녕하세요'}</h1>`
document.body.innerHTML = h1
//2.DOM객체의 이벤트
	//1.기존 함수 적용
function 함수1(){console.log('문서열림1')}
document.onload = 함수1
document.addEventListener('DOMContentLoaded', 함수1)	//문서에서 이벤트가 발생하면 함수 실행됨
	//2. 익명[이름없는]함수 적용
document.onload =function(){console.log('문서열림2')}
document.addEventListener('DOMContentLoaded',function(){console.log('문서열림2') } )
	//3.화살표 함수 적용[ (인수) => {실행문} ] 함수 적용
document.onload=() => {console.log('문서열림3')}	
document.addEventListener('DOMContentLoaded',() => {console.log('문서열림3')})

let 익명함수=function(){ console.log ('문서열림5')}
let 화살표함수=( )=> {console.log ('문서열림4')}
let 객체={행동:( )=>{console.log ('문서열림6')}}

// function() {} = "() => {}" 공공, 의료, 금융 기타 등등 대부분 시스템은 오래되어 있기 때문에 통일성을 위해 function 을 사용한다.

// ES6 함수 ()=>{} 는 vueJS 같은 곳에서 쓰되 대부분 쇼핑몰 같은 신식 홈페이지 제작할 때 쓴다.

// 그러므로 function 을 사용하기를 맴우맹무ㅐ우매우ㅐ무애무애ㅜ매우매ㅜ애ㅜ매ㅜ 권장한다.

// onload 는 html 이 바로 load가 완료되었을 때 실행한다 라는 의미를 갖고 있다. (어쩔 떄 쓰냐 네이버에 진입하자마자 나는 로그인을 하고 싶다 ㅇㅋ?)

// ex) 네이버를 틀었다 > 각각 이미지가 들어가야할 곳이 있어야 할 거 아니야? > 그러면 일단 문서 html 을 로드를 완료하고 > 해당 각각의 이미지 들어갈 부분에 서버에서 해당 이미지를 불러올 때 onload 사용

익명함수 // 문서열림5가 바로 실행되겠지?



