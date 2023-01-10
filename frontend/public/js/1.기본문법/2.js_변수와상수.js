/*
 	- 데이터 1개 저장할 수 있는 메모리 공간
 	- 준비물: 
 		1.	자료형키워드
 		2.	변수/상수 명
 		3.	저장할 데이터
 		4.=: 대입연산자 [오른쪽 데이터를 왼쪽에 넣기]
 		
 	변수	: 변하는 수	
 		1. let 키워드 사용
 		2. 형태: let변수명=데이터
 		3. 대입후에 변경 가능
 	상수	: 고정된 수
 		1.	const 키워드 사용
 		2. 형태: const 변수명=데이터
 		3. 대입후에 변경 불가능
 		
 	사용방법
 		1.let or const
 		2.변수명 정의[만들기]
 		3.=대입연산자				let상수=Number(prompt(상수))
 		4. 데이터
	변수호출
		1. 변수명 이용한 호출 [let쓰지 않음]
	
	변수 값 변경
	
 */
// 1.변수 선언
let value1=10		//'value1' 이라는 변수 상자에 10대입했다.
// 2.변수값 호출
console.log('변수값:'+ value1)		//'value1' 이라는 변수상자의 값 호출
// 3. 변수 값 변경
//let value1=20 // 이미 value1 존재해서 오류남 

value1=20	// 기존값 무시하고 'value1'이라는 변수 상자에 새로운 값 대입했다.
console. log('변수값 수정후:' + value1 )

//4.변수 연산
console.log('변수값 더하기 5:' +value1+5 )	//	문자열+ 숫자+ 숫자
console.log('변수값 더하기 5:' +(value1+5) )//	문자열+(순자+숫자)
let value2=30
let result=value1+value2
console.log('변수들 간의 연산 : '+result)

//1. 상수선언
const data1=10
//data1=20 		//!!:변경 불가하니까 오류발생함 
console.log( '상수값: '+ data1 )

const data2=20 
const result2= data1+data2 
console.log('상수들 간의 연산:'+result2)

//+ 역활: 1.더하기[산술]	2.붙이기[연결]
//	숫자+숫자=숫자 [산술]
//	문자+숫자=문자 [문자]
