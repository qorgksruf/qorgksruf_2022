
console.log( 'js실행') // 1. 확인

// 테이블의 첫행[제목] html 마크업 대입된 변수 
// let html변수명 = 'HTML마크업작성'		//! : 마크업 문자처리
let 테이블행 = '<tr> <th>단</th> <th>곱</th> <th>결과</th> </tr>';	//1번 실행 결과 누적

/* 3. <table>의 행<tr> 반복문으로 만들기 */
for( let 곱 = 1 ; 곱 <= 9 ; 곱++  ){ // for s 
	// 곱은 1부터 9까지 1씩증가 반복 처리 
		console.log( 테이블행 )
	// ! : 변수명 과 수식은 문자처리 X
	// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
	테이블행 += '<tr> <th> 2 </th> <th>'+곱+'</th> <th>'+(2*곱)+'</th> </tr>';
	// += 추가 /  = 대입
} // for e


// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기 
document.querySelector('.gu_table').innerHTML = 테이블행

//3.
function regi(){
	console.log('클릭했다.')//3.확인
	
	//4. 단:<input> 곱:<input>에 입력된 value 각 변수에 저장
	let dan=document.querySelector('.dan').value	// 함수안에 있으면 결과 누적 안되고 클릭할떄마다 변화되는 것을 의미함
	let gop=document.querySelector('.gop').value
	
for( let 곱 = 1 ; 곱 <= gop ; 곱++  ){ // for s 
	// 곱은 1부터 9까지 1씩증가 반복 처리 
		console.log( 테이블행 )
	// ! : 변수명과 수식은 문자처리 X
	// 4. 마크업과 변수 이용한 HTML 구성하고 변수에 추가
	테이블행 += '<tr> <th>'+dan+' </th> <th>'+곱+'</th> <th>'+(dan*곱)+'</th> </tr>';
	// += 추가 /  = 대입
} // for e


// 5. 반복문으로 누적된 HTML 변수를 TABLE에 넣어주기 
document.querySelector('.gu_table').innerHTML = 테이블행



}	







		
		
		